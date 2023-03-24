package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import hospital.vital.api.domain.paciente.PacitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Breno
 */

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta {


    @Autowired
    private PacitenteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidacaoExecepition("Consulta não pode ser agendada com paciente inativo");
        }
    }
}
