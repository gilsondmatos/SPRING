package org.blogpessoal.blogpessoal.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.blogpessoal.blogpessoal.Repository.UsuarioRepository;
import org.blogpessoal.blogpessoal.model.UserLogin;
import org.blogpessoal.blogpessoal.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> CadastrarUsuario(Usuario usuario) {
		
		
		if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			return null;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);				
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());
				
				return user;

			}
		}
		return null;
	}

}