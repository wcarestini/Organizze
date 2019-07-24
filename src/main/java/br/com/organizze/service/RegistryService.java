package br.com.organizze.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.organizze.entity.Registry;
import br.com.organizze.repository.RegistryRepository;

@Service
public class RegistryService {

	@Autowired
	private RegistryRepository dao;
	
	public Registry save(Registry registry) {
		return dao.save(registry);
	}
	
	public Page<Registry> findAll(Pageable pageable){
		return dao.findAll(pageable);
	}
	
	public List<Registry> saveWithRegistryRecurrent(Registry registryRecurrent, Integer replicate, String period) {
		List<Registry> scheduled = new ArrayList<Registry>();
		Registry registry = registryRecurrent;
		scheduled.add(dao.save(registry));
		while(replicate > 0) {
			if(period.equals("WEEK")) {
				registry = new Registry(registry.getName(),registry.getDate().plusWeeks(1),
						registry.getAmount(),registry.getType());
				scheduled.add(dao.save(registry));
			} else if (period.equals("MONTH")) {
				registry = new Registry(registry.getName(),registry.getDate().plusMonths(1),
						registry.getAmount(),registry.getType());
				scheduled.add(dao.save(registry));
			}else if (period.equals("TWO_MONTHS")) {
				registry = new Registry(registry.getName(),registry.getDate().plusMonths(2),
						registry.getAmount(),registry.getType());
				scheduled.add(dao.save(registry));
			}
			replicate--;
		}
		return scheduled;
	}
	
}
