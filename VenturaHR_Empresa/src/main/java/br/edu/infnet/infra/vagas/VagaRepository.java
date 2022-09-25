package br.edu.infnet.infra.vagas;

import br.edu.infnet.domain.vagas.Vaga;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VagaRepository extends CrudRepository<Vaga, Integer> {
    
    List<Vaga> findByIdUsuario(Integer idUsuario);
    List<Vaga> findByCargoContainingIgnoreCase(String pesquisa);
    List<Vaga> findByCidadeContainingIgnoreCase(String pesquisa);
    List<Vaga> findAll();
    
    // list<vaga> findbycargocontainingignorecase(string pesquisa)
}
