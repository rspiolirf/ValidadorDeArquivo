import java.util.ArrayList;

public class ResultadoDaValidacaoLinhaLayout {
    private boolean ehValido = true;
    private ArrayList<String> mensagensDeErro = new ArrayList<>();

    public boolean ehValido() {
        return ehValido;
    }

    public void setStatusDaValidacao(boolean ehValido) {
        this.ehValido = ehValido;
    }

    public ArrayList<String> getMensagensDeErro() {
        return new ArrayList<String>(mensagensDeErro);
    }

    public void adicionaMensagemDeErro(String mensagemDeErro) {
        this.mensagensDeErro.add(mensagemDeErro);
    }
}