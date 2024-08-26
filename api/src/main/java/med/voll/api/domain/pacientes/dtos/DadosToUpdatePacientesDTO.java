package med.voll.api.domain.pacientes.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.dtos.DadosEnderecoDTO;

public record DadosToUpdatePacientesDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco) {
}
