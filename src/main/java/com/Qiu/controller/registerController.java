package com.Qiu.controller;

import com.Qiu.domain.Course;
import com.Qiu.domain.User;
import com.Qiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zhuce")
public class registerController {
    @Autowired
    private UserService userService;


    @GetMapping("/{email}")
    public Result getByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        Integer code = user == null ? Code.GET_OK : Code.GET_ERR;
        String msg = user == null ? "" : "该邮箱已被注册！";
        return new Result(code,user,msg);
    }


    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

}
