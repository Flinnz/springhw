package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.EducationalInstitution;

public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Integer> {
}
