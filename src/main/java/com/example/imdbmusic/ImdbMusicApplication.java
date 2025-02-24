package com.example.imdbmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.imdbmusic.repository")
public class ImdbMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbMusicApplication.class, args);
	}

}
