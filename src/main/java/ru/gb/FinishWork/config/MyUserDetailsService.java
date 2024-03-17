package ru.gb.FinishWork.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.repository.UsersRepo;
import ru.gb.FinishWork.service.impl.UsersServiceImplements;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

//    private UsersRepo usersRepo;
    @Autowired
    private UsersServiceImplements usersServiceImplements;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersServiceImplements.getUserByName(username);
//        User user = usersRepo.findByLogin(username);


        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(username + "There is not such user in REPO"));
    }
}
