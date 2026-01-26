package fr.eni.encheres.repository;

import fr.eni.encheres.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressRepository {
    void createDeliveryAddress(DeliveryAddress deliveryAddress);

    List<DeliveryAddress> readAll();

    DeliveryAddress readById(long id);

    void updateDeliveryAddress(DeliveryAddress deliveryAddress);

    void deleteDeliveryAddress(long id);
}
