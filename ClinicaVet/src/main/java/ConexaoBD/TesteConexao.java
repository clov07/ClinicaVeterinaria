/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexaoBD;

import java.sql.Connection;

/**
 *
 * @author luizg
 */
public class TesteConexao {
    public static void main(String[] args) {
        Connection conexao = ConnectionFactory.getConnection();
        if (conexao != null) {
            System.out.println("✅ Conexão bem-sucedida!");
        } else {
            System.out.println("❌ Erro ao conectar.");
        }
    }
}

