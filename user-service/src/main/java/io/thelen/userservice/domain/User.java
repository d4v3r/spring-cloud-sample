package io.thelen.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    //same object for entity and domain is not a good idea.
    //don't try this at home.
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
