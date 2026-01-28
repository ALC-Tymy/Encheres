package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Category;
import fr.eni.encheres.entity.DeliveryAddress;
import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ArticleRowMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException{
        Article articleResult = new Article();

        //Attribus principaux du l'article
        articleResult.setIdArticle(rs.getLong("id_article"));
        articleResult.setName(rs.getString("name"));
        articleResult.setDescription(rs.getString("description"));
        articleResult.setOriginalPoint(rs.getInt("original_point"));
        articleResult.setFinalPoint(rs.getInt("final_point"));
        articleResult.setBeginningDate(rs.getObject("beginning_date", LocalDate.class));
        articleResult.setEndingDate(rs.getObject("ending_date", LocalDate.class));
        articleResult.setStatus(rs.getString("status"));

        //User qui est le vendeur de l'article
        Long sellerId = rs.getLong("id_user_seller");
        if(!rs.wasNull()){
            User user = new User();
            user.setIdUser(rs.getLong("id_user_seller"));
            user.setPseudo(rs.getString("pseudo_seller"));
            user.setEmail(rs.getString("email_seller"));
            user.setPassword(rs.getString("password_seller"));
            user.setFirstName(rs.getString("first_name_seller"));
            user.setLastName(rs.getString("last_name_seller"));
            user.setAddress(rs.getString("address_seller"));
            user.setZipCode(rs.getString("zipcode_seller"));
            user.setCity(rs.getString("city_seller"));
            user.setPhone(rs.getString("phone_seller"));
            user.setWalletPoint(rs.getInt("walletPoint_seller"));
            user.setWalletPending(rs.getInt("walletPending_seller"));
            user.setActif(rs.getBoolean("actif_seller"));
            articleResult.setSeller(user);
        }

        //User qui a fait acheté l'article
        Long buyerId = rs.getLong("id_user_buyer");
        if(!rs.wasNull()){
            User user = new User();
            user.setIdUser(rs.getLong("id_user_buyer"));
            user.setPseudo(rs.getString("pseudo_buyer"));
            user.setEmail(rs.getString("email_buyer"));
            user.setPassword(rs.getString("password_buyer"));
            user.setFirstName(rs.getString("first_name_buyer"));
            user.setLastName(rs.getString("last_name_buyer"));
            user.setAddress(rs.getString("address_buyer"));
            user.setZipCode(rs.getString("zipcode_buyer"));
            user.setCity(rs.getString("city_buyer"));
            user.setPhone(rs.getString("phone_buyer"));
            user.setWalletPoint(rs.getInt("walletPoint_buyer"));
            user.setWalletPending(rs.getInt("walletPending_buyer"));
            user.setActif(rs.getBoolean("actif_buyer"));
            articleResult.setBuyer(user);
        }

        // categorie de l'article
        Long categoryId = rs.getLong("id_category");
        if(!rs.wasNull()) {
            Category category = new Category();
            category.setIdCategory(rs.getLong("id_category"));
            category.setName(rs.getString("name_category"));
            articleResult.setCategory(category);
        }

        // adresse de livraison
        Long deliveryAddressId = rs.getLong("id_delivery_address");
        if(!rs.wasNull()){
            DeliveryAddress deliveryAddress = new DeliveryAddress();
            deliveryAddress.setIdDeladdress(rs.getLong("id_delivery_address"));
            deliveryAddress.setAddress(rs.getString("address_delivery_address"));
            deliveryAddress.setZipCode(rs.getString("zipCode_delivery_address"));
            deliveryAddress.setCity(rs.getString("city_delivery_address"));
            articleResult.setDeliveryAddress(deliveryAddress);
        }
        return articleResult;
    }
}
