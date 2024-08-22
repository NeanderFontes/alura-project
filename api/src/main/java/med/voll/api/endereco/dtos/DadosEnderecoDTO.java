package med.voll.api.endereco.dtos;

public record DadosEndereco(
        String logradouro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
}
