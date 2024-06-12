package org.example.warehouse10c.controller;

import jakarta.websocket.server.PathParam;
import org.example.warehouse10c.dto.ClientDto;
import org.example.warehouse10c.model.Client;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.service.ClientService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping()
    public List<Client> getA() {
        List<Client> allClient = clientService.getAllClient();
        return allClient;
    }

    @GetMapping("/{id}")
    public Client getIdClient(@PathVariable Integer id) {
        Client client = clientService.getByIdClient(id);
        return client;
    }

    @PostMapping()
    public Result add(@RequestBody ClientDto clientDto) {
        Result result = clientService.createClient(clientDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        Result result = clientService.updateClient(id, clientDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Result result = clientService.deleteClient(id);
        return result;
    }


}
