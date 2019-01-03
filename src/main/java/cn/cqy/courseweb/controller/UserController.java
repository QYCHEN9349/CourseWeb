package cn.cqy.courseweb.controller;

import cn.cqy.courseweb.repository.UserRepository;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    String index() {
        return "welcome";
    }

    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.GET)
    String ajaxLoginGet() {
        return "login";
    }

    //登陆post
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    String ajaxLoginPost(@RequestBody Map<String, Object> user) {
        String username = user.get("username").toString();
        String password=user.get("password").toString();
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        return "redirect:/student/test";
    }

    @RequestMapping("/guest/test")
    String guestIndex() {
        return "guest";
    }

    @RequestMapping("/manager/test")
    String managerIndex() {
        return "manager";
    }

    @RequestMapping("/teacher/test")
    String teacherIndex() {
        return "teacher";
    }

    @RequestMapping("/student/test")
    String studentIndex() {
        return "student";
    }
}
