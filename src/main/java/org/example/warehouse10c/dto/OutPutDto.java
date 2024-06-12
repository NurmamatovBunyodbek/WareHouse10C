package org.example.warehouse10c.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPutDto {

    private Integer wareHouseId;
    private String factureNumber;
    private Integer code;
    private Integer currencyId;
    private Integer clientId;

}
