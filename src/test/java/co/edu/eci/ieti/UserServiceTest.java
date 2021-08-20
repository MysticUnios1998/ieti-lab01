package co.edu.eci.ieti;

import co.edu.eci.ieti.service.UserService;
import co.edu.eci.ieti.service.UserServiceHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceHashMapTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceHashMap();
    }

    @Test
    public void shouldCreateUser() {

    }

    @Test
    public void shouldFindById() {
    }

    @Test
    public void shouldFindAll() {
    }

    @Test
    public void shouldDeleteById() {
    }

    @Test
    public void shouldUpdateUser() {
    }
}