package ru.yabujinfan.springhw.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yabujinfan.springhw.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
