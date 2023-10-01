package entrega;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		Metodos operacao = new Metodos();
		operacao.carregarProdutosDeArquivo();
		
		int option = 0;
		System.out.println();
		

		
		
		
		
		
		
		
	}//main void
	public static void salvaArray(ArrayList<Produto> lista) {
		try {
			PrintWriter writer = new PrintWriter("arquivo.txt");
			for (Produto a : lista) {
				writer.write(a.getNome() + "," + a.getCodigo() + "," + a.getCategoria()+"\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}
	}
	
	public static ArrayList<Produto> carregaArray() {
		ArrayList<Produto> tempArray = new ArrayList<Produto>();
		
		File arquivo = new File("arquivo.txt");
		try {
			Scanner sc = new Scanner(arquivo);
			while (sc.hasNextLine()) {
				String[] ProdutoArray = sc.nextLine().split(",");
				Produto novoProduto = new Produto(ProdutoArray[0], 
						Integer.parseInt(ProdutoArray[1]), Integer.parseInt(ProdutoArray[2]), ProdutoArray[3], 
						Integer.parseInt(ProdutoArray[4]), Integer.parseInt(ProdutoArray[5]));
				tempArray.add(novoProduto);
			}
			sc.close();
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("Arquivo não encontrado");
		}
		
		return tempArray;
	}

}//Main classe
