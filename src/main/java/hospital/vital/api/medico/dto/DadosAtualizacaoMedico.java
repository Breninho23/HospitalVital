package hospital.vital.api.medico.dto;

import hospital.vital.api.endereco.dto.DadosEndereco;

/**
 * @author Breno
 */

public record DadosAtualizacaoMedico(Long id, String nome, String telefone, DadosEndereco endereco) {
}
