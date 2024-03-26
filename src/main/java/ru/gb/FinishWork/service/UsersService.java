package ru.gb.FinishWork.service;


import ru.gb.FinishWork.model.User;
import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void updateUser(Long id, User user);
    void newUser(User user);
    void deleteUserById(Long id);
    Optional<User> getUserByName(String name);
}
