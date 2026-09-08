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

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public BcbImpostoGateway bcbImpostoGateway(RestTemplate restTemplate) {
        return new BcbImpostoGatewayImpl(restTemplate);
    }

    @Bean
    public ConsultarImpostoBcbInputBoundary consultarImpostoBcbInputBoundary(BcbImpostoGateway gateway) {
        return new ConsultarImpostoBcbInteractor(gateway);
    }
}
