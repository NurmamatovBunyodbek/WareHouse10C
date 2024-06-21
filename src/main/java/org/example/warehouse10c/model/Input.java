package org.example.warehouse10c.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp date;
    @OneToOne
    private WareHouse wareHouse;
    @OneToOne
    private Supplier supplier;
    @OneToOne
    private Currency currencyId;
    @Column(nullable = false)
    private String factureNumber;
    @Column(nullable = false)
    private String code;
}
