import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Arquivo {

    private ArrayList<String> elementos;

    public Arquivo() { elementos = new ArrayList<>(); }

    public Arquivo(List<String> elementos) {
        this.elementos = new ArrayList<>(elementos);
    }

    public ArrayList<String> getElementos()
    {
        return new ArrayList<>(elementos);
    }

    public HashSet<String> getElementosDistintos() { return new HashSet<>(elementos); }

    public void adicionaElemento(String elemento) {
        elementos.add(elemento);
    }
}