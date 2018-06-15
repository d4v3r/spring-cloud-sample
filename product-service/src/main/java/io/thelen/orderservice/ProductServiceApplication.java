package io.thelen.orderservice;

import io.thelen.orderservice.domain.Product;
import io.thelen.orderservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ProductServiceApplication {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @PostConstruct
    private void createProducts() {
        productRepository.save(new Product(1L, "Laptop Computer", "mac-book-pro-15"));
    }
}
