package org.example.warehouse10c.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Cluster;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OutPut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp date;
    @OneToOne
    private WareHouse wareHouse;
    @Column(nullable = false)
    private String factureNumber;
    @Column(nullable = false)
    private Integer code;
    @OneToOne
    private Currency currency;
    @OneToOne
    private Client client;


}
