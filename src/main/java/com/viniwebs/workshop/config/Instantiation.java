package com.viniwebs.workshop.config;

import com.viniwebs.workshop.domain.User;
import com.viniwebs.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User("Vinicius", "vinicius@gmail.com");
        User user2 = new User("Rogerio", "rogerio@gmail.com");
        User user3 = new User("Alex", "alex@gmail.com");
        User user4 = new User("Cassio", "cassio@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
    }
}
