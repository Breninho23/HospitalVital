package hospital.vital.api.domain.medico.dto;

import hospital.vital.api.domain.endereco.dto.DadosEndereco;

/**
 * @author Breno
 */

public record DadosAtualizacaoMedico(Long id, String nome, String telefone, DadosEndereco endereco) {
}
