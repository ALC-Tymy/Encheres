package fr.eni.encheres.service;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.repository.UserRepository;
import fr.eni.encheres.service.exceptions.SignUpException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void createUser(User user)  throws SignUpException {

        //**********************************************************************
        //**** VERIFICATIONS ****
        //**********************************************************************


//        if (userRepository.readByPseudo(user.getPseudo()) != null){
//            throw new SignUpException("Ce pseudo est déjà pris");
//        }
//
//        if (userRepository.readByEmail(user.getEmail()) != null){
//            throw new SignUpException("Cet email est déjà enregistré");
//        }

        // Hash du password
        User newUser = new User(user.getPseudo(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                user.getAddress(), user.getZipCode(), user.getPhone(), user.getCity());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.createUser(newUser);
    }


    @Override
    public long getIdLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.readByPseudo(username).getIdUser();
    }


    @Override
    public List<User> readAll() {
        return this.userRepository.readAll();
    }

    @Override
    public User readById(long id) {
        return this.userRepository.readById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) throws SignUpException{

        // On ne regarde si l'email est déjà utilisé QUE si l'utilisateur a updaté le champ
        if (!user.getEmail().matches(userRepository.readById(user.getIdUser()).getEmail())){
            if (userRepository.readByEmail(user.getEmail()) != null){
                throw new SignUpException("Cet email est déjà enregistré");
            }
        }

        // Hash du password
        User newUser = new User(user.getIdUser(), user.getPseudo(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                user.getAddress(), user.getZipCode(), user.getPhone(), user.getCity(), user.getWalletPoint(), user.getWalletPending(), user.isActif());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.updateUser(newUser);

    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteUser(id);
    }

    @Override
    public void desactivateUser(long id) {
        this.userRepository.desactivateUser(id);
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
