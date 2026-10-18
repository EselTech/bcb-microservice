package tech.esel.interface_adapters.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbInputBoundary;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbRequestModel;
import java.time.LocalDate;
@Component
public class BcbRabbitListener {
    private static final Logger log = LoggerFactory.getLogger(BcbRabbitListener.class);
    private final ConsultarImpostoBcbInputBoundary inputBoundary;
    public BcbRabbitListener(ConsultarImpostoBcbInputBoundary inputBoundary) { this.inputBoundary = inputBoundary; }
    @RabbitListener(queues = "${bcb.rabbit.queue:bcb.impostos.consultar}")
    public String consultar(String codigoSgs) {
        try {
            var resultado = inputBoundary.executar(new ConsultarImpostoBcbRequestModel(codigoSgs, LocalDate.now()));
            return "OK|" + resultado.valorTaxa() + "|" + resultado.dataAtualizacao();
        } catch (Exception ex) {
            log.error("Falha ao consultar série SGS {}", codigoSgs, ex);
            return "ERROR";
        }
    }
}
