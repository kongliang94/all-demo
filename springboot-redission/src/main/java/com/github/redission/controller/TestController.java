package com.github.redission.controller;

import com.github.redission.dao.UserRepository;
import com.github.redission.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class TestController {


    private UserRepository userRepository;

    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/testSaveUser")
    public String saveUser() throws InterruptedException {
        User user = new User("1", "kk", 100L);
        userRepository.setUser(user);

        Thread.sleep(2000);
        log.info(userRepository.getUser("1").getName());
        return "success";
    }


    @RequestMapping("/check")
    public Mono<String> check() {
        return Mono.just("hello,everything nice");
    }

}
