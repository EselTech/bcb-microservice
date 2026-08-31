package tech.esel.entities;

import java.time.LocalDate;

public class Imposto {
    private String sigla;
    private Double valorTaxa;
    private LocalDate dataAtualizacao;

    public Imposto(String sigla, Double valorTaxa, LocalDate dataAtualizacao) {
        this.sigla = sigla;
        this.valorTaxa = valorTaxa;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Imposto() {
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Double getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(Double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
