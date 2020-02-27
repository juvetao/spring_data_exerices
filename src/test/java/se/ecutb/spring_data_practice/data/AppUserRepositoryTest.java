package se.ecutb.spring_data_practice.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.spring_data_practice.entity.Address;
import se.ecutb.spring_data_practice.entity.AppUser;
import se.ecutb.spring_data_practice.repo.AppUserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AppUserRepositoryTest {
    @Autowired
    AppUserRepository testObject;

    @BeforeEach
    void setUp(){
        Address address1 = new Address("Gyllenstjansvagen 1", "123 42", "Karlskrona");
        Address address2 = new Address("Skomakaregatan 2", "465 46", "Karlskrona");
        Address address3 = new Address("Arlidakglat 3", "789 42", "Ronneby");
        AppUser user1 = new AppUser("cheng.tao86@gmail.com", "Cheng Tao", "1231320", address1);
        AppUser user2 = new AppUser("yanhu1985@gmail.com", "Yan Hu", ".05461", address2);
        AppUser user3 = new AppUser("estelle.tao@gmail.com", "Estelle Tao", ".038+50", address3);
        testObject.save(user1);
        testObject.save(user2);
        testObject.save(user3);
    }

    @Test
    public void given_email_findByEmailIgnoreCase_Return_Optional_with_Entity(){
        String email = "Cheng.tao86@Gmail.com";
        assertTrue(testObject.findByEmailIgnoreCase(email).isPresent());
    }

    @Test
    public void given_email_and_password_findByEmailIgnoreCaseAndPassword_Return_Optional_with_Entity(){
        String email = "cheng.tao86@gmail.com";
        String password = "1231320";
        assertTrue(testObject.findByEmailAndPassword(email, password).isPresent());
    }

    @Test
    public void given_contains_findByNameContaining_Return_List_with_Entity(){
        String contains = "Tao";
        int expectedLength = 2;
        List<AppUser> actual = testObject.findByNameContaining(contains);
        int actualLength = actual.size();
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void given_address_findByAddressAddressID_Return_List_with_Entity(){
        int id = 1;
        List<AppUser> actual = testObject.findByAddressAddressId(id);
        int actualLength = actual.size();
        int expectedLength = 1;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void given_city_findByAddressCityIgnoreCase_Return_List_with_Entity(){
        String city = "karlskrona";
        List<AppUser> actual = testObject.findByAddressCityIgnoreCase(city);
        int actualLength = actual.size();
        int expectedLength = 2;
        assertEquals(expectedLength, actualLength);
    }
}
