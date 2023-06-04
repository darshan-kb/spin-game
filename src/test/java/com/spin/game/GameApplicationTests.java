package com.spin.game;

import com.spin.game.entities.BetCategory;
import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.service.InitGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameApplicationTests {

	@Autowired
	BetCategoryRepository betrepo;
	@Autowired
	InitGameService igs;

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

}
