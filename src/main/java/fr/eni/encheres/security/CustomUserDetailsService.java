
package fr.eni.encheres.security;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.repository.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service personnalisé permettant à Spring Security de charger
 * les informations d'un utilisateur depuis la base de données.
 * <p>
 * Cette classe récupère un utilisateur à partir de son email ou de son pseudo,
 * puis lui associe ses rôles afin de construire un objet {@link UserDetails}
 * utilisable par le mécanisme d'authentification.
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Repository permettant l'accès aux utilisateurs.
     */
    private final UserRepository userRepository;

    /**
     * Outil JDBC pour l'exécution de requêtes SQL.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructeur avec injection des dépendances.
     *
     * @param userRepository repository des utilisateurs
     * @param jdbcTemplate outil JDBC pour l'accès aux rôles
     */
    public CustomUserDetailsService(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Charge un utilisateur à partir de son identifiant (email ou pseudo).
     * <p>
     * Récupère :
     * <ul>
     *   <li>Les informations de l'utilisateur</li>
     *   <li>Ses rôles depuis la table ROLES</li>
     * </ul>
     *
     * @param identify email ou pseudo saisi lors de la connexion
     * @return un objet {@link UserDetails} contenant les informations de sécurité
     * @throws UsernameNotFoundException si l'utilisateur n'existe pas
     */
    @Override
    public UserDetails loadUserByUsername(@NonNull String identify) throws UsernameNotFoundException {

        User user = userRepository.findOptionalByEmailOrPseudo(identify)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé: " + identify));

        var authorities = jdbcTemplate.query(
                "SELECT role FROM ROLES WHERE pseudo = ?",
                (rs, rowNum) -> new SimpleGrantedAuthority(rs.getString("role")),
                user.getPseudo()
        );

        return new org.springframework.security.core.userdetails.User(
                user.getPseudo(),
                user.getPassword(),
                user.isActif(),
                true, true, true,
                authorities
        );
    }
}
