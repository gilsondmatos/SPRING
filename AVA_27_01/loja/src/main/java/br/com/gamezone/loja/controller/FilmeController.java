package br.com.gamezone.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gamezone.loja.model.Filme;
import br.com.gamezone.loja.repository.FilmeRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Filme>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("{id}")
	public ResponseEntity<Filme> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity
			.notFound().build());
	}
	@GetMapping("/filme/{nomeDoFilme}")
	public ResponseEntity<List<Filme>> getByName(@PathVariable String nomeDoFilme){
		return ResponseEntity.ok(repository.findAllByNomeDoFilmeContainingIgnoreCase(nomeDoFilme));
	}
	@PostMapping
	public ResponseEntity<Filme> post (@RequestBody Filme filme){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(filme));
	}
	@PutMapping
	public ResponseEntity<Filme> put (@RequestBody Filme filme){
		return ResponseEntity.ok(repository.save(filme));	
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	

}
