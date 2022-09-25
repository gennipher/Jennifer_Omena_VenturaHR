package br.edu.infnet.VenturaHR_WebMvc.infra.vagas;

import br.edu.infnet.VenturaHR_WebMvc.domain.vagas.Vaga;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8081/vagas", name = "Vagas")
public interface VagaService {
    
    @GetMapping(value = "/")
    List<Vaga> findAllVagas();
    
    @PostMapping
    Vaga publicarVaga(@RequestBody Vaga vaga);
    
    @GetMapping(value = "/usuario/{idusuario}")
    List<Vaga> listarPorIdUsuario(@PathVariable Integer idUsuario);

    @GetMapping(value = "/cargo/{pesquisa}")
    List<Vaga> pesquisarVagasPorCargo(@PathVariable String pesquisa);
    
    @GetMapping(value = "/cidade/{pesquisa}")
    List<Vaga> pesquisarVagasPorCidade(@PathVariable String pesquisa);
}
