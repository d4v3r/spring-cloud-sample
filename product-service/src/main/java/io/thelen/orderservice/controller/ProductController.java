package io.thelen.orderservice.controller;

import io.thelen.orderservice.domain.Product;
import io.thelen.orderservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("products")
    public List<Product> products() {
        log.info("products called");
        return productRepository.findAll();
    }

    @GetMapping("products/{id}")
    public Product product(@PathVariable("id") long id) {
        log.info("product called");
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
