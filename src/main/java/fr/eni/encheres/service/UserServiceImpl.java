package fr.eni.encheres.service;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        this.userRepository.createUser(user);
    }

    @Override
    public List<User> readAll() {
        return this.userRepository.readAll();
    }

    @Override
    public User readById(long id) {
        return this.userRepository.readById(id);
    }

    @Override
    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteUser(id);
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
        return this.userRepository.findOptionalByEmailOrPseudo(identify);
    }

}
