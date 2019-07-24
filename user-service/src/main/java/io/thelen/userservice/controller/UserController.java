package io.thelen.userservice.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.thelen.userservice.domain.User;
import io.thelen.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
public class UserController {

    private UserRepository userRepository;
    private AtomicInteger usersInRepository;

    public UserController(UserRepository userRepository, MeterRegistry registry) {
        this.userRepository = userRepository;
        usersInRepository = registry.gauge("user_repository_gauge", new AtomicInteger(0));
        assert usersInRepository != null;
        usersInRepository.set((int) userRepository.count());
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

    @PostMapping("users")
    public void createUser(@RequestBody User user) {
        log.info("createUser called with user = {}", user);
        userRepository.save(user);
        usersInRepository.set((int) userRepository.count());
        log.info("There are {} users in the repository", usersInRepository);
    }
}
