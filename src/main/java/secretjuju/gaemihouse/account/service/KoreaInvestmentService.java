package secretjuju.gaemihouse.account.service;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.member.service.MemberService;


@Service
public class KoreaInvestmentService {

    private final MemberService memberService;

    public KoreaInvestmentService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String getAccessToken(String memberId) {

//        MemberDTO member = new MemberDTO();
//        member.setAppKey("PSAQ2zEMgKcoUYhfMMVxDfO5D6xxpyvdPVhR");
//        member.setAppSecret("P0eIWiuAOlPMNSzK/8IcXCN62xuknqP8eJTqB4/s4T6vJKdOD/7vc1U04IMr0lHGPaj2voIo1fFYQZ3r2azuK5lREZCDFmDyWRt0hSVA9pEbTzM6BE3nnfLqk1Y7ZgK8pVx4unhYtAGc+VnTJSF756K6QD2NeXs/YpTd1Avz9KWn1s4D97o=");

        MemberDTO member = memberService.selectMyInfo(memberId);

        String accessToken = "";

        String url = "https://openapivts.koreainvestment.com:29443/oauth2/tokenP";
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("grant_type", "client_credentials");
        jsonObject.put("appkey", member.getAppKey());
        jsonObject.put("appsecret", member.getAppSecret());

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost postRequest = new HttpPost(url);

            postRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            postRequest.setEntity(new StringEntity(jsonObject.toString()));

            HttpResponse response = client.execute(postRequest);

            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

                // 유효기간 24시간
                accessToken = new JSONObject(body).getString("access_token");
//                System.out.println(accessToken);
            } else {
                System.out.println("응답 코드 : " + response.getStatusLine().getStatusCode());
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return accessToken;
    }

    public boolean getAccountBalance(String memberId) {

//        MemberDTO member = new MemberDTO();
//        member.setAppKey("PSAQ2zEMgKcoUYhfMMVxDfO5D6xxpyvdPVhR");
//        member.setAppSecret("P0eIWiuAOlPMNSzK/8IcXCN62xuknqP8eJTqB4/s4T6vJKdOD/7vc1U04IMr0lHGPaj2voIo1fFYQZ3r2azuK5lREZCDFmDyWRt0hSVA9pEbTzM6BE3nnfLqk1Y7ZgK8pVx4unhYtAGc+VnTJSF756K6QD2NeXs/YpTd1Avz9KWn1s4D97o=");
//
//        member.setAccountNum("5007447801");

        MemberDTO member = memberService.selectMyInfo(memberId);

        String accessToken = getAccessToken(memberId);
        String url = "https://openapivts.koreainvestment.com:29443/uapi/domestic-stock/v1/trading/inquire-balance"
                + "?CANO=" + member.getAccountNum().substring(0, 8)
                + "&ACNT_PRDT_CD=" + member.getAccountNum().substring(8)
                + "&AFHR_FLPR_YN=N"
                + "&OFL_YN"
                + "&INQR_DVSN=02"
                + "&UNPR_DVSN=01"
                + "&FUND_STTL_ICLD_YN=N"
                + "&FNCG_AMT_AUTO_RDPT_YN=N"
                + "&PRCS_DVSN=00"
                + "&CTX_AREA_FK100"
                + "&CTX_AREA_NK100";

        System.out.println(url);

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url);

            getRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
            getRequest.setHeader("appkey", member.getAppKey());
            getRequest.setHeader("appsecret", member.getAppSecret());
            getRequest.setHeader("tr_id", "VTTC8434R");
            getRequest.setHeader("tr_cont", "M");

            HttpResponse response = client.execute(getRequest);

            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

                JSONArray result1 = new JSONObject(body).getJSONArray("output1");
                JSONObject result2 = new JSONObject(body).getJSONArray("output2").getJSONObject(0);

//                System.out.println(result1);
//                System.out.println(result2);

                for (int i = 0; i < result1.length(); i++) {
                    String stockName = (result1.getJSONObject(i)).getString("prdt_name");
                    int stockCount = (result1.getJSONObject(i)).getInt("hldg_qty");
                    int stockAveragePurchasePrice = (int) (result1.getJSONObject(i)).getDouble("pchs_avg_pric");
                    int stockCurrentPrice = (result1.getJSONObject(i)).getInt("prpr");
                    int balanceTotalPurchasePrice = (result1.getJSONObject(i)).getInt("pchs_amt");
                    int balanceTotalEvaluatePrice = (result1.getJSONObject(i)).getInt("evlu_amt");
                    Double balanceYield = (result1.getJSONObject(i)).getDouble("evlu_pfls_rt");
//                    System.out.println("종목명: " + stockName + ", " // 종목명
//                            + "보유 개수: " + stockCount + ", " // 보유 개수
//                            + "매입 평균 가격: " + stockAveragePurchasePrice + ", " // 매입 평균 가격
//                            + "현재 가격: " + stockCurrentPrice + ", " // 현재 가격
//                            + "총 구매 금액: " + balanceTotalPurchasePrice + ", " // 총 구매 금액
//                            + "총 평가 금액: " + balanceTotalEvaluatePrice + ", " // 총 평가 금액
//                            + "종목 평가 수익률(총 구매 금액 기준): " + balanceYield + ", " // 종목 평가 수익률
//                    );
                }

