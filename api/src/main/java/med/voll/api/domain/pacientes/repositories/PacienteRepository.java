package med.voll.api.domain.pacientes.repositories;

import med.voll.api.domain.pacientes.models.PacientesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacientesModel, Long> {
    Page<PacientesModel> findAllByAtivoTrue(Pageable pageableAll);
}
