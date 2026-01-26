package fr.eni.encheres.repository;

import fr.eni.encheres.entity.DeliveryAddress;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryAddressRepositorySQL implements DeliveryAddressRepository{
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DeliveryAddressRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createDeliveryAddress(DeliveryAddress deliveryAddress){
        String sql = "INSERT INTO DELIVERY_ADDRESS (address, zipcode, city)" +
                " VALUES (:address, :zipcode, :city)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("address", deliveryAddress.getAddress());
        map.addValue("zipcode", deliveryAddress.getZipCode());
        map.addValue("city", deliveryAddress.getCity());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<DeliveryAddress> readAll(){
        String sql = "SELECT * FROM DELIVERY_ADDRESS";
        List<DeliveryAddress> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DeliveryAddress.class));
        return list;
    }

    @Override
    public DeliveryAddress readById(long id){
        String sql = "SELECT * FROM DELIVERY_ADDRESS WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        DeliveryAddress deliveryAddress = namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(DeliveryAddress.class));
        return deliveryAddress;
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress){
        String sql = "UPDATE DELIVERY_ADDRESS SET address=:address, zipcode=:zipcode, city=:city";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource();
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteDeliveryAddress(long id){
        String sql = "DELETE FROM DELIVERY_ADDRESS WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        this.namedParameterJdbcTemplate.update(sql, map);
    }

}
