package se.ecutb.spring_data_practice.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.spring_data_practice.entity.Address;
import se.ecutb.spring_data_practice.repo.AddressRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AddressRepositoryTest {
    @Autowired
    AddressRepository testObject;

    @BeforeEach
    void setUp(){
        Address address1 = new Address("Gyllenstjansvagen 1", "123 42", "Karlskrona");
        Address address2 = new Address("Skomakaregatan 2", "465 46", "Karlskrona");
        Address address3 = new Address("Gyllenstjansvagen 1", "789 42", "Ronneby");
        testObject.save(address1);
        testObject.save(address2);
        testObject.save(address3);
    }

    @Test
    public void given_City_findByCityIgnoreCase_return_LengthOfList_with_entity(){
        String city = "Karlskrona";
        int expectedLength = 2;

        List<Address> actual = testObject.findByCityIgnoreCase("karlskrona");
        int actualLength = actual.size();

        assertEquals(expectedLength, actualLength);
    }
}
