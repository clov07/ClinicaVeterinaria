/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import ConexaoBD.ConnectionFactory;
import DTO.PacienteDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private final Connection connection;

    public PacienteDAO() {
        this.connection = ConnectionFactory.getConnection(); // Conexão com o banco
    }

    // ✅ Criar (Inserir Paciente)
    public void adicionarPaciente(PacienteDTO paciente) {
    String query = "INSERT INTO pacientes (nome, cpfDoDono, dataNascimento, telefoneDoDono, emailDoDono, sexo, especie, raca) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, paciente.getNome());
                pst.setString(2, paciente.getCpfDoDono());
                pst.setString (3,paciente.getDataNascimento()); 
                pst.setString(4, paciente.getTelefoneDoDono());
                pst.setString(5, paciente.getEmailDoDono());
                pst.setString(6, paciente.getSexo());
                pst.setString(7, paciente.getEspecie());
                pst.setString(8, paciente.getRaca());
                
               
         
         System.out.println("📌 Executando INSERT: " + query);
         System.out.println("📌 Dados: " + paciente.getNome() + ", " + paciente.getCpfDoDono());

        int linhasAfetadas = pst.executeUpdate();
        
        if (linhasAfetadas > 0) {
            System.out.println("✅ Paciente cadastrado com sucesso!");
        } else {
            System.out.println("❌ Nenhum paciente foi cadastrado!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("❌ Erro ao cadastrar paciente: " + e.getMessage());
    }

    }

    // ✅ Ler (Listar Pacientes)
    public List<PacienteDTO> listarPacientes() {
        List<PacienteDTO> pacientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM pacientes";
            try ( 
                 Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("idPaciente");
                    String nome = rs.getString("nome");
                    String cpfDoDono = rs.getString("cpfDoDono");
                    String dataNascimento = rs.getString("dataNascimento");
                    String telefoneDoDono = rs.getString("telefoneDoDono");
                    String emailDoDono = rs.getString("emailDoDono");
                    String sexo = rs.getString("sexo");
                    String especie = rs.getString("especie");
                    String raca = rs.getString("raca");

                    PacienteDTO paciente = new PacienteDTO(id, nome, cpfDoDono, dataNascimento, telefoneDoDono, emailDoDono, sexo, especie, raca);
                    pacientes.add(paciente);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar pacientes: " + e.getMessage());
        }
        return pacientes;
    }

    // ✅ Atualizar Paciente
    public void atualizarPaciente(PacienteDTO paciente) {
        try {
            String query = "UPDATE pacientes SET nome = ?, cpfDoDono = ?, dataNascimento = ?, telefoneDoDono = ?, emailDoDono = ?, sexo = ?, especie = ?, raca = ? WHERE idPaciente = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, paciente.getNome());
                ps.setString(2, paciente.getCpfDoDono());
                ps.setString(3, paciente.getDataNascimento()); 
                ps.setString(4, paciente.getTelefoneDoDono());
                ps.setString(5, paciente.getEmailDoDono());
                ps.setString(6, paciente.getSexo());
                ps.setString(7, paciente.getEspecie());
                ps.setString(8, paciente.getRaca());
                ps.setInt(9, paciente.getId());

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    // ✅ Excluir Paciente
    public void excluirPaciente(int idPaciente) {
        try {
            String query = "DELETE FROM pacientes WHERE idPaciente = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, idPaciente);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao excluir paciente: " + e.getMessage());
        }
    }
}
