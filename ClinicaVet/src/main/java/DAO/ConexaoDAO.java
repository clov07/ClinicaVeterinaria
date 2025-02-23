/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class ConexaoDAO {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/clinicavet";
    private static final String USUARIO = "root"; // Substitua pelo seu usuário do MySQL
    private static final String SENHA = "mirandiba10"; // Substitua pela sua senha do MySQL

    public boolean executarComandoSQL(String query, Object... parametros) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinicavet", "root", "mirandiba10")) {
        PreparedStatement stmt = conn.prepareStatement(query);
        
        for (int i = 0; i < parametros.length; i++) {
            stmt.setObject(i + 1, parametros[i]);
        }
        
        int resultado = stmt.executeUpdate();
        return resultado > 0;  // Se o número de linhas afetadas for maior que 0, significa que a operação foi bem-sucedida
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    
    }
    public static Connection getConnection() {
        try {
            // Carrega o driver JDBC (não necessário em Java 8+, mas pode ajudar)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("❌ Erro ao conectar ao banco: " + e.getMessage(), e);
        }
    }
}
