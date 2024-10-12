/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayush.first.project.SpringWithDb.controller;

import com.ayush.first.project.SpringWithDb.model.User;
import com.ayush.first.project.SpringWithDb.repository.UserManagement;
import java.util.List;
import java.util.Optional;
import org.springframework.http.*;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ayush
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserManagement userRepository = new UserManagement();

    public UserController() {

    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.getUserByID(id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("User not found with id: " + id));
        }     
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.createUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
        for (User user : users) {
            userRepository.createUser(user);
        }
        return ResponseEntity.ok(userRepository.getAllUsers());
    }
}
