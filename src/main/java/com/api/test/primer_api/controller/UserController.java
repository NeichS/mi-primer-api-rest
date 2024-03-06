package com.api.test.primer_api.controller;

import com.api.test.primer_api.model.entity.User;
import com.api.test.primer_api.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUser userService;


    @PostMapping("user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("user")
    public User update(User user) {
        return userService.save(user);
    }

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable Integer id) {
        User userDelete = userService.findById(id);
        userService.delete(userDelete);
    }

    @GetMapping("user/{id}")
    public User showById(@PathVariable Integer id) {
        return userService.findById(id);
    }
}
