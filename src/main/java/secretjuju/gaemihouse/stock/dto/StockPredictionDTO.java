package secretjuju.gaemihouse.stock.dto;

import javax.persistence.Column;
import java.util.Date;

public class StockPredictionDTO {

    private int stockPredictionCode;
    private String stockPredictionName;
    private String stockPredictionImage1;
    private String stockPredictionImage2;
    private Date stockPredictionDate;

    public StockPredictionDTO() {
    }

    public StockPredictionDTO(int stockPredictionCode, String stockPredictionName, String stockPredictionImage1, String stockPredictionImage2, Date stockPredictionDate) {
        this.stockPredictionCode = stockPredictionCode;
        this.stockPredictionName = stockPredictionName;
        this.stockPredictionImage1 = stockPredictionImage1;
        this.stockPredictionImage2 = stockPredictionImage2;
        this.stockPredictionDate = stockPredictionDate;
    }

    public int getStockPredictionCode() {
        return stockPredictionCode;
    }

    public void setStockPredictionCode(int stockPredictionCode) {
        this.stockPredictionCode = stockPredictionCode;
    }

    public String getStockPredictionName() {
        return stockPredictionName;
    }

    public void setStockPredictionName(String stockPredictionName) {
        this.stockPredictionName = stockPredictionName;
    }

    public String getStockPredictionImage1() {
        return stockPredictionImage1;
    }

    public void setStockPredictionImage1(String stockPredictionImage1) {
        this.stockPredictionImage1 = stockPredictionImage1;
    }

    public String getStockPredictionImage2() {
        return stockPredictionImage2;
    }

    public void setStockPredictionImage2(String stockPredictionImage2) {
        this.stockPredictionImage2 = stockPredictionImage2;
    }

    public Date getStockPredictionDate() {
        return stockPredictionDate;
    }

    public void setStockPredictionDate(Date stockPredictionDate) {
        this.stockPredictionDate = stockPredictionDate;
    }

    @Override
    public String toString() {
        return "StockPredictionDTO{" +
                "stockPredictionCode=" + stockPredictionCode +
                ", stockPredictionName='" + stockPredictionName + '\'' +
                ", stockPredictionImage1='" + stockPredictionImage1 + '\'' +
                ", stockPredictionImage2='" + stockPredictionImage2 + '\'' +
                ", stockPredictionDate=" + stockPredictionDate +
                '}';
    }
}
