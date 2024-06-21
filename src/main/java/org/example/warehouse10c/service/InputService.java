package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.InputDto;
import org.example.warehouse10c.model.*;
import org.example.warehouse10c.repository.CurrencyRepository;
import org.example.warehouse10c.repository.InputRepository;
import org.example.warehouse10c.repository.SuppliesRepository;
import org.example.warehouse10c.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    CurrencyRepository currencyRepository;


    @Autowired
    SuppliesRepository suppliesRepository;


    public List<Input> getAllInput() {
        List<Input> list = inputRepository.findAll();
        return list;
    }

    public Result createInput(InputDto inputDto) {
        Input input = new Input();
        input.setCode(inputDto.getCode());
        input.setFactureNumber(inputDto.getFactureNumber());

        Optional<WareHouse> optional =
                wareHouseRepository.findById(inputDto.getWareHouse());

        WareHouse wareHouse = optional.get();
        input.setWareHouse(wareHouse);

        Optional<Currency> optionalCurrency =
                currencyRepository.findById(inputDto.getCurrencyId());
        Currency currency = optionalCurrency.get();
        input.setCurrencyId(currency);

        Optional<Supplier> supplierOptional =
                suppliesRepository.findById(inputDto.getSupplier());
        Supplier supplier = supplierOptional.get();

        input.setSupplier(supplier);

        inputRepository.save(input);
        return new Result(true, "Created");

    }

    public Result deleted(Integer id) {
        inputRepository.deleteById(id);
        return new Result(true, "deleted");
    }


}
