package com.example.demo.dto;

public class LocaisDto {
    private Long id;
    private String cep;
    private String rua;
    private Integer numero;
    private String complemento;

    public LocaisDto() {}

    public LocaisDto(Long id, String cep, String rua, Integer numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Long getId() { return id; }
    public String getCep() { return cep; }
    public String getRua() { return rua; }
    public Integer getNumero() { return numero; }
    public String getComplemento() { return complemento; }
}
