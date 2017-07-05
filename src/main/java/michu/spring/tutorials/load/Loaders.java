package michu.spring.tutorials.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.net.SyslogOutputStream;
import michu.spring.tutorials.jparepository.UserJpaRepository;
import michu.spring.tutorials.model.Users;
import michu.spring.tutorials.repository.UsersRepository;

//@Component
public class Loaders {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	ElasticsearchOperations operations; 
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@PostConstruct
	@Transactional
	public void loadAll(){
		
		operations.putMapping(Users.class);
		System.out.println("Loading Data");
		List<Users> data = getData();
		userJpaRepository.save(data); // save to H2 database		
		usersRepository.save(userJpaRepository.findAll()); //loads from H2 to ES
		System.out.println("Loading complited");
		
	}
	
	private List<Users> getData(){
		
		List<Users> users = new ArrayList<>();
		
		users.add(new Users("Agata", "Controling", 8000L));
		users.add(new Users("Marta", "Accounting", 6000L));
		users.add(new Users("Gosia", "Programming", 7000L));
		users.add(new Users("Agata", "Traveling", 10000L));
		return users;
		
	}
	
}
