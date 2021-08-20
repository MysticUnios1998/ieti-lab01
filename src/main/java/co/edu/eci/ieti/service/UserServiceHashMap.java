package co.edu.eci.ieti.service;

import co.edu.eci.ieti.data.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceHashMap implements UserService {

    private Map<Integer, User> users;

    public UserServiceHashMap() {
        users = new HashMap<Integer, User>();
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User update(User user, String userId) {
        return null;
    }
}
