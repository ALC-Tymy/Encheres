package fr.eni.encheres.repository;

import fr.eni.encheres.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositorySQL implements UserRepository {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositorySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createUser(User user) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode,city, phone) " +
                " VALUES (:pseudo, :email, :password, :firstName, :lastName, :address, :zipCode, :city, :phone)";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("pseudo", user.getPseudo());
        map.addValue("email", user.getEmail());
        map.addValue("password", user.getPassword());
        map.addValue("firstName", user.getFirstName());
        map.addValue("lastName", user.getLastName());
        map.addValue("address", user.getAddress());
        map.addValue("zipCode", user.getZipCode());
        map.addValue("city", user.getCity());
        map.addValue("phone", user.getPhone());

        namedParameterJdbcTemplate.update(sql, map, keyHolder);
        long id = keyHolder.getKey().longValue();
        user.setIdUser(id);

        // Ajout du rôle USER lors de la création d'un utilisateur
        String sqlRole = "INSERT INTO ROLES (pseudo, role) VALUES (:pseudoRole, :role)";
        MapSqlParameterSource mapRole = new MapSqlParameterSource();
        mapRole.addValue("pseudoRole", user.getPseudo());
        mapRole.addValue("role", "ROLE_USER");
        namedParameterJdbcTemplate.update(sqlRole, mapRole);

    }

    @Override
    public List<User> readAll() {
        String sql = "SELECT * FROM [USER]";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    public User readById(long id) {
        String sql = "SELECT * FROM [USER] WHERE id_user=:idUser";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idUser", id);

        User user = namedParameterJdbcTemplate.queryForObject(sql, map, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE [USER] SET pseudo=:pseudo, email=:email, password=:password, first_name=:firstname, lastname=:lastname, address=:address, zipcode=:zipcode, city=:city, phone=:phone, walletPoint=:walletPoint, walletPending=:walletPending";
        BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteUser(long id) {
        String sql = "DELETE FROM [USER] WHERE id_user=:idUser";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idUser", id);
        this.namedParameterJdbcTemplate.update(sql, map);
    }

    /**
     * Recherche un utilisateur par email ou par pseudo.
     * <p>
     * Le type {@link Optional} indique que la méthode peut ne pas trouver
     * d'utilisateur correspondant et évite ainsi le retour de {@code null}.
     *
     * @param identify email ou pseudo
     * @return un {@link Optional} contenant l'utilisateur s'il existe
     */
    @Override
    public Optional<User> findOptionalByEmailOrPseudo(String identify) {
        String sql =
                "SELECT Top 1 u.pseudo, u.email, u.password, u.actif " +
                        "FROM [USER] AS u " +
                        "WHERE LOWER(u.email) = LOWER(:identify) " +
                        "   OR LOWER(u.pseudo) = LOWER(:identify)";

        MapSqlParameterSource map = new MapSqlParameterSource("identify", identify);

        List<User> users = namedParameterJdbcTemplate.query(sql, map, (rs, rowNum) -> new User(
                rs.getString("pseudo"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getBoolean("actif")
        ));

        return users.stream().findFirst();
    }

}
