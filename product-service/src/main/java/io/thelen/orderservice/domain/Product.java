package io.thelen.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    //same object for entity and domain is not a good idea.
    //don't try this at home.
    @Id
    private Long id;
    private String name;
    private String sku;
}
