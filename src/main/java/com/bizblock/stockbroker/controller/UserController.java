/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.bizblock.stockbroker.controller;

import com.bizblock.stockbroker.dto.LoginDTO;
import com.bizblock.stockbroker.dto.UpdateDTO;
import com.bizblock.stockbroker.dto.UserRequest;
import com.bizblock.stockbroker.model.User;
import com.bizblock.stockbroker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BLAZE
 */
@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String createNewUser(@RequestBody UserRequest userRequest)
    {
        userService.createNewUser(userRequest);
        return "user created successfully";
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO)
    {
        User user = userService.loginUser(loginDTO);
        if(user == null)
            return (ResponseEntity<User>)ResponseEntity.notFound();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/update-user")
    public String updateUser(@RequestBody UpdateDTO updateDTO)
    {
        User user = userService.getUserByUsername(updateDTO.getUsername());
        user.setEmail(updateDTO.getEmail());
        userService.updateUserDetails(user);
        return "i updated it champ";
    }
}
