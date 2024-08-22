package med.voll.api.medicos.enums;

public enum Especialidade {
    ORTOPEDIA("Ortopedia"),
    CARDIOLOGIA("Cardiologia"),
    GINECOLOGIA("Ginecologia"),
    DERMATOLOGIA("Dermatologia");

    private final String nomeEspecialidade;

    Especialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
