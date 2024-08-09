package com.viniwebs.workshop.resources;

import com.viniwebs.workshop.domain.User;
import com.viniwebs.workshop.dto.UserDto;
import com.viniwebs.workshop.services.UserService;
import com.viniwebs.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
        if (user == null) {
            throw new ObjectNotFoundException("User with id " + id + " not found");
        }
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        service.save(user);
        URI uri = URI.create("/users/" + user.getId());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }
}
