package fr.eni.encheres.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class Proposal {

    private long idProposal;
    private int pointProposal;
    private LocalDateTime dateProposal;
    private int ranking;
    private User buyer;
    private Article article;

    public Proposal() {
    }

    public Proposal(long idProposal, int pointProposal, LocalDateTime dateProposal, int ranking, User buyer, Article article) {
        this.idProposal = idProposal;
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.ranking = ranking;
        this.buyer = buyer;
        this.article = article;
    }

    public Proposal(int pointProposal, LocalDateTime dateProposal, int ranking, User buyer, Article article) {
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.ranking = ranking;
        this.buyer = buyer;
        this.article = article;
    }

    public Proposal(int pointProposal, Article article) {
        this.pointProposal = pointProposal;
        this.article = article;
    }

    public long getIdProposal() {
        return idProposal;
    }

    public void setIdProposal(long idProposal) {
        this.idProposal = idProposal;
    }

    public int getPointProposal() {
        return pointProposal;
    }

    public void setPointProposal(int pointProposal) {
        this.pointProposal = pointProposal;
    }

    public LocalDateTime getDateProposal() {
        return dateProposal;
    }

    public void setDateProposal(LocalDateTime dateProposal) {
        this.dateProposal = dateProposal;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "idProposal=" + idProposal +
                ", pointProposal=" + pointProposal +
                ", dateProposal=" + dateProposal +
                ", ranking=" + ranking +
                ", buyer=" + buyer +
                ", article=" + article +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Proposal proposal = (Proposal) o;
        return idProposal == proposal.idProposal && pointProposal == proposal.pointProposal && ranking == proposal.ranking && Objects.equals(dateProposal, proposal.dateProposal) && Objects.equals(buyer, proposal.buyer) && Objects.equals(article, proposal.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProposal, pointProposal, dateProposal, ranking, buyer, article);
    }
}
