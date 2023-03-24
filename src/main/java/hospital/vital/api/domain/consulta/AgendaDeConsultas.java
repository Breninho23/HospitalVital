package hospital.vital.api.domain.consulta;

import hospital.vital.api.domain.ValidacaoExecepition;
import hospital.vital.api.domain.consulta.dto.DadosAgendamentoConsulta;
import hospital.vital.api.domain.medico.Medico;
import hospital.vital.api.domain.medico.MedicoRepository;
import hospital.vital.api.domain.paciente.PacitenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void agendar(DadosAgendamentoConsulta dados){
        if(!pacitenteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoExecepition("Id do paciente informado não existe");
        }
        //Id do médico é opicional
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoExecepition("Id do médico informado não existe");
        }

        //validacoes

        var paciente = pacitenteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
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
