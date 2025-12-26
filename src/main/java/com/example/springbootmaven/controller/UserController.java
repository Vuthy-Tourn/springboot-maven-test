package com.example.springbootmaven.controller;

import com.example.springbootmaven.model.User;
import com.example.springbootmaven.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
