package fr.eni.encheres.repository;

import fr.eni.encheres.entity.DeliveryAddress;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryAddressRepositorySQL implements DeliveryAddressRepository {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DeliveryAddressRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createDeliveryAddress(DeliveryAddress deliveryAddress) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO DELIVERY_ADDRESS (address, zipcode, city)" +
                " VALUES (:address, :zipcode, :city)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("address", deliveryAddress.getAddress());
        map.addValue("zipcode", deliveryAddress.getZipCode());
        map.addValue("city", deliveryAddress.getCity());

        namedParameterJdbcTemplate.update(sql, map, keyHolder);
        long id = keyHolder.getKey().longValue();
        deliveryAddress.setIdDeladdress(id);
    }

    @Override
    public List<DeliveryAddress> readAll() {
        String sql = "SELECT * FROM DELIVERY_ADDRESS";
        List<DeliveryAddress> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DeliveryAddress.class));
        return list;
    }

    @Override
    public DeliveryAddress readById(long id) {
        String sql = "SELECT * FROM DELIVERY_ADDRESS WHERE id_delivery_address=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        DeliveryAddress deliveryAddress = namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(DeliveryAddress.class));
        return deliveryAddress;
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        String sql = "UPDATE DELIVERY_ADDRESS SET address=:address, zipcode=:zipcode, city=:city WHERE id_delivery_address=idDeliveryAddress;";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(DeliveryAddress.class);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteDeliveryAddress(long id) {
        String sql = "DELETE FROM DELIVERY_ADDRESS WHERE id_delivery_address=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        this.namedParameterJdbcTemplate.update(sql, map);
    }

    /**
     * Recherche une adresse existante en base de données afin d'éviter les doublons.
     *
     * @return l'adresse trouvée ou null si aucune correspondance n'existe
     */
    @Override
    public DeliveryAddress SearchDoublonAddress(String address, String zipCode, String city) {
        String sql = """
                SELECT TOP 1 id_delivery_address AS idDeladdress, address, zipcode AS zipCode, city
                FROM DELIVERY_ADDRESS
                WHERE address = :address
                AND zipcode = :zipcode
                AND city = :city
                ;
                """;
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("address", address);
        map.addValue("zipcode", zipCode);
        map.addValue("city", city);

        List<DeliveryAddress> addressList = namedParameterJdbcTemplate.query(
                sql,
                map,
                new BeanPropertyRowMapper<>(DeliveryAddress.class)
        );

        return addressList.stream().findFirst().orElse(null);
    }

}
