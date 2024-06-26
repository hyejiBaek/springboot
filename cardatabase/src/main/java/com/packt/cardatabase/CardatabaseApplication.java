package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;
	
	public static void main(String[] args){
		
		SpringApplication.run(CardatabaseApplication.class, args); 
		logger.info("Application started");
		
	}
	
	@Override
	public void run(String...args) throws Exception {
		// 소유자 db 저장
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
		// 자동차 db 저장
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));
		 
		// 콘솔 표출
		for(Car car : repository.findAll()) {
			logger.info(car.getBrand() + "  " + car.getModel());
		}
 
		// 사용자 추가
		urepository.save(new User("user", "$2y$04$41vVyHBAzWNCKQsLETYBouUTrM/U1lUIDQxnw816S//QKErLlm1sq", "USER"));
		urepository.save(new User("admin", "$2y$04$WQM/mHLnM/Be1GmPpnFToOfi.lw64nKFKsciMy64eyHHjoXKWNtFi", "ADMIN"));
	}
}
