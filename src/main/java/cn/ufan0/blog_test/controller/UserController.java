package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.User;
import cn.ufan0.blog_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }

    @Secured("ROLE_USER")
    @PutMapping("/user")
    public void updateUser(User user) {
        // 未输入任何值时不执行 sql 操作
        if (user.getDescription() != null || user.getNickname() != null || user.getEmail() != null || user.getProfile_photo() != null || user.getUsername() != null || user.getPassword() != null) {
            userService.UpdateUser(user);
        }
    }
}
