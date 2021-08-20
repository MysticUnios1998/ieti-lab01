package co.edu.eci.ieti.controller;

import co.edu.eci.ieti.data.User;
import co.edu.eci.ieti.dto.UserDto;
import co.edu.eci.ieti.mapper.UserMapper;
import co.edu.eci.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        var users = userService.all();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        var userOptional = userService.findById(id);
        return new ResponseEntity<>(userOptional.orElse(new User()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        var createdUser = userService.create(UserMapper.toUser(userDto));
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable String id) {
        var updatedUser = userService.update(UserMapper.toUser(userDto), id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        var deleted = userService.deleteById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
