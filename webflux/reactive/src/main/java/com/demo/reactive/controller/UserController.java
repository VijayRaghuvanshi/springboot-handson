package com.demo.reactive.controller;

import com.demo.reactive.entity.User;
import com.demo.reactive.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id){
        logger.info("get user request received user id {}", id);

        return userService.getUserById(id);
    }

    @GetMapping
    public Flux<User> getAllUsers(){
        logger.info("get All users request received ");

        return userService.getAllUsers();
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user){

        logger.info("create user request received {}", user);
/*        User user1 = new User();
        user1.setEmail("john@example.com");
        user1.setName("Jon Doe");*/
         return userService.createUser(user);
    }
}
