package med.voll.api.domain.pacientes.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.dtos.DadosEnderecoDTO;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPacientesDTO(
        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @CPF
        String cpf,

        @Valid
        @NotNull
        DadosEnderecoDTO endereco) {
}
