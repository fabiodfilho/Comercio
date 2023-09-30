package entrega;

public class Comida extends Produto {
    private String sabor;

    public Comida(String nome, int codigo, int custoCompra, int valorVenda, String sabor) {
        super(nome, codigo, "Comida", custoCompra, valorVenda);
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}

