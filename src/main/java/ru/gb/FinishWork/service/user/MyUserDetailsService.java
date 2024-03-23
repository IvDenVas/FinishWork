package ru.gb.FinishWork.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.model.UserRole;
import ru.gb.FinishWork.repository.UsersRepo;
import ru.gb.FinishWork.service.impl.UsersServiceImplements;

import java.util.Collections;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersServiceImplements usersServiceImplements;
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersServiceImplements.getUserByName(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(username + "Данного пользователя не существует"));
    }


}
