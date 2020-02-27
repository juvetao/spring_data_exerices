package se.ecutb.spring_data_practice.repo;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.spring_data_practice.entity.Status;

import java.util.Optional;

public interface StatusRepository extends CrudRepository<Status, Integer> {
    Optional<Status> findByStatusCodeIgnoreCase(String statusCode);
}
