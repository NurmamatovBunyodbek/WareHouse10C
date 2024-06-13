package org.example.warehouse10c.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private  String name;
    private Integer categoryId;
    private boolean active;

}
