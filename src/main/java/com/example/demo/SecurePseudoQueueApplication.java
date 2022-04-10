package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Secure Pseudo Queue", version = "V0", description = "GitHub: https://github.com/th3-c0d3r/secure-pseudo-queue"))
public class SecurePseudoQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurePseudoQueueApplication.class, args);
	}

}
