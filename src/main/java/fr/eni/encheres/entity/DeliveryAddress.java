package fr.eni.encheres.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeliveryAddress {

    private long idDeladdress;
    private String address;
    private String zipCode;
    private String city;

    public DeliveryAddress() {
    }

    public DeliveryAddress(long idDeladdress, String address, String zipCode, String city) {
        this.idDeladdress = idDeladdress;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public DeliveryAddress(String address, String zipCode, String city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public long getIdDeladdress() {
        return idDeladdress;
    }

    public void setIdDeladdress(long idDeladdress) {
        this.idDeladdress = idDeladdress;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAddress that = (DeliveryAddress) o;
        return idDeladdress == that.idDeladdress && Objects.equals(address, that.address) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDeladdress, address, zipCode, city);
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "idDeladdress=" + idDeladdress +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
