package ru.yabujinfan.springhw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yabujinfan.springhw.dto.ParentAddressDto;
import ru.yabujinfan.springhw.dto.ParentDto;
import ru.yabujinfan.springhw.models.Parent;
import ru.yabujinfan.springhw.services.ParentService;

import java.util.List;

@Controller
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/parent")
    public @ResponseBody List<Parent> getParents() {
        return parentService.getAllParents();
    }

    @PostMapping("/parent")
    public @ResponseBody Parent postParent(@RequestBody ParentDto parent) {
        return parentService.addParent(parent);
    }

    @GetMapping("/parent/{id}")
    public @ResponseBody Parent getParent(@PathVariable(value = "id") Integer id) {
        return parentService.getById(id);
    }

    @PatchMapping("/parent/address")
    public @ResponseBody Parent patchParentAddress(@RequestBody ParentAddressDto parentAddressDto) {
        return parentService.changeAddress(parentService.getById(parentAddressDto.parentId), parentAddressDto.addressId);
    }
}
