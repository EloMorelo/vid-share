package com.vd.vid_share.controller;


import com.vd.vid_share.entities.User;
import com.vd.vid_share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User User)
    {
        return ResponseEntity.ok().body(userService.saveUser(User));
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User User)
    {
        return ResponseEntity.ok().body(userService.updateUser(User));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id)
    {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("User deleted");
    }


}
