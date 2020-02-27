package se.ecutb.spring_data_practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.spring_data_practice.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCityIgnoreCase (String city);
    List<Address> findByCity(String city);
}
