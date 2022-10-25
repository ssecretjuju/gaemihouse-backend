package secretjuju.gaemihouse.member.service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class KoreaInvestmentService {
    public String getAccessToken(Map<String, String> appInfo) {

        HttpURLConnection connection = null;


        try {
            URL url = new URL("https://openapivts.koreainvestment.com:29443/oauth2/tokenP");

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
//            dos.writeBytes(appInfo);
            dos.close();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }

        String accessToken = "";

        return accessToken;
    }
}

//req = requests.post(
//        # url="https://openapi.koreainvestment.com:9443/oauth2/tokenP",
//        url="https://openapivts.koreainvestment.com:29443/oauth2/tokenP",
//        json={
//        "grant_type": "client_credentials",
//        "appkey": appkey,
//        "appsecret": appsecret
//        }
//        )
//        print(req.text)
