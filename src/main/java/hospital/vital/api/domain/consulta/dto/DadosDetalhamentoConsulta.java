package hospital.vital.api.domain.consulta.dto;

import hospital.vital.api.domain.consulta.Consulta;

import java.time.LocalDateTime;

/**
 * @author Breno
 */

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(),consulta.getPaciente().getId(),consulta.getData());
    }
}
