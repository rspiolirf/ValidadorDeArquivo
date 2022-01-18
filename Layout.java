import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Layout {

    private ArrayList<LinhaLayout> elementos;
    private ArrayList<RegraDeValidacao> regrasDeValidacao;

    public Layout(ArrayList<LinhaLayout> elementos, ArrayList<RegraDeValidacao> regrasDeValidacao) {
        this.elementos = elementos;
        this.regrasDeValidacao = regrasDeValidacao;
    }

    public ArrayList<String> getElementos()
    {
        ArrayList<String> resultado = new ArrayList<>();
        elementos.forEach(elemento -> resultado.add(elemento.getValor()));
        return resultado;
    }

    public HashSet<String> getElementosObrigatorios() {
        HashSet<String> resultado = new HashSet<>();
        elementos.forEach(elemento -> {
            if (elemento.ehObrigatorio()) resultado.add(elemento.getValor());
        });
        return resultado;
    }

    public ArrayList<LinhaLayout> getLinhas() {
        return new ArrayList<>(elementos);
    }

    public ArrayList<RegraDeValidacao> getRegrasDeValidacao() { return new ArrayList<>(regrasDeValidacao); }
}