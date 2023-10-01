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
    
    @Override 
    public String salvarProdutosEmArquivo() {
        return getNome()+
        		" (código: " + getCodigo() + " | estoque: " + getEstoque() + " | categoria: " + getCategoria() + " | sabor:" + getSabor()+ " | custo de compra:" + getCustoCompra() + " | valor de venda:" + getValorVenda() + " )";
    }
    
    @Override
    public String toStringProduto(){
        return getNome() +
        		" (código: " + getCodigo() + " | estoque: " + getEstoque() + " | categoria: " + getCategoria() + " | sabor:" + getSabor()+ " | custo de compra:" + getCustoCompra() + " | valor de venda:" + getValorVenda() + " )";
    }
    
}//class comida

