import java.util.HashSet;

public class ArquivoContemLinhasObrigatoriasDoLayout implements RegraDeValidacao {
    @Override
    public ResultadoDaRegraDeValidacao processa(Arquivo arquivo, Layout layout) {
        boolean resultado = arquivo.getElementosDistintos().containsAll(layout.getElementosObrigatorios());
        if (resultado) return new ResultadoDaRegraDeValidacao(true, null);

        HashSet<String> elementosObrigatorios = layout.getElementosObrigatorios();
        arquivo.getElementosDistintos().forEach(elementosObrigatorios::remove);
        return new ResultadoDaRegraDeValidacao(false, "Erro: Arquivo não contém todas as linhas obrigatórias "+ elementosObrigatorios + " do layout");
    }
}
