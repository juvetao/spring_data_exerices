package se.ecutb.spring_data_practice.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.spring_data_practice.entity.Car;
import se.ecutb.spring_data_practice.repo.CarRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    CarRepository testCarObject;

    @BeforeEach
    public void setUp() {
        Car car1 = new Car("ABC123", "BMW", "320", LocalDate.parse("2010-02-12"));
        Car car2 = new Car("XYZ789", "Volvo", "XC40", LocalDate.parse("2009-12-10"));
        testCarObject.save(car1);
        testCarObject.save(car2);
    }

    @Test
    public void given_regNum_findByRegNumberIgnoreCase_Return_Optional_with_entity(){
        String regNumber = "abc123";
        assertTrue(testCarObject.findByRegNumberIgnoreCase(regNumber).isPresent());
    }

    @Test
    public void given_regDate_findByRegDateAfter_Return_List_with_entities(){
        LocalDate regDate = LocalDate.parse("2009-01-01");
        List<Car> actual = testCarObject.findByRegDateAfter(regDate);
        int actualLength = actual.size();
        int expectedLength = 2;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void give_regDate_findByRegDateBefore_Return_List_with_entities(){
        LocalDate regDate = LocalDate.parse("2011-01-01");
        List<Car> actual = testCarObject.findByRegDateBefore(regDate);
        int actualLength = actual.size();
        int expectedLength =2;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void given_regDate_findByRegDateBetween_Return_List_with_entities(){
        LocalDate regDate1 = LocalDate.parse("2009-01-01");
        LocalDate regDate2 = LocalDate.parse("2011-01-01");
        List<Car> actual = testCarObject.findByRegDateBetween(regDate1, regDate2);
        int actualLength = actual.size();
        int expectedLength =2;
        assertEquals(expectedLength, actualLength);
    }
}
