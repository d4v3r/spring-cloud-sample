package io.thelen.orderservice.controller;

import io.thelen.orderservice.client.ProductClient;
import io.thelen.orderservice.client.UserClient;
import io.thelen.orderservice.domain.Order;
import io.thelen.orderservice.entity.OrderEntity;
import io.thelen.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class OrderController {

    private OrderRepository orderRepository;
    private UserClient userClient;
    private ProductClient productClient;

    public OrderController(OrderRepository orderRepository, UserClient userClient, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.productClient = productClient;
    }

    @GetMapping("orders")
    public List<Order> orders() {
        log.info("Orders called");
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(
                orderEntity -> orders.add(getOrder(orderEntity.getOrderId()))
        );
        return orders;
    }

    private Order getOrder(Long id) {
        log.info("getOrder called");
        OrderEntity orderEntity = orderRepository.getOne(id);
        return new Order(
                orderEntity.getOrderId(),
                productClient.getProduct(orderEntity.getProductId()),
                userClient.getUser(orderEntity.getUserId())
        );
    }
}
