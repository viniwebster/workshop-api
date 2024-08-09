package com.viniwebs.workshop.resources;

import com.viniwebs.workshop.domain.User;
import com.viniwebs.workshop.dto.UserDto;
import com.viniwebs.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = service.findAll();
        List<UserDto> usersDto = users.stream().map(UserDto::new).toList();
        return ResponseEntity.ok().body(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User obj = new User();
        obj.setId(user.getId());
        obj.setEmail(user.getEmail());
        obj.setUsername(user.getUsername());
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }
}
