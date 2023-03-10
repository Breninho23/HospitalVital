package hospital.vital.api.domain.medico.dto;

import hospital.vital.api.domain.medico.Medico;
import hospital.vital.api.domain.medico.enums.Especialidade;

/**
 * @author Breno
 */

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico (Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
