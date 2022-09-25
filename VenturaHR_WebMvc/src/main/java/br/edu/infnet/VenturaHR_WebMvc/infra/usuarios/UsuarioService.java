package br.edu.infnet.VenturaHR_WebMvc.infra.usuarios;

import br.edu.infnet.VenturaHR_WebMvc.domain.usuarios.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(url = "http://localhost:8081/usuarios", name = "Usuarios")
public interface UsuarioService {
    
//    @GetMapping(value = "/id/{id}")
//    Usuario obterPorId(String id);
    
    @GetMapping(path = {"/email/{email}"})
    Usuario obterPorEmail(@PathVariable String email);
    
    @PostMapping
    Usuario inserirUsuario(Usuario usuario);   
}
