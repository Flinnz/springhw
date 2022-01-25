package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
}
