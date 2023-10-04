package main;
import itens.Comercio;

public class visual {
	public static void imprimirMenu() {
        System.out.println("Menu:");
        System.out.println("1) Listar todos os produtos");
        System.out.println("2) Cadastrar um novo produto");
        System.out.println("3) Adicionar estoque de um produto");
        System.out.println("4) Remover um produto do comércio");
        System.out.println("5) Vender algum produto existente");
        System.out.println("6) Relatório de compra e vendas");
        System.out.println("7) Sair do programa");
    }
	
	public static void voltarMenu() {
		
		System.out.println("\nVoltando ao menu...");
			
	}
	
	public static void MenuListar() {
        System.out.println("- Deseja listar:");
        System.out.println("(1)-Todos  (2)-Comida  (3)-Acessorios");
		
	}
	
	public static void valorSaldo() {
		
		System.out.println("Saldo atual: "+ Comercio.getSaldo());
	}
	
	public static void listarMain() {
		
        System.out.println("Lista de produtos atualizada: " + "\n");
        Comercio.listarTodos();
        System.out.println("");
		
	}
}//classe

