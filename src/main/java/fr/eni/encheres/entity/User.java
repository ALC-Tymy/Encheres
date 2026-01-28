package fr.eni.encheres.entity;

import java.util.Objects;
import jakarta.validation.constraints.*;

public class User {
    private long idUser;

    @Size(min=3, max=30, message = "Le pseudo doit contenir entre 3 et 30 caractères")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Le pseudo ne peut contenir que des chiffres et des lettres")
    private String pseudo;

    @Size(min=2, max=30, message = "Le prénom doit contenir entre 2 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ -]+$", message = "Le prénom ne peut contenir que des lettres, des espaces et des tirets")
    private String firstName;

    @Size(min=2, max=30, message = "Le nom doit contenir entre 2 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ -]+$", message = "Le nom ne peut contenir que des lettres, des espaces et des tirets")
    private String lastName;

    @Email(message = "L'adresse email n'est pas valide")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{6,}$", message = "Le mot de passe doit contenir au moins 6 caractères, une majuscule, un chiffre et un caractère spécial")
    private String password;

    @Size(min=3, max=30, message = "L'adresse doit contenir entre 3 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ0-9 -]+$", message = "L'adresse ne peut pas contenir de caractères spéciaux en dehors des espaces et tirets")
    private String address;

    @Size(min=3, max=10, message = "Le code postal doit contenir entre 3 et 10 caractères")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Le code postal n'est pas valide")
    private String zipCode;

    @Size(min=10, max=20, message = "Le numéro de téléphone doit contenir entre 10 et 20 caractères")
    @Pattern(regexp = "^(\\+?[0-9]{1,3}[\\s.-]?)?([0-9][\\s.-]?){6,14}[0-9]$", message = "Le numéro de téléphone n'est pas valide")
    private String phone;

    @Size(min=2, max=30, message = "Le nom de la ville doit contenir entre 2 et 30 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ' -]+$", message = "Le nom de la ville n'est pas valide")
    private String city;

    @PositiveOrZero
    private int walletPoint;

    @PositiveOrZero
    private int walletPending;

    private boolean actif;


    /****************************************/


    public User() {
    }

    public User(String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        this.city = city;
    }

    public User(long idUser, String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city, int walletPoint, int walletPending, boolean actif) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        this.city = city;
        this.walletPoint = walletPoint;
        this.walletPending = walletPending;
        this.actif = actif;
    }

    public User(String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city, int walletPoint, int walletPending, boolean actif) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        this.city = city;
        this.walletPoint = walletPoint;
        this.walletPending = walletPending;
        this.actif = actif;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getWalletPoint() {
        return walletPoint;
    }

    public void setWalletPoint(int walletPoint) {
        this.walletPoint = walletPoint;
    }

    public int getWalletPending() {
        return walletPending;
    }

    public void setWalletPending(int walletPending) {
        this.walletPending = walletPending;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser && walletPoint == user.walletPoint && walletPending == user.walletPending && actif == user.actif && Objects.equals(pseudo, user.pseudo) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(address, user.address) && Objects.equals(zipCode, user.zipCode) && Objects.equals(phone, user.phone) && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, pseudo, firstName, lastName, email, password, address, zipCode, phone, city, walletPoint, walletPending, actif);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", pseudo='" + pseudo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", walletPoint=" + walletPoint +
                ", walletPending=" + walletPending +
                ", actif=" + actif +
                '}';
    }
}
