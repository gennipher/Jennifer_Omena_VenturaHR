package br.edu.infnet.app;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping(path = {"/usuarios"})
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    /*@GetMapping("/usuarios")
    public List<Usuario> obterLista() {
        
        return (List<Usuario>) usuarioRepository.findAll();
    }*/
    
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity obterPorId(@PathVariable int id) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build(); //Retorno default 404
        
        try {
            
            Usuario usuario = usuarioRepository.findById(id).get();
            if (usuario != null) {
                retorno = ResponseEntity.ok().body(usuario);
            }
        } catch (Exception e) {
        
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Usuario não encontrado");
        }
        
        return retorno;
    }
    
    @GetMapping(path = {"/email/{email}"})
    public ResponseEntity obterPorEmail(@PathVariable String email) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        if(StringUtils.isNotBlank(email)) {
            
            try {

                Usuario usuario = usuarioRepository.findByEmail(email);
                if (usuario != null) {

                    retorno = ResponseEntity.ok().body(usuario);
                }
            } catch (Exception e) {

                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
        return retorno;
    }
    
    @GetMapping(path = {"/cpf/{cpf}"})
    public ResponseEntity obterPorCPF(@PathVariable String cpf) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {
            
            Usuario usuario = usuarioRepository.findByCpf(cpf);
            if (usuario != null) {
                
                retorno = ResponseEntity.ok().body(usuario);
            }
        } catch (Exception e) {
            
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return retorno;
    }
    
    @GetMapping(path = {"/cnpj/{cnpj}"})
    public ResponseEntity obterPorCnpj(@PathVariable String cnpj) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {
            
            Usuario usuario = usuarioRepository.findByCpf(cnpj);
            if (usuario != null) {
                
                retorno = ResponseEntity.ok().body(usuario);
            }
        } catch (Exception e) {
            
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return retorno;
    }
    
    @PostMapping
    public ResponseEntity inserirUsuario(@RequestBody Usuario usuario) {
        
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(usuario != null && usuario.getId() == null) {
            
            try {
                
                Usuario usuarioInserido = usuarioRepository.save(usuario);
                retorno = ResponseEntity.status(HttpStatus.CREATED).body(usuarioInserido);
                //retorno = ResponseEntity.ok().body(usuarioInserido);
            } catch (Exception e) {
                
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
        return retorno;
    }
    
    @PatchMapping
    public ResponseEntity atualizarUsuario(@RequestBody Usuario usuario) {
        
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        try {
            
            if (usuario != null && usuario.getId() != null) {

                Usuario usuarioGravado = usuarioRepository.findById(usuario.getId()).get();
                if(usuarioGravado != null) {

                    try {

                        usuarioGravado = usuarioRepository.save(usuario);
                        retorno = ResponseEntity.ok().body(usuarioGravado);
                    } catch (Exception e) {

                        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
                    }
                }
            }
            
        } catch (Exception e) {}
        return retorno;
    }
}
