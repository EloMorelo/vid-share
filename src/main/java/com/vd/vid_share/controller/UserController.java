package com.vd.vid_share.controller;


import com.vd.vid_share.entities.User;
import com.vd.vid_share.repository.UserRepo;
import com.vd.vid_share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id)
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
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id)
    {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("User deleted");
    }


}
