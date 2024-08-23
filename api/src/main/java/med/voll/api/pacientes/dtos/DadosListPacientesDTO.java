package med.voll.api.pacientes.dtos;

import med.voll.api.pacientes.models.PacientesModel;

public record DadosListPacientesDTO(
        String nome,
        String email,
        String cpf) {

    public DadosListPacientesDTO(PacientesModel pacientesModel) {
        this(pacientesModel.getNome(), pacientesModel.getEmail(), pacientesModel.getCpf());
    }
}
