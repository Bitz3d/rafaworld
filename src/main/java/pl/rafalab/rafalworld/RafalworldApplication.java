package pl.rafalab.rafalworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class RafalworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(RafalworldApplication.class, args);
	}
}
