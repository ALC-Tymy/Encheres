package fr.eni.encheres.entity.dto;

import fr.eni.encheres.entity.Category;

import java.time.LocalDateTime;

public class CreateArticleDTO {
    //DTO de Article
    private String name;
    private String description;
    private int originalPoint;
    private LocalDateTime beginningDate;
    private LocalDateTime endingDate;
    private Category category;
    //DTO De DeliveryAddress
    private String address;
    private String zipCode;
    private String city;

    public CreateArticleDTO() {
    }

    public CreateArticleDTO(String name, String description, int originalPoint, LocalDateTime beginningDate, LocalDateTime endingDate, Category category, String address, String zipCode, String city) {
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.category = category;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CreateArticleDTO{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", originalPoint=" + originalPoint + ", beginningDate=" + beginningDate + ", endingDate=" + endingDate + ", category=" + category + ", address='" + address + '\'' + ", zipCode='" + zipCode + '\'' + ", city='" + city + '\'' + '}';
    }
}
