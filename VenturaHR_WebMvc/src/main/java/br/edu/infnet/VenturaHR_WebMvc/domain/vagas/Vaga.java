package br.edu.infnet.VenturaHR_WebMvc.domain.vagas;

import br.edu.infnet.VenturaHR_WebMvc.domain.criterios.Criterio;
import java.util.List;

public class Vaga {
    
    private Integer id;
    private Integer idusuario;
    private String cargo;
    private String cidade;
    private String formaContratacao;
    private List<Criterio> listaCriterio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public List<Criterio> getListaCriterio() {
        return listaCriterio;
    }

    public void setListaCriterio(List<Criterio> listaCriterio) {
        this.listaCriterio = listaCriterio;
    }
    
}
