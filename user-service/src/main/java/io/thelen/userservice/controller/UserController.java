package io.thelen.userservice.controller;

import io.thelen.userservice.domain.User;
import io.thelen.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public List<User> users() {
        log.info("users called");
        return userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public User user(@PathVariable("id") long id) {
        log.info("user called");
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
