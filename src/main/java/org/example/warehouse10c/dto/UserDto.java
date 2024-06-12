package org.example.warehouse10c.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.warehouse10c.model.WareHouse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private String firstname;
    private String lastname;
    private String phonenumber;
    private Integer code;
    private String password;
    private boolean active;
    private Integer wareHousesId;

}
