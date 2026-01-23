package fr.eni.encheres.repository;

import fr.eni.encheres.entity.User;

public interface UserRepository {
    void createUser(User user);

    void updateUser(User user);
}
