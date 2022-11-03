package com.example.HallService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HallServiceApplication {

	@Bean
public RestTemplate getRestTemplate(){
	return new RestTemplate();
}

	public static void main(String[] args) {
		SpringApplication.run(HallServiceApplication.class, args);
	}
@Bean
	public CommandLineRunner CommandLineRunnerBean(){
		return(args) -> {
			System.out.println("Hall server starting");
			HallService.InitializeWaiters();
			for (String arg:args){
				System.out.println(arg);
			}
		};
}
}
