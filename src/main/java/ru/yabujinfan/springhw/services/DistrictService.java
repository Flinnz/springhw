package ru.yabujinfan.springhw.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.springhw.models.District;
import ru.yabujinfan.springhw.repos.DistrictRepository;

import java.util.List;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District addDistrict(District district) {
        return districtRepository.save(district);
    }

    public District getById(Integer id) {
        return districtRepository.getById(id);
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
}
