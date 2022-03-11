package com.team.demo;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

//import com.team.entity.User;
//import com.team.persistence.UserDao;

@EntityScan(basePackages = "com.team.entity")
@EnableJpaRepositories(basePackages = "com.team.persistence")
@SpringBootApplication(scanBasePackages = "com.team")
public class UserServiceApplication /*implements CommandLineRunner*/ {
	
//	@Autowired
//	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User u1 = new User(1, "Lili", "Vincze", "l.vincze@gmail.com", "password", 20.0);
//		User u2 = new User(2, "Kirushney", "Kalamohan", "k.kalamohan@gmail.com", "password", 10.0);
//		User u3 = new User(3, "Asel", "Perera", "a.perera@gmail.com", "password", 100.0);
//		User u4 = new User(4, "Ryan", "McDermott", "r.mcdermott@gmail.com", "password", 99.0);
//		User u5 = new User(5, "Abdul", "Rizvi", "a.rizvi@gmail.com", "password", 0.0);
//		
//		userDao.save(u1);
//		userDao.save(u2);
//		userDao.save(u3);
//		userDao.save(u4);
//		userDao.save(u5);
//		
//	}

}
