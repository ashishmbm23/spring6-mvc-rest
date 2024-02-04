package com.ashish.spring6mvcrest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info =
		@Info(title = "${application-title}",
				version = "${application-version}",
				description = "${application-description}",
				contact = @Contact(
						name = "Ashish",
						email = "ashishmbm23@gmail.com",
						url = "https://www.google.com"
				)
		)
)

public class Spring6MvcRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6MvcRestApplication.class, args);
	}

}
