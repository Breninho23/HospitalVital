package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Breno
 */

@Component
public class ValidacaoHorarioAntecedencia implements ValidadorAgendamentoConsulta{

    public void validar (DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoExecepition("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }


    }
}
