package fr.eni.encheres.entity;

import java.util.ArrayList;
import java.util.List;

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
    private List<Article> buyingList = new ArrayList<>();
    private List<Article> sellingList = new ArrayList<>();
    private List<Proposal> proposalUserList = new ArrayList<>();

    public User() {
    }

    /**
     * @param idUser
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param zipCode
     * @param phone
     * @param city
     * @param walletPoint
     * @param walletPending
     */
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

    /**
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param zipCode
     * @param phone
     * @param city
     * @param walletPoint
     * @param walletPending
     */
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

    /**
     * @param idUser
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param zipCode
     * @param phone
     * @param city
     * @param walletPoint
     * @param walletPending
     * @param buyingList
     * @param sellingList
     * @param proposalUserList
     */
    public User(long idUser, String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city,
                int walletPoint, int walletPending, List<Article> buyingList, List<Article> sellingList, List<Proposal> proposalUserList) {
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
        this.buyingList = buyingList;
        this.sellingList = sellingList;
        this.proposalUserList = proposalUserList;
    }

    /**
     * @param pseudo
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param address
     * @param zipCode
     * @param phone
     * @param city
     * @param walletPoint
     * @param walletPending
     * @param buyingList
     * @param sellingList
     * @param proposalUserList
     */
    public User(String pseudo, String firstName, String lastName, String email, String password, String address, String zipCode, String phone, String city,
                int walletPoint, int walletPending, List<Article> buyingList, List<Article> sellingList, List<Proposal> proposalUserList) {
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
        this.buyingList = buyingList;
        this.sellingList = sellingList;
        this.proposalUserList = proposalUserList;
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

    public List<Article> getBuyingList() {
        return buyingList;
    }

    public void setBuyingList(List<Article> buyingList) {
        this.buyingList = buyingList;
    }

    public List<Article> getSellingList() {
        return sellingList;
    }

    public void setSellingList(List<Article> sellingList) {
        this.sellingList = sellingList;
    }

    public List<Proposal> getProposalUserList() {
        return proposalUserList;
    }

    public void setProposalUserList(List<Proposal> proposalUserList) {
        this.proposalUserList = proposalUserList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", pseudo='").append(pseudo).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", walletPoint=").append(walletPoint);
        sb.append(", walletPending=").append(walletPending);
        sb.append(", buyingList=").append(buyingList);
        sb.append(", sellingList=").append(sellingList);
        sb.append(", proposalUserList=").append(proposalUserList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return idUser == user.idUser && walletPoint == user.walletPoint && walletPending == user.walletPending && pseudo.equals(user.pseudo) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password) && address.equals(user.address) && zipCode.equals(user.zipCode) && phone.equals(user.phone) && city.equals(user.city) && buyingList.equals(user.buyingList) && sellingList.equals(user.sellingList) && proposalUserList.equals(user.proposalUserList);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idUser);
        result = 31 * result + pseudo.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + walletPoint;
        result = 31 * result + walletPending;
        result = 31 * result + buyingList.hashCode();
        result = 31 * result + sellingList.hashCode();
        result = 31 * result + proposalUserList.hashCode();
        return result;
    }
}
