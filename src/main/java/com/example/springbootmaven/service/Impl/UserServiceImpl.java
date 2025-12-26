package com.example.springbootmaven.service.Impl;

import com.example.springbootmaven.model.User;
import com.example.springbootmaven.repository.UserRepository;
import com.example.springbootmaven.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User user) {
        User existing = findById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

