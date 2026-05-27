package org.serratec.SerratecFlix.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("usuario-endereco")
    private Usuario usuario;

    public Endereco() {}

    public Endereco(Long id, String cep, String logradouro, String bairro, String cidade, String uf, Usuario usuario) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
