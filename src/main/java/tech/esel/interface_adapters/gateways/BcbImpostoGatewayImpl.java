package tech.esel.interface_adapters.gateways;

import org.springframework.web.client.RestTemplate;
import tech.esel.entities.Imposto;
import tech.esel.usecases.consultar_imposto.BcbImpostoGateway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BcbImpostoGatewayImpl implements BcbImpostoGateway {
    private final RestTemplate restTemplate;

    public BcbImpostoGatewayImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Imposto consultarImposto(String sigla, LocalDate data) {
        String url = "https://api.bcb.gov.br/dados/serie/bcdata.sgs." + sigla + "/dados/ultimos/1?formato=json";

        BcbDataResponseDTO[] bcbResponseArray = restTemplate.getForObject(url, BcbDataResponseDTO[].class);

        if (bcbResponseArray == null || bcbResponseArray.length == 0) {
            throw new RuntimeException("Dados não encontrados no BCB");
        }

        BcbDataResponseDTO bcbDataResponseDTO = bcbResponseArray[0];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(bcbDataResponseDTO.dataCotacao(), formatter);

        return new Imposto(sigla, bcbDataResponseDTO.valor(), dataFormatada);
    }
}
