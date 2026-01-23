package fr.eni.encheres.entity;

import java.time.LocalDate;

public class Proposal {

    private long idProposal;
    private int pointProposal;
    private LocalDate dateProposal;
    private int ranking;
    private User user;
    private Article article;

    public Proposal() {
    }

    /**
     * @param idProposal
     * @param pointProposal
     * @param dateProposal
     * @param ranking
     */
    public Proposal(long idProposal, int pointProposal, LocalDate dateProposal, int ranking) {
        this.idProposal = idProposal;
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.ranking = ranking;
    }

    /**
     * @param pointProposal
     * @param dateProposal
     * @param ranking
     */
    public Proposal(int pointProposal, LocalDate dateProposal, int ranking) {
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.ranking = ranking;
    }

    /**
     * @param idProposal
     * @param pointProposal
     * @param dateProposal
     * @param ranking
     * @param user
     * @param article
     */
    public Proposal(long idProposal, int pointProposal, LocalDate dateProposal, int ranking, User user, Article article) {
        this.idProposal = idProposal;
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.ranking = ranking;
        this.user = user;
        this.article = article;
    }

    /**
     * @param pointProposal
     * @param dateProposal
     * @param ranking
     * @param user
     * @param article
     */
    public Proposal(int pointProposal, LocalDate dateProposal, int ranking, User user, Article article) {
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.ranking = ranking;
        this.user = user;
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

    public LocalDate getDateProposal() {
        return dateProposal;
    }

    public void setDateProposal(LocalDate dateProposal) {
        this.dateProposal = dateProposal;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Proposal{");
        sb.append("idProposal=").append(idProposal);
        sb.append(", pointProposal=").append(pointProposal);
        sb.append(", dateProposal=").append(dateProposal);
        sb.append(", ranking=").append(ranking);
        sb.append(", user=").append(user);
        sb.append(", article=").append(article);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Proposal proposal = (Proposal) o;
        return idProposal == proposal.idProposal && pointProposal == proposal.pointProposal && ranking == proposal.ranking && dateProposal.equals(proposal.dateProposal) && user.equals(proposal.user) && article.equals(proposal.article);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idProposal);
        result = 31 * result + pointProposal;
        result = 31 * result + dateProposal.hashCode();
        result = 31 * result + ranking;
        result = 31 * result + user.hashCode();
        result = 31 * result + article.hashCode();
        return result;
    }
}
