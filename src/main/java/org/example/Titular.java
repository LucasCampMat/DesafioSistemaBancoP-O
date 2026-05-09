package org.example;

public class Titular {

    private String cpfTitular = "";
    private String idTitular = "";
    private String nomeTitular = "";
    private String enderecoTitular = "";
    private String telefoneTitular = "";
    private String emailTitular = "";

    public void atualizarCadastro(String novoTelefone, String novoEmail, String novoEndereco) {
        this.telefoneTitular = novoTelefone;
        this.emailTitular = novoEmail;
        this.enderecoTitular = novoEndereco;
    }

    public String exibirDadosTitular() {
        return ("Nome: " + getNomeTitular() +
                "| Endereço: " + getEnderecoTitular() +
                "| Telefone: " + getTelefoneTitular() +
                "| Email: " + getEmailTitular());
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void setEnderecoTitular(String enderecoTitular) {
        this.enderecoTitular = enderecoTitular;
    }

    public void setTelefoneTitular(String telefoneTitular) {
        this.telefoneTitular = telefoneTitular;
    }

    public void setEmailTitular(String emailTitular) {
        this.emailTitular = emailTitular;
    }


    public String getIdTitular() {
        return idTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public String getEnderecoTitular() {
        return enderecoTitular;
    }

    public String getTelefoneTitular() {
        return telefoneTitular;
    }

    public String getEmailTitular() {
        return emailTitular;
    }
}
