package secretjuju.gaemihouse.stock.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.stock.dto.StockPredictionDTO;
import secretjuju.gaemihouse.stock.model.StockPrediction;
import secretjuju.gaemihouse.stock.repository.StockPredictionRepository;

import java.io.*;
import java.net.URL;
import java.util.*;

@Service
public class StockPredictionService {

    private final StockPredictionRepository stockPredictionRepository;
//    private final S3UploadConfig s3Uploader;
    private final ModelMapper modelMapper;

    public StockPredictionService(StockPredictionRepository stockPredictionRepository, ModelMapper modelMapper) {
        this.stockPredictionRepository = stockPredictionRepository;
//        this.s3Uploader = s3Uploader;
        this.modelMapper = modelMapper;
    }

    public List<StockPredictionDTO> getStockPredictionByStockName(String stockName) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        java.util.Date start = cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        Date end = cal.getTime();

        System.out.println(start);
        System.out.println(end);

//        List<String> test = new ArrayList<>(List.of(new String[]{"https://mblogthumb-phinf.pstatic.net/MjAxOTEwMTFfMjIg/MDAxNTcwNzg1ODM3NTU0.S-ltTb4JaOedIKIRE-mWYcVuZGTBGi8Z8G8NJZtQmrkg.dlyc5gHE3DSF4rvH3fiirLhP7ilKSZuz6t0a0KoWJrYg.PNG.kkson50/sample_images_03.png?type=w800",
//                "https://mblogthumb-phinf.pstatic.net/MjAxOTEwMTFfMjYw/MDAxNTcwNzg1ODM3NTY0.wmnNedC0zB5ummw6DSfYJeQEkiqILCyHRArLs7ZkSzgg.FfY1vXaDbLM3EdsvBHDV1EP0FVKo4jamY_yAJfs9gBIg.PNG.kkson50/sample_images_04.png?type=w800",
//                "https://mblogthumb-phinf.pstatic.net/MjAxOTEwMTFfNjEg/MDAxNTcwNzg1ODM3Nzc0.zxDXm20VlPdQv8GQi9LWOdPwkqoBdiEmf8aBTWTsPF8g.FqMQTiF6ufydkQxrLBgET3kNYAyyKGJTWTyi1qd1-_Ag.PNG.kkson50/sample_images_01.png?type=w800",
//                "https://mblogthumb-phinf.pstatic.net/MjAxOTEwMTFfODMg/MDAxNTcwNzg1ODM3NTUz.2m5sz7K4ATO7WZzXYGE-MmUQ1DYUOflq0IaGgitVZEIg.jYZnxxm0E275Jplbrw25aFCFPVXKcmai1zhf8rlYl3Eg.PNG.kkson50/sample_images_02.png?type=w800"}));
        List<StockPrediction> stockPredictions = stockPredictionRepository.findAllByStockPredictionNameAndStockPredictionDateBetween(stockName, start, end);
        List<StockPredictionDTO> stockPredictionDTOS = new ArrayList<>();
        int i=0;
        for (i = 0; i < stockPredictions.size(); i++) {
            stockPredictionDTOS.add(modelMapper.map(stockPredictions.get(i), StockPredictionDTO.class));


            //            URL imageUrl1 = new URL(stockPredictionDTOS.get(i).getStockPredictionImage1());
//            URL imageUrl2 = new URL(stockPredictionDTOS.get(i).getStockPredictionImage2());
////                URL testUrl = new URL(test.get(i));
//
//                System.out.println(imageUrl1);
//                InputStream is = new BufferedInputStream(imageUrl1.openStream());
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//
//                byte[] buf = new byte[4096];
//                int n = 0;
//                while (-1 != (n = is.read(buf))) {
//                    bos.write(buf, 0, n);
//                }
//
//                bos.close();
//                is.close();
//
//                byte[] response = bos.toByteArray();
//
//                File imageDir = new File("D:\\secretjuju\\gaemihouse-backend\\src\\main\\resources\\static\\images", "stock");
//                if (!imageDir.isDirectory()) {
//                    imageDir.mkdirs();
//                }
//
//                File image1 = new File("D:\\secretjuju\\gaemihouse-backend\\src\\main\\resources\\static\\images\\stock", UUID.randomUUID() + ".jpg");
//                if (!image1.exists()) {
//                    FileOutputStream fos1 = new FileOutputStream("D:\\secretjuju\\gaemihouse-backend\\src\\main\\resources\\static\\images\\stock\\" + UUID.randomUUID() + ".jpg");
//
//                    fos1.write(response);
//                    fos1.close();
//                }

//            System.out.println(s3Uploader.upload(image1, "static"));
        }
        return stockPredictionDTOS;
    }
}
