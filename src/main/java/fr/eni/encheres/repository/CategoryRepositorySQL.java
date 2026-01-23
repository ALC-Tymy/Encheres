package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositorySQL implements CategoryRepository {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CategoryRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createCategory(Category category) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("", category.getName());
        namedParameterJdbcTemplate.update(sql, map, keyHolder);
        long id = keyHolder.getKey().longValue();
        category.getIdCategory(id);
        // C'est pas ".setIdCategory" plutôt ? -M
    }

    @Override
    public Category getById(long id) {
        String sql = "";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("", id);
        return namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public List<Category> getAll() {
        String sql = "";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public void deleteCategory(long id) {
        String sql = "";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("", id);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("", category.getIdCategory());
        map.addValue("", category.getName());
        namedParameterJdbcTemplate.update(sql, map);
    }
}
