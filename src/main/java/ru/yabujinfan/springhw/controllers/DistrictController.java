package ru.yabujinfan.springhw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yabujinfan.springhw.models.District;
import ru.yabujinfan.springhw.services.DistrictService;

import java.util.List;

@Controller
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/district")
    public @ResponseBody List<District> getDistricts() {
        return districtService.getAllDistricts();
    }

    @PostMapping("/district")
    public @ResponseBody District postDistrict(@RequestBody District district) {
        return districtService.addDistrict(district);
    }

    @GetMapping("/district/{id}")
    public @ResponseBody District getDistrict(@PathVariable(value = "id") Integer id) {
        return districtService.getById(id);
    }
}
