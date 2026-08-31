package tech.esel.interface_adapters.gateways;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BcbDataResponseDTO(
        @JsonProperty("valor")
        Double valor,

        @JsonProperty("data")
        String dataCotacao
) {
}