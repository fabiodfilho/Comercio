package itens;


public class Produto {
	protected static int contador = 1;
	protected int codigo;

	protected String categoria;
	protected String nome;
	protected int estoque;
	protected double valorDeCompra;
    protected double valorDeVenda;

	public Produto() {
		codigo = contador;
	}

	//Construtor sem estoque
	public Produto(String categoria, String nome,double valorDeCompra, double valorDeVenda) {

		this.categoria = categoria;
		this.nome = nome;
		this.valorDeCompra = valorDeCompra;
		this.valorDeVenda = valorDeVenda;

		codigo = contador;
	}//Construtor sem estoque

    //Construtor com estoque
	public Produto(String categoria, String nome, int estoque, double valorDeCompra, double valorDeVenda) {

		this.categoria = categoria;
		this.nome = nome;
		this.estoque = estoque;
		this.valorDeCompra = valorDeCompra;
		this.valorDeVenda = valorDeVenda;

		codigo = contador;
	}//Construtor com estoque


	public String getCategoria() {
		return categoria;
	}

	
	public int getCodigo() {
		return codigo;
	}


	public int getEstoque() {
		return estoque;
	}


	public void addEstoque(int quantidade) {
		if (quantidade >= 0) {
			estoque += quantidade;

		} else {
			System.out.println("Não pode adicionar quantidade negativa!");
		}
	}



	public void remEstoque(int valor) {
		if (valor >= 0) {
			this.estoque -= valor;
		} else {
			System.out.println("Quantidade total negativa!");
		}
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorDeCompra() {
		return valorDeCompra;
	}


	public void setValorDeCompra(double valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}


	public double getValorDeVenda() {
		return valorDeVenda;
	}


	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	
	public String toStringSuper() {
		return nome +
				" (cod.: " +
				codigo +
				" | estoque: " +
				estoque +
				" | categoria: " +
				categoria +
				" | custo de compra: " +
				valorDeCompra +
				" | valor de venda: " +
				valorDeVenda +
				")";
	}//toString

	public String toStringArquivo() {
		return codigo + "," + categoria + "," + nome + "," + estoque + "," + valorDeCompra + "," + valorDeVenda;
	}
}//Class


