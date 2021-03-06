package com.crud.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudProjectApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE PEOPLE IF EXISTS");
		template.execute("CREATE TABLE PEOPLE(id INTEGER (11) PRIMARY KEY auto_increment, name VARCHAR(255))");

		for (int i= 0; i < 3; i++) {
			template.update("insert into people(name)values('People 000"+i+"')");
		}
	}
}
