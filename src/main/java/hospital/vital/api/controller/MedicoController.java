package hospital.vital.api.controller;

import hospital.vital.api.medico.DadosCadastroMedico;
import hospital.vital.api.medico.DadosListagemMedico;
import hospital.vital.api.medico.Medico;
import hospital.vital.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Breno
 */
@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}