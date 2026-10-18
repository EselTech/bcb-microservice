package tech.esel.frameworks_and_drivers.config;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitBcbConfig {
    @Bean Queue bcbRequestQueue(@Value("${bcb.rabbit.queue:bcb.impostos.consultar}") String name) { return new Queue(name, true); }
}
