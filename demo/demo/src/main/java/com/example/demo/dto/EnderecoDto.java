package com.example.demo.dto;


public class EnderecoDto {
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;
    private String complemento;

    public EnderecoDto(String cep, String estado, String cidade, String bairro, String rua, Integer numero, String complemento){
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua ;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getRua() {return rua;}
    public Integer getNumero() {return numero;}
    public String getComplemento() {return complemento;}
    public String getCep() {return cep;}
    public String getBairro() {return bairro;}
    public String getCidade() {return cidade;}
    public String getEstado() {return estado;}
}
