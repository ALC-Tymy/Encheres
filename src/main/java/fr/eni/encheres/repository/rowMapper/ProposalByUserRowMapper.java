package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProposalByUserRowMapper implements RowMapper<Proposal> {
    @Override
    public Proposal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Proposal proposalresult = new Proposal();

        proposalresult.setIdProposal(rs.getLong("id_proposal"));
        proposalresult.setPointProposal(rs.getInt("point_proposal"));
        proposalresult.setDateProposal(rs.getObject("date_proposal", LocalDate.class));
        proposalresult.setRanking(rs.getInt("ranking"));

        Long buyerId = rs.getLong("id_buyer");
        if(buyerId > 0){
            User buyer = new User();
            buyer.setIdUser(buyerId);
            proposalresult.setBuyer(buyer);
        }

        Long articleId = rs.getLong("id_article");
        if(articleId > 0){
            Article article = new Article();
            article.setIdArticle(articleId);
            article.setName(rs.getString("name"));
            article.setStatus(rs.getString("status"));
            article.setBeginningDate(rs.getObject("beginning_date", LocalDateTime.class));
            article.setEndingDate(rs.getObject("ending_date", LocalDateTime.class));
            article.setFinalPoint(rs.getInt("final_point"));
            proposalresult.setArticle(article);
        }

        return proposalresult;
    }
}
