package com.example.demo.dto;

public class AvaliacoesDto {
    private Long id;
    private Float nota;
    private Long horarioId;
    private Long estabelecimentoId;
    private String nomeEstabelecimento; // opcional extra

    public AvaliacoesDto() {}

    public AvaliacoesDto(Long id, Float nota, Long horarioId, Long estabelecimentoId, String nomeEstabelecimento) {
        this.id = id;
        this.nota = nota;
        this.horarioId = horarioId;
        this.estabelecimentoId = estabelecimentoId;
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public Long getId() { return id; }
    public Float getNota() { return nota; }
    public Long getHorarioId() { return horarioId; }
    public Long getEstabelecimentoId() { return estabelecimentoId; }
    public String getNomeEstabelecimento() { return nomeEstabelecimento; }
}
