package br.com.organizze.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Schedule {
	
	@Scheduled(fixedDelay = 60000)
	public void execute() {
		System.out.println("scheduled");
	}
}
