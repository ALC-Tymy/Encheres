package fr.eni.encheres.entity;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAddress {

    private long idDeladress;
    private String Adress;
    private String zipCode;
    private String city;
    private List<Article> articleAdressList = new ArrayList<>();

    public DeliveryAddress() {
    }

    /**
     *
     * @param idDeladress
     * @param adress
     * @param zipCode
     * @param city
     */
    public DeliveryAddress(long idDeladress, String adress, String zipCode, String city) {
        this.idDeladress = idDeladress;
        Adress = adress;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * @param adress
     * @param zipCode
     * @param city
     */
    public DeliveryAddress(String adress, String zipCode, String city) {
        Adress = adress;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * @param idDeladress
     * @param adress
     * @param zipCode
     * @param city
     * @param articleAdressList
     */
    public DeliveryAddress(long idDeladress, String adress, String zipCode, String city, List<Article> articleAdressList) {
        this.idDeladress = idDeladress;
        Adress = adress;
        this.zipCode = zipCode;
        this.city = city;
        this.articleAdressList = articleAdressList;
    }

    /**
     * @param adress
     * @param zipCode
     * @param city
     * @param articleAdressList
     */
    public DeliveryAddress(String adress, String zipCode, String city, List<Article> articleAdressList) {
        Adress = adress;
        this.zipCode = zipCode;
        this.city = city;
        this.articleAdressList = articleAdressList;
    }

    public long getIdDeladress() {
        return idDeladress;
    }

    public void setIdDeladress(long idDeladress) {
        this.idDeladress = idDeladress;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
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

    public List<Article> getArticleAdressList() {
        return articleAdressList;
    }

    public void setArticleAdressList(List<Article> articleAdressList) {
        this.articleAdressList = articleAdressList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeliveryAddress{");
        sb.append("idDeladress=").append(idDeladress);
        sb.append(", Adress='").append(Adress).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", articleAdressList=").append(articleAdressList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryAddress that = (DeliveryAddress) o;
        return idDeladress == that.idDeladress && Adress.equals(that.Adress) && zipCode.equals(that.zipCode) && city.equals(that.city) && articleAdressList.equals(that.articleAdressList);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idDeladress);
        result = 31 * result + Adress.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + articleAdressList.hashCode();
        return result;
    }
}
