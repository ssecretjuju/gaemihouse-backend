package secretjuju.gaemihouse.keyword.dto;

import java.util.Date;

public class KeywordDTO {

    private int keywordId;
    private String keywordContent;
    private int keywordCount;
    private Date keywordDate;

    public KeywordDTO() {
    }

    public KeywordDTO(int keywordId, String keywordContent, int keywordCount, Date keywordDate) {
        this.keywordId = keywordId;
        this.keywordContent = keywordContent;
        this.keywordCount = keywordCount;
        this.keywordDate = keywordDate;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeywordContent() {
        return keywordContent;
    }

    public void setKeywordContent(String keywordContent) {
        this.keywordContent = keywordContent;
    }

    public int getKeywordCount() {
        return keywordCount;
    }

    public void setKeywordCount(int keywordCount) {
        this.keywordCount = keywordCount;
    }

    public Date getKeywordDate() {
        return keywordDate;
    }

    public void setKeywordDate(Date keywordDate) {
        this.keywordDate = keywordDate;
    }

    @Override
    public String toString() {
        return "KeywordDTO{" +
                "keywordId=" + keywordId +
                ", keywordContent='" + keywordContent + '\'' +
                ", keywordCount=" + keywordCount +
                ", keywordDate=" + keywordDate +
                '}';
    }
}
