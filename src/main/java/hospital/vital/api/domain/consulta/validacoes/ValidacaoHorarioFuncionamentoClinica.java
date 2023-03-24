package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

/**
 * @author Breno
 */
public class ValidacaoHorarioFuncionamentoClinica {

    public void validar (DadosAgendamentoConsulta dadosAgendamentoConsulta){

        var dataConsulta = dadosAgendamentoConsulta.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramento = dataConsulta.getHour() > 18;
        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramento){
            throw new ValidacaoExecepition("Consulta for do horario de funcionamento da clinica");
        }
    }
}
