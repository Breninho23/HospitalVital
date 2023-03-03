package hospital.vital.api.medico;

import hospital.vital.api.endereco.DadosEndereco;
import hospital.vital.api.medico.Especialidade;

/**
 * @author Breno
 */
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
