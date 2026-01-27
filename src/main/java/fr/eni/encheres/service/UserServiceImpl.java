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
        if(!user.getPseudo().matches("^[a-zA-Z0-9]*$")){
            throw new SignUpException("Le pseudo ne peut contenir que des chiffres et des lettres");
        }

        // LASTNAME
        if(user.getLastName().length() < 2 || user.getLastName().length() > 30 ){
            throw new SignUpException("Le nom doit contenir entre 2 et 30 caractères");
        }
        if(!user.getLastName().matches("^[a-zA-Z ]*$")){
            throw new SignUpException("Le nom doit contenir uniquement des lettres");
        }

        // FIRSTNAME
        if(user.getFirstName().length() < 2 || user.getFirstName().length() > 30 ){
            throw new SignUpException("Le prénom doit contenir entre 2 et 30 caractères");
        }
        // Ajouter tiret du 6 dans REGEX
        if(!user.getFirstName().matches("^[a-zA-Z ]*$")){
            throw new SignUpException("Le prénom doit contenir uniquement des lettres");
        }

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
}
