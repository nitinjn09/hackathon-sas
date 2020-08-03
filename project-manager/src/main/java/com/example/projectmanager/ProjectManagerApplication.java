package com.example.projectmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProjectManagerApplication {
	//private static final Logger log = LoggerFactory.getLogger(ProjectManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception
	{
		return args ->
		{
			int count  = 0;
			while (true)
			{
				log.trace("TRACE-"+count);
				log.info("INFO-"+count);
				log.debug("DEBUG-"+count);
				log.warn("WARN-"+count);
				log.error("ERROR-"+count);
				count++;
				Thread.sleep(100000);
			}
		};
	}
}
