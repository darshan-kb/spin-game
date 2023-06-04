package com.spin.game;

import com.spin.game.entities.BetCategory;
import com.spin.game.repository.BetCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameApplicationTests {

	@Autowired
	BetCategoryRepository betrepo;

	@Test
	void contextLoads() {
	}

	@Test
	void add100Values(){
		for(int i=0;i<100;i++){
			betrepo.save(new BetCategory(i));
		}
	}

}
