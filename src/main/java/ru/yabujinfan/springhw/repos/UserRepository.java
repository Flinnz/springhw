package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
