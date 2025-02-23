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
    public boolean executarComandoSQL(String query, Object... parametros) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suabase", "root", "senha")) {
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
}
