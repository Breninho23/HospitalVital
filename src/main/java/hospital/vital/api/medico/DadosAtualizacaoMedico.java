package hospital.vital.api.medico;

import hospital.vital.api.endereco.DadosEndereco;

/**
 * @author Breno
 */

public record DadosAtualizacaoMedico(Long id, String nome, String telefone, DadosEndereco endereco) {
}
