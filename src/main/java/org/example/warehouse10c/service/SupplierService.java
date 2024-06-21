package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.SupplierDto;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.model.Supplier;
import org.example.warehouse10c.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;


    public List<Supplier> getAllSu() {
        List<Supplier> list = supplierRepository.findAll();
        return list;
    }

    public Result createSupplier(SupplierDto supplierDto) {

        Supplier supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplierRepository.save(supplier);
        return new Result(true, "Success");
    }

    public Result update(Integer id, SupplierDto supplierDto) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            Supplier supplier = supplierOptional.get();
            supplier.setName(supplierDto.getName());
            supplier.setPhoneNumber(supplierDto.getPhoneNumber());
            supplierRepository.save(supplier);
            return new Result(true, "Updated");
        }
        return new Result(false, "not found");
    }


}
