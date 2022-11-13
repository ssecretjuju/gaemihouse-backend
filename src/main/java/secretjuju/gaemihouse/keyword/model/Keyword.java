package secretjuju.gaemihouse.keyword.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ChattingLogForOracle")
@Table(name = "TBL_KEYWORD")
@Access(AccessType.FIELD)
@SequenceGenerator(
        name="SEQ_KEYWORD_ID_GEN",
        sequenceName = "SEQ_KEYWORD_ID",
        initialValue = 1,
        allocationSize = 1
)
public class Keyword {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_KEYWORD_ID_GEN"
    )
    @Column(name = "KEYWORD_ID")
    private int keywordId;

    @Column(name = "KEYWORD_CONTENT")
    private String keywordContent;

    @Column(name = "KEYWORD_COUNT")
    private String keywordCount;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yy-MM-dd")
    @Column(name = "KEYWORD_DATE")
    private Date keywordDate;

    public Keyword() {
    }

    public Keyword(String keywordContent, Date keywordDate) {
        this.keywordContent = keywordContent;
        this.keywordDate = keywordDate;
    }

    public Keyword(int keywordId, String keywordContent, String keywordCount, Date keywordDate) {
        this.keywordId = keywordId;
        this.keywordContent = keywordContent;
        this.keywordCount = keywordCount;
        this.keywordDate = keywordDate;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public String getKeywordContent() {
        return keywordContent;
    }

    public String getKeywordCount() {
        return keywordCount;
    }

    public Date getKeywordDate() {
        return keywordDate;
    }
}
