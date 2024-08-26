package med.voll.api.domain.medicos.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.dtos.DadosEnderecoDTO;

public record DadosToUpdateMedicosDTO(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @JsonProperty("endereco")
        @JsonAlias({"enderecoDTO", "endereco DTO", "endereco", "endereco-DTO"})
        @Valid
        DadosEnderecoDTO enderecoDTO) {

//    public DadosToUpdateMedicosDTO(MedicoModel medicoModel) {
//        this.id = medicoModel.getId();
//        this.nome = medicoModel.getNome();
//        this.telefone = medicoModel.getTelefone();
//        this.enderecoDTO = medicoModel.getEndereco();
//    }
}
