package ru.yabujinfan.springhw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yabujinfan.springhw.models.Address;
import ru.yabujinfan.springhw.services.AddressService;

import java.util.List;

@Controller
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @PostMapping("/address")
    public @ResponseBody Address postAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/address/{id}")
    public @ResponseBody Address getAddress(@PathVariable(value = "id") Integer id) {
        return addressService.getById(id);
    }
}
