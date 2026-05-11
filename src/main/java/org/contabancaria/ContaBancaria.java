package org.contabancaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

    //-------------------------------ATRIBUTOS-------------------------------//

    private String numeroDaConta = "";
    private String agencia = "";
    private String status = "";
    private String senha = "";
    private double saldo = 0.00;
    private LocalDate dataAbertura = null;
    private Titular titular;

    private List<String> extratoBancario;

    //-------------------------------CONSTRUTOR-----------------------------//

    public ContaBancaria(String numeroDaConta, Titular titular, String agencia, Double saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.dataAbertura = LocalDate.now();
        this.agencia = agencia;
        this.saldo = saldoInicial;
        this.extratoBancario = new ArrayList<>();

        this.extratoBancario.add("Saldo inicial: R$ " + String.format("%.2f", saldoInicial));
    }

    //-----------------------------OPERAÇÕES FINANCEIRAS----------------------------//

    public boolean transferirValor(double valor, ContaBancaria contaDestino) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        System.out.println("Conta inexistente ou saldo insuficiente.");
        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        this.extratoBancario.add("Depósito: R$ " + String.format("%.2f", valor));
    }

    public boolean sacar(double valor) {
        if (valor > 0.00 && this.saldo >= valor) {
            saldo -= valor;
            this.extratoBancario.add("Saque de R$ " + String.format("%.2f", valor) + "Efetuado com sucesso:");
            return true;
        }
        System.out.println("Saldo insuficiente.");
        return false;
    }

    public String consultarSaldo() {
        return "Saldo atual: R$ " + String.format("%.2f", this.saldo);
    }

    public String emitirExtrato() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder extrato = new StringBuilder();

        extrato.append("----- EXTRADO DA CONTA -----\n");
        extrato.append("Conta aberta em: ").append(this.dataAbertura.format(formatter)).append("\n");
        extrato.append("---------------------------------------\n");

        for(String transacao : extratoBancario) {
            extrato.append(transacao).append("\n");
        }
        extrato.append("---------------------------------------\n");
        extrato.append(consultarSaldo());
        return extrato.toString();
    }

    //-------------------------STATUS DA CONTA--------------------------//

    public void criarContaBancaria() {
        this.status = "Conta ativa.";
        System.out.println("Conta bancária criada com sucesso.");
    }

    public void bloquearConta() {
        this.status = "Conta bloqueada";
        System.out.println("Conta bloqueada com sucesso.");
    }

    public void desbloquearConta() {
        this.status = "Conta ativa.";
    }

    public String exibirStatusAtual() {
        return "Status da conta: " + this.status;
    }

    public boolean solocitarEncerramento() {
        if (getSaldo() != 0.00) {
            System.out.println("Conta encerrada com sucesso.");
            this.status = "Conta encerrada.";
            return true;
        } else if (getSaldo() < 0.00) {
            System.out.println("Para encerrar sua conta, é necessário deixar seus débitos em dia, fale com seu gerente.");
            return false;
        }
        System.out.println("Seu saldo deve ser zero para poder encerrar a conta.");
        return false;
    }

    /// ----------------------------Getter and Setters------------------------///

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }
}


