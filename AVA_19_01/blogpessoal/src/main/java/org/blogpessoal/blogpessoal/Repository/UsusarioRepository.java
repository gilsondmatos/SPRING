package org.blogpessoal.blogpessoal.Repository;

import java.util.Optional;

import org.blogpessoal.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsusarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsuario(String usuario);
}
