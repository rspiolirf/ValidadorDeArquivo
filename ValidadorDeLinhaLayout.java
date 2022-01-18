import java.util.ArrayList;

public class ValidadorDeLinhaLayout {

    private final Layout layout;
    private Arquivo arquivo;

    public ValidadorDeLinhaLayout(Layout layout) {
        this.layout = layout;
        this.arquivo = new Arquivo();
    }

    public ResultadoDaValidacaoLinhaLayout valida(Arquivo arquivo) {
        this.arquivo = arquivo;
        return valida();
    }

    public ResultadoDaValidacaoLinhaLayout valida() {
        ResultadoDaValidacaoLinhaLayout resultado = new ResultadoDaValidacaoLinhaLayout();
        processaTodasAsRegras().forEach(regra -> verificaSeHouveErro(resultado, regra));
        return resultado;
    }

    private ArrayList<ResultadoDaRegraDeValidacao> processaTodasAsRegras() {
        ArrayList<ResultadoDaRegraDeValidacao> resultadosDasValidacoesDasRegras = new ArrayList<>();
        layout.getRegrasDeValidacao().forEach(regraDeValicao -> resultadosDasValidacoesDasRegras.add(regraDeValicao.processa(arquivo, layout)));
        return resultadosDasValidacoesDasRegras;
    }

    private void verificaSeHouveErro(ResultadoDaValidacaoLinhaLayout resultado, ResultadoDaRegraDeValidacao regra) {
        if (!regra.EhValido()) {
            resultado.setStatusDaValidacao(false);
            resultado.adicionaMensagemDeErro(regra.getMensagemDeErro());
        }
    }

    public void adicionaElementoAoArquivo(String elemento) {
        arquivo.adicionaElemento(elemento);
    }

    public Arquivo getArquivo() { return arquivo; }
}