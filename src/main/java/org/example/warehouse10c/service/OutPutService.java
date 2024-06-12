package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.OutPutDto;
import org.example.warehouse10c.model.*;
import org.example.warehouse10c.repository.ClientRepository;
import org.example.warehouse10c.repository.CurrencyRepository;
import org.example.warehouse10c.repository.OutPutRepository;
import org.example.warehouse10c.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutPutService {

    @Autowired
    OutPutRepository outPutRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    public List<OutPut> getAllOutPut() {
        List<OutPut> putList = outPutRepository.findAll();
        return putList;
    }

    public Result createOutPut(OutPutDto outPutDto) {
        OutPut outPut = new OutPut();
        outPut.setFactureNumber(outPutDto.getFactureNumber());
        outPut.setCode(outPutDto.getCode());
        Optional<Client> optionalClient = clientRepository.findById(outPutDto.getClientId());
        Client client = optionalClient.get();
        outPut.setClient(client);

        Optional<WareHouse> optionalWareHouse = wareHouseRepository.findById(outPutDto.getWareHouseId());
        WareHouse wareHouse = optionalWareHouse.get();
        outPut.setWareHouse(wareHouse);

        Optional<Currency> currencyOptional = currencyRepository.findById(outPutDto.getCurrencyId());
        Currency currency = currencyOptional.get();
        outPut.setCurrency(currency);

        outPutRepository.save(outPut);
        return new Result(true, " Yaratildi");
    }

    public Result updateOutPut(Integer id, OutPutDto outPutDto) {
        Optional<OutPut> putOptional = outPutRepository.findById(id);
        if (putOptional.isPresent()) {
            OutPut outPut = putOptional.get();
            outPut.setCode(outPutDto.getCode());
            outPut.setFactureNumber(outPutDto.getFactureNumber());

            Optional<Client> optional = clientRepository.findById(outPutDto.getClientId());
            Client client = optional.get();
            outPut.setClient(client);

            Optional<WareHouse> wareHouse = wareHouseRepository.findById(outPutDto.getWareHouseId());
            WareHouse wareHouse1 = wareHouse.get();
            outPut.setWareHouse(wareHouse1);

            Optional<Currency> optionalCurrency = currencyRepository.findById(outPutDto.getCurrencyId());
            Currency currency = optionalCurrency.get();
            outPut.setCurrency(currency);

            outPutRepository.save(outPut);

            return new Result(true, "Updated");
        }
        return new Result(false, "Not found");
    }

    public Result deleted(Integer id) {
        outPutRepository.deleteById(id);
        return new Result(true, "Deleted");

    }


}
