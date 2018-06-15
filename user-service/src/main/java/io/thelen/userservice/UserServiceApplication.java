package io.thelen.userservice;

import io.thelen.userservice.domain.User;
import io.thelen.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @PostConstruct
    private void createUsers() {
        userRepository.save(new User(1L, "Bruce", "Thelen", "bruce@bruce.com"));
    }
}
