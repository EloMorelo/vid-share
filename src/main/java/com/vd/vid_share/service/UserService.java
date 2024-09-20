package com.vd.vid_share.service;

import com.vd.vid_share.entities.User;
import com.vd.vid_share.repository.UserRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(UUID id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    public void deleteUserById(UUID id) {
        userRepo.deleteById(id);
    }
}
