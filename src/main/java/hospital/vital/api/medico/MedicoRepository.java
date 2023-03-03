package hospital.vital.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Breno
 */

public interface MedicoRepository extends JpaRepository <Medico, Long> {
}
