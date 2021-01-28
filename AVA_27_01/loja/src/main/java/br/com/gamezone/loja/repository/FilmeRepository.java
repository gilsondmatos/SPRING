package br.com.gamezone.loja.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.gamezone.loja.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository <Filme, Long> {
	public List<Filme> findAllByNomeDoFilmeContainingIgnoreCase(String nomeDoFilme);
}
