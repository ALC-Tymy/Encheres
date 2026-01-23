package fr.eni.encheres.entity;

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
        this.address = adress;
        this.zipCode = zipCode;
        this.phone = phone;
        this.city = city;
        this.walletPoint = walletPoint;
        this.walletPending = walletPending;
    }

    public User(String pseudo, String firstName, String lastName, String email, String password, String adress, String zipCode, String phone, String city, int walletPoint, int walletPending) {
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = adress;
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

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
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
        return idUser == user.idUser && walletPoint == user.walletPoint && walletPending == user.walletPending && pseudo.equals(user.pseudo) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password) && address.equals(user.address) && zipCode.equals(user.zipCode) && phone.equals(user.phone) && city.equals(user.city);
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
        return result;
    }
}
