package com.app.AIRS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableJpaAuditing
@EnableJpaRepositories
public class AirsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) { SpringApplication.run(AirsApplication.class, args); }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AirsApplication.class);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.info("------------------*---------------------");
			log.info("|                                      |");
			log.info("|  Started AIRS API Application        |");
			log.info("|                                      |");
			log.info("------------------*---------------------");
		};
	}

}
