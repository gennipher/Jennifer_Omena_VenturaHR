package br.edu.infnet.VenturaHR_WebMvc.domain.criterios;

public class Criterio {
    
    private Integer id;
    private Integer idvaga2;
    private String descricao;
    private int perfil;
    private int peso;
    public Criterio() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdvaga2() {
        return idvaga2;
    }

    public void setIdvaga2(Integer idvaga2) {
        this.idvaga2 = idvaga2;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
