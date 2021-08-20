package co.edu.eci.ieti;

import co.edu.eci.ieti.data.User;
import co.edu.eci.ieti.service.UserService;
import co.edu.eci.ieti.service.UserServiceHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceHashMapTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceHashMap();
        mockData();
    }

    private void mockData() {
        userService.create(new User("123", "A", "B", "C", new Date()));
    }

    @Test
    public void shouldCreateUser() {
        try {
            assertEquals(userService.create(new User("122", null,null,null,null)), new User("122", null,null,null,null));
            assertEquals(userService.create(new User("1014297320", "Eduard", "Arias", "eduarias08@gmail.com", new Date())), new User("1014297320", "Eduard", "Arias", "eduarias08@gmail.com", new Date()));
            assertTrue(userService.all().size() == 3);
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }

    @Test
    public void shouldFindById() {
        try {
            assertEquals(userService.findById("123").orElseThrow(), new User("123", "A", "B", "C", new Date()));
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }

    @Test
    public void shouldDeleteById() {
        try {
            assertFalse(userService.deleteById("asdasd"));
            assertTrue(userService.deleteById("123"));
            assertThrows(NoSuchElementException.class, () -> userService.findById("123").get());
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }

    @Test
    public void shouldUpdateUser() {
        try {
            assertEquals(userService.findById("123").get(), new User("123", "A", "B", "C", new Date()));
            assertNotEquals(userService.update(new User(null, "D", "E", "F", new Date()), "123").getEmail(), new User("123", "A", "B", "C", new Date()).getEmail());
            assertEquals(userService.findById("123").get(), new User("123", "D", "E", "F", new Date()));
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }
}