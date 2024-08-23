package med.voll.api.pacientes.repositories;

import med.voll.api.pacientes.models.PacientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacientesModel, Long> {
}
