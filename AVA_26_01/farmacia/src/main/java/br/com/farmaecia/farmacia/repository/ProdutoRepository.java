package br.com.farmaecia.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import br.com.farmaecia.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
	public List<Produto> findAllByNomeProdutoContainingIgnoreCase (String nomeProduto);
	
}
