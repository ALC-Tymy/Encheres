package fr.eni.encheres.repository;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.dto.ArticleLog;
import fr.eni.encheres.repository.rowMapper.ArticleByUserRowMapper;
import fr.eni.encheres.repository.rowMapper.ArticleRowMapper;
import fr.eni.encheres.service.CategoryService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepositorySQL implements ArticleRepository {
    CategoryService categoryService;
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ArticleRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, CategoryService categoryService) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.categoryService = categoryService;
    }

    @Override
    public void createArticle(Article article) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = """
                INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date,status, id_category, id_del_address, id_seller )
                                VALUES(:name, :description, :original_point, :final_point, :beginning_date, :ending_date,:status, :id_category , :id_del_address,  :id_seller)
                """;
        Long sellerId = null;
        if (article.getSeller() != null) {
            sellerId = article.getSeller().getIdUser();
        }

        Long categoryId = null;
        if (article.getCategory() != null) {
            categoryId = article.getCategory().getIdCategory();
        }

        Long deliveryAddressId = null;
        if (article.getDeliveryAddress() != null) {
            deliveryAddressId = article.getDeliveryAddress().getIdDeladdress();
        }

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", article.getName());
        map.addValue("description", article.getDescription());
        map.addValue("original_point", article.getOriginalPoint());
        map.addValue("final_point", article.getFinalPoint());
        map.addValue("beginning_date", article.getBeginningDate());
        map.addValue("ending_date", article.getEndingDate());
        map.addValue("status", "CR");
        map.addValue("id_category", categoryId);
        map.addValue("id_del_address", deliveryAddressId);
        map.addValue("id_seller", sellerId);

        namedParameterJdbcTemplate.update(sql, map, keyHolder);
        long id = keyHolder.getKey().longValue();
        article.setIdArticle(id);
    }

    @Override
    public List<Article> readAll() {
        String sql = "SELECT * FROM ARTICLE";
        List<Article> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class));
        return list;
    }

    @Override
    public List<Article> readFullAll() {
        String sql = """
                SELECT a.id_article, a.name, a.description, a.original_point, a.final_point, a.beginning_date, a.ending_date, a.status,
                       ub.id_user AS id_user_buyer, ub.pseudo AS pseudo_buyer, ub.email AS email_buyer, ub.password AS password_buyer, ub.first_name AS first_name_buyer, ub.last_name AS last_name_buyer, ub.address AS address_buyer, ub.zipcode AS zipcode_buyer, ub.city AS city_buyer, ub.phone AS phone_buyer, ub.walletPoint AS walletPoint_buyer, ub.walletPending AS walletPending_buyer, ub.actif AS actif_buyer,
                       us.id_user AS id_user_seller, us.pseudo AS pseudo_seller, us.email AS email_seller, us.password AS password_seller, us.first_name AS first_name_seller, us.last_name AS last_name_seller, us.address AS address_seller, us.zipcode AS zipcode_seller, us.city AS city_seller, us.phone AS phone_seller, us.walletPoint AS walletPoint_seller, us.walletPending AS walletPending_seller, us.actif AS actif_seller,
                       c.id_category, c.name AS name_category,
                       da.id_delivery_address, da.address AS address_delivery_address, da.zipcode AS zipCode_delivery_address, da.city AS city_delivery_address
                FROM ARTICLE a
                         LEFT JOIN [USER] ub ON ub.id_user = a.id_buyer
                         LEFT JOIN [USER] us ON us.id_user = a.id_seller
                         LEFT JOIN CATEGORY c ON c.id_category = a.id_category
                         LEFT JOIN DELIVERY_ADDRESS da ON da.id_delivery_address = a.id_del_address
                """;
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }

    @Override
    public List<Article> readFullEC() {
        String sql = """
                SELECT a.id_article, a.name, a.description, a.original_point, a.final_point, a.beginning_date, a.ending_date, a.status,
                       ub.id_user AS id_user_buyer, ub.pseudo AS pseudo_buyer, ub.email AS email_buyer, ub.password AS password_buyer, ub.first_name AS first_name_buyer, ub.last_name AS last_name_buyer, ub.address AS address_buyer, ub.zipcode AS zipcode_buyer, ub.city AS city_buyer, ub.phone AS phone_buyer, ub.walletPoint AS walletPoint_buyer, ub.walletPending AS walletPending_buyer, ub.actif AS actif_buyer,
                       us.id_user AS id_user_seller, us.pseudo AS pseudo_seller, us.email AS email_seller, us.password AS password_seller, us.first_name AS first_name_seller, us.last_name AS last_name_seller, us.address AS address_seller, us.zipcode AS zipcode_seller, us.city AS city_seller, us.phone AS phone_seller, us.walletPoint AS walletPoint_seller, us.walletPending AS walletPending_seller, us.actif AS actif_seller,
                       c.id_category, c.name AS name_category,
                       da.id_delivery_address, da.address AS address_delivery_address, da.zipcode AS zipCode_delivery_address, da.city AS city_delivery_address
                FROM ARTICLE a
                         LEFT JOIN [USER] ub ON ub.id_user = a.id_buyer
                         LEFT JOIN [USER] us ON us.id_user = a.id_seller
                         LEFT JOIN CATEGORY c ON c.id_category = a.id_category
                         LEFT JOIN DELIVERY_ADDRESS da ON da.id_delivery_address = a.id_del_address
                WHERE a.status = 'EC'
                ORDER BY a.ending_date
                """;
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }

    @Override
    public List<Article> readFullCR() {
        String sql = """
                SELECT a.id_article, a.name, a.description, a.original_point, a.final_point, a.beginning_date, a.ending_date, a.status,
                       ub.id_user AS id_user_buyer, ub.pseudo AS pseudo_buyer, ub.email AS email_buyer, ub.password AS password_buyer, ub.first_name AS first_name_buyer, ub.last_name AS last_name_buyer, ub.address AS address_buyer, ub.zipcode AS zipcode_buyer, ub.city AS city_buyer, ub.phone AS phone_buyer, ub.walletPoint AS walletPoint_buyer, ub.walletPending AS walletPending_buyer, ub.actif AS actif_buyer,
                       us.id_user AS id_user_seller, us.pseudo AS pseudo_seller, us.email AS email_seller, us.password AS password_seller, us.first_name AS first_name_seller, us.last_name AS last_name_seller, us.address AS address_seller, us.zipcode AS zipcode_seller, us.city AS city_seller, us.phone AS phone_seller, us.walletPoint AS walletPoint_seller, us.walletPending AS walletPending_seller, us.actif AS actif_seller,
                       c.id_category, c.name AS name_category,
                       da.id_delivery_address, da.address AS address_delivery_address, da.zipcode AS zipCode_delivery_address, da.city AS city_delivery_address
                FROM ARTICLE a
                         LEFT JOIN [USER] ub ON ub.id_user = a.id_buyer
                         LEFT JOIN [USER] us ON us.id_user = a.id_seller
                         LEFT JOIN CATEGORY c ON c.id_category = a.id_category
                         LEFT JOIN DELIVERY_ADDRESS da ON da.id_delivery_address = a.id_del_address
                WHERE a.status = 'CR'
                ORDER BY a.beginning_date
                """;
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }

    @Override
    public Article readById(long id) {
        String sql = """
                                SELECT a.id_article, a.name, a.description, a.original_point, a.final_point, a.beginning_date, a.ending_date, a.status,
                                       ub.id_user AS id_user_buyer, ub.pseudo AS pseudo_buyer, ub.email AS email_buyer, ub.password AS password_buyer, ub.first_name AS first_name_buyer, ub.last_name AS last_name_buyer, ub.address AS address_buyer, ub.zipcode AS zipcode_buyer, ub.city AS city_buyer, ub.phone AS phone_buyer, ub.walletPoint AS walletPoint_buyer, ub.walletPending AS walletPending_buyer, ub.actif AS actif_buyer,
                                       us.id_user AS id_user_seller, us.pseudo AS pseudo_seller, us.email AS email_seller, us.password AS password_seller, us.first_name AS first_name_seller, us.last_name AS last_name_seller, us.address AS address_seller, us.zipcode AS zipcode_seller, us.city AS city_seller, us.phone AS phone_seller, us.walletPoint AS walletPoint_seller, us.walletPending AS walletPending_seller, us.actif AS actif_seller,
                                       c.id_category, c.name AS name_category,
                                       da.id_delivery_address, da.address AS address_delivery_address, da.zipcode AS zipCode_delivery_address, da.city AS city_delivery_address
                                FROM ARTICLE a
                                         LEFT JOIN [USER] ub ON ub.id_user = a.id_buyer
                                         LEFT JOIN [USER] us ON us.id_user = a.id_seller
                                         LEFT JOIN CATEGORY c ON c.id_category = a.id_category
                                         LEFT JOIN DELIVERY_ADDRESS da ON da.id_delivery_address = a.id_del_address
                                WHERE id_article=:id;
                """;
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        Article article = namedParameterJdbcTemplate.queryForObject(sql, map, new ArticleRowMapper());
        return article;
    }

    @Override
    public void updateArticle(Article article) {
        String sql = "UPDATE ARTICLE SET name=:name, description=:description, original_point=:original_point, final_point=:final_point, beginning_date=:beginning_date, ending_date=:ending_date, status=:status WHERE id_article = :idArticle;";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(Article.class);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteArticle(long id) {
        String sql = "DELETE FROM ARTICLE WHERE id_article=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        this.namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Article> readArticleCRByIdSeller(long id) {
        String sql = "SELECT * FROM ARTICLE WHERE id_seller=:id AND STATUS='CR'";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return namedParameterJdbcTemplate.query(sql, map, new BeanPropertyRowMapper<>(Article.class));
    }

    // Récupérer la liste des articles mis en vente dont la vente est en cours selon un utilisateur (ex connecté) //
    @Override
    public List<Article> readArticleECByIdSeller(long id) {

        String sql = " SELECT article.name, article.original_point, article.final_point, " +
                "       article.id_buyer, article.id_article, " +
                "       article.beginning_date, article.ending_date, " +
                "       [USER].id_user, [USER].pseudo " +
                "    FROM ARTICLE " +
                "    LEFT JOIN [USER] ON article.id_buyer = [USER].id_user " +
                " WHERE article.id_seller=:id AND status='EC' " +
                " ORDER BY article.ending_date ";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, map, new ArticleByUserRowMapper());
    }


    @Override
    public List<Article> readArticleVDLVByIdSeller(long id) {

        String sql = " SELECT article.name, article.original_point, article.final_point, " +
                "       article.id_buyer, article.id_article, " +
                "       article.beginning_date, article.ending_date, " +
                "       [USER].id_user, [USER].pseudo " +
                "    FROM ARTICLE " +
                "    LEFT JOIN [USER] ON article.id_buyer = [USER].id_user " +
                " WHERE article.id_seller=:id AND (status='VD' OR status='LV') " +
                " ORDER BY article.ending_date DESC ";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, map, new ArticleByUserRowMapper());
    }

    @Override
    public List<ArticleLog> findCRtoEC() {
        String sql = """
                SELECT id_article, name, status, beginning_date, ending_date
                FROM ARTICLE
                WHERE status = 'CR'
                  AND beginning_date <= SYSDATETIME()
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ArticleLog(
                rs.getLong("id_article"),
                rs.getString("name"),
                rs.getString("status"),
                rs.getTimestamp("beginning_date").toLocalDateTime(),
                rs.getTimestamp("ending_date").toLocalDateTime()
        ));
    }

    @Override
    public List<ArticleLog> findECtoVD() {
        String sql = """
                SELECT id_article, name, status, beginning_date, ending_date
                FROM ARTICLE
                WHERE status = 'EC'
                  AND ending_date <= SYSDATETIME()
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ArticleLog(
                rs.getLong("id_article"),
                rs.getString("name"),
                rs.getString("status"),
                rs.getTimestamp("beginning_date").toLocalDateTime(),
                rs.getTimestamp("ending_date").toLocalDateTime()
        ));
    }

    @Override
    public int updateCRtoEC() {
        String sql = """
                UPDATE ARTICLE SET status = 'EC' WHERE status ='CR' AND beginning_date <= SYSDATETIME()
                """;
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateECtoVD() {
        String sql = """
                UPDATE ARTICLE SET status = 'VD' WHERE status ='EC' AND ending_date <= SYSDATETIME()
                """;
        return jdbcTemplate.update(sql);
    }
}