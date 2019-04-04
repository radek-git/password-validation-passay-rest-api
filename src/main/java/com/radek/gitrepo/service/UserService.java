package com.radek.gitrepo.service;

import com.radek.gitrepo.entity.User;
import com.radek.gitrepo.repository.UserRepository;
import com.radek.gitrepo.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAll(UserSpecification userSpecification, Pageable pageable) {
        return userRepository.findAll(userSpecification, pageable);
    }

    public User add(User user) {
        return userRepository.save(user);
    }
}
