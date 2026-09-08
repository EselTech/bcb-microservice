package tech.esel.interface_adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbInputBoundary;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbRequestModel;
import tech.esel.usecases.consultar_imposto.ConsultarImpostoBcbResponseModel;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/bcb/impostos")
public class ConsultarImpostoBcbController {

    private final ConsultarImpostoBcbInputBoundary inputBoundary;

    // A injeção de dependência via construtor (Inversion of Control)
    public ConsultarImpostoBcbController(ConsultarImpostoBcbInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @GetMapping("/{sigla}")
    public ResponseEntity<ConsultarImpostoBcbResponseModel> consultar(
            @PathVariable String sigla,
            @RequestParam(required = false) String data) {

        LocalDate dataConsulta = (data != null) ? LocalDate.parse(data) : LocalDate.now();

        var request = new ConsultarImpostoBcbRequestModel(sigla, dataConsulta);

        var response = inputBoundary.executar(request);

        return ResponseEntity.ok(response);
    }
}
