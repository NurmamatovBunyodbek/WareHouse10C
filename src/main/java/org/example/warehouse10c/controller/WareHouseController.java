package org.example.warehouse10c.controller;

import org.example.warehouse10c.dto.WarehouseDto;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.model.WareHouse;
import org.example.warehouse10c.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("warehouse")
public class WareHouseController {

    @Autowired
    WarehouseService warehouseService;


    @GetMapping()
    public List<WareHouse> get() {
        List<WareHouse> allWarehouse = warehouseService.getAllWarehouse();
        return allWarehouse;
    }

    @PostMapping()
    public Result add(@RequestBody WarehouseDto warehouseDto) {
        Result result = warehouseService.createWarehouse(warehouseDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody WarehouseDto warehouseDto) {
        Result result = warehouseService.updateWarehouse(id, warehouseDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Result result = warehouseService.delete(id);
        return result;
    }


}
