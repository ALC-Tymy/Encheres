package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User userResult = new User();

        userResult.setIdUser(rs.getLong("id_user"));
        userResult.setPseudo(rs.getString("pseudo_user"));
        userResult.setFirstName(rs.getString("firstname_user"));
        userResult.setLastName(rs.getString("lastname_user"));
        userResult.setEmail(rs.getString("email_user"));
        userResult.setPassword(rs.getString("password_user"));
        userResult.setAddress(rs.getString("address_user"));
        userResult.setZipCode(rs.getString("zipCode_user"));
        userResult.setPhone(rs.getString("phone_user"));
        userResult.setCity(rs.getString("city_user"));
        userResult.setWalletPoint(rs.getInt("walletPoint_user"));
        userResult.setWalletPending(rs.getInt("walletPending_user"));
        userResult.setActif(rs.getBoolean("actif_user"));

        return userResult;
    }

}
