package hospital.vital.api.controller;

import hospital.vital.api.domain.paciente.dto.DadosCadastroPaciente;
import hospital.vital.api.domain.paciente.Paciente;
import hospital.vital.api.domain.paciente.PacitenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Breno
 */
@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacitenteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}

