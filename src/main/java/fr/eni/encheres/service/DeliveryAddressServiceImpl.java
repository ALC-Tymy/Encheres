package fr.eni.encheres.service;

import fr.eni.encheres.entity.DeliveryAddress;
import fr.eni.encheres.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService{

    DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressServiceImpl(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    @Override
    public void createDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddressRepository.createDeliveryAddress(deliveryAddress);
    }

    @Override
    public List<DeliveryAddress> readAll() {
        return this.deliveryAddressRepository.readAll();
    }

    @Override
    public DeliveryAddress readById(long id) {
        return this.deliveryAddressRepository.readById(id);
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddressRepository.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public void deleteDeliveryAddress(long id) {
        this.deliveryAddressRepository.deleteDeliveryAddress(id);
    }
}
