package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import hospital.vital.api.domain.paciente.PacitenteRepository;

/**
 * @author Breno
 */
public class ValidadorPacienteAtivo {

    private PacitenteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidacaoExecepition("Consulta não pode ser agendada com paciente inativo");
        }
    }
}
