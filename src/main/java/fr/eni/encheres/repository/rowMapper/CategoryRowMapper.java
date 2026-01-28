package fr.eni.encheres.repository.rowMapper;

import fr.eni.encheres.entity.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category categoryResult = new Category();

        categoryResult.setIdCategory(rs.getLong("id_category"));
        categoryResult.setName(rs.getString("name_category"));

        return null;
    }
}
