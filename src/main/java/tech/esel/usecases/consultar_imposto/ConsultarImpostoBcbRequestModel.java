package tech.esel.usecases.consultar_imposto;

import java.time.LocalDate;

public record ConsultarImpostoBcbRequestModel(String siglaImposto, LocalDate dataConsulta) {
}

