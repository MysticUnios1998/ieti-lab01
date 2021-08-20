package co.edu.eci.ieti.service;

import co.edu.eci.ieti.data.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user );
    Optional<User> findById(String id );
    List<User> all();
    boolean deleteById( String id );
    User update( User user, String userId );

}
