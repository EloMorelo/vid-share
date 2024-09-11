package com.vd.vid_share.repository;

import com.vd.vid_share.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
