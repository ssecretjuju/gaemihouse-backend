package secretjuju.gaemihouse.keyword.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secretjuju.gaemihouse.keyword.model.Keyword;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
    List<Keyword> findAllByKeywordDateBetween(Date start, Date end);
}
