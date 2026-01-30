package fr.eni.encheres.service;

import fr.eni.encheres.entity.DeliveryAddress;
import fr.eni.encheres.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

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

    @Override
    public DeliveryAddress existingCreate(String address, String zipCode, String city) {

        // Nettoie les valeurs reçues (suppression des espaces inutiles)
        String valaddress = address.trim();
        String valzipcode = zipCode.trim();
        String valcity = city.trim();

        // Vérifie si une adresse identique existe déjà en base de données
        DeliveryAddress existing =
                deliveryAddressRepository.SearchDoublonAddress(valaddress, valzipcode, valcity);

        // Si une adresse existe déjà, on la retourne directement
        if (existing != null) {
            return existing;
        }

        // Création d'une nouvelle instance de DeliveryAddress
        DeliveryAddress deliveryAddress =
                new DeliveryAddress(valaddress, valzipcode, valcity);

        // Persiste la nouvelle adresse en base de données
        deliveryAddressRepository.createDeliveryAddress(deliveryAddress);

        return deliveryAddress;
    }

}
