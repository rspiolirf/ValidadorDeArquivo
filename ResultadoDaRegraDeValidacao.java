public class ResultadoDaRegraDeValidacao {
    private boolean ehValido;
    private String mensagemDeErro;

    public ResultadoDaRegraDeValidacao(boolean ehValido, String mensagemDeErro) {
        this.ehValido = ehValido;
        this.mensagemDeErro = mensagemDeErro;
    }

    public boolean EhValido() {
        return ehValido;
    }

    public String getMensagemDeErro() {
        return mensagemDeErro;
    }
}
