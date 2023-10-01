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

    @Override 
    public String salvarProdutosEmArquivo() {
        return getNome()+
        		" (código: " + getCodigo() + " | estoque: " + getEstoque() + " | categoria: " + getCategoria() + " | cor:" + getCor()+ " | custo de compra:" + getCustoCompra() + " | valor de venda:" + getValorVenda() + " )";
    }
    
    @Override
    public String toStringProduto(){
        return getNome() +
        		" (código: " + getCodigo() + " | estoque: " + getEstoque() + " | categoria: " + getCategoria() + " | cor:" + getCor()+ " | custo de compra:" + getCustoCompra() + " | valor de venda:" + getValorVenda() + " )";
    }
    

}//class Mimos