                int accountTotalStockPurchasePrice = result2.getInt("pchs_amt_smtl_amt");
                int accountTotalStockEvaluatePrice = result2.getInt("evlu_amt_smtl_amt");
                int accountChangePrice = result2.getInt("evlu_pfls_smtl_amt");
                int accountAmountPrice = result2.getInt("asst_icdc_amt");
//                System.out.println("보유 종목 총 매입 금액: " + accountTotalStockPurchasePrice + ", "
//                        + "보유 종목 총 평가 금액: " + accountTotalStockEvaluatePrice + ", "
//                        + "원금 대비 변동 금액: " + accountChangePrice
//                );

                return true;
            } else {
                System.out.println("응답 코드 : " + response.getStatusLine().getStatusCode());

                return false;
            }

        } catch (Exception e) {
            System.err.println(e.toString());

            return false;
        }
    }

    public int getCurrentEvaluateProperty(String memberId) {
//        MemberDTO member = new MemberDTO();
//        member.setAppKey("PSAQ2zEMgKcoUYhfMMVxDfO5D6xxpyvdPVhR");
//        member.setAppSecret("P0eIWiuAOlPMNSzK/8IcXCN62xuknqP8eJTqB4/s4T6vJKdOD/7vc1U04IMr0lHGPaj2voIo1fFYQZ3r2azuK5lREZCDFmDyWRt0hSVA9pEbTzM6BE3nnfLqk1Y7ZgK8pVx4unhYtAGc+VnTJSF756K6QD2NeXs/YpTd1Avz9KWn1s4D97o=");
//
//        member.setAccountNum("5007447801");

        MemberDTO member = memberService.selectMyInfo(memberId);

        String accessToken = getAccessToken(memberId);
        String url = "https://openapivts.koreainvestment.com:29443/uapi/domestic-stock/v1/trading/inquire-balance"
                + "?CANO=" + member.getAccountNum().substring(0, 8)
                + "&ACNT_PRDT_CD=" + member.getAccountNum().substring(8)
                + "&AFHR_FLPR_YN=N"
                + "&OFL_YN"
                + "&INQR_DVSN=02"
                + "&UNPR_DVSN=01"
                + "&FUND_STTL_ICLD_YN=N"
                + "&FNCG_AMT_AUTO_RDPT_YN=N"
                + "&PRCS_DVSN=00"
                + "&CTX_AREA_FK100"
                + "&CTX_AREA_NK100";

        System.out.println(url);

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url);

            getRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
            getRequest.setHeader("appkey", member.getAppKey());
            getRequest.setHeader("appsecret", member.getAppSecret());
            getRequest.setHeader("tr_id", "VTTC8434R");
            getRequest.setHeader("tr_cont", "M");

            HttpResponse response = client.execute(getRequest);

            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

                JSONObject result2 = new JSONObject(body).getJSONArray("output2").getJSONObject(0);

                int accountTotalStockEvaluatePrice = result2.getInt("evlu_amt_smtl_amt");
                System.out.println("보유 종목 총 매입 평가 금액: " + accountTotalStockEvaluatePrice);

                return accountTotalStockEvaluatePrice;
            } else {
                System.out.println("응답 코드 : " + response.getStatusLine().getStatusCode());

                return -1;
            }

        } catch (Exception e) {
            System.err.println(e.toString());

            return -1;
        }
    }

    public double getCurrentEvaluateYield(String memberId) {
//        MemberDTO member = new MemberDTO();
//        member.setAppKey("PSAQ2zEMgKcoUYhfMMVxDfO5D6xxpyvdPVhR");
//        member.setAppSecret("P0eIWiuAOlPMNSzK/8IcXCN62xuknqP8eJTqB4/s4T6vJKdOD/7vc1U04IMr0lHGPaj2voIo1fFYQZ3r2azuK5lREZCDFmDyWRt0hSVA9pEbTzM6BE3nnfLqk1Y7ZgK8pVx4unhYtAGc+VnTJSF756K6QD2NeXs/YpTd1Avz9KWn1s4D97o=");
//
//        member.setAccountNum("5007447801");

        MemberDTO member = memberService.selectMyInfo(memberId);

        String accessToken = getAccessToken(memberId);
        String url = "https://openapivts.koreainvestment.com:29443/uapi/domestic-stock/v1/trading/inquire-balance"
                + "?CANO=" + member.getAccountNum().substring(0, 8)
                + "&ACNT_PRDT_CD=" + member.getAccountNum().substring(8)
                + "&AFHR_FLPR_YN=N"
                + "&OFL_YN"
                + "&INQR_DVSN=02"
                + "&UNPR_DVSN=01"
                + "&FUND_STTL_ICLD_YN=N"
                + "&FNCG_AMT_AUTO_RDPT_YN=N"
                + "&PRCS_DVSN=00"
                + "&CTX_AREA_FK100"
                + "&CTX_AREA_NK100";

        System.out.println(url);

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url);

            getRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
            getRequest.setHeader("appkey", member.getAppKey());
            getRequest.setHeader("appsecret", member.getAppSecret());
            getRequest.setHeader("tr_id", "VTTC8434R");
            getRequest.setHeader("tr_cont", "M");

            HttpResponse response = client.execute(getRequest);

            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

                JSONObject result2 = new JSONObject(body).getJSONArray("output2").getJSONObject(0);

                int accountTotalStockPurchasePrice = result2.getInt("pchs_amt_smtl_amt");
                int accountChangePrice = result2.getInt("evlu_pfls_smtl_amt");

                return Math.round(accountChangePrice / (double) accountTotalStockPurchasePrice * 100 * 100) / 100.0;
            } else {
                System.out.println("응답 코드 : " + response.getStatusLine().getStatusCode());

                return -1;
            }

        } catch (Exception e) {
            System.err.println(e.toString());

            return -1;
        }
    }
}