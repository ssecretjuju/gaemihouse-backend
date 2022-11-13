package secretjuju.gaemihouse.stock.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "StockPrediction")
@Table(name = "TBL_STOCK_PREDICTION")
@Access(AccessType.FIELD)
@SequenceGenerator(
        name="SEQ_STOCK_PREDICTION_CODE_GEN",
        sequenceName = "SEQ_STOCK_PREDICTION_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class StockPrediction {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_STOCK_PREDICTION_CODE_GEN"
    )
    @Column(name = "STOCK_PREDICTION_CODE")
    private int stockPredictionCode;

    @Column(name = "STOCK_PREDICTION_NAME")
    private String stockPredictionName;

    @Column(name = "STOCK_PREDICTION_IMAGE1")
    private String stockPredictionImage1;

    @Column(name = "STOCK_PREDICTION_IMAGE2")
    private String stockPredictionImage2;

    @Column(name = "STOCK_PREDICTION_DATE")
    private Date stockPredictionDate;

    public int getStockPredictionCode() {
        return stockPredictionCode;
    }

    public String getStockPredictionName() {
        return stockPredictionName;
    }

    public String getStockPredictionImage1() {
        return stockPredictionImage1;
    }

    public String getStockPredictionImage2() {
        return stockPredictionImage2;
    }

    public Date getStockPredictionDate() {
        return stockPredictionDate;
    }
}