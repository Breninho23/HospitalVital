package hospital.vital.api.domain.consulta;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import hospital.vital.api.domain.consulta.dto.DadosDetalhamentoConsulta;
import hospital.vital.api.domain.consulta.validacoes.ValidadorAgendamentoConsulta;
import hospital.vital.api.domain.medico.Medico;
import hospital.vital.api.domain.medico.MedicoRepository;
import hospital.vital.api.domain.paciente.PacitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Breno
 */
@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacitenteRepository pacitenteRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
        if(!pacitenteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoExecepition("Id do paciente informado não existe");
        }
        //Id do médico é opicional
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoExecepition("Id do médico informado não existe");
        }

        //Principios de SOLID estamos aplicando S, O e D
        //Single Responsability Principle
        //Open-Closed Principle
        //Dependency Inversion Principle
        validadores.forEach(v -> v.validar(dados));

        var paciente = pacitenteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        if(medico == null){
            throw new ValidacaoExecepition("Não existe médico disponível nessa data");
        }

        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados){
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if(dados.especialidade() == null){
            throw new ValidacaoExecepition("Especialidade é obrigatório quando médico não for escolhido!");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}
