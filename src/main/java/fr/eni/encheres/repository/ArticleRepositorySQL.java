package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositorySQL implements ArticleRepository{
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ArticleRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createArticle(Article article){
        String sql = "INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status) " +
                " + VALUES(:name, :description, :original_point, :final_point, :beginning_date, :ending_date, :status)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", article.getName());
        map.addValue("description", article.getDescription());
        map.addValue("original_point", article.getOriginalPoint());
        map.addValue("final_point", article.getFinalPoint());
        map.addValue("beginning_date", article.getBeginningDate());
        map.addValue("ending_date", article.getEndingDate());
        map.addValue("status", article.getStatus());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Article> readAll(){
        String sql = "SELECT * FROM ARTICLE";
        List<Article> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class));
        return list;
    }

    @Override
    public Article readById(long id){
        String sql = "SELECT * FROM ARTICLE WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        Article article = namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Article.class));
        return article;
    }

    @Override
    public void updateArticle(Article article){
        String sql = "UPDATE ARTICLE SET name=:name, description=:description, original_point=:original_point, final_point=:final_point, beginning_date=:beginning_date, ending_date=:ending_date, status=:status";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(Article.class);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteArticle(long id){
        String sql = "DELETE FROM ARTICLE WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        this.namedParameterJdbcTemplate.update(sql, map);
    }


}


