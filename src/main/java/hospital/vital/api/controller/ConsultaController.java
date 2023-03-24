package hospital.vital.api.controller;

import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import hospital.vital.api.domain.consulta.dto.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Breno
 */
@RestController
@RequestMapping("consultas")
public class ConsultaController {


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null,null));
    }
}

