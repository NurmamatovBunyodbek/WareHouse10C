package org.example.warehouse10c.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.internal.UserTypeSqlTypeAdapter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OutPutProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Double price;
    @OneToOne
    private OutPut outPut;


}
