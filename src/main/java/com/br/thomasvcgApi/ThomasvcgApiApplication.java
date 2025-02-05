package com.br.thomasvcgApi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class 	ThomasvcgApiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		String dbUrl = dotenv.get("DATABASE_URL");
		String dbUser = dotenv.get("DATABASE_USERNAME");
		String dbPassword = dotenv.get("DATABASE_PASSWORD");

		System.out.println("Database URL: " + dbUrl);
		System.out.println("Database User: " + dbUser);
		System.out.println("Database Password: " + dbPassword);
		SpringApplication.run(ThomasvcgApiApplication.class, args);
	}

}
