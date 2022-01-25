package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {
}
