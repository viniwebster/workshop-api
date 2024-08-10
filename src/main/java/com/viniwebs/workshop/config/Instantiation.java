package com.viniwebs.workshop.config;

import com.viniwebs.workshop.domain.Post;
import com.viniwebs.workshop.domain.User;
import com.viniwebs.workshop.dto.AuthorDto;
import com.viniwebs.workshop.repositories.PostRepository;
import com.viniwebs.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User("Vinicius", "vinicius@gmail.com");
        User user2 = new User("Rogerio", "rogerio@gmail.com");
        User user3 = new User("Alex", "alex@gmail.com");
        User user4 = new User("Cassio", "cassio@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

        Post p1 = new Post("Viajem", sdf.parse("09/08/2024"), "Hoje viajo para maldivas" ,new AuthorDto(user1));
        Post p2 = new Post("Ferias", sdf.parse("29/05/2023"), "Hoje viajo para maldivas" ,new AuthorDto(user2));
        Post p3= new Post("Corinthians",sdf.parse("10/07/2024"), "O corinthians é gigante!" ,new AuthorDto(user1));
        Post p4 = new Post("Frio", sdf.parse("09/08/2020"), "Hoje esta muito frio" ,new AuthorDto(user4));

        postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
    }
}
