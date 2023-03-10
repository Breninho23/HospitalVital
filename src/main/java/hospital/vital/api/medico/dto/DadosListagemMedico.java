package hospital.vital.api.medico.dto;

import hospital.vital.api.medico.enums.Especialidade;
import hospital.vital.api.medico.Medico;

/**
 * @author Breno
 */

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico (Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
