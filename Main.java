package entrega;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		Metodos operacao = new Metodos();
		System.out.println("Iniciando sistema...");
		operacao.carregarProdutosDeArquivo();
		System.out.println("");
		visual.imprimirMenu();	
		
		int opcao = 0;
		
		while (opcao != 6) {	
				visual.imprimirMenu();
				opcao = Integer.parseInt(sc.nextLine());	
		
		switch (opcao) {
		case 1: 
			
			System.out.println("(1) Listar tudo (2) Listar por categoria");
			opcao = Integer.parseInt(sc.nextLine());
		
			if (opcao == 1) {
        	
        	operacao.ListAll();
        	
				} else if (opcao == 2) {
        	
					System.out.println("(1) Comidas (2) Mimos");
					int categoryOption = Integer.parseInt(sc.nextLine());
					switch (categoryOption){
					case 1 -> operacao.listarProdutosPorCategoria("Comida");
					case 2 -> operacao.listarProdutosPorCategoria("Mimos");    
            }
        } break; //case 1
        	
     // ...
		case 2:
		    System.out.println("Digite o código do produto:");
		    int codprod = Integer.parseInt(sc.nextLine());

		    if (operacao.localizarPorcod(codprod) != null) {
		        System.out.println("Product code already in use");
		        break;
		    }

		    System.out.println("Digite o nome do produto:");
		    String nomeProduto = sc.nextLine();

		    System.out.println("Digite o custo de compra do produto:");
		    int compraProduto = Integer.parseInt(sc.nextLine());

		    System.out.println("Digite o valor de venda do produto:");
		    int vendaProduto = Integer.parseInt(sc.nextLine());

		    System.out.println("Digite a categoria do produto:");
		    System.out.println("1) Comida, 2) Mimos");
		    String categoriaProduto = sc.nextLine();

		    Produto novoProduto = null;

		    switch (categoriaProduto) {
		        case "1":
		            categoriaProduto = "Comida";
		            System.out.println("Digite o sabor do produto:");
		            String novoSabor = sc.nextLine();
		            String categoriaDProduto = "Comida";

		            novoProduto = new Comida(nomeProduto, codprod, 0, categoriaDProduto, compraProduto, vendaProduto, novoSabor);
		            break;
		        case "2":
		            categoriaProduto = "Mimos";
		            System.out.println("Digite a cor do produto:");
		            String novaCor = sc.nextLine();
		            String categoriaD2Produto = "Mimos";
		            
		            novoProduto = new Mimos(nomeProduto, codprod, 0, categoriaD2Produto, compraProduto, vendaProduto, novaCor);
		            break;
		    }

		    if (novoProduto != null) {
		        operacao.addProduto(novoProduto);

		        System.out.println("Deseja adicionar estoque? (1) Sim (2) Não");
		        int opcaoAddEstoque = Integer.parseInt(sc.nextLine());

		        if (opcaoAddEstoque == 1) {
		            System.out.println("Digite a quantidade de estoque:");
		            int estoqueN = Integer.parseInt(sc.nextLine());
		            if (estoqueN < 0) {
		                System.out.println("estoque negativo!");
		            } else {
		                novoProduto.setEstoque(estoqueN);
		                operacao.salvarProdutosEmArquivo(operacao.getProdutos());
		                System.out.println(novoProduto.getNome() + " Adicionado com sucesso!.");
		                System.out.println(" code: " + novoProduto.getCodigo() + ", " + "stock: " + novoProduto.getEstoque() + "\n");
		            }
		        } else {
		            System.out.print(novoProduto.getNome() + " added successfully.");
		            System.out.println(" code: " + novoProduto.getCodigo() + ", " + "stock: " + novoProduto.getEstoque() + "\n");
		        }
		    } else {
		        System.out.println("Product code already in use");
		    }
		    break;


                    

			}//switch
		}//while
	}//main void
}//Main classe
