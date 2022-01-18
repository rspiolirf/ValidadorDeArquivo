import java.util.HashSet;

public class ArquivoContemSomenteLinhasPresentesNoLayout implements RegraDeValidacao {
    @Override
    public ResultadoDaRegraDeValidacao processa(Arquivo arquivo, Layout layout) {
        HashSet<String> elementosDistintosDoArquivo = arquivo.getElementosDistintos();
        layout.getElementos().forEach(elementosDistintosDoArquivo::remove);

        boolean resultado = elementosDistintosDoArquivo.isEmpty();
        if (resultado) return new ResultadoDaRegraDeValidacao(true, null);

        return new ResultadoDaRegraDeValidacao(false, "Erro: Arquivo contém linha(s) " + elementosDistintosDoArquivo + " não presente(s) no layout");
    }
}
