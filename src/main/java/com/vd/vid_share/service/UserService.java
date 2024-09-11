package com.vd.vid_share.service;

import com.vd.vid_share.repository.UserRepo;
import com.vd.vid_share.entities.User;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter @Setter @NoArgsConstructor
@Service
public class UserService {

    UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Integer id){
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }

        return null;
    }

    public User saveUser (User User){
        User savedUser = userRepo.save(User);

        return savedUser;
    }

    public User updateUser (User User) {
        Optional<User> existingUser = userRepo.findById(User.getId());

        User updatedUser = userRepo.save(User);

        return updatedUser;
    }

    public void deleteUserById (Integer id) {
        userRepo.deleteById(id);
    }
}
