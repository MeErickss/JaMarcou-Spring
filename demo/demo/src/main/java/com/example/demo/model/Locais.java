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
    private Double coordenadas;

    public Locais() {}

    public Locais(Long id, String cep, String rua, Integer numero, String complemento, Double coordenadas) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.coordenadas = coordenadas;
    }

    public Long getId() {return id;}
    public String getCep() {return cep;}
    public String getComplemento() {return complemento;}
    public Double getCoordenadas() {return coordenadas;}
    public Integer getNumero() {return numero;}
    public String getRua() {return rua;}

    public void setCep(String cep) {this.cep = cep;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
    public void setCoordenadas(Double coordenadas) {this.coordenadas = coordenadas;}
    public void setRua(String rua) {this.rua = rua;}
    public void setNumero(Integer numero) {this.numero = numero;}
}
