public class LinhasDoArquivoEstaoOrdenadasConformeLayout implements RegraDeValidacao {
    private static final int ULTIMA_LINHA_DO_LAYOUT = -1;

    @Override
    public ResultadoDaRegraDeValidacao processa(Arquivo arquivo, Layout layout) {
        for (LinhaLayout linhaDoLayout : layout.getLinhas()) {
            if (linhaDoLayout.ehObrigatorio()) {
                String valorNoLayout = linhaDoLayout.getValor();
                int ordemNoLayout = linhaDoLayout.getOrdem();
                ordemNoLayout = defineIndiceDoRodapeComoUltimaLinhaDoArquivo(ordemNoLayout, arquivo);
                try {
                    String valorNoArquivo = arquivo.getElementos().get(ordemNoLayout);
                    if (valorNoLayout != valorNoArquivo) {
                        return new ResultadoDaRegraDeValidacao(false, "Erro: As linhas do arquivo não estão ordenadas conforme o layout");
                    }
                } catch (IndexOutOfBoundsException e) {
                    return new ResultadoDaRegraDeValidacao(false, "Erro: As linhas do arquivo não estão ordenadas conforme o layout");
                }
            }
        }

        return new ResultadoDaRegraDeValidacao(true, null);
    }

    private int defineIndiceDoRodapeComoUltimaLinhaDoArquivo(int ordemNoLayout, Arquivo arquivo) {
        return (ordemNoLayout == ULTIMA_LINHA_DO_LAYOUT) ? arquivo.getElementos().size() - 1 : ordemNoLayout;
    }
}
