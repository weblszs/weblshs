package com.Qiu.controller;

import com.Qiu.domain.User;
import com.Qiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public Result login(@RequestBody User user)
    {
//        System.out.println(user);
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        User u = userService.getByAll(user.getEmail(), user.getPassword());
        Integer code = u != null ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = u != null ? "" : "邮箱或密码错误！";
        return new Result(code,u,msg);
    }


    @GetMapping("/{email}")
    public Result getByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        Integer code = user == null ? Code.GET_OK : Code.GET_ERR;
        String msg = user == null ? "" : "该邮箱已被注册！";
        return new Result(code,user,msg);
    }
}
