package fr.eni.encheres.entity;

public class DeliveryAdress {

    private long idDeladdress;
    private String Address;
    private String zipCode;
    private String city;

    public DeliveryAdress() {
    }

    public DeliveryAdress(long idDeladress, String adress, String zipCode, String city) {
        this.idDeladdress = idDeladress;
        Address = adress;
        this.zipCode = zipCode;
        this.city = city;
    }

    public DeliveryAdress(String adress, String zipCode, String city) {
        Address = adress;
        this.zipCode = zipCode;
        this.city = city;
    }

    public long getIdDeladress() {
        return idDeladdress;
    }

    public void setIdDeladress(long idDeladress) {
        this.idDeladdress = idDeladress;
    }

    public String getAdress() {
        return Address;
    }

    public void setAdress(String adress) {
        Address = adress;
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
        final StringBuffer sb = new StringBuffer("DeliveryAdress{");
        sb.append("idDeladdress=").append(idDeladdress);
        sb.append(", Address='").append(Address).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryAdress that = (DeliveryAdress) o;
        return idDeladdress == that.idDeladdress && Address.equals(that.Address) && zipCode.equals(that.zipCode) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idDeladdress);
        result = 31 * result + Address.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
