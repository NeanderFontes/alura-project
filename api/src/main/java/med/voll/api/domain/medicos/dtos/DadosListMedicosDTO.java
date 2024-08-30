package med.voll.api.domain.medicos.dtos;

import med.voll.api.domain.medicos.enums.EspecialidadeMedico;
import med.voll.api.domain.medicos.models.MedicoModel;

public record DadosListMedicosDTO(
        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeMedico especialidadeMedicos) {

    public DadosListMedicosDTO(MedicoModel medicoModel) {
        this(medicoModel.getId(), medicoModel.getNome(), medicoModel.getEmail(), medicoModel.getCrm(), medicoModel.getEspecialidadeMedicos());
    }
}
