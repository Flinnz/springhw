package ru.yabujinfan.springhw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yabujinfan.springhw.dto.ChildDto;
import ru.yabujinfan.springhw.dto.ChildEducationalInstitutionDto;
import ru.yabujinfan.springhw.dto.ChildParentIdsDto;
import ru.yabujinfan.springhw.models.Child;
import ru.yabujinfan.springhw.models.EducationalInstitution;
import ru.yabujinfan.springhw.services.ChildService;

import java.util.List;

@Controller
public class ChildController {
    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/child")
    public @ResponseBody List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    @PostMapping("/child")
    public @ResponseBody List<EducationalInstitution> postChild(@RequestBody ChildDto child) {
        Child addedChild = childService.addChild(child);
        return childService.getEducationalInstitution(addedChild);
    }

    @PatchMapping("/child/parents")
    public @ResponseBody Child patchChildParents(@RequestBody ChildParentIdsDto childParentIdsDto) {
        return childService.addParentsToChild(childService.getById(childParentIdsDto.childId), childParentIdsDto.parentIds);
    }

    @PatchMapping("/child/educationalInstitution")
    public @ResponseBody Child patchChildEducationalInstitution(@RequestBody ChildEducationalInstitutionDto childEducationalInstitutionDto) {
        return childService.setEducationalInstitution(childEducationalInstitutionDto.childId, childEducationalInstitutionDto.educationalInstitutionId);
    }

    @GetMapping("/child/{id}")
    public @ResponseBody Child getChild(@PathVariable(value="id") Integer id) {
        return childService.getById(id);
    }
}
