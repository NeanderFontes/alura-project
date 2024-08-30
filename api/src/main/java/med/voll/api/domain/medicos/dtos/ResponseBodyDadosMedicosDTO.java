package med.voll.api.domain.medicos.dtos;

import med.voll.api.domain.endereco.models.EnderecoModel;
import med.voll.api.domain.medicos.enums.EspecialidadeMedico;
import med.voll.api.domain.medicos.models.MedicoModel;

public record ResponseBodyDadosMedicosDTO(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        EspecialidadeMedico especialidadeMedico,
        EnderecoModel enderecoModel) {

    public ResponseBodyDadosMedicosDTO(MedicoModel medicoModel) {
        this(medicoModel.getId(),
                medicoModel.getNome(),
                medicoModel.getEmail(),
                medicoModel.getCrm(),
                medicoModel.getTelefone(),
                medicoModel.getEspecialidadeMedicos(),
                medicoModel.getEndereco());
    }
}
