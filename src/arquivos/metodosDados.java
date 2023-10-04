package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import itens.*;

public class metodosDados {

    // Escreve no arquivo "produtosCadastrados"
    public static void escreverArquivo(ArrayList<Produto> veiculos) {
        try {
            PrintWriter arquivo = new PrintWriter("src\\arquivos\\produtosCadastrados.txt");

            for (Produto veiculo : veiculos) {
                arquivo.write(veiculo.toStringArquivo() + "\n");

            } arquivo.close();

        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
        }
    }//EscreverVeiculos

    // Obtem os dados do arquivo "veiculosCadastrados"
    public static ArrayList<Produto> obterProdutos() {
        ArrayList<Produto> tempArray = new ArrayList<>();
        File arquivo = new File("src\\arquivos\\produtosCadastrados.txt");

        try {
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {

                String[] produtoArray = sc.nextLine().split(",");
                Produto novoProduto = new Produto();

                switch (produtoArray[1]) {
                    case "Comida":
                        novoProduto = new Comida(produtoArray[1], produtoArray[2],Integer.parseInt(produtoArray[3]),
                                Double.parseDouble(produtoArray[4]), Double.parseDouble(produtoArray[5]),
                                produtoArray[6], Double.parseDouble(produtoArray[7]));
                        break;
                    case "acessorios":
                        novoProduto = new Acessorios(produtoArray[1], produtoArray[2],Integer.parseInt(produtoArray[3]),
                                Double.parseDouble(produtoArray[4]), Double.parseDouble(produtoArray[5]),
                                produtoArray[6]);
                        break;
                    default:
                }
                tempArray.add(novoProduto);
            }//While
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
        return tempArray;
    }//ObterArquivo

    // Escreve no arquivo "Compras"
    public static void escreverCompras(ArrayList<String> array) {
        try {
            PrintWriter arquivo = new PrintWriter("src\\arquivos\\compras.txt");
            for (String a : array) {
                arquivo.write(a + "\n");
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }//EscreverCompras


    public static void escreverSaldo(double saldo) {
        try {
        	PrintWriter arquivo = new PrintWriter("src\\arquivos\\saldo.txt");
            arquivo.write(String.format("%.2f", saldo));
            arquivo.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }
    public static double obterSaldo() {
        File arquivo = new File("src\\arquivos\\saldo.txt");
        double saldo = 0;
        try {
        	Scanner sc = new Scanner(arquivo);
            while(sc.hasNextLine()) {
            	String saldoTemp = sc.nextLine();
            	saldo = Double.parseDouble(saldoTemp);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
        return saldo;
    }
    
    // Escreve no arquivo "vendas"
    public static void escreverVendas(ArrayList<String> array) {
        try {
            PrintWriter arquivo = new PrintWriter("src\\arquivos\\vendas.txt");
            for (String a : array) {
                arquivo.write(a + "\n");
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }//EscreverVendas

    // Obtem os dados do arquivo "compras"
    public static ArrayList<String> obterCompras() {
        ArrayList<String> listCompras = new ArrayList<>();
        File arquivo = new File("src\\arquivos\\compras.txt");

        try {
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {
                listCompras.add(sc.nextLine());
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
        return listCompras;
    }//ObterCompras

    // Obtem os dados do arquivo "vendas"
    public static ArrayList<String> obterVendas() {
        ArrayList<String> listVendas = new ArrayList<>();
        File arquivo = new File("src\\arquivos\\vendas.txt");

        try {
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {
                listVendas.add(sc.nextLine());
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
        return listVendas;
    }
}
