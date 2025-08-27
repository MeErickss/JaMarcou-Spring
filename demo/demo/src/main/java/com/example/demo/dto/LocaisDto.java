package com.example.demo.dto;

public class LocaisDto {
    private Long id;
    private String cep;
    private String rua;
    private Integer numero;
    private String complemento;
    private Double coordenadas;

    public LocaisDto() {}

    public LocaisDto(Long id, String cep, String rua, Integer numero, String complemento, Double coordenadas) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.coordenadas = coordenadas;
    }

    public Long getId() { return id; }
    public String getCep() { return cep; }
    public String getRua() { return rua; }
    public Integer getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public Double getCoordenadas() { return coordenadas; }
}
