public class LinhaLayout {
    private String valor;
    private boolean obrigatorio;
    private int ordem;

    public LinhaLayout(String valor, boolean obrigatorio, int ordem) {
        this.valor = valor;
        this.obrigatorio = obrigatorio;
        this.ordem = ordem;
    }

    public String getValor() {
        return valor;
    }

    public boolean ehObrigatorio() {
        return obrigatorio;
    }

    public int getOrdem() {
        return ordem;
    }
}
