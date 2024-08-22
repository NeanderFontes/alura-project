package med.voll.api.medicos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.models.EnderecoModel;
import med.voll.api.medicos.dtos.DadosCadastroMedicosDTO;
import med.voll.api.medicos.dtos.DadosToUpdateMedicosDTO;
import med.voll.api.medicos.enums.EspecialidadeMedico;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadeMedico especialidadeMedicos;

    @Embedded
    private EnderecoModel endereco;

    private Boolean ativo;

    public MedicoModel(DadosCadastroMedicosDTO dadosMedicosDto) {
        this.ativo = true;
        this.nome = dadosMedicosDto.nome();
        this.email = dadosMedicosDto.email();
        this.telefone = dadosMedicosDto.telefone();
        this.crm = dadosMedicosDto.crm();
        this.especialidadeMedicos = dadosMedicosDto.especialidadeMedicos();
        this.endereco = new EnderecoModel(dadosMedicosDto.endereco());
    }

    public void updateDadosMedicos(DadosToUpdateMedicosDTO dadosUpdateMedicos) {
        if (dadosUpdateMedicos.nome() != null) {
            this.nome = dadosUpdateMedicos.nome();
        }
        if (dadosUpdateMedicos.telefone() != null) {
            this.telefone = dadosUpdateMedicos.telefone();
        }
        if (dadosUpdateMedicos.enderecoDTO() != null) {
            this.endereco.updateInfoEndereco(dadosUpdateMedicos.enderecoDTO());
        }
    }

    public void exclusaoLogica() {
        this.ativo = false;
    }
}
