package ru.yabujinfan.springhw.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.springhw.dto.ChildDto;
import ru.yabujinfan.springhw.models.*;
import ru.yabujinfan.springhw.repos.ChildRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {
    private final ChildRepository childRepository;
    private final ParentService parentService;
    private final EducationalInstitutionService educationalInstitutionService;

    public ChildService(ChildRepository childRepository, ParentService parentService, EducationalInstitutionService educationalInstitutionService) {
        this.childRepository = childRepository;
        this.parentService = parentService;
        this.educationalInstitutionService = educationalInstitutionService;
    }

    public Child getById(Integer id) {
        return childRepository.findById(id).orElse(null);
    }

    public Child addChild(Child child) {
        return childRepository.save(child);
    }

    public Child addChild(ChildDto childDto) {
        Child child = new Child(childDto.fullname, childDto.age);
        if (childDto.educationalInstitutionId != null) {
            child.setEducationalInstitution(educationalInstitutionService.getById(childDto.educationalInstitutionId));
        }
        if (childDto.parentIds != null && !childDto.parentIds.isEmpty()) {
            for (Integer parentId : childDto.parentIds) {
                child.getParents().add(parentService.getById(parentId));
            }
        }
        return addChild(child);
    }

    public Child addParentsToChild(Child child, List<Integer> parentIds) {
        for (Integer parentId : parentIds) {
            child.getParents().add(parentService.getById(parentId));
        }
        childRepository.save(child);
        return child;
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public List<EducationalInstitution> getEducationalInstitution(Child child) {
        if (child.getParents() != null && !child.getParents().isEmpty()) {
            List<String> addresses = child
                    .getParents()
                    .stream()
                    .map(Parent::getAddress)
                    .map(Address::getDistrict)
                    .map(District::getName)
                    .collect(Collectors.toList());
            return educationalInstitutionService
                    .getAllEducationalInstitutions()
                    .stream()
                    .filter((ei) -> ei.getAddress() != null && addresses.contains(ei.getAddress().getDistrict().getName()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public Child setEducationalInstitution(Integer childId, Integer schoolId) {
        Child child = this.getById(childId);
        if (child == null) return null;
        EducationalInstitution school = educationalInstitutionService.getById(schoolId);
        if (school == null) return null;
        child.setEducationalInstitution(school);
        return childRepository.save(child);
    }
}
