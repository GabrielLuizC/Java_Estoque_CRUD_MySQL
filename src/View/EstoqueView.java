package View;

import Control.EstoqueController;
import Model.Estoque;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class EstoqueView {
    public static void menuEstoque() throws ParseException {
        int escolhe = 0;

        Estoque estoque = new Estoque();
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);

        System.out.println("1 - Cadastrar Estoque");
        System.out.println("2 - Listar Estoque");
        System.out.println("3 - Editar Estoque");
        System.out.println("4 - Excluir Estoque");
        System.out.println("5 - Voltar");

        escolhe = scan.nextInt();

        switch (escolhe){
            case 1:
                cadastrarEstoque();
                avancar();
                break;
            case 2:
                listarEstoque();
                avancar();
                break;
            case 3:
                editarEstoque(estoque, escolhe);
                avancar();
                break;
            case 4:
                excluirEstoque();
                avancar();
                break;
            case 5:
                menu.menu();
                break;
            default:
                System.out.println("ERROR SYSTEM");
        }
    }

    public static void avancar() throws ParseException{
        int tmp = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("\nDIGITE 1 PARA CONTINUAR: ");
        tmp = scan.nextInt();
        System.out.println("\n");
        menuEstoque();
    }

    public static void cadastrarEstoque() throws ParseException{
        EstoqueController estoqueController = new EstoqueController();
        Estoque estoque = new Estoque();
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        scan.nextLine();
        System.out.println("Digite o Nome do Insumo: ");
        estoque.setNomeInsumo(scan.nextLine().toUpperCase());

        System.out.println("Digite a Quantidade do Insumo: ");
        estoque.setQntInsumo(scan.nextInt());

        System.out.println("Digite o Preço do Insumo: ");
        estoque.setPrecoInsumo(scan.nextDouble());

        estoqueController.cadastrarEstoque(estoque);
    }

    public static void listarEstoque(){
        EstoqueController estoqueController = new EstoqueController();
        for (Estoque estoque : estoqueController.listarEstoque()){
            System.out.println("ID: " + estoque.getIdInsumo() +
                    " | NOME: " + estoque.getNomeInsumo() +
                    " | QUANTIDADE: " + estoque.getQntInsumo() +
                    " | PREÇO: " + estoque.getPrecoInsumo() +
                    " | VALIDADE: " + estoque.getRecebeData());
        }
    }

    public static void editarEstoque(Estoque estoque, int escolhe) throws ParseException{
        EstoqueController estoqueController = new EstoqueController();
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        listarEstoque();

        System.out.println("\nDigite qual o ID do Insumo a ser Editado: ");
        estoque.setIdInsumo(scan.nextInt());
        scan.nextLine();

        System.out.println(" ");
        System.out.println("1 - Nome");
        System.out.println("2 - Quantidade");
        System.out.println("3 - Preco");
        System.out.println("4 - Validade");
        System.out.println("5 - Editar Todas Opções");
        System.out.println(" ");
        System.out.println("Digite o que deseja editar: ");
        escolhe = scan.nextInt();

        switch (escolhe){
            case 1:
                scan.nextLine();
                System.out.println("Digite o Nome do Insumo: ");
                estoque.setNomeInsumo(scan.nextLine().toUpperCase());
                break;
            case 2:
                scan.nextLine();
                System.out.println("Digite a Quantidade do Insumo: ");
                estoque.setQntInsumo(scan.nextInt());
                break;
            case 3:
                scan.nextLine();
                System.out.println("Digite o Preço do Insumo: ");
                estoque.setPrecoInsumo(scan.nextDouble());
                break;
            case 4:
                scan.nextLine();
                estoque.setRecebeData(estoque.getData());
                break;
            case 5:
                scan.nextLine();
                System.out.println("Digite o Nome do Insumo: ");
                estoque.setNomeInsumo(scan.nextLine().toUpperCase());

                System.out.println("Digite a Quantidade do Insumo: ");
                estoque.setQntInsumo(scan.nextInt());

                System.out.println("Digite o Preço do Insumo: ");
                estoque.setPrecoInsumo(scan.nextDouble());
                break;
        }
        estoqueController.editarEstoque(estoque, escolhe);
    }

    public static void excluirEstoque(){
        EstoqueController estoqueController = new EstoqueController();
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Estoque estoque = new Estoque();
        listarEstoque();

        System.out.println("Digite qual o ID do Insumo a ser Excluido: ");
        estoque.setIdInsumo(scan.nextInt());

        estoqueController.excluirEstoque(estoque);
    }
}
