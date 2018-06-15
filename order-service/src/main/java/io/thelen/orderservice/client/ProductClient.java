package io.thelen.orderservice.client;

import io.thelen.orderservice.domain.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProduct(Long id) {
        ResponseEntity<Product> exchange1 = restTemplate.exchange(
                "http://product-service/products/{id}",
                HttpMethod.GET,
                null,
                Product.class,
                id
        );
        return exchange1.getBody();
    }
}
