package hospital.vital.api.domain.consulta.dto;

import java.time.LocalDateTime;

/**
 * @author Breno
 */

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
