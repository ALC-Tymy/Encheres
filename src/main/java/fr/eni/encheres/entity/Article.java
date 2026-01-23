package fr.eni.encheres.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Article {

    private long idArticle;
    private String name;
    private String description;
    private int originalPoint;
    private int finalPoint;
    private LocalDate beginningDate;
    private LocalDate endingDate;
    private String status;
    private Category category;
    private DeliveryAddress deliveryAddress;
    private User buyer;
    private User seller;
    private List<Proposal> proposalArticleList = new ArrayList<>();

    public Article() {
    }

    /**
     * @param idArticle
     * @param name
     * @param description
     * @param originalPoint
     * @param finalPoint
     * @param beginningDate
     * @param endingDate
     * @param status
     */
    public Article(long idArticle, String name, String description, int originalPoint, int finalPoint, LocalDate beginningDate, LocalDate endingDate, String status) {
        this.idArticle = idArticle;
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.status = status;
    }

    /**
     * @param name
     * @param description
     * @param originalPoint
     * @param finalPoint
     * @param beginningDate
     * @param endingDate
     * @param status
     */
    public Article(String name, String description, int originalPoint, int finalPoint, LocalDate beginningDate, LocalDate endingDate, String status) {
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.status = status;
    }

    /**
     * @param idArticle
     * @param name
     * @param description
     * @param originalPoint
     * @param finalPoint
     * @param beginningDate
     * @param endingDate
     * @param status
     * @param category
     * @param deliveryAddress
     * @param buyer
     * @param seller
     * @param proposalArticleList
     */
    public Article(long idArticle, String name, String description, int originalPoint, int finalPoint, LocalDate beginningDate, LocalDate endingDate, String status, Category category,
                   DeliveryAddress deliveryAddress, User buyer, User seller, List<Proposal> proposalArticleList) {
        this.idArticle = idArticle;
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.status = status;
        this.category = category;
        this.deliveryAddress = deliveryAddress;
        this.buyer = buyer;
        this.seller = seller;
        this.proposalArticleList = proposalArticleList;
    }

    /**
     * @param name
     * @param description
     * @param originalPoint
     * @param finalPoint
     * @param beginningDate
     * @param endingDate
     * @param status
     * @param category
     * @param deliveryAddress
     * @param buyer
     * @param seller
     * @param proposalArticleList
     */
    public Article(String name, String description, int originalPoint, int finalPoint, LocalDate beginningDate, LocalDate endingDate, String status, Category category,
                   DeliveryAddress deliveryAddress, User buyer, User seller, List<Proposal> proposalArticleList) {
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.status = status;
        this.category = category;
        this.deliveryAddress = deliveryAddress;
        this.buyer = buyer;
        this.seller = seller;
        this.proposalArticleList = proposalArticleList;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOriginalPoint() {
        return originalPoint;
    }

    public void setOriginalPoint(int originalPoint) {
        this.originalPoint = originalPoint;
    }

    public int getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(int finalPoint) {
        this.finalPoint = finalPoint;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<Proposal> getProposalArticleList() {
        return proposalArticleList;
    }

    public void setProposalArticleList(List<Proposal> proposalArticleList) {
        this.proposalArticleList = proposalArticleList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Article{");
        sb.append("idArticle=").append(idArticle);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", originalPoint=").append(originalPoint);
        sb.append(", finalPoint=").append(finalPoint);
        sb.append(", beginningDate=").append(beginningDate);
        sb.append(", endingDate=").append(endingDate);
        sb.append(", status='").append(status).append('\'');
        sb.append(", category=").append(category);
        sb.append(", deliveryAddress=").append(deliveryAddress);
        sb.append(", buyer=").append(buyer);
        sb.append(", seller=").append(seller);
        sb.append(", proposalArticleList=").append(proposalArticleList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;
        return idArticle == article.idArticle && originalPoint == article.originalPoint && finalPoint == article.finalPoint && name.equals(article.name) && description.equals(article.description) && beginningDate.equals(article.beginningDate) && endingDate.equals(article.endingDate) && status.equals(article.status) && category.equals(article.category) && deliveryAddress.equals(article.deliveryAddress) && buyer.equals(article.buyer) && seller.equals(article.seller) && proposalArticleList.equals(article.proposalArticleList);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idArticle);
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + originalPoint;
        result = 31 * result + finalPoint;
        result = 31 * result + beginningDate.hashCode();
        result = 31 * result + endingDate.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + deliveryAddress.hashCode();
        result = 31 * result + buyer.hashCode();
        result = 31 * result + seller.hashCode();
        result = 31 * result + proposalArticleList.hashCode();
        return result;
    }
}
