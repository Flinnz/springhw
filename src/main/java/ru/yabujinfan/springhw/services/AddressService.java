package ru.yabujinfan.springhw.services;

import org.springframework.stereotype.Service;
import ru.yabujinfan.springhw.models.Address;
import ru.yabujinfan.springhw.repos.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address getById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
