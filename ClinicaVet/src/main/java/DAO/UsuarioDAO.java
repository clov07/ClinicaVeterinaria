/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author carlo
 */

import ConexaoBD.ConnectionFactory;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        connection = ConnectionFactory.getConnection();
    }

    // Método para verificar se o usuário e senha estão corretos
    public boolean validarLogin(String usuario, String senha) {
        String query = "SELECT * FROM entrar WHERE usuario = ? AND senha = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, usuario);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("✅ Login bem-sucedido para: " + usuario);
                return true;
            } else {
                System.out.println("❌ Falha no login: usuário ou senha incorretos!");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao validar login: " + e.getMessage());
            return false;
        }
    }

    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

