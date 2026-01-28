package fr.eni.encheres.repository;

import fr.eni.encheres.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void createUser(User user);

    List<User> readAll();

    User readById(long id);

    void updateUser(User user);

    void deleteUser(long id);

    /**
     * Recherche un utilisateur par email ou par pseudo.
     * <p>
     * Le type {@link Optional} indique que la méthode peut ne pas trouver
     * d'utilisateur correspondant et évite ainsi le retour de {@code null}.
     *
     * @param identify email ou pseudo
     * @return un {@link Optional} contenant l'utilisateur s'il existe
     */
    Optional<User> findOptionalByEmailOrPseudo(String identify);


}
