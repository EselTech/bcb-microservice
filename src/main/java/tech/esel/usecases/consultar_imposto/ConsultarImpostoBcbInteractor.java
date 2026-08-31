package tech.esel.usecases.consultar_imposto;

import tech.esel.entities.Imposto;

public class ConsultarImpostoBcbInteractor implements ConsultarImpostoBcbInputBoundary {

    private final BcbImpostoGateway bcbGateway;

    public ConsultarImpostoBcbInteractor(BcbImpostoGateway bcbGateway) {
        this.bcbGateway = bcbGateway;
    }

    public ConsultarImpostoBcbResponseModel executar(ConsultarImpostoBcbRequestModel request) {
        if (request.siglaImposto() == null || request.siglaImposto().isBlank()) {
            throw new IllegalArgumentException("A sigla do imposto é obrigatória para a consulta no BCB.");
        }

        Imposto impostoEntity = bcbGateway.consultarImposto(request.siglaImposto(), request.dataConsulta());


        return new ConsultarImpostoBcbResponseModel(
                impostoEntity.getSigla(),
                impostoEntity.getValorTaxa(),
                impostoEntity.getDataAtualizacao()
        );
    }
}
