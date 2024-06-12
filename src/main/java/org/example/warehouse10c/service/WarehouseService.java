package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.WarehouseDto;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.model.WareHouse;
import org.example.warehouse10c.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WareHouseRepository wareHouseRepository;


    public List<WareHouse> getAllWarehouse() {
        List<WareHouse> list = wareHouseRepository.findAll();
        return list;
    }


    public Result createWarehouse(WarehouseDto warehouseDto) {
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(warehouseDto.getName());
        wareHouse.setActive(warehouseDto.isActive());
        wareHouseRepository.save(wareHouse);
        return new Result(true, "Created");
    }

    public Result updateWarehouse(Integer id, WarehouseDto warehouseDto) {

        Optional<WareHouse> wareHouseOptional = wareHouseRepository.findById(id);
        if (wareHouseOptional.isPresent()) {
            WareHouse wareHouse = wareHouseOptional.get();
            wareHouse.setName(warehouseDto.getName());
            wareHouse.setActive(warehouseDto.isActive());
            wareHouseRepository.save(wareHouse);
            return new Result(true, "Warehouse update");
        }
        return new Result(false, "Warehouse not found");
    }

    public Result delete(Integer id) {
        wareHouseRepository.deleteById(id);
        return new Result(true, "deleted");
    }


}
