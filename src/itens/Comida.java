package itens;

public class Comida extends Produto {
	private String sabor;
	private double peso;


	//Construtor sem estoque
	public Comida(String categoria, String marca, double custo, double valorDeVenda, String cambio, double motor) {
		super(categoria, marca, custo, valorDeVenda);
		this.sabor = cambio;
		this.peso = motor;
		contador++;
	}//Construtor sem estoque
	
	
	//Construtor com estoque
	public Comida(String categoria, String marca, int estoque , double custo, double valorDeVenda, String cambio, double motor) {
		super(categoria, marca,estoque, custo, valorDeVenda);
		this.sabor = cambio;
		this.peso = motor;
		contador++;
	}//Construtor com estoque
	
	
	
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String cambio) {
		this.sabor = cambio;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double motor) {
		this.peso = motor;
	}


	@Override
	public String toString() {
		return nome +
				" (cod.: " +
				codigo +
				" | estoque: " +
				estoque +
				" | atributos: " +
				sabor + " " + peso +
				" | custo de compra: " +
				valorDeCompra +
				" | valor de venda: " +
				valorDeVenda +
				")";
	}//toString

	@Override
	public String toStringArquivo() {
		return super.toStringArquivo() + "," + sabor + "," + peso;
	}
}

