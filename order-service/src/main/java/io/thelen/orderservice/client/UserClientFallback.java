package io.thelen.orderservice.client;

import io.thelen.orderservice.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User getUser(Long id) {
        return new User(id, "Fake First Name", "Fake Last Name", "Fake Email");
    }
}