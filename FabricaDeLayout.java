import java.util.ArrayList;
import java.util.Arrays;

public class FabricaDeLayout {

    public static Layout cria(VersaoDoLayout versaoDoLayout) {

        if (versaoDoLayout == VersaoDoLayout.Um) {
            ArrayList<LinhaLayout> elementos = new ArrayList<>(Arrays.asList(
                    new LinhaLayout("10", true, 0),
                    new LinhaLayout("11", true, 1),
                    new LinhaLayout("90", true, -1)));

            ArrayList<RegraDeValidacao> regrasDeValidacao = new ArrayList<>(Arrays.asList(
                    new ArquivoContemLinhasObrigatoriasDoLayout(),
                    new ArquivoContemSomenteLinhasPresentesNoLayout(),
                    new LinhasDoArquivoEstaoOrdenadasConformeLayout()
            ));
            return new Layout(elementos, regrasDeValidacao);
        }

        if (versaoDoLayout == VersaoDoLayout.Dois) {
            ArrayList<LinhaLayout> elementos = new ArrayList<>(Arrays.asList(
                    new LinhaLayout("10", true, 0),
                    new LinhaLayout("11", true, 1),
                    new LinhaLayout("65", true, 2),
                    new LinhaLayout("66", true, 3),
                    new LinhaLayout("90", true, -1)));

            ArrayList<RegraDeValidacao> regrasDeValidacao = new ArrayList<>(Arrays.asList(
                    new ArquivoContemLinhasObrigatoriasDoLayout(),
                    new ArquivoContemSomenteLinhasPresentesNoLayout()
            ));
            return new Layout(elementos, regrasDeValidacao);
        }

        if (versaoDoLayout == VersaoDoLayout.Tres) {
            ArrayList<LinhaLayout> elementos = new ArrayList<>(Arrays.asList(
                    new LinhaLayout("10", true, 0),
                    new LinhaLayout("11", true, 1),
                    new LinhaLayout("65", false, 2),
                    new LinhaLayout("66", false, 3),
                    new LinhaLayout("90", true, -1)));

            ArrayList<RegraDeValidacao> regrasDeValidacao = new ArrayList<>(Arrays.asList(
                    new ArquivoContemLinhasObrigatoriasDoLayout(),
                    new ArquivoContemSomenteLinhasPresentesNoLayout(),
                    new LinhasDoArquivoEstaoOrdenadasConformeLayout()
            ));
            return new Layout(elementos, regrasDeValidacao);
        }

        // layout padrao
        ArrayList<LinhaLayout> elementos = new ArrayList<>(Arrays.asList(
                new LinhaLayout("10", true, 0),
                new LinhaLayout("11", true, 1),
                new LinhaLayout("90", true, -1)));

        ArrayList<RegraDeValidacao> regrasDeValidacao = new ArrayList<>(Arrays.asList(
                new ArquivoContemLinhasObrigatoriasDoLayout(),
                new ArquivoContemSomenteLinhasPresentesNoLayout(),
                new LinhasDoArquivoEstaoOrdenadasConformeLayout()
        ));
        return new Layout(elementos, regrasDeValidacao);
    }
}
