package itens;

import arquivos.metodosDados;
import java.util.ArrayList;

public class Comercio {

    public static ArrayList<Produto> todosOsProdutos = new ArrayList<>();
    public static ArrayList<String> compras = new ArrayList<>();
    public static ArrayList<String> vendas = new ArrayList<>();
    private static final ArrayList<String> tempCompras = new ArrayList<>(); 
    private static final ArrayList<String> tempVendas = new ArrayList<>(); 
    private static double saldo;

    public static ArrayList<Produto> getTodosOsProdutos() {
        return todosOsProdutos;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Comercio.saldo = saldo;
    }

    public static void listarTodos() {
        if (todosOsProdutos.size() == 0) {
            System.out.println("Nenhum produto cadastrado no sistema.");

        } else {
            for (Produto produto : todosOsProdutos) {
                System.out.println(produto.toStringSuper());
            }
        }
    }

    public static void listarPorCategoria(int opcao) {
        String categoria = definirCategoria(opcao);

       
        int quantidade = 0;
        for (Produto produto : todosOsProdutos) {
            if (produto.getCategoria().equals(categoria)) {
                quantidade++;
            }
        }
        
        if (quantidade == 0) {
            System.out.println("Não existe nenhum cadastro de " + categoria);
        } else {

            for (Produto produto : todosOsProdutos) {
                if (produto.getCategoria().equals(categoria) ) {
                    System.out.println(produto);
                }
            }
        }

    }
   
    public static void cadastrar(Produto produto) {
        todosOsProdutos.add(produto);
        saldo -= produto.estoque * produto.valorDeCompra;

        
        metodosDados.escreverArquivo(todosOsProdutos); 
        metodosDados.escreverCompras(compras);
    }

    public static void adicionar(int codigo, int quantidade) {
    	for (Produto produto : todosOsProdutos) {
            if (quantidade * produto.valorDeCompra > saldo) {
                System.out.println("\nSaldo insuficiente!");
            } else {
                if (codigo == produto.codigo) {
                    produto.addEstoque(quantidade);

                    saldo -= quantidade * produto.valorDeCompra;

                    metodosDados.escreverArquivo(todosOsProdutos);
                    metodosDados.escreverCompras(compras);

                    String tempString = produto.nome + "," + quantidade + "," + produto.valorDeCompra + "," + quantidade * produto.valorDeCompra;
                    tempCompras.add(tempString);
                    metodosDados.escreverSaldo(Comercio.getSaldo());
                }
            }
    	}
    }

    public static void remover(int codigo) {
        for (Produto produto : todosOsProdutos) {
            if (codigo == produto.codigo) {
                todosOsProdutos.remove(produto);
                metodosDados.escreverArquivo(todosOsProdutos);
                break;
            }
        }
    }

    public static void vender(int codigo, int quantidade) {
    	for (Produto produto : todosOsProdutos) {
            if (verificarCodigoNaLista(codigo) && produto.codigo == codigo) {
                produto.remEstoque(quantidade);

                saldo += quantidade * produto.valorDeVenda;

                String tempString = produto.nome + "," + quantidade + "," + produto.valorDeVenda + "," + quantidade * produto.valorDeVenda;
                vendas.add(tempString);
                tempVendas.add(tempString);

                metodosDados.escreverArquivo(todosOsProdutos);
                metodosDados.escreverVendas(vendas);
                metodosDados.escreverSaldo(Comercio.getSaldo());
            }
    	}
    }

    public static void relatorio(int opcao) {
    	
        double totalGasto = 0.0;
        double totalArrecadado = 0.0;

        switch (opcao) {
            case 1: 
            	//compras
                System.out.println("RELATÓRIO DE COMPRAS:\n");
                for (String a : metodosDados.obterCompras()) {
                    String[] tempArray = a.split(",");

                    System.out.printf("Nome: %s | Unidades: %s | Valor da unidade: %s | Unidade x Valor: %s\n", tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
                    totalGasto += Double.parseDouble(tempArray[3]);
                }
                System.out.println("\nValor total gasto: " + totalGasto + "\n");

                //vendas
                System.out.println("RELATÓRIO DE VENDAS:\n");
                for (String a : metodosDados.obterVendas()) {
                    String[] tempArray = a.split(",");

                    System.out.printf("Nome: %s | Unidades: %s | Valor da unidade: %s | Unidade x Valor: %s\n", tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
                    totalArrecadado += Double.parseDouble(tempArray[3]);
                }
                System.out.println("\nValor total arrecadado: " + totalArrecadado + "\n");

                break;
            case 2: 
                System.out.println("RELATÓRIO DE COMPRAS:\n");
                for (String a : tempCompras) {
                    String[] tempArray = a.split(",");

                    System.out.printf("Nome: %s | Unidades: %s | Valor da unidade: %s | Unidade x Valor: %s\n", tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
                    totalGasto += Double.parseDouble(tempArray[3]);
                }
                System.out.println("Valor total gasto: " + totalGasto + "\n");

                
                System.out.println("RELATÓRIO DE VENDAS:\n");
                for (String a : tempVendas) {
                    String[] tempArray = a.split(",");

                    System.out.printf("Nome: %s | Unidades: %s | Valor da unidade: %s | Unidade x Valor: %s\n", tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
                    totalArrecadado += Double.parseDouble(tempArray[3]);
                }
                System.out.println("\nValor total arrecadado: " + totalArrecadado + "\n");
                break;
            default:
        }
    }
    public static boolean verificarCodigoNaLista(int codigo) {
        for (Produto produto : todosOsProdutos) {
            if (codigo == produto.getCodigo() ) {
                return true;
            }
        }
            return false;
    }

    public static String definirCategoria(int opcao) {
        String categoria = "";
        switch (opcao) {

            case 2 -> categoria = "Comida";
            case 3 -> categoria = "Acessorios";

        }

        return categoria;
    }
    
    public static Produto getProduto(int codigo) {
        for (Produto produto : todosOsProdutos) {
            if (codigo == produto.getCodigo() ) {
                return produto;
            }
        }
        return null;
    }

    public static void addCompra(String nome, int quantidade, double valorDeCompra) {
        String tempString = nome + "," + quantidade + "," + valorDeCompra + "," + quantidade * valorDeCompra;

        compras.add(tempString);
    }

}
