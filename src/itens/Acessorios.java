package itens;

public class Acessorios extends Produto {
	private String cor;
	
	
	//Construtor sem estoque
	public Acessorios(String categoria, String marca, double custo, double valorDeVenda, String cor) {

		super(categoria, marca, custo, valorDeVenda);
		this.cor = cor;
		contador++;
	}//Construtor sem estoque

	
	//Construtor com estoque
	public Acessorios(String categoria, String marca, int estoque, double custo, double valorDeVenda, String cor) {

		super(categoria, marca, estoque, custo, valorDeVenda);
		this.cor = cor;
		contador++;
	}//Construtor com estoque
	
	
	public String getCor() {
		return cor;
	}

	public void setCor(String tipo) {
		this.cor = tipo;
	}

	@Override
	public String toString() {
		return nome +
				" (cod.: " +
				codigo +
				" | estoque: " +
				estoque +
				" | atributos: " +
				cor +
				" | custo de compra: " +
				valorDeCompra +
				" | valor de venda: " +
				valorDeVenda +
				")";
	}//toString

	@Override
	public String toStringArquivo() {
		return super.toStringArquivo() + "," + cor;
	}
}//Class
