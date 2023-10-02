package entrega;

public class Produto {
    private String nome;
    private int codigo;
    private int estoque;
    private String categoria;
    private int custoCompra;
    private int valorVenda;

    public Produto(String nome, int codigo, String categoria, int custoCompra, int valorVenda) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = 0;
        this.categoria = categoria;
        this.custoCompra = custoCompra;
        this.valorVenda = valorVenda;
    }

    public Produto(String nome, int codigo, int estoque, String categoria, int custoCompra, int valorVenda) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = estoque;
        this.categoria = categoria;
        this.custoCompra = custoCompra;
        this.valorVenda = valorVenda;
    }
    
    // Métodos getters e setters
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCustoCompra() {
		return custoCompra;
	}

	public void setCustoCompra(int custoCompra) {
		this.custoCompra = custoCompra;
	}

	public int getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(int valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	public void addEstoquecod(int quantEstoque) {
		this.estoque += quantEstoque;	
	}
	public void removeEstoquecod(int quantEstoque) {
		this.estoque -= quantEstoque;
	}
       
	public String saveFileString() {
		return codigo+","+nome+","+estoque;
	}
	public String toString(){
		return nome +
				" (código: " + codigo + " | estoque: " + estoque + " | categoria: " + categoria + " | custo de compra:" + custoCompra + " | valor de venda:" + valorVenda + " )";
	}
	
	public String salvarProdutosEmArquivo() {
	    return getNome() +
	            " (código: " + getCodigo() + " | estoque: " + getEstoque() + " | categoria: " + getCategoria() + " | custo de compra: " + getCustoCompra() + " | valor de venda: " + getValorVenda() + ")";
	}

	
	public String toStringProduto(){
        return nome +
        		" (código: " + codigo + " | estoque: " + estoque + " | categoria: " + categoria + " | custo de compra:" + custoCompra + " | valor de venda:" + valorVenda + " )";
    }
}//class produto 