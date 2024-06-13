package org.example.warehouse10c.controller;


import org.example.warehouse10c.dto.MeasurmentDto;
import org.example.warehouse10c.model.Measurement;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.service.MeasurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MeasurementController {


    @Autowired
    MeasurmentService measurmentService;


    @GetMapping
    public List<Measurement> getMeasurements() {
        List<Measurement> measurements = measurmentService.getAll();
        return measurements;
    }

    @PostMapping()
    public Result add(@RequestBody MeasurmentDto measurmentDto) {
        Result result = measurmentService.createMeasurement(measurmentDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody MeasurmentDto measurmentDto) {
        Result result = measurmentService.updateMeasurement(id, measurmentDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Result result = measurmentService.delete(id);
        return result;
    }


}
