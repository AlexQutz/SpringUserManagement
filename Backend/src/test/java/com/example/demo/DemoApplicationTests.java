package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


//Testing of all the methods.

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {


	@Autowired
	UserRepository userepo;

	@Autowired
	UserService userservice;

	@Test
	@Order(1)
	public void UserPostTest(){
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		User u4 = new User();


		u1.setId(1L);
		u1.setFirstName("Alexandros");
		u1.setLastName("Koutsantoniou");
		u1.setUsername("alexkouts");
		u1.setPassword("1234");

		u2.setId(2L);
		u2.setFirstName("Dimitris");
		u2.setLastName("Koutsantoniou");
		u2.setUsername("jimmy");
		u2.setPassword("12345");

		u3.setId(3L);
		u3.setFirstName("Peter");
		u3.setLastName("Parker");
		u3.setUsername("spider");
		u3.setPassword("man");

		u4.setId(4L);
		u4.setFirstName("Alexis");
		u4.setLastName("Konstantinou");
		u4.setUsername("nikale");
		u4.setPassword("xandros");



		userepo.save(u1);
		userepo.save(u2);
		userepo.save(u3);
		userepo.save(u4);

	}

	@Test
	@Order(2)
	public void UserGetAllTest() {
		userepo.findAll();
	}

	@Test
	@Order(3)
	public void UserGetById(){
		userepo.findById(2L);
	}

	@Test
	@Order(4)
	public void UsersGetByName(){
		userepo.findbyName("Alex");
	}

	@Test
	@Order(5)
	public void UserUpdateTest(){
		User u = userepo.findById(2L).get();
		u.setPassword("1233445667788");
		u.setLastName("Chaliou");
		userepo.save(u);
	}

	@Test
	@Order(6)
	public void UserDeleteTest(){
		userepo.deleteById(3L);
		assertThat(userepo.findById(3L)).isEmpty();
	}

}
