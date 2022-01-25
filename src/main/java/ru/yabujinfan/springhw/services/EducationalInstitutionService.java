package ru.yabujinfan.springhw.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.springhw.dto.EducationalInstitutionDto;
import ru.yabujinfan.springhw.models.EducationalInstitution;
import ru.yabujinfan.springhw.repos.EducationalInstitutionRepository;

import java.util.List;

@Service
public class EducationalInstitutionService {
    private final EducationalInstitutionRepository educationalInstitutionRepository;
    private final AddressService addressService;

    public EducationalInstitutionService(EducationalInstitutionRepository educationalInstitutionRepository, AddressService addressService) {
        this.educationalInstitutionRepository = educationalInstitutionRepository;
        this.addressService = addressService;
    }

    public List<EducationalInstitution> getAllEducationalInstitutions() {
        return educationalInstitutionRepository.findAll();
    }

    public EducationalInstitution getById(Integer id) {
        return educationalInstitutionRepository.findById(id).orElse(null);
    }

    public EducationalInstitution changeAddress(EducationalInstitution educationalInstitution, Integer addressId) {
        educationalInstitution.setAddress(addressService.getById(addressId));
        return educationalInstitutionRepository.save(educationalInstitution);
    }

    public EducationalInstitution add(EducationalInstitution educationalInstitution) {
        return educationalInstitutionRepository.save(educationalInstitution);
    }

    public EducationalInstitution add(EducationalInstitutionDto educationalInstitutionDto) {
        return new EducationalInstitution(addressService.getById(educationalInstitutionDto.addressId), educationalInstitutionDto.number);
    }
}

