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

import br.com.gamezone.loja.model.Categoria;
import br.com.gamezone.loja.repository.CategoriaRepository;

//Essa classe é um controlador
@RestController

//URI - Defini a URI. Como será acessada
@RequestMapping("/categoria")

//Essa classe vai aceitar requisição de qualquer origem
@CrossOrigin("*")
public class CategoriaController {
	
	//Injeção de dependência
	//Toda responsabilidade fica com o Spring
	//O Autowired garante que os serviços do repository sejá acessado
	@Autowired
	private CategoriaRepository repository;
	
	//Metodo FindAll
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity
				.ok(resp)).orElse(ResponseEntity
						.notFound().build());
	}
	
	@GetMapping("/categoriafilme/{categoriaFilme}")
	public ResponseEntity<List<Categoria>> GetByCategoriaFilme(@PathVariable String categoriaFilme){
		return ResponseEntity.ok(repository.findAllByCategoriaFilmeContainingIgnoreCase(categoriaFilme));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoriaFilme){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoriaFilme));	
	}
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoriaFilme){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoriaFilme));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
	
		
