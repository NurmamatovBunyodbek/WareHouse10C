package org.example.warehouse10c.controller;

import org.apache.logging.log4j.message.ReusableMessage;
import org.example.warehouse10c.dto.UserDto;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.model.User;
import org.example.warehouse10c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationSupport;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping()
    public List<User> getUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/{id}")
    public User getIdUser(@PathVariable Integer id) {
        User user = userService.getByIdUsers(id);
        return user;
    }

    @PostMapping()
    public Result create(@RequestBody UserDto userDto) {
        Result result = userService.createUser(userDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody UserDto userDto) {
        Result result = userService.updateUser(id, userDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Result result = userService.deleteUsers(id);
        return result;
    }


}
