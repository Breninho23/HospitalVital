package hospital.vital.api.domain.consulta.dto;

import hospital.vital.api.domain.medico.enums.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author Breno
 */

public record DadosAgendamentoConsulta(Long idMedico,
                                       @NotNull
                                       Long idPaciente,
                                       @NotNull
                                       @Future
                                       LocalDateTime data,

                                       Especialidade especialidade) {
}
