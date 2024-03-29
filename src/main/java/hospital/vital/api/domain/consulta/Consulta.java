package hospital.vital.api.domain.consulta;

import hospital.vital.api.domain.medico.Medico;
import hospital.vital.api.domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Breno
 */

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

}
