package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ArticleByUserRowMapper implements RowMapper<Article>
{
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

        Article articleResult = new Article();

        articleResult.setName(rs.getString("name"));
        articleResult.setOriginalPoint(rs.getInt("original_point"));
        articleResult.setFinalPoint(rs.getInt("final_point"));
        articleResult.setIdArticle(rs.getLong("id_article"));
        articleResult.setBeginningDate(rs.getObject("beginning_date", LocalDateTime.class));
        articleResult.setEndingDate(rs.getObject("ending_date", LocalDateTime.class));

        Long buyerId = rs.getLong("id_buyer");
        if (buyerId > 0){
            User buyer = new User();
            buyer.setIdUser(buyerId);
            buyer.setPseudo(rs.getString("pseudo"));
            articleResult.setBuyer(buyer);
        }

        return articleResult;
    }
}
