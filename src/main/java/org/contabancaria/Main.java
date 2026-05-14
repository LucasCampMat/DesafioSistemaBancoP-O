package org.contabancaria;


import org.contabancaria.model.ContaBancaria;
import org.contabancaria.model.Titular;

public class Main {
    public static void main(String[] args) {


        // 1. Criar e preencher o Titular diretamente

        Titular titular1 = new Titular();
        titular1.setCpfTitular("123456789");
        titular1.setNomeTitular("Titular");
        titular1.setEnderecoTitular("Avenida Coqueiral.");
        titular1.setEmailTitular("lucas@outlook.com");
        titular1.setTelefoneTitular("123456789");


        // 2. Criar a Conta Bancária vinculando o titular

        ContaBancaria conta = new ContaBancaria("27903", titular1, "3617", 0.00);

        //AREA DE TESTES DE OPERAÇÕES

        conta.depositar(250.00);
        conta.sacar(50.00);
        conta.sacar(600.00);

        //  LEITURA DOS TESTES

        System.out.println("Dados do dono da conta.\n");
        System.out.println(conta.getTitular().exibirDadosTitular());
        System.out.println("\n" + conta.emitirExtrato());
        System.out.println("\n" + conta.exibirStatusAtual());
    }
}
