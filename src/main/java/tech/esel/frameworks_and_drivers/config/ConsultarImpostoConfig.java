package tech.esel.frameworks_and_drivers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tech.esel.interface_adapters.gateways.BcbImpostoGatewayImpl;
import tech.esel.usecases.consultar_imposto.BcbImpostoGateway;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbInputBoundary;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbInteractor;

@Configuration
public class ConsultarImpostoConfig {

    // 1. Ensina o Spring a instanciar o RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 2. Ensina o Spring a instanciar o seu Gateway, injetando o RestTemplate
    @Bean
    public BcbImpostoGateway bcbImpostoGateway(RestTemplate restTemplate) {
        return new BcbImpostoGatewayImpl(restTemplate);
    }

    // 3. Ensina o Spring a instanciar o Interactor, injetando o Gateway.
    // O retorno deste Bean é a interface (InputBoundary), que é o que o Controller pede.
    @Bean
    public ConsultarImpostoBcbInputBoundary consultarImpostoBcbInputBoundary(BcbImpostoGateway gateway) {
        return new ConsultarImpostoBcbInteractor(gateway);
    }
}
