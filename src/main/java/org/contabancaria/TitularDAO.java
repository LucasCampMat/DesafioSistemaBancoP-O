package org.contabancaria;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TitularDAO {

    public void salvar (Titular titular){
        String sql = "INSERT INTO titular (cpf, nome, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, titular.getCpfTitular());
            stmt.setString(2, titular.getNomeTitular());
            stmt.setString(3, titular.getEnderecoTitular());
            stmt.setString(4, titular.getTelefoneTitular());
            stmt.setString(5, titular.getEmailTitular());

            stmt.executeUpdate();
        System.out.println("Titular salvo com sucerro no banco de dados.");
        }
        catch(Exception e){
            throw new RuntimeException("Erro crítico ao salvar o titular no banco de daods.");
        }
    }
}
