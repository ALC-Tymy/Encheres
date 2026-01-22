package fr.eni.encheres.entity;

import java.time.LocalDate;

public class Proposal {

    private long idProposal;
    private int pointProposal;
    private LocalDate dateProposal;
    private boolean isNumberOne;
    private User user;
    private Article article;

    public Proposal() {
    }

    public Proposal(long idProposal, int pointProposal, LocalDate dateProposal, boolean isNumberOne, User user, Article article) {
        this.idProposal = idProposal;
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.isNumberOne = isNumberOne;
        this.user = user;
        this.article = article;
    }

    public Proposal(int pointProposal, LocalDate dateProposal, boolean isNumberOne, User user, Article article) {
        this.pointProposal = pointProposal;
        this.dateProposal = dateProposal;
        this.isNumberOne = isNumberOne;
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

    public boolean isNumberOne() {
        return isNumberOne;
    }

    public void setNumberOne(boolean numberOne) {
        isNumberOne = numberOne;
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
        sb.append(", isNumberOne=").append(isNumberOne);
        sb.append(", user=").append(user);
        sb.append(", article=").append(article);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Proposal proposal = (Proposal) o;
        return idProposal == proposal.idProposal && pointProposal == proposal.pointProposal && isNumberOne == proposal.isNumberOne && dateProposal.equals(proposal.dateProposal) && user.equals(proposal.user) && article.equals(proposal.article);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idProposal);
        result = 31 * result + pointProposal;
        result = 31 * result + dateProposal.hashCode();
        result = 31 * result + Boolean.hashCode(isNumberOne);
        result = 31 * result + user.hashCode();
        result = 31 * result + article.hashCode();
        return result;
    }
}
