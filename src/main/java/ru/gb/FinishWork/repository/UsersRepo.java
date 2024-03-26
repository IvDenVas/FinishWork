package ru.gb.FinishWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.FinishWork.model.User;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<User,Long> {
    Optional<User> findByName(String username);
}
