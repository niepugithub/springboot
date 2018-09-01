package com.example.controller;

import com.example.beans.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<User> getAllUser(){
        LOGGER.trace("======================打印trace日志===================");
        return userService.getAllUser();
    }
}
