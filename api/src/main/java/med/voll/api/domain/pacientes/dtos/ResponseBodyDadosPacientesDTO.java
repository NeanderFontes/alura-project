package med.voll.api.domain.pacientes.dtos;

import med.voll.api.domain.endereco.models.EnderecoModel;
import med.voll.api.domain.pacientes.models.PacientesModel;

public record ResponseBodyDadosPacientesDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoModel enderecoModel) {
    public ResponseBodyDadosPacientesDTO(PacientesModel entityPaciente) {
        this(entityPaciente.getId(),
                entityPaciente.getNome(),
                entityPaciente.getEmail(),
                entityPaciente.getTelefone(),
                entityPaciente.getCpf(),
                entityPaciente.getEndereco());
    }
}
