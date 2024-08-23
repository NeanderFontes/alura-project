package med.voll.api.pacientes.repositories;

import med.voll.api.pacientes.models.PacientesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacientesModel, Long> {
    Page<PacientesModel> findAllByAtivoTrue(Pageable pageableAll);
}
