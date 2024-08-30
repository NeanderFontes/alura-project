package med.voll.api.domain.medicos.repositories;

import med.voll.api.domain.medicos.models.MedicoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
    Page<MedicoModel> findAllByAtivoTrue(Pageable pageable);
}
