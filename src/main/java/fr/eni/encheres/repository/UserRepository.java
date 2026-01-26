package fr.eni.encheres.repository;

import fr.eni.encheres.entity.User;

import java.util.List;

public interface UserRepository {

    void createUser(User user);

    List<User> readAll();

    void updateUser(User user);

    void deleteUser(long id);
}
