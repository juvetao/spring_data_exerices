package se.ecutb.spring_data_practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.spring_data_practice.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByEmailIgnoreCase(String email);
    Optional<AppUser> findByEmailAndPassword(String email, String password);
    List<AppUser> findByNameContaining(String contains);

    //@Query("SELECT user from AppUser user where user.address.addressId = :id")
    List<AppUser> findByAddressAddressId (int addressId);

    List<AppUser> findByAddressCityIgnoreCase (String city);
}
