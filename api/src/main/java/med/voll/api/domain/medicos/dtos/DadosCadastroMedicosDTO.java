package med.voll.api.domain.medicos.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.dtos.DadosEnderecoDTO;
import med.voll.api.domain.medicos.enums.EspecialidadeMedico;

public record DadosCadastroMedicosDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "Tamanho entre 4 e 6")
        String crm,
        @NotNull
        @JsonProperty("especialidadeMedicos")
        @JsonAlias({"especialidade_medicos", "especialidade-medicos", "especialidadeMedicos", "especialidade medicos"})
        @Column(name = "especialidade_medicos")
        EspecialidadeMedico especialidadeMedicos,
        @NotNull
        @Valid
        DadosEnderecoDTO endereco) {
}
