package michu.spring.tutorials.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import michu.spring.tutorials.model.Users;

public interface UsersRepository extends ElasticsearchRepository<Users, Long>{

	List<Users> findByName(String text);

	List<Users> findBySalary(Long salary);

	List<Users> findByNameContains(String text);
}
