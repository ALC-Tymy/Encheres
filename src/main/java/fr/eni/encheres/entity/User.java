package fr.eni.encheres.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private long idUser;
    private String pseudo;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String zipCode;
    private String phone;
    private String city;
    private int walletPoint = 0;
    private int walletPending;

    public User() {
    }

    public User(long idUser, String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city, int walletPoint, int walletPending) {
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
    }

    public User(String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city, int walletPoint, int walletPending) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser && walletPoint == user.walletPoint && walletPending == user.walletPending && Objects.equals(pseudo, user.pseudo) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(address, user.address) && Objects.equals(zipCode, user.zipCode) && Objects.equals(phone, user.phone) && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, pseudo, firstName, lastName, email, password, address, zipCode, phone, city, walletPoint, walletPending);
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
                '}';
    }
}
