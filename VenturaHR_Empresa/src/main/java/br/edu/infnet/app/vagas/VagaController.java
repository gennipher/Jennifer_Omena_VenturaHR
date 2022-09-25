package br.edu.infnet.app.vagas;

import br.edu.infnet.domain.vagas.Criterio;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = {"/vagas"})
public class VagaController {
    
    @Autowired
    private VagaRepository vagaRepository;
    
    @GetMapping(path="/usuario/{idUsuario}")
    public ResponseEntity obterPorIdUsuario(@PathVariable int idUsuario) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {
            
            List<Vaga> list = vagaRepository.findByIdUsuario(idUsuario);
            if(!list.isEmpty()) {
                retorno = ResponseEntity.ok().body(list);
            }
        } catch (Exception e) {}
        return retorno;
    }
    
    @GetMapping(path="/cargo/{pesquisa}")
    public ResponseEntity pesquisarVagasPorCargo(@PathVariable String pesquisa) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {
            
            List<Vaga> list = vagaRepository.findByCargoContainingIgnoreCase(pesquisa);
            if(!list.isEmpty()) {
                retorno = ResponseEntity.ok().body(list);
            }
        } catch (Exception e) {}
        return retorno;
    }
    
    @GetMapping(path="/cidade/{pesquisa}")
    public ResponseEntity pesquisarVagasPorCidade(@PathVariable String pesquisa) {
        
        ResponseEntity retorno = ResponseEntity.notFound().build();
        try {
            
            List<Vaga> list = vagaRepository.findByCidadeContainingIgnoreCase(pesquisa);
            if(!list.isEmpty()) {
                retorno = ResponseEntity.ok().body(list);
            }
        } catch (Exception e) {}
        return retorno;
    }
    
    @PostMapping
    public ResponseEntity publicarVaga (@RequestBody Vaga vaga) {
        
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        List<Criterio> criterioList = vaga.getCriterioList();
        if(criterioList != null && !criterioList.isEmpty()) {
            
            for (Criterio criterio : criterioList) {
                
                criterio.setIdVaga2(vaga);
            }
            Vaga vagaInserida = vagaRepository.save(vaga);
            retorno = ResponseEntity.status(HttpStatus.CREATED).body(vagaInserida);
        }
        return retorno;
    }
    
    
    @GetMapping(path ={"/"})
    public ResponseEntity obterVagas() {
        
        List<Vaga> list = vagaRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
}
