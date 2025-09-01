package com.example.demo.dto;

public class AvaliacoesDto {
    private Long id;
    private Float nota;
    private Long horarioId;
    private Long estabelecimentoId;

    public AvaliacoesDto() {}

    public AvaliacoesDto(Long id, Float nota, Long horarioId, Long estabelecimentoId) {
        this.id = id;
        this.nota = nota;
        this.horarioId = horarioId;
        this.estabelecimentoId = estabelecimentoId;
    }

    public Long getId() { return id; }
    public Float getNota() { return nota; }
    public Long getHorarioId() { return horarioId; }
    public Long getEstabelecimentoId() { return estabelecimentoId; }
}
