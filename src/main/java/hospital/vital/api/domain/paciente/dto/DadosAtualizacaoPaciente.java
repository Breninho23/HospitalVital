package hospital.vital.api.domain.paciente.dto;

import hospital.vital.api.domain.endereco.dto.DadosEndereco;

/**
 * @author Breno
 */

public record DadosAtualizacaoPaciente(Long id, String nome, String telefone, DadosEndereco endereco) {
}
