package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.UserDto;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.model.User;
import org.example.warehouse10c.model.WareHouse;
import org.example.warehouse10c.repository.UserRepository;
import org.example.warehouse10c.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }

    public User getByIdUsers(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    public Result createUser(UserDto userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhonenumber(userDto.getPhonenumber());
        user.setPassword(userDto.getPassword());
        user.setCode(userDto.getCode());
        user.setActive(userDto.isActive());

        Optional<WareHouse> houseOptional = wareHouseRepository.findById(userDto.getWareHousesId());
        WareHouse wareHouse = houseOptional.get();

        user.setWareHouses((List<WareHouse>) wareHouse);
        userRepository.save(user);
        return new Result(true, "User created");

    }

    public Result updateUser(Integer id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setPassword(userDto.getPassword());
            user.setCode(userDto.getCode());
            user.setActive(userDto.isActive());
            Optional<WareHouse> houseOptional = wareHouseRepository.findById(userDto.getWareHousesId());
            WareHouse wareHouse = houseOptional.get();
            user.setWareHouses((List<WareHouse>) wareHouse);

            userRepository.save(user);
            return new Result(true, "Update successfully");
        }
        return new Result(false, "User not found");
    }

    public Result deleteUsers(Integer id) {
        userRepository.deleteById(id);
        return new Result(true, "User deleted");
    }

}
