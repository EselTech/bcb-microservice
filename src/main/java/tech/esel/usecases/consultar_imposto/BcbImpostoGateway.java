package tech.esel.usecases.consultar_imposto;

import tech.esel.entities.Imposto;

import java.time.LocalDate;

public interface BcbImpostoGateway {
    Imposto consultarImposto(String sigla, LocalDate data);
}
