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
import michu.spring.tutorials.model.Users;
import michu.spring.tutorials.repository.UsersRepository;

//@Component
public class Loaders {
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	ElasticsearchOperations operations; 
	
	@PostConstruct
	@Transactional
	public void loadAll(){
		
		operations.putMapping(Users.class);
		System.out.println("Loading Data");
		//usersRepository.save(getData());
		System.out.println("Loading complited");
		
	}
	
	private List<Users> getData(){
		
		List<Users> users = new ArrayList<>();
		
		users.add(new Users("Agata", 123L, "Controling", 8000L));
		users.add(new Users("Marta", 1234L, "Accounting", 6000L));
		users.add(new Users("Gosia", 12345L, "Programming", 7000L));
		users.add(new Users("Agata", 123L, "Traveling", 10000L));
		return users;
		
	}
	
}
