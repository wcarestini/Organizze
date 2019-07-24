package br.com.organizze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.organizze.entity.Registry;

import java.time.LocalDate;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

    Registry findByRecurrentTrueAndDate(LocalDate date);
}
