package fr.eni.encheres.repository;

import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositorySQL implements UserRepository{
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createUser(User user){
        String sql = "INSERT INTO USER (pseudo, email, password, firstname, lastname, address, zipcode,city, phone, walletPoint, walletPending) " +
                " VALUES (:pseudo, :email, :password, :firstname, :lastname, :address, :zipcode, :city, :phone, :walletPoint, :walletPending)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("pseudo", user.getPseudo());
        map.addValue("email", user.getEmail());
        map.addValue("password", user.getPassword());
        map.addValue("firstname", user.getFirstName());
        map.addValue("lastname", user.getLastName());
        map.addValue("address", user.getAdress());
        map.addValue("zipcode",user.getZipCode());
        map.addValue("city", user.getCity());
        map.addValue("phone", user.getPhone());
        map.addValue("walletPoint", user.getWalletPoint());
        map.addValue("walletPending", user.getWalletPending());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<User> readAll(){
        String sql = "SELECT user.id as id_user, ";
    }

    @Override
    public void updateUser(User user){
        String sql = "UPDATE USER SET pseudo=:pseudo, email=:email, password=:password, firstname=:firstname, lastname=:lastname, address=:address, zipcode=:zipcode, city=:city, phone=:phone, walletPoint=:walletPoint, walletPending=:walletPending";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, map);
    }
}
