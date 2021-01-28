package br.com.gamezone.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gamezone.loja.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findAllByCategoriaFilmeContainingIgnoreCase(String categoriaFilme);
}
