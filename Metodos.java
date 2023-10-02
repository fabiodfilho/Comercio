package entrega;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Metodos {
	
	//Banco de valores loja:
	
	public double saldo = 35000;

    public void buyWithFloatingCapital(double valorCompra) {
    	saldo -= valorCompra;
    }
    public void sellWithFloatingCapital(double valorVenda) {
    	saldo += valorVenda;
    }
	
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    
    public void ListAll() {
    	ArrayList<Produto> produtos2 = carregarProdutosDeArquivo();
        if (produtos2.isEmpty()) {
            System.out.println("\n- Nenhum produto registrado.\n");
        }

        for (Produto produto : produtos2) {
            System.out.println(produto);
        }
    }
    
    public void listarProdutosPorCategoria(String categoria) {
        if (produtos.isEmpty()) {
            System.out.println("\n- Nenhum produto registrado.\n");
            return;
        }

        boolean encontrou = false;

        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(produto);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("\n- Nenhum produto encontrado na categoria '" + categoria + "'.\n");
        }
    }

    public void addProduto(Produto produto) {
    	produtos.add(produto);
    }
    
    public void addEstoque(int productEstoque, int productCodigo) {
    	Produto produto = localizarPorcod(productCodigo);
        if (produto != null) {
        	produto.addEstoquecod(productEstoque);
        } else {
            System.out.println("O código não existe!");
        }
    }
    
    public Produto localizarPorcod(int codigoProduto) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                return produto;
            }
        }
        return null;
    }
    
    public void deletarProduto(int codigoProduto) {
        Produto product = localizarPorcod(codigoProduto);
        if (product != null) {
            produtos.remove(product);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto com código " + codigoProduto + " não encontrado.");
        }
    }
    
    public void removeEstoque(int quantidadeEstoque, int codigoProduto) {
        Produto produto = localizarPorcod(codigoProduto);
        if (produto != null) {
            produto.removeEstoquecod(quantidadeEstoque);
            System.out.println("Estoque removido com sucesso.");
        } else {
            System.out.println("Produto com código " + codigoProduto + " não encontrado.");
        }
    }
    
    public void salvarProdutosEmArquivo(ArrayList<Produto> produtos) {
        try (PrintWriter writer = new PrintWriter("C:\\Users\\Fabio Filho\\Documents\\testejava\\arquivo.txt")) {
            for (Produto produto : produtos) {
                writer.println(produto.salvarProdutosEmArquivo());
            }
            System.out.println("Produtos salvos em arquivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: arquivo.txt");
        }
    }

    public ArrayList<Produto> carregarProdutosDeArquivo() {
        File arquivo = new File("C:\\Users\\Fabio Filho\\Documents\\testejava\\arquivo.txt");
        ArrayList<Produto> tempArray = new ArrayList<Produto>();

        try {
            Scanner sc = new Scanner(arquivo);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] produtoArray = linha.split(",");

                System.out.println("Linha lida: " + linha);

                if (produtoArray.length >= 7) {
                    Produto produto = null;

                    if (produtoArray[6].equalsIgnoreCase("Comida")) {
                        produto = new Comida(produtoArray[0], Integer.parseInt(produtoArray[1]), Integer.parseInt(produtoArray[2]), produtoArray[3], Integer.parseInt(produtoArray[4]), Integer.parseInt(produtoArray[5]), produtoArray[6]);
                    } else if (produtoArray[6].equalsIgnoreCase("Mimos")) {
                        produto = new Mimos(produtoArray[0], Integer.parseInt(produtoArray[1]), Integer.parseInt(produtoArray[2]), produtoArray[3], Integer.parseInt(produtoArray[4]), Integer.parseInt(produtoArray[5]), produtoArray[6]);
                    }

                    if (produto != null) {
                        tempArray.add(produto);
                        
                    }
                    
                }
            }
            sc.close();

            produtos.clear(); // Limpa a lista produtos atual
            produtos.addAll(tempArray); // Adiciona os produtos carregados à lista produtos
            System.out.println("Produtos carregados do arquivo.");
            return tempArray;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: arquivo.txt");
        }
		return tempArray;
		                   
    }
}
    
    
    
   

