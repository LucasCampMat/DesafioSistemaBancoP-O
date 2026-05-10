package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);



        //  FAZER UM IF PARA VER SE É CLIENTE OU NOVO CLIENTE //

        ContaBancaria contaBancaria = new ContaBancaria();

        System.out.println("Bem vindo ao Sistema de Conta Bancaria.");

        System.out.println("Digite o nome do títular: ");
        String nomeTitular = in.nextLine();
        System.out.println("Digite o numero da conta: ");
        String numeroDaConta = in.nextLine();

        System.out.println("Digite o número para a transação desejada: \n(1) Depositar\n(2) Sacar\n(3) Ver saldo");
        int escolha = in.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Digite o valor a ser depositado: ");
                double valorDepositado = in.nextDouble();
                break;

                case 2:
                    System.out.println("Digite o valor a ser sacado: ");
                    break;
                    case 3:
                        System.out.println(contaBancaria.getSaldo());
        }

    }
}
