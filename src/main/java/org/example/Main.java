package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("=============== Bem vindo ao TestBank ===============");
        System.out.println("(1) Dejesa abrir uma nova conta. \n(2) Entrar em sua conta.");
        int escolha = in.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Digite o nome do titular: ");
                String nomeTitular = in.nextLine();
                System.out.println("Digite o CPF do titular: ");
                String cpfTitular = in.nextLine();

                Titular titular = new Titular(cpfTitular, "1", nomeTitular);
                ContaBancaria contaBancaria = new ContaBancaria("27.903", titular , "3617", 0.0);

                contaBancaria.criarContaBancaria();
            case 2:
                break;
        }

//        System.out.println("Digite o número para a transação desejada: \n(1) Depositar\n(2) Sacar\n(3) Ver saldo");
//        int escolhaTransacao = in.nextInt();

//        switch (escolha) {
//            case 1:
//                System.out.println("Digite o valor a ser depositado: ");
//                double valorDepositado = in.nextDouble();
//                break;
//
//                case 2:
//                    System.out.println("Digite o valor a ser sacado: ");
//                    break;
//                    case 3:
//                        System.out.println(contaBancaria.getSaldo());
//        }

    }
}
