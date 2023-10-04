package main;
import arquivos.metodosDados;
import itens.*;

import java.util.Locale;
import java.util.Scanner;

//Grupo:
//Fábio José Dantas Filho
//Renata Cardoso Mantovani
//Tiago Sousa Gomes 
//Evelyn Julia da Silva

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        Comercio.todosOsProdutos = metodosDados.obterProdutos();
        Comercio.setSaldo(metodosDados.obterSaldo());
        Comercio.compras = metodosDados.obterCompras();
        Comercio.vendas = metodosDados.obterVendas();

        int opcao = 1;
        System.out.println("Carregando sistema... + \n");
        while (opcao != 7) {
        	
        	visual.imprimirMenu();
        	System.out.println("");
        	visual.valorSaldo();
            opcao = sc.nextInt();
            System.out.println("");

            switch (opcao) {
                case 1: // Listar
                	visual.MenuListar();
                    opcao = sc.nextInt();

                    switch (opcao) {
                        case 1 -> Comercio.listarTodos();
                        case 2, 3 -> Comercio.listarPorCategoria(opcao);
                        default -> System.out.println("Opção inválida!");
                    }
                    break;

                case 2: // Cadastrar
                    System.out.println("Deseja cadastrar:");
                    System.out.println("(1)-Comida  (2)-Acessorios");
                    System.out.print("");
                    int opcaoCadastro = sc.nextInt();
                    System.out.print("\n");

                    if (opcaoCadastro > 0 && opcaoCadastro < 3) {

                       
                        sc.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        String nome = sc.nextLine();

                        String categoria = Comercio.definirCategoria(opcaoCadastro + 1);

                        System.out.print("Digite o valor de compra: ");
                        double valorDeCompra = sc.nextDouble();

                        if (valorDeCompra <= Comercio.getSaldo()) {
                            System.out.print("Digite o valor da venda: ");
                            double valorDeVenda = sc.nextDouble();
                            sc.nextLine();

                            Produto novoProduto = new Produto();

                            switch (opcaoCadastro) {
                                case 1: // Criando no produto (comida)

                                    System.out.print("Digite o sabor do produto: ");
                                    String sabor = sc.nextLine();
                                    System.out.print("Digite o peso do produto: ");
                                    double peso = sc.nextDouble();

                                    novoProduto = new Comida(categoria, nome, valorDeCompra, valorDeVenda, sabor, peso);
                                    break;
                                case 2: // Criando no produto (Mimos)

                                    System.out.print("Digite a cor: ");
                                    String tipo = sc.nextLine();

                                    novoProduto = new Acessorios(categoria, nome, valorDeCompra, valorDeVenda, tipo);
                                    break;

                                default:

                            } 
                            
                            //Salvar arquivos:                    
                            Comercio.cadastrar(novoProduto);
                            System.out.println("\n" + novoProduto.getNome() + " Cadastrado com sucesso!"); // Feedback

                            System.out.println("\n" + "Deseja adicionar um estoque ? (s/n)");
                            char escolha = sc.next().charAt(0);

                            if (escolha == 's') { 
                            	System.out.println("Digite a quantidade que deseja adicionar ao estoque: ");
                                int quantidade = sc.nextInt();

                                
                                Comercio.addCompra(novoProduto.getNome(), quantidade, valorDeCompra);
                                Comercio.adicionar(novoProduto.getCodigo(), quantidade);

                                if (quantidade >= 0) { // Feedback
                                	Comercio.addCompra(novoProduto.getNome(), quantidade, valorDeCompra);
                                	Comercio.adicionar(novoProduto.getCodigo(), quantidade);
                                    System.out.println("\n" + novoProduto.getNome() + " | " + quantidade + " unidades adicionadas com sucesso!");
                                }
                            }


                            break;
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3: // Adicionar estoque:
                    if (Comercio.getTodosOsProdutos().size() == 0) {
                        System.out.println("Não existe nenhum produto cadastrado no sistema!");
                        break;
                    }  
                    
                    visual.listarMain(); //antes de perguntar lista todos os produtos
                    
                    System.out.print("Digite o código do produto que deseja adicionar estoque: ");
                    int codigo = sc.nextInt(); 
                    
                    if (Comercio.verificarCodigoNaLista(codigo)) { 

                        System.out.print("Digite a quantidade quer adicionar: ");
                        int quantidade = sc.nextInt();

                        //saldo
                        if (quantidade * Comercio.getProduto(codigo).getValorDeCompra() <= Comercio.getSaldo()) { 
                        	
                        	if (quantidade >= 0) {
                        		
                        		Comercio.addCompra(Comercio.getProduto(codigo).getNome(), quantidade, Comercio.getProduto(codigo).getValorDeCompra());
                                Comercio.adicionar(codigo, quantidade);
                        		
                                System.out.println("\n" + Comercio.getProduto(codigo).getNome() + " | " + quantidade + " unidades adicionadas com sucesso!");
                        	}          
                        } else {
                            System.out.println("Saldo insulficiente!");
                        }
                    } else {
                        System.out.println("\nNão existe produto com este código!");
                    }

                    break;

                case 4: // Remover
                    if (Comercio.getTodosOsProdutos().size() == 0) { 
                        System.out.println("Não existe nenhum produto cadastrado no sistema!");

                    } else {
                    	visual.listarMain();//antes de perguntar lista todos os produtos
                    	
                        System.out.print("Digite o código do produto que deseja remover: ");
                        codigo = sc.nextInt(); 

                        for (Produto i : Comercio.getTodosOsProdutos()) {
                            if (Comercio.verificarCodigoNaLista(codigo) && i.getEstoque() == 0) {
                                if (i.getCodigo() != codigo) {
                                    continue;                                         
                                }
                                System.out.println("\n" + Comercio.getProduto(codigo) + " | Removido com sucesso!"); 
                                Comercio.remover(codigo); 
                                break;
                            } else if (Comercio.verificarCodigoNaLista(codigo)){                            

                                System.out.print("Deseja realmente remover este produto ? (s/n): ");
                                char response = sc.next().charAt(0); 

                                if (response == 's') {
                                    System.out.println("\n" +  "Removido com sucesso!");
                                    Comercio.remover(codigo);

                                } else {
                                    visual.voltarMenu();
                                }
                                break;

                            } else {
                                System.out.println("\nNão existe nenhum produto com este código!");
                                break;
                            }
                        }
                    }
                    break;
                case 5: // Venda de produtos

                    if (Comercio.todosOsProdutos.size() == 0) { 
                        System.out.println("Não existe nenhum produto cadastrado no sistema!");
                        break;
                    }
                    	visual.listarMain(); //antes de perguntar lista todos os produtos
                    	
                        System.out.print("Digite o código do produto que deseja vender: ");
                        codigo = sc.nextInt(); 
                        if (Comercio.verificarCodigoNaLista(codigo)) { 
                            System.out.print("Digite a quantidade que deseja vender: ");
                            int quantidade = sc.nextInt(); 

                            if (quantidade <= Comercio.getProduto(codigo).getEstoque()) {
                                Comercio.vender(codigo, quantidade);
                                System.out.println("\n" + Comercio.getProduto(codigo).getNome() + " | " + quantidade + " unidades vendidas com sucesso!");

                            } else {
                                System.out.println("\n" + "Tem apenas " + Comercio.getProduto(codigo).getEstoque() + " unidades disponíveis no estoque!");
                            }

                        } else {
                            System.out.println("\nNão existe produto com este código!");
                        }
                    break;

                case 6: // Relatório
                    System.out.println("Dados:");
                    System.out.println("(1)-Tudo  (2)-Esta sessão");
                    int opcaoRelatorio = sc.nextInt();
                    System.out.print("\n");

                    switch (opcaoRelatorio) {
                        case 1, 2 -> Comercio.relatorio(opcaoRelatorio);
                        default -> System.out.println("Opção inválida!");
                    }
                    break;

                case 7: // Sair
                    System.out.println("Saindo......");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    sc.close();
            }
        }
    }//Main 
}//Class