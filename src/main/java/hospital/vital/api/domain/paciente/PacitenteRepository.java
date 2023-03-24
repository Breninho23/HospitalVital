package hospital.vital.api.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Breno
 */

public interface PacitenteRepository extends JpaRepository<Paciente, Long> {



    @Query("""
            select p.ativo
            from Paciente p 
            where
            p.id = :idPaciente
            """)
    Boolean findAtivoById(Long idPaciente);
}
