package hospital.vital.api.medico.dto;

import hospital.vital.api.endereco.Endereco;
import hospital.vital.api.medico.enums.Especialidade;
import hospital.vital.api.medico.Medico;

/**
 * @author Breno
 */

public record DadosDetalhamentoMedico(Long id, String nome, String email, String telefone, String crm, Boolean ativo, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
       this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone() , medico.getCrm(), medico.getAtivo(), medico.getEspecialidade(), medico.getEndereco());
    }


}
