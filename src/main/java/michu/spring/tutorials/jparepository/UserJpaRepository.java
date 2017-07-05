package michu.spring.tutorials.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import michu.spring.tutorials.model.Users;

//for example of loading data from jpa repository to ES repository
public interface UserJpaRepository extends JpaRepository<Users, Long>{

}
