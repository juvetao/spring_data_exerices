package se.ecutb.spring_data_practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ecutb.spring_data_practice.entity.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByRegNumberIgnoreCase (String reNumber);


    List<Car> findByRegDateAfter (LocalDate regDate);
    List<Car> findByRegDateBefore (LocalDate regDate);
    List<Car> findByRegDateBetween (LocalDate regDate1, LocalDate regDate2);

    //    List<Car> findByStatusStatusCode (String statusCode);

}
