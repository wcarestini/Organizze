package br.com.organizze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.organizze.entity.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {
}
