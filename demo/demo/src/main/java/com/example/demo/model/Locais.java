package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "locais")
public class Locais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;


    public Locais() {}

    public Locais(Long id, String cep, String rua, Integer numero, String complemento, String estado, String cidade, String bairro) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public Long getId() {return id;}
    public String getCep() {return cep;}
    public String getComplemento() {return complemento;}
    public Integer getNumero() {return numero;}
    public String getRua() {return rua;}
    public String getBairro() {return bairro;}
    public String getCidade() {return cidade;}
    public String getEstado() {return estado;}

    public void setCep(String cep) {this.cep = cep;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
    public void setRua(String rua) {this.rua = rua;}
    public void setNumero(Integer numero) {this.numero = numero;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setEstado(String estado) {this.estado = estado;}

}
