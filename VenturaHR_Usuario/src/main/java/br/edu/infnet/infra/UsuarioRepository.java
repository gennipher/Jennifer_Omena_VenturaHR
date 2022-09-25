package br.edu.infnet.infra;

import br.edu.infnet.domain.usuarios.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    
    Usuario findByEmail(String email);
    Usuario findByCpf(String cpf);
    
}


