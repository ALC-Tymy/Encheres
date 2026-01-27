package fr.eni.encheres.service;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.repository.UserRepository;
import fr.eni.encheres.service.exceptions.SignUpException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void createUser(User user) throws SignUpException {

        //**********************************************************************
        //**** VERIFICATIONS ****
        //**********************************************************************

        // Manque les contraintes d'unicité

        // PSEUDO
        if (user.getPseudo().length() < 3 || user.getPseudo().length() > 30){
            throw new SignUpException("Le pseudo doit contenir entre 3 et 30 caractères");
        }
        if(!user.getPseudo().matches("^[a-zA-Z0-9]+$")){
            throw new SignUpException("Le pseudo ne peut contenir que des chiffres et des lettres");
        }

        // EMAIL
        if (!user.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            throw new SignUpException("L'adresse email n'est pas valide");
        }

        // PASSWORD
        if (!user.getPassword().matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{6,}$")){
            throw new SignUpException("Le mot de passe doit contenir au moins 6 caractères, une majuscule, un chiffre et un caractère spécial");
        }

        // LASTNAME
        if(user.getLastName().length() < 2 || user.getLastName().length() > 30 ){
            throw new SignUpException("Le nom doit contenir entre 2 et 30 caractères");
        }
        if(!user.getLastName().matches("^[A-Za-zÀ-ÖØ-öø-ÿ -]+$")){
            throw new SignUpException("Le nom ne peut contenir que des lettres, des espaces et des tirets");
        }

        // FIRSTNAME
        if(user.getFirstName().length() < 2 || user.getFirstName().length() > 30 ){
            throw new SignUpException("Le prénom doit contenir entre 2 et 30 caractères");
        }
        if(!user.getFirstName().matches("^[A-Za-zÀ-ÖØ-öø-ÿ -]+$")){
            throw new SignUpException("Le prénom ne peut contenir que des lettres, des espaces et des tirets");
        }

        // ADDRESS
        if(!user.getAddress().matches("^[A-Za-zÀ-ÖØ-öø-ÿ0-9 -]+$")){
            throw new SignUpException("L'adresse ne peut pas contenir de caractères spéciaux en dehors des espaces et tirets");
        }
        if(user.getAddress().length() < 3 || user.getAddress().length() > 30) {
            throw new SignUpException("L'adresse doit contenir entre 3 et 30 caractères");
        }

        // ZIPCODE
        if(!user.getZipCode().matches("^[A-Za-z0-9]+$")){
            throw new SignUpException("Le code postal n'est pas valide");
        }
        if(user.getZipCode().length() > 10){
            throw new SignUpException("Le code postal ne peut pas faire plus de 10 caractères");
        }

        // CITY
        if(!user.getCity().matches("^[A-Za-zÀ-ÖØ-öø-ÿ' -]+$")){
            throw new SignUpException("Le nom de la ville n'est pas valide");
        }
        if(user.getCity().length() < 2 || user.getCity().length() > 30){
            throw new SignUpException("Le nom de la ville doit faire entre 2 et 30 caractères");
        }

        // PHONE
        if(!user.getPhone().matches("^(\\+?[0-9]{1,3}[\\s.-]?)?([0-9][\\s.-]?){6,14}[0-9]$")){
            throw new SignUpException("Le numéro de téléphone n'est pas valide");
        }

        User newUser = new User(user.getPseudo(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
                user.getAddress(), user.getZipCode(), user.getPhone(), user.getCity());

        userRepository.createUser(newUser);
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
}
