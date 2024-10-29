package com.vans.vans.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vans.vans.dto.UserDto;
import com.vans.vans.model.User;
import com.vans.vans.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getById(id);
        if (user != null) {
            return ResponseEntity.ok(user); // 200 OK
        } else {
            return ResponseEntity.status(404).body(null); // 404 Not Found
        }
    }
}

// @GetMapping
// public List<User> getAllUsers() {
// return userService.getAllUsers();
// }

// @PostMapping
// public User createUser(@RequestBody User user) {
// return userService.saveUser(user);
// }

// @GetMapping("/{id}")
// public ResponseEntity<User> getUserById(@PathVariable Long id) {
// User user = userService.getUserById(id);
// if (user != null) {
// return ResponseEntity.ok(user); // 200 OK
// } else {
// return ResponseEntity.status(404).body(null); // 404 Not Found
// }
// }

// @GetMapping("/{email}")
// public User getUserByEmail(@PathVariable String email) {
// return userService.getUserByEmail(email);
// }
