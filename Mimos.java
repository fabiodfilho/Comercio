package entrega;

public class Mimos extends Produto {
    private String cor;

    public Mimos(String nome, int codigo, int custoCompra, int valorVenda, String cor) {
        super(nome, codigo, "Mimos", custoCompra, valorVenda);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}

