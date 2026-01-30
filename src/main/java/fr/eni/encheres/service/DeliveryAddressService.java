package fr.eni.encheres.service;

import fr.eni.encheres.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {

    void createDeliveryAddress(DeliveryAddress deliveryAddress);

    List<DeliveryAddress> readAll();

    DeliveryAddress readById(long id);

    void updateDeliveryAddress(DeliveryAddress deliveryAddress);

    void deleteDeliveryAddress(long id);

    DeliveryAddress existingCreate(String address, String zipCode, String city);
}
