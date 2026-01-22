package fr.eni.encheres.bo;

import java.time.LocalDate;

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
    private DeliveryAdress deliveryAdress;
    private User buyer;
    private User seller;

    public Article() {
    }

    public Article(long idArticle, String name, String description, int originalPoint, int finalPoint, LocalDate beginningDate, String status, LocalDate endingDate, Category category, DeliveryAdress deliveryAdress, User buyer, User seller) {
        this.idArticle = idArticle;
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.status = status;
        this.endingDate = endingDate;
        this.category = category;
        this.deliveryAdress = deliveryAdress;
        this.buyer = buyer;
        this.seller = seller;
    }

    public Article(String name, String description, int originalPoint, int finalPoint, LocalDate beginningDate, LocalDate endingDate, String status, Category category, DeliveryAdress deliveryAdress, User buyer, User seller) {
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.status = status;
        this.category = category;
        this.deliveryAdress = deliveryAdress;
        this.buyer = buyer;
        this.seller = seller;
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

    public DeliveryAdress getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(DeliveryAdress deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
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
        sb.append(", deliveryAdress=").append(deliveryAdress);
        sb.append(", buyer=").append(buyer);
        sb.append(", seller=").append(seller);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;
        return idArticle == article.idArticle && originalPoint == article.originalPoint && finalPoint == article.finalPoint && name.equals(article.name) && description.equals(article.description) && beginningDate.equals(article.beginningDate) && endingDate.equals(article.endingDate) && status.equals(article.status) && category.equals(article.category) && deliveryAdress.equals(article.deliveryAdress) && buyer.equals(article.buyer) && seller.equals(article.seller);
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
        result = 31 * result + deliveryAdress.hashCode();
        result = 31 * result + buyer.hashCode();
        result = 31 * result + seller.hashCode();
        return result;
    }
}
