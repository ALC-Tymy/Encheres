package fr.eni.encheres.entity.dto;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Category;
import fr.eni.encheres.entity.User;
import jakarta.validation.constraints.*;


import java.time.LocalDateTime;

public class CreateArticleDTO {
    //DTO de Article

    @Size(min = 4, max = 30, message = "Le nom de l''article doit contenir entre 4 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ -]+$", message = "Le nom de l''article ne peut contenir que des lettres, des espaces et des tirets")
    private String name;
    @Size(min = 4, max = 500, message = "La description de l''article doit contenir entre 4 et 500 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ -]+$", message = "La description de l''article ne peut contenir que des lettres, des espaces et des tirets")
    private String description;

    private int originalPoint;
    private int finalPoint;

    @FutureOrPresent(message = "La date de début doit être dans le présent ou le futur")
    @NotNull(message = "La date de début est obligatoire")
    private LocalDateTime beginningDate;

    @Future(message = "La date de fin doit être dans le futur")
    @NotNull(message = "La date de fin est obligatoire")
    private LocalDateTime endingDate;

    @NotNull(message = "Veuillez sélectionner une catégorie")
    private Category category;

    private User seller;

    //DTO De DeliveryAddress
    @Size(min = 3, max = 30, message = "L''adresse doit contenir entre 3 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9 -]+$", message = "L''adresse ne peut pas contenir de caractères spéciaux en dehors des espaces et tirets")
    private String address;
    @Size(min = 3, max = 10, message = "Le code postal doit contenir entre 3 et 10 caractères")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Le code postal n''est pas valide")
    private String zipCode;
    @Size(min = 2, max = 30, message = "Le nom de la ville doit contenir entre 2 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ' -]+$", message = "Le nom de la ville n''est pas valide")
    private String city;

    public CreateArticleDTO() {
    }


    public CreateArticleDTO(String name, String description, int originalPoint, int finalPoint, LocalDateTime beginningDate, LocalDateTime endingDate, Category category, User seller, String address, String zipCode, String city) {
        this.name = name;
        this.description = description;
        this.originalPoint = originalPoint;
        this.finalPoint = finalPoint;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.category = category;
        this.seller = seller;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(int finalPoint) {
        this.finalPoint = finalPoint;
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
        this.finalPoint = originalPoint;
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

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
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
        return "CreateArticleDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", originalPoint=" + originalPoint +
                ", finalPoint=" + finalPoint +
                ", beginningDate=" + beginningDate +
                ", endingDate=" + endingDate +
                ", category=" + category +
                ", seller=" + seller +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
