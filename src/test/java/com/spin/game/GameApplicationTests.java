package com.spin.game;

import com.spin.game.entities.BetCategory;
import com.spin.game.entities.User;
import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.repository.UserRepository;
import com.spin.game.service.InitGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class GameApplicationTests {

	@Autowired
	BetCategoryRepository betrepo;

	@Autowired
	UserRepository userRepository;
	@Autowired
	InitGameService igs;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	void add100Values(){
		for(int i=0;i<100;i++){
			betrepo.save(new BetCategory(i));
		}
	}

	@Test
	void testInitGame(){
		System.out.println(igs.gameInit());
	}

	@Test
	void addUser(){
		userRepository.save(new User("Arun","Dharme",passwordEncoder.encode("Arun@1212"),"arundharme@gmail.com",false,false,"ROLE_USER,ROLE_ADMIN"));
	}
}
