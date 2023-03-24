package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

/**
 * @author Breno
 */

@Component
public class ValidacaoHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {

    public void validar (DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramento = dataConsulta.getHour() > 18;
        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramento){
            throw new ValidacaoExecepition("Consulta for do horario de funcionamento da clinica");
        }
    }
}
