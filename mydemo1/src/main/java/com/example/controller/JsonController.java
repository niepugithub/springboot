package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping("getJson")
    @ResponseBody
    public User getJson(@RequestBody String user){
        JSONObject obj = JSON.parseObject(user);
        System.out.println(obj);
        User u = new User();
        u.setId((int)obj.get("id"));
        u.setAge((int)obj.get("age"));
        u.setUsername((String) obj.get("username"));
        return u;
    }
}
