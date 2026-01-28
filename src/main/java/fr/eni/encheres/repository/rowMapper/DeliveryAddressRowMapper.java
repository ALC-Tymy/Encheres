package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.DeliveryAddress;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryAddressRowMapper implements RowMapper<DeliveryAddress> {
    @Override
    public DeliveryAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
        DeliveryAddress deliveryAddressResult = new DeliveryAddress();

        deliveryAddressResult.setIdDeladdress(rs.getLong("id_deliveryAddress"));
        deliveryAddressResult.setAddress(rs.getString("address_deliveryAddress"));
        deliveryAddressResult.setZipCode(rs.getString("zipCode_deliveryAddress"));
        deliveryAddressResult.setCity(rs.getString("city_deliveryAddress"));

        return null;
    }
}
