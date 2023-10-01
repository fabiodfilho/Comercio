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
	
	public ArrayList<Produto> produtos = new ArrayList<Produto>();

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void ListAll() {
        if (produtos.isEmpty()) {
            System.out.println("\n- Nenhum produto registrado.\n");
        }

        for (Produto produto : produtos) {
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
    
    public void salvarProdutosEmArquivo() {
        try (PrintWriter writer = new PrintWriter("arquivo.txt")) {
            for (Produto produto : produtos) {
                writer.println(produto.saveFileString());
            }
            System.out.println("Produtos salvos em arquivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: arquivo.txt");
        }
    }

    public void carregarProdutosDeArquivo() {
        ArrayList<Produto> tempArray = new ArrayList<Produto>();
        File arquivo = new File("arquivo.txt");
        
        try {
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {
                String[] produtoArray = sc.nextLine().split(",");
                Produto produto = null;
                
                // Verificar a categoria e criar o objeto apropriado
                if (produtoArray[6].equalsIgnoreCase("Chest")) {
                    produto = new Comida(produtoArray[0], Integer.parseInt(produtoArray[1]), Integer.parseInt(produtoArray[2]), Integer.parseInt(produtoArray[3]), produtoArray[4]);
                } else if (produtoArray[6].equalsIgnoreCase("Legs")) {
                    produto = new Mimos(produtoArray[0], Integer.parseInt(produtoArray[1]), Integer.parseInt(produtoArray[2]), Integer.parseInt(produtoArray[3]), produtoArray[4]);
                }          
                if (produto != null) {
                    tempArray.add(produto);
                }
            }
            sc.close();
            
            produtos = tempArray;
            System.out.println("Produtos carregados do arquivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: arquivo.txt");
        }
    }
}
    

    
    
    
   

