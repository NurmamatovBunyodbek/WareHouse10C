package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.MeasurmentDto;
import org.example.warehouse10c.model.Measurement;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurmentService {
    @Autowired
    MeasurementRepository measurementRepository;
    public List<Measurement>getAll() {
        List<Measurement> all = measurementRepository.findAll();
        return all;


    }
    public Result createMeasurement(MeasurmentDto measurmentDto){
        Measurement measurement = new Measurement();
        measurement.setName(measurmentDto.getName());
        measurement.setActive(measurmentDto.isActive());
        measurementRepository.save(measurement);
        return new Result(true, "Measurement created");
    }


    public  Result updateMeasurement(Integer id , MeasurmentDto measurmentDto) {
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        if (measurementOptional.isPresent()) {
            Measurement measurement = measurementOptional.get();
            measurement.setName(measurmentDto.getName());
            measurement.setActive(measurmentDto.isActive());
            measurementRepository.save(measurement);
            return new Result(true, "Updated");
        }
        return new Result(false, "Not found");
    }

    public Result delete(Integer id){
        measurementRepository.deleteById(id);
        return new Result(true,"deleted");
    }







}
