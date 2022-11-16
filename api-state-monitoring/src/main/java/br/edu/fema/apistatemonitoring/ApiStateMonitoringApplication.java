package br.edu.fema.apistatemonitoring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ApiStateMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStateMonitoringApplication.class, args);
	}

}
