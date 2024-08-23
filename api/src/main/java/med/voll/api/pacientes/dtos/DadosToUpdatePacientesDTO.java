package med.voll.api.pacientes.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.dtos.DadosEnderecoDTO;

public record DadosToUpdatePacientesDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco) {
}
