package med.voll.api.medicos.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.dtos.DadosEnderecoDTO;
import med.voll.api.endereco.models.EnderecoModel;
import med.voll.api.medicos.models.MedicoModel;

public record DadosToUpdateMedicosDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO enderecoDTO) {

//    public DadosToUpdateMedicosDTO(MedicoModel medicoModel) {
//        this.id = medicoModel.getId();
//        this.nome = medicoModel.getNome();
//        this.telefone = medicoModel.getTelefone();
//        this.enderecoDTO = medicoModel.getEndereco();
//    }
}
