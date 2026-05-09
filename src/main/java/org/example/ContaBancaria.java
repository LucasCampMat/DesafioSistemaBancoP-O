package org.example;

import java.util.Scanner;

public class ContaBancaria {


    private int numeroDaConta = 0;
    private String titular;
    private double saldo = 0.00;
    private double deposita = 0.00;
    private double saca = 0.00;


    public void depositar(){
        if(this.deposita >= 10){
            System.out.println("Depositado com sucesso.");
        } else {
            System.out.println("O valor mínimo permitido para depósito neste terminal é de 10 reais.");
        }

    }

    public void sacar(){
        if(this.saca >= 10){
            System.out.println("Sacado com sucesso.");
        } else System.out.println("O valor mínimo para saque é de 10 reais.");{

        }
    }


    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta() {

        this.numeroDaConta = numeroDaConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular() {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }
}


