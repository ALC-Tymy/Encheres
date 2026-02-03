package fr.eni.encheres.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class Article {

    private long idArticle;
    private String name;
    private String description;
    private int originalPoint;
    private Integer finalPoint;
    private LocalDateTime beginningDate;
    private LocalDateTime endingDate;
    private String status;
    private Category category;
    private DeliveryAddress deliveryAddress;
    private User buyer;
    private User seller;
    private String imagePath;

    public Article() {
    }


    public Article(long idArticle, String name, String description, int originalPoint, Integer finalPoint, LocalDateTime beginningDate, LocalDateTime endingDate, String status, Category category, DeliveryAddress deliveryAddress, User buyer, User seller, String imagePath) {
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
        this.imagePath = imagePath;
    }

    public Article(String name, String description, int originalPoint, Integer finalPoint, LocalDateTime beginningDate, LocalDateTime endingDate, String status, Category category, DeliveryAddress deliveryAddress, User buyer, User seller, String imagePath) {
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
        this.imagePath = imagePath;
    }

    public Article(String name, String description, int originalPoint, LocalDateTime beginningDate, LocalDateTime endingDate, Category category, User seller) {
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.category = category;
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

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDateTime getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDateTime beginningDate) {
        this.beginningDate = beginningDate;
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

    public String getImagePath() {return imagePath;}

    public void setImagePath(String imagePath) {this.imagePath = imagePath;}


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return getIdArticle() == article.getIdArticle() && getOriginalPoint() == article.getOriginalPoint() && Objects.equals(getName(), article.getName()) && Objects.equals(getDescription(), article.getDescription()) && Objects.equals(getFinalPoint(), article.getFinalPoint()) && Objects.equals(getBeginningDate(), article.getBeginningDate()) && Objects.equals(getEndingDate(), article.getEndingDate()) && Objects.equals(getStatus(), article.getStatus()) && Objects.equals(getCategory(), article.getCategory()) && Objects.equals(getDeliveryAddress(), article.getDeliveryAddress()) && Objects.equals(getBuyer(), article.getBuyer()) && Objects.equals(getSeller(), article.getSeller()) && Objects.equals(getImagePath(), article.getImagePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdArticle(), getName(), getDescription(), getOriginalPoint(), getFinalPoint(), getBeginningDate(), getEndingDate(), getStatus(), getCategory(), getDeliveryAddress(), getBuyer(), getSeller(), getImagePath());
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
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}