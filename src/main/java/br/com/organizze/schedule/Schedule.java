package br.com.organizze.schedule;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.organizze.entity.Registry;
import br.com.organizze.service.RegistryService;

@Component
@EnableScheduling
public class Schedule {

	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	private final RegistryService registryService;

	@Autowired
	public Schedule(RegistryService registryService) {
		this.registryService = registryService;
	} 

	@Scheduled(cron = "0 55 23 * * *", zone = TIME_ZONE)
	public void execute() {
		List<Registry> registryList = registryService.findByRecurrentTrueAndDate(LocalDate.now());
		registryList.forEach(registry -> {
			registry.setRecurrent(false);
			registryService.update(registry);

			registry.setRecurrent(true);
			registry.setDate(registry.getDate().plusDays(registry.getRecurringDays()));
			registryService.save(registry);

			System.out.println(registry);
		});
	}
}