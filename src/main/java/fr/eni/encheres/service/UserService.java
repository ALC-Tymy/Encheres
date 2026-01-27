package fr.eni.encheres.service;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.service.exceptions.SignUpException;

import java.util.List;

public interface UserService {

    void createUser(User user) throws SignUpException;
    List<User> readAll();
    User readById(long id);
    void updateUser(User user);
    void deleteUser(long id);

}
