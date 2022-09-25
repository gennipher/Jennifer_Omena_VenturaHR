package br.edu.infnet.VenturaHR_WebMvc.domain.usuarios;

import javax.validation.constraints.NotNull;

public class Usuario {
    
    private Integer id;
    
    @NotNull(message = "Nome é obrigatório")
    private String nome;
    
    @NotNull(message = "Endereço é obrigatório")
    private String endereco;
    
    @NotNull(message = "Telefone é obrigatório")
    private String telefone;
    
    @NotNull(message = "E-mail é obrigatório")
    private String email;
    
    @NotNull(message = "Senha é obrigatório")
    private String senha;
    
    @NotNull(message = "Cpf é obrigatório")
    private String cpf;
    
    private String razaoSocial;
    
    private String cnpj;
    
    private Character tipo;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

}
