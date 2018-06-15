package io.thelen.orderservice.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "getDefaultProduct")
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

    public Product getDefaultProduct(Long id) {
        return (new Product(999L, "Fake Laptop", "not-a-real-product"));
    }
}
