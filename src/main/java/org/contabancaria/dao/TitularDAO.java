package org.contabancaria.dao;

import org.contabancaria.infra.ConnectionFactory;
import org.contabancaria.model.Titular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TitularDAO {

    // 1. INSERT
    public void salvar (Titular titular) {
        String sql = "INSERT INTO titular (cpf, nome, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titular.getCpfTitular());
            stmt.setString(2, titular.getNomeTitular());
            stmt.setString(3, titular.getEnderecoTitular());
            stmt.setString(4, titular.getTelefoneTitular());
            stmt.setString(5, titular.getEmailTitular());

            stmt.executeUpdate();
            System.out.println("Titular salvo com sucesso no banco de dados.");
        } catch (Exception e) {
            throw new RuntimeException("Erro crítico ao salvar o titular.");
        }
    }

    // 2. select for CPF (INDIVIDUAL)

    public Titular buscarPorCpf(String cpfBusca) {
        String sql = "SELECT * FROM titular WHERE cpf = ?";

        try(Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cpfBusca);

            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Titular titular = new Titular();
                    titular.setCpfTitular(rs.getString("cpf"));
                    titular.setNomeTitular(rs.getString("nome"));
                    titular.setEnderecoTitular(rs.getString("endereco"));
                    titular.setTelefoneTitular(rs.getString("telefone"));
                    titular.setEmailTitular(rs.getString("email"));
                    return titular;
                }
            }

        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar o titular.");
        }
        return null;
    }
}
