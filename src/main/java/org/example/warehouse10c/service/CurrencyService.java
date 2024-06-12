package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.CurrencyDto;
import org.example.warehouse10c.model.Currency;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrency() {
        List<Currency> all = currencyRepository.findAll();
        return all;
    }

    public Result createCurrency(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.isActive());
        currencyRepository.save(currency);
        return new Result(true, "Successfully");
    }

    public Result update(Integer id, CurrencyDto currencyDto) {
        Optional<Currency> optional = currencyRepository.findById(id);
        if (optional.isPresent()) {
            Currency currency = optional.get();
            currency.setName(currencyDto.getName());
            currency.setActive(currencyDto.isActive());
            currencyRepository.save(currency);
            return new Result(true, "Updated");
        }
        return new Result(false, "not found");
    }

    public Result deleted(Integer id) {
        currencyRepository.deleteById(id);
        return new Result(true, "deleted");
    }
}
