package secretjuju.gaemihouse.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secretjuju.gaemihouse.stock.model.StockPrediction;

import java.util.Date;
import java.util.List;

public interface StockPredictionRepository extends JpaRepository<StockPrediction, Integer> {

    List<StockPrediction> findAllByStockPredictionNameAndStockPredictionDateBetween(String stockName, Date start, Date end);
}
