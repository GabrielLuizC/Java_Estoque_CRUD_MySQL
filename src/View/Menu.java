package View;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws ParseException {
        int escolhe = 0;
        EstoqueView estoqueView = new EstoqueView();
        Scanner scan = new Scanner(System.in);

        System.out.println("1 - Estoque");
        System.out.println("2 - Sair");

        escolhe = scan.nextInt();

        switch (escolhe){
            case 1:
                estoqueView.menuEstoque();
                break;
            case 2:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("ERROR SYSTEM");
        }
    }
}
