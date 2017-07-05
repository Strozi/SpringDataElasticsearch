package michu.spring.tutorials.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Document(indexName = "users", type="users", shards=1)
public class Users {

	private String name;
	@Id
	@GeneratedValue
	private Long id;
	private String teamName;
	private Long salary;
	
	public Users(){}
	
	
	public Users(String name, String teamName, Long salary) {
		super();
		this.name = name;		
		this.teamName = teamName;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setIg(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	
}
