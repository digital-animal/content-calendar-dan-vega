package com.zahid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		log.info("Welcome to Content Calendar Application");
		SpringApplication.run(Application.class, args);

		System.out.println("# Connecting to Database: dvcc");
		connectToDatabase();
	}

	public static void connectToDatabase() {

		String jdbcURL = "jdbc:postgresql://localhost:5432/dvcc";

		try (Connection connection = DriverManager.getConnection(jdbcURL, "postgres", "123")) {

			if (!connection.isValid(0)) {
				System.out.println("Unable to connect to database");
				System.exit(0);
			}

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM content ORDER BY  created_at DESC LIMIT 10");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String title = resultSet.getString("title");
				System.out.println(title);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
