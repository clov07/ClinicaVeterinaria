/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUILogin;
import DAO.UsuarioDAO;
import GUI.Paciente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class LoginController {
 public void logarUsuario(GUIlogin GUIlogin) throws SQLException {
        UsuarioDAO usuario = new UsuarioDAO();
        boolean loginValido = usuario.validarlogin(GUIlogin.getusuariotxt().getText(),GUIlogin.getsenhatxt().getText());
        
        if (loginValido) {
            JOptionPane.showMessageDialog(GUIlogin, "Login realizado com sucesso");
            // Abre a TelaHospedes
             Paciente Paciente = new Paciente();
            Paciente.setVisible(true);
            GUIlogin.dispose(); // Fecha a tela de login após login bem-sucedido
        } else {
            JOptionPane.showMessageDialog(GUIlogin, "ERRO! Verifique se os campos estão corretos");
        }
    }
}

