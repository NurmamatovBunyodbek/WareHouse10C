package org.example.warehouse10c.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MeasurmentDto {
    private String name;
    private boolean active;
}
