package se.ecutb.spring_data_practice.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.spring_data_practice.entity.Status;
import se.ecutb.spring_data_practice.repo.StatusRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class StatusRepositoryTest {

    @Autowired
    StatusRepository testObject;

    @BeforeEach
    void setUp(){
        testObject.save(new Status("finished"));
    }

    @Test
    public void given_StatusCode_findByStatusCodeIgnoreCase_return_Optional_with_entity(){
        String statusCode = "finisheD";
        assertTrue(testObject.findByStatusCodeIgnoreCase(statusCode).isPresent());
    }
}
