package org.example.warehouse10c.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false, unique = true)
    private String phonenumber;
    @Column(nullable = false)
    private Integer code;
    @Column(nullable = false)
    private String password;
    private boolean active;
    @OneToMany
    private List<WareHouse> wareHouses;
}
