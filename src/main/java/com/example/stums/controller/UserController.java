package com.example.stums.controller;

import com.example.stums.common.R;
import com.example.stums.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author darkFernMoss
 * since 2022/11/11
 * at project student_ms
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 登录，不存在就创建用户
     * @param work_id
     * @param password
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Integer work_id,@RequestBody String password){
        return null;
    }

    /**
     * 登出
     * @return
     */
    @PostMapping ("/logout")
    public R<String> logout(){
        return null;
    }

}
