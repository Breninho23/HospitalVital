package hospital.vital.api.domain.paciente.dto;

import hospital.vital.api.domain.medico.Medico;
import hospital.vital.api.domain.medico.enums.Especialidade;
import hospital.vital.api.domain.paciente.Paciente;

/**
 * @author Breno
 */

public record DadosListagemPaciente(Long id, String nome, String email, String cpf) {

    public DadosListagemPaciente (Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
