package org.example.warehouse10c.controller;


import org.example.warehouse10c.model.Measurement;
import org.example.warehouse10c.service.MeasurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
