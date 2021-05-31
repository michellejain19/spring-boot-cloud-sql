package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootCloudSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudSqlApplication.class, args);
	}

	@Autowired repository repo;

	@GetMapping("/shows")
	public List<Show> getAllShows(){
		return repo.findAll();
	}

}


@AllArgsConstructor
@NoArgsConstructor
@Data
class Show{
	private Long id;
	private String title;
}

@Repository
interface repository extends JpaRepository<Show, Long>{}

