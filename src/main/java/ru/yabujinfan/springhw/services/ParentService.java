package ru.yabujinfan.springhw.services;


import org.springframework.stereotype.Service;
import ru.yabujinfan.springhw.dto.ParentDto;
import ru.yabujinfan.springhw.models.Address;
import ru.yabujinfan.springhw.models.Parent;
import ru.yabujinfan.springhw.repos.ParentRepository;

import java.util.List;

@Service
public class ParentService {
    private final ParentRepository parentRepository;
    private final AddressService addressService;

    public ParentService(ParentRepository parentRepository, AddressService addressService) {
        this.parentRepository = parentRepository;
        this.addressService = addressService;
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    public Parent getById(Integer id) {
        return parentRepository.getById(id);
    }

    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Parent addParent(ParentDto parentDto) {
        Parent parent = new Parent(parentDto.fullname, addressService.getById(parentDto.addressId));
        return addParent(parent);
    }

    public Parent changeAddress(Parent parent, Integer addressId) {
        parent.setAddress(addressService.getById(addressId));
        return parentRepository.save(parent);
    }
}
