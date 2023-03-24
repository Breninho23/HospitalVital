package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.ConsultaRepository;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Breno
 */

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var mesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(mesmoHorario){
            throw new ValidacaoExecepition("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
