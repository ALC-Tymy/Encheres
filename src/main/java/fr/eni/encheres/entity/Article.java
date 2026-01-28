package fr.eni.encheres.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Article {

    private long idArticle;
    private String name;
    private String description;
    private int originalPoint;
    private Integer finalPoint;
    private LocalDate beginningDate;
    private LocalDate endingDate;
    private String status;
    private Category category;
    private DeliveryAddress deliveryAddress;
    private User buyer;
    private User seller;

    public Article() {
    }

    public Article(long idArticle, String name, String description, int originalPoint, Integer finalPoint, LocalDate beginningDate, LocalDate endingDate, String status, Category category, DeliveryAddress deliveryAddress, User buyer, User seller) {
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
    }

    public Article(String name, String description, int originalPoint, Integer finalPoint, LocalDate beginningDate, LocalDate endingDate, String status, Category category, DeliveryAddress deliveryAddress, User buyer, User seller) {
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

    public Integer getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(Integer finalPoint) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return idArticle == article.idArticle && originalPoint == article.originalPoint && Objects.equals(name, article.name) && Objects.equals(description, article.description) && Objects.equals(finalPoint, article.finalPoint) && Objects.equals(beginningDate, article.beginningDate) && Objects.equals(endingDate, article.endingDate) && Objects.equals(status, article.status) && Objects.equals(category, article.category) && Objects.equals(deliveryAddress, article.deliveryAddress) && Objects.equals(buyer, article.buyer) && Objects.equals(seller, article.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticle, name, description, originalPoint, finalPoint, beginningDate, endingDate, status, category, deliveryAddress, buyer, seller);
    }

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", originalPoint=" + originalPoint +
                ", finalPoint=" + finalPoint +
                ", beginningDate=" + beginningDate +
                ", endingDate=" + endingDate +
                ", status='" + status + '\'' +
                ", category=" + category +
                ", deliveryAddress=" + deliveryAddress +
                ", buyer=" + buyer +
                ", seller=" + seller +
                '}';
    }
}
