package tech.esel.usecases.consultar_imposto;

import java.time.LocalDate;

public record ConsultarImpostoBcbResponseModel(String siglaImposto, double valorTaxa, LocalDate dataAtualizacao) {
}
