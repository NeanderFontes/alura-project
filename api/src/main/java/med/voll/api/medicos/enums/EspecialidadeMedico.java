package med.voll.api.medicos.enums;

public enum EspecialidadeMedico {
    ORTOPEDIA("Ortopedia"),
    CARDIOLOGIA("Cardiologia"),
    GINECOLOGIA("Ginecologia"),
    DERMATOLOGIA("Dermatologia");

    private final String nomeEspecialidade;

    EspecialidadeMedico(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
