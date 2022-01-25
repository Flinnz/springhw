package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
