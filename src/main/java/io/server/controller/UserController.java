package io.server.controller;


import io.server.exception.UserNotFoundException;
import io.server.model.User;
import io.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by Arjun Gautam */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }






  @GetMapping("/excellentusers")
      List<User> getAllexcellentUser () {
          return userRepository.getAllExcellent();
      }



    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setDepartment(newUser.getDepartment());
                    user.setGpa(newUser.getGpa());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }




}
