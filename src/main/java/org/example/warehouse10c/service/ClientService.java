package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.ClientDto;
import org.example.warehouse10c.model.Client;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public List<Client> getAllClient() {
        List<Client> clientList = clientRepository.findAll();
        return clientList;
    }

    public Client getByIdClient(Integer id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        return clientOptional.get();
    }

    public Result createClient(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setPhonenumber(clientDto.getPhonenumber());
        clientRepository.save(client);
        return new Result(true, "Client yaratildi");
    }

    public Result updateClient(Integer id, ClientDto clientDto) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(clientDto.getName());
            client.setPhonenumber(clientDto.getPhonenumber());
            clientRepository.save(client);
            return new Result(true, "Ma'lumotlar o'zgardi");
        }
        return new Result(false, "Client topilmadi");
    }

    public Result deleteClient(Integer id) {
        clientRepository.deleteById(id);
        return new Result(true, "Client o'chirildi");
    }


}
