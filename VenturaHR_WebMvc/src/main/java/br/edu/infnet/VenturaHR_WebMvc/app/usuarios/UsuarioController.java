package br.edu.infnet.VenturaHR_WebMvc.app.usuarios;

import br.edu.infnet.VenturaHR_WebMvc.domain.usuarios.Usuario;
import br.edu.infnet.VenturaHR_WebMvc.domain.vagas.Vaga;
import br.edu.infnet.VenturaHR_WebMvc.infra.usuarios.UsuarioService;
import br.edu.infnet.VenturaHR_WebMvc.infra.vagas.VagaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private VagaService vagaService;
    
    //fazer login
    @RequestMapping("/login")
    public ModelAndView logarNoSite(String email, String senha) {
        
        ModelAndView retorno = new ModelAndView("index");
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(senha)) {
            
            Usuario usuario = usuarioService.obterPorEmail(email);
            if (usuario != null && senha.equals(usuario.getSenha())) {
                
                String destino = "";
                switch (usuario.getTipo()) {
                    
                    case 'C':
                        destino = "candidato/index"; 
                        break;
                    case 'E': 
                        destino = "empresa/index";
                        try {
                            
                            List<Vaga> publicadas = vagaService.listarPorIdUsuario(usuario.getId());
                            retorno.addObject("publicadas", publicadas);
                        } catch (Exception e) {}
                        break;
                    
                }
                retorno.setViewName(destino);
                retorno.addObject("usuario", usuario);
            } else {
                
                retorno.addObject("erro", "Login inválido");
            }
        } else {
            retorno.addObject("erro", "Os campos são obrigatórios");
        }
        return retorno;
    }
    
    //criar conta
    @RequestMapping("/usuario/criarConta")
    public ModelAndView criarConta(@Valid Usuario usuario, BindingResult br) {
        
        ModelAndView retorno = new ModelAndView("usuario/index");
        if(br.hasErrors()) {
            
            retorno.addObject("erros", br.getFieldErrors());
        } else {
            
            Usuario gravado = usuarioService.inserirUsuario(usuario);
            String destino = "";
            switch (usuario.getTipo()) {
                
                case 'C':
                    destino = "candidato/index"; 
                    break;
                case 'E': 
                    destino = "empresa/index"; 
                    break;
            }
            retorno.setViewName(destino);
            retorno.addObject("usuario", gravado);
        }
        return retorno;
    }
    
    //publicar vaga
    
    //listar vaga
}
