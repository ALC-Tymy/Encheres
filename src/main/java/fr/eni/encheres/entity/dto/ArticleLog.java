package fr.eni.encheres.entity.dto;

import java.time.LocalDateTime;

public class ArticleLog {
    private long id;
    private String name;
    private String status;
    private LocalDateTime beginningDate;
    private LocalDateTime endingDate;


    public ArticleLog() {
    }

    public ArticleLog(long id, String name, String status, LocalDateTime beginningDate, LocalDateTime endingDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDateTime beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
