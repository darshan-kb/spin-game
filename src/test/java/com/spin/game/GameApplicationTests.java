package com.spin.game;

import com.spin.game.entities.BetCategory;
import com.spin.game.entities.User;
import com.spin.game.model.TicketModel;
import com.spin.game.model.TicketRecordModel;
import com.spin.game.repository.BetCategoryRepository;
import com.spin.game.repository.UserRepository;
import com.spin.game.service.CalculateResultService;
import com.spin.game.service.InitGameService;
import com.spin.game.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

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

	@Autowired
	TicketService ticketService;

	@Autowired
	CalculateResultService calculateResultService;

	@Test
	void contextLoads() {
	}

	@Test
	void add100Values(){
//		for(int i=0;i<100;i++){
//			betrepo.save(new BetCategory(i));
//		}
	}

	@Test
	void testInitGame(){
		System.out.println(igs.gameInit());
	}

	@Test
	void addUser(){
		userRepository.save(new User("Arun","Dharme",passwordEncoder.encode("Arun@1212"),"arundharme@gmail.com",false,false,"ROLE_USER,ROLE_ADMIN"));
	}

	@Test
	void addTicket(){
		String email = "darshanbehere@gmail.com";
		List<TicketRecordModel> lst = new ArrayList<>();
		lst.add(new TicketRecordModel(1,50));
		lst.add(new TicketRecordModel(8,500));
		lst.add(new TicketRecordModel(45,1000));
		lst.add(new TicketRecordModel(89,20));
		lst.add(new TicketRecordModel(78,100));
		TicketModel tm = new TicketModel();
		tm.setTicketRecords(lst);
//		ticketService.saveTicket(email);
	}

	@Test
	void getAllBets(){
		calculateResultService.getCurrentGameResult(152);
	}
}
