package br.com.organizze.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.organizze.entity.Registry;
import br.com.organizze.service.RegistryService;

@RestController
@RequestMapping("/organizze")
public class RegistryRest {
	
	@Autowired
	private RegistryService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Registry registry){
		return new ResponseEntity<>(service.save(registry),HttpStatus.CREATED);
	}
	
	@PostMapping("recurrent")
	public ResponseEntity<?> saveRecurrent(@RequestBody Registry registry,
											@RequestParam(value = "replicate") Integer replicate,
											@RequestParam(value = "period") String period){
		return new ResponseEntity<>(service.saveWithRegistryRecurrent(registry, replicate, period),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(Pageable pageable){
		return new ResponseEntity<>(service.findAll(pageable),HttpStatus.OK);
	}
	
}
