package ru.gb.FinishWork.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.model.UserRole;
import ru.gb.FinishWork.repository.UsersRepo;
import ru.gb.FinishWork.service.UsersService;
import ru.gb.FinishWork.service.user.MyUserDetailsService;

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
        updateUser.setUserRole(user.getUserRole());
        updateUser.setId(user.getId());
        return usersRepo.save(updateUser);
    }

    @Override
    public User newUser(User user) {
        user.setPassword(new BCryptPasswordEncoder(5).encode(user.getPassword()));
        return usersRepo.save(user);
    }

    @Override
    public void registrationUser(User user){
        user.setPassword(new BCryptPasswordEncoder(5).encode(user.getPassword()));
        usersRepo.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = getUserById(id);
        usersRepo.delete(user);
    }

    @Override
    public Optional<User> getUserByName(String username) {
        return usersRepo.findByName(username);
    }

}
