package org.example.warehouse10c.controller;

import org.example.warehouse10c.model.Currency;
import org.example.warehouse10c.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping()
    public List<Currency> getCurrency(){
        List<Currency> allCurrency = currencyService.getAllCurrency();
        return allCurrency;
    }




}
