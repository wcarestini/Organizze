package br.com.organizze.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.organizze.entity.Registry;
import br.com.organizze.repository.RegistryRepository;

@Service
public class RegistryService {

	private final RegistryRepository dao;

	@Autowired
	public RegistryService(RegistryRepository dao) {
		this.dao = dao;
	}

	public Registry save(Registry registry) {
		if (registry.getId() != null) {
			registry.setId(null);
		}
		return dao.save(registry);
	}

	public Registry update(Registry registry) {
		if (registry.getId() == null) {
			throw new IllegalArgumentException("Id não pode ser nulo para atualizar");
		}
		return dao.save(registry);
	}

	public Page<Registry> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	public Registry findByRecurrentTrueAndDate(LocalDate date) {
		return dao.findByRecurrentTrueAndDate(date);
	}
}
