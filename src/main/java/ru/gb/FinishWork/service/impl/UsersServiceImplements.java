package ru.gb.FinishWork.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.model.UserRole;
import ru.gb.FinishWork.repository.UsersRepo;
import ru.gb.FinishWork.service.UsersService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImplements implements UsersService {
    private UsersRepo usersRepo;

    @Override
    public List<User> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return usersRepo.findById(id).get();
    }

    @Override
    public User updateUser(Long id, User user) {
        User updateUser = usersRepo.findById(id).get();
        updateUser.setName(user.getName());
        updateUser.setPassword(user.getPassword());
        updateUser.setTelNumber(user.getTelNumber());
        updateUser.setEmail(user.getEmail());
        updateUser.setUserRole(UserRole.user);
        return usersRepo.save(updateUser);
    }

    @Override
    public User newUser(User user) {
        return usersRepo.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = getUserById(id);
        usersRepo.delete(user);
    }

    //    @Override
//    public User getUserByName(String login){
//        return usersRepo.findByName(login).get();
//    }
//    @Override
    public Optional<User> getUserByName(String username) {
        return usersRepo.findByName(username);
    }
}
