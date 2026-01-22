package fr.eni.encheres.bo;

public class DeliveryAdress {

    private long idDeladress;
    private String Adress;
    private String zipCode;
    private String city;

    public DeliveryAdress() {
    }

    public DeliveryAdress(long idDeladress, String adress, String zipCode, String city) {
        this.idDeladress = idDeladress;
        Adress = adress;
        this.zipCode = zipCode;
        this.city = city;
    }

    public DeliveryAdress(String adress, String zipCode, String city) {
        Adress = adress;
        this.zipCode = zipCode;
        this.city = city;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeliveryAdress{");
        sb.append("idDeladress=").append(idDeladress);
        sb.append(", Adress='").append(Adress).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryAdress that = (DeliveryAdress) o;
        return idDeladress == that.idDeladress && Adress.equals(that.Adress) && zipCode.equals(that.zipCode) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(idDeladress);
        result = 31 * result + Adress.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
