package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {
}
