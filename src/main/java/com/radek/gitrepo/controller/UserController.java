package com.radek.gitrepo.controller;

import com.radek.gitrepo.annotation.PageableDefaults;
import com.radek.gitrepo.dto.UserDTO;
import com.radek.gitrepo.entity.User;
import com.radek.gitrepo.mapper.UserMapper;
import com.radek.gitrepo.service.UserService;
import com.radek.gitrepo.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDTO> findAll(UserSpecification userSpecification,
                                 @PageableDefaults(size = 5, maxSize = 9) Pageable pageable) {
        // max = 50
       // if (pageable.getPageSize() > 50) {
            // blad
            //
            // albo wyswietlic max ilosc
            //return userMapper.toDTO(userService.findAll(PageRequest.of(pageable.getPageNumber(), 50)).getContent());
        return userMapper.toDTO(userService.findAll(userSpecification, pageable).getContent());
    }

        //return userService.findAll(pageable).map(userMapper::toDTO);

    @PostMapping
    public UserDTO add (@RequestBody @Valid User user) {
        return userMapper.toDTO(userService.add(user));
    }
}

