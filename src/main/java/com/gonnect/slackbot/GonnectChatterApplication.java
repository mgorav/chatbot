package com.gonnect.slackbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.gonnect.slackbot"})
public class GonnectChatterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GonnectChatterApplication.class, args);
	}

}

