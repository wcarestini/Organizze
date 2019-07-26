package br.com.organizze.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.organizze.entity.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

    List<Registry>findByRecurrentTrueAndDate(LocalDate date);
}
