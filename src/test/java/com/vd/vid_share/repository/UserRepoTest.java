package com.vd.vid_share.repository;

import com.vd.vid_share.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("Adam@gmail.com");
        user.setPassword("Adam123");
        user.setUsername("Adam");

        User savedUser = userRepo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
}