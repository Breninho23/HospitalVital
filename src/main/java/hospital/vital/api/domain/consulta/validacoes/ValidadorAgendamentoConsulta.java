package hospital.vital.api.domain.consulta.validacoes;

import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;

/**
 * @author Breno
 */
 
public interface ValidadorAgendamentoConsulta {

    void validar (DadosAgendamentoConsulta dados);
}
