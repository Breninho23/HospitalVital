package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import hospital.vital.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Breno
 */

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo){
            throw new ValidacaoExecepition("Consulta não pode ser agendada com médico inativo");
        }
    }
}
