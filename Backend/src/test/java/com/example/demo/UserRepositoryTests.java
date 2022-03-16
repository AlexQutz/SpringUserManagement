/*package com.example.demo;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setFirstName("Alexandros");
        user.setLastName("Koutsantoniou");
        user.setUsername("alexkouts");
        user.setPassword("1234");

        User saveUser = repo.save(user);

        User existUser = entityManager.find(User.class, saveUser.getId());

        assertThat(existUser.getUsername()).isEqualTo(user.getUsername());

    }

    @Test
    public void testFindByID() {
        Long id = Long.valueOf(1);

        User user = repo.findByID(id);

        assertThat(user).isNotNull();
    }

}*/
