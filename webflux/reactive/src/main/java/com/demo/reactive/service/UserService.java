package com.demo.reactive.service;

import com.demo.reactive.entity.User;
import com.demo.reactive.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    final UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Mono<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Mono<User> createUser(User user){
        return userRepository.save(user);
    }

}
