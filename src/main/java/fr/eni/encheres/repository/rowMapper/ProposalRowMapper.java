package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ProposalRowMapper implements RowMapper<Proposal> {
    @Override
    public Proposal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Proposal proposalResult = new Proposal();

        //Attribus principaux de Proposal
        proposalResult.setIdProposal(rs.getLong("id_proposal"));
        proposalResult.setPointProposal(rs.getInt("pointProposal_proposal"));
        proposalResult.setDateProposal(rs.getObject("dateProposal_proposal", LocalDate.class));
        proposalResult.setRanking(rs.getInt("ranking_proposal"));

        //Article correspondant à la proposition
        Long articleId = rs.getLong("id_article");
        if(!rs.wasNull()) {
            Article article = new Article();
            article.setIdArticle(rs.getLong("id_article"));
            article.setName(rs.getString("name"));
            article.setDescription(rs.getString("description"));
            article.setOriginalPoint(rs.getInt("originalPoint"));
            article.setFinalPoint(rs.getInt("final_point"));
            article.setBeginningDate(rs.getObject("beginning_date", LocalDate.class));
            article.setEndingDate(rs.getObject("ending_date", LocalDate.class));
            article.setStatus(rs.getString("status"));
            proposalResult.setArticle(article);

            //User qui est le vendeur de l'article
            Long userId = rs.getLong("id_user-seller");
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
                article.setSeller(user);
            }
            proposalResult.setArticle(article);
        }

        //User qui a fait la proposition
        Long userId = rs.getLong("id_user_buyer");
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
            proposalResult.setBuyer(user);
        }
        return proposalResult;
    }
}
