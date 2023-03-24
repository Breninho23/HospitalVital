package hospital.vital.api.domain.paciente.dto;

import hospital.vital.api.domain.endereco.Endereco;
import hospital.vital.api.domain.medico.Medico;
import hospital.vital.api.domain.medico.enums.Especialidade;
import hospital.vital.api.domain.paciente.Paciente;

/**
 * @author Breno
 */

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
