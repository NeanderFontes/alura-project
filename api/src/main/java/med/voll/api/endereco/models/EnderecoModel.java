package med.voll.api.endereco.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.dtos.DadosEnderecoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoModel {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public EnderecoModel(DadosEnderecoDTO dadosEnderecoDto) {
        this.logradouro = dadosEnderecoDto.logradouro();
        this.bairro = dadosEnderecoDto.bairro();
        this.cep = dadosEnderecoDto.cep();
        this.uf = dadosEnderecoDto.uf();
        this.cidade = dadosEnderecoDto.cidade();
        this.numero = dadosEnderecoDto.numero();
        this.complemento = dadosEnderecoDto.complemento();
    }

    public void updateInfoEndereco(DadosEnderecoDTO dadosEnderecoDTO) {
        if (dadosEnderecoDTO.logradouro() != null) {
            this.logradouro = dadosEnderecoDTO.logradouro();
        }

        if (dadosEnderecoDTO.bairro() != null) {
            this.bairro = dadosEnderecoDTO.bairro();
        }

        if (dadosEnderecoDTO.cep() != null) {
            this.cep = dadosEnderecoDTO.cep();
        }

        if (dadosEnderecoDTO.uf() != null) {
            this.uf = dadosEnderecoDTO.uf();
        }

        if (dadosEnderecoDTO.cidade() != null) {
            this.cidade = dadosEnderecoDTO.cidade();
        }

        if (dadosEnderecoDTO.numero() != null) {
            this.numero = dadosEnderecoDTO.numero();
        }

        if (dadosEnderecoDTO.complemento() != null) {
            this.complemento = dadosEnderecoDTO.complemento();
        }
    }
}
