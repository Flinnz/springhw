package ru.yabujinfan.springhw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yabujinfan.springhw.dto.EducationalInstitutionAddressDto;
import ru.yabujinfan.springhw.dto.EducationalInstitutionDto;
import ru.yabujinfan.springhw.models.EducationalInstitution;
import ru.yabujinfan.springhw.services.EducationalInstitutionService;

import java.util.List;

@Controller
public class EducationalInstitutionController {
    private final EducationalInstitutionService educationalInstitutionService;

    public EducationalInstitutionController(EducationalInstitutionService educationalInstitutionService) {
        this.educationalInstitutionService = educationalInstitutionService;
    }

    @GetMapping("/educationalInstitution")
    public @ResponseBody List<EducationalInstitution> getEducationalInstitutions() {
        return educationalInstitutionService.getAllEducationalInstitutions();
    }

    @PostMapping("/educationalInstitution")
    public @ResponseBody EducationalInstitution postEducationalInstitution(@RequestBody EducationalInstitutionDto educationalInstitutionDto) {
        return educationalInstitutionService.add(educationalInstitutionDto);
    }

    @GetMapping("/educationalInstitution/{id}")
    public @ResponseBody EducationalInstitution getEducationalInstitution(@PathVariable(value = "id") Integer id) {
        return educationalInstitutionService.getById(id);
    }

    @PatchMapping("/educationalInstitution")
    public @ResponseBody EducationalInstitution patchEducationalInstitutionAddress(@RequestBody EducationalInstitutionAddressDto educationalInstitutionAddressDto) {
        return educationalInstitutionService.changeAddress(educationalInstitutionService.getById(educationalInstitutionAddressDto.educationalInstitutionId), educationalInstitutionAddressDto.addressId);
    }
}

