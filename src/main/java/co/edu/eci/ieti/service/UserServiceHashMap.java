package co.edu.eci.ieti.service;

import co.edu.eci.ieti.data.User;
import co.edu.eci.ieti.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceHashMap implements UserService {

    private Map<String, User> users;

    public UserServiceHashMap() {
        users = new HashMap<String, User>();
    }

    @Override
    public User create(User user) {
        if (user.getId() == null) user.setId(IdGenerator.generateId(10, false, true));
        user.setCreateAt(new Date());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> all() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public boolean deleteById(String id) {
        return users.remove(id) != null;
    }

    @Override
    public User update(User user, String userId) {
        User updateableUser = users.get(userId);
        if (!updateableUser.getName().equals(user.getName())) updateableUser.setName(user.getName());
        if (!updateableUser.getEmail().equals(user.getEmail())) updateableUser.setEmail(user.getEmail());
        if (!updateableUser.getLastName().equals(user.getLastName())) updateableUser.setLastName(user.getLastName());
        if (updateableUser.getCreateAt() == null) updateableUser.setCreateAt(user.getCreateAt());
        return updateableUser;
    }
}
