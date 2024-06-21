package org.example.warehouse10c.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.warehouse10c.model.Currency;
import org.example.warehouse10c.model.Supplier;
import org.example.warehouse10c.model.WareHouse;
import org.springframework.data.relational.core.sql.In;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {

    private Integer wareHouse;
    private Integer supplier;
    private Integer currencyId;
    private String factureNumber;
    private String code;

}
