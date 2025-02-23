package GUI;

import DAO.ConexaoDAO;
import DAO.PacienteDAO;
import DTO.PacienteDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author maria
 */
public class Paciente extends javax.swing.JFrame {
    
private PacienteDAO PacienteDAO = new PacienteDAO();

private ConexaoDAO conexaoDAO = new ConexaoDAO();

    /**
     * Creates new form GUImedicamentos
     */
    public Paciente() {
        initComponents();
        listarPacientes();

    }
    
private void inicializarTabela() {
    // A tabela já foi criada pelo GUI, não é necessário criar uma nova instância
    DefaultTableModel model = new DefaultTableModel(
        new Object[][]{}, 
        new String[]{"ID", "Nome", "CPF", "Data Nascimento", "Telefone", "Email", "Sexo", "Espécie", "Raça"}
    );
    tablePacientes.setModel(model); // Associa o modelo à tabela existente

    // Definindo o modo de seleção
    tablePacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    // Adicionando o listener para capturar a seleção da tabela
    ListSelectionModel selectionModel = tablePacientes.getSelectionModel();
    selectionModel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Verifica se a seleção é válida (não está vazio)
            if (!e.getValueIsAdjusting() && tablePacientes.getSelectedRow() != -1) {
                carregarCamposPaciente(); // Atualiza os campos ao selecionar uma linha
            }
        }
    });
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pacientestext = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        txtEmailDoDono = new javax.swing.JTextField();
        txtEspecieB = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        cadastrarbutton = new javax.swing.JButton();
        atualizarbutton = new javax.swing.JButton();
        excluirbutton = new javax.swing.JButton();
        carregarcamposbutton = new javax.swing.JButton();
        txtRacaB = new javax.swing.JTextField();
        txtRaca = new javax.swing.JLabel();
        txtSexo = new javax.swing.JLabel();
        txtSexoB = new javax.swing.JTextField();
        txtDataDNasc = new javax.swing.JLabel();
        txtDataDeNascimento = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JLabel();
        txtTelefoneDoDono = new javax.swing.JTextField();
        txtCPF = new javax.swing.JLabel();
        txtCpfDoDono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        pacientestext.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        pacientestext.setForeground(new java.awt.Color(51, 51, 255));
        pacientestext.setText("PACIENTES");

        txtNomePaciente.setBackground(new java.awt.Color(0, 0, 0));
        txtNomePaciente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNomePaciente.setForeground(new java.awt.Color(0, 0, 0));
        txtNomePaciente.setText("Nome:");
        txtNomePaciente.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtNomePacienteComponentAdded(evt);
            }
        });

        txtEspecie.setBackground(new java.awt.Color(0, 0, 0));
        txtEspecie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEspecie.setForeground(new java.awt.Color(0, 0, 0));
        txtEspecie.setText("Espécie:");

        txtEmail.setBackground(new java.awt.Color(0, 0, 0));
        txtEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setText("E-mail:");

        txtEmailDoDono.setBackground(new java.awt.Color(255, 255, 255));
        txtEmailDoDono.setForeground(new java.awt.Color(0, 0, 0));
        txtEmailDoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailDoDonoActionPerformed(evt);
            }
        });

        txtEspecieB.setBackground(new java.awt.Color(255, 255, 255));
        txtEspecieB.setForeground(new java.awt.Color(0, 0, 0));
        txtEspecieB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecieBActionPerformed(evt);
            }
        });

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePacientes.setModel(new DefaultTableModel(
            new Object[][]{}, 
            new String[]{"ID", "Nome", "CPF", "Data Nascimento", "Telefone", "Email", "Sexo", "Espécie", "Raça"}
        ));
        tablePacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePacientes);

        cadastrarbutton.setText("Cadastrar");
        cadastrarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarbuttonActionPerformed(evt);
            }
        });

        atualizarbutton.setText("Atualizar");
        atualizarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarbuttonActionPerformed(evt);
            }
        });

        excluirbutton.setText("Excluir");
        excluirbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirbuttonActionPerformed(evt);
            }
        });

        carregarcamposbutton.setText("Carregar Campos");
        carregarcamposbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarcamposbuttonActionPerformed(evt);
            }
        });

        txtRacaB.setBackground(new java.awt.Color(255, 255, 255));
        txtRacaB.setForeground(new java.awt.Color(0, 0, 0));
        txtRacaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRacaBActionPerformed(evt);
            }
        });

        txtRaca.setBackground(new java.awt.Color(0, 0, 0));
        txtRaca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRaca.setForeground(new java.awt.Color(0, 0, 0));
        txtRaca.setText("Raça:");

        txtSexo.setBackground(new java.awt.Color(0, 0, 0));
        txtSexo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSexo.setForeground(new java.awt.Color(0, 0, 0));
        txtSexo.setText("Sexo:");

        txtSexoB.setBackground(new java.awt.Color(255, 255, 255));
        txtSexoB.setForeground(new java.awt.Color(0, 0, 0));
        txtSexoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoBActionPerformed(evt);
            }
        });

        txtDataDNasc.setBackground(new java.awt.Color(0, 0, 0));
        txtDataDNasc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDataDNasc.setForeground(new java.awt.Color(0, 0, 0));
        txtDataDNasc.setText("Data de Nascimento:");

        txtDataDeNascimento.setBackground(new java.awt.Color(255, 255, 255));
        txtDataDeNascimento.setForeground(new java.awt.Color(0, 0, 0));
        txtDataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDeNascimentoActionPerformed(evt);
            }
        });

        txtTelefone.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefone.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefone.setText("Telefone:");

        txtTelefoneDoDono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefoneDoDono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefoneDoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneDoDonoActionPerformed(evt);
            }
        });

        txtCPF.setBackground(new java.awt.Color(0, 0, 0));
        txtCPF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCPF.setForeground(new java.awt.Color(0, 0, 0));
        txtCPF.setText("CPF:");

        txtCpfDoDono.setBackground(new java.awt.Color(255, 255, 255));
        txtCpfDoDono.setForeground(new java.awt.Color(0, 0, 0));
        txtCpfDoDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfDoDonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pacientestext)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEspecie)
                                    .addComponent(txtTelefone)
                                    .addComponent(txtSexo, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEspecieB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRaca)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtTelefoneDoDono, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCPF))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtSexoB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDataDNasc)))
                                        .addGap(12, 12, 12)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRacaB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCpfDoDono, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmailDoDono))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNomePaciente)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cadastrarbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(atualizarbutton)
                                        .addGap(18, 18, 18)
                                        .addComponent(excluirbutton)
                                        .addGap(18, 18, 18)
                                        .addComponent(carregarcamposbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 32, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(pacientestext)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEspecieB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEspecie)
                    .addComponent(txtRacaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSexoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo)
                    .addComponent(txtDataDNasc)
                    .addComponent(txtDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefoneDoDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone)
                    .addComponent(txtCPF)
                    .addComponent(txtCpfDoDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail)
                    .addComponent(txtEmailDoDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarbutton)
                    .addComponent(atualizarbutton)
                    .addComponent(excluirbutton)
                    .addComponent(carregarcamposbutton))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailDoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailDoDonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailDoDonoActionPerformed

    private void txtEspecieBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecieBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecieBActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtRacaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRacaBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRacaBActionPerformed

    private void txtSexoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoBActionPerformed

    private void txtDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDeNascimentoActionPerformed

    private void txtTelefoneDoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneDoDonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneDoDonoActionPerformed

    private void txtCpfDoDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfDoDonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfDoDonoActionPerformed

    private void cadastrarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarbuttonActionPerformed
       cadastrarPaciente();
    }//GEN-LAST:event_cadastrarbuttonActionPerformed

    private void atualizarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarbuttonActionPerformed
      atualizarPaciente();
      listarPacientes();
      carregarCamposPaciente();
    }//GEN-LAST:event_atualizarbuttonActionPerformed

    private void carregarcamposbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarcamposbuttonActionPerformed
        carregarCamposPaciente();
    }//GEN-LAST:event_carregarcamposbuttonActionPerformed

    private void txtNomePacienteComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtNomePacienteComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePacienteComponentAdded

    private void excluirbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirbuttonActionPerformed
       excluirPaciente();
       listarPacientes();
       limparCamposPaciente();

    }//GEN-LAST:event_excluirbuttonActionPerformed

    private void tablePacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePacientesMouseClicked
        carregarCamposPaciente();
         listarPacientes();
    }//GEN-LAST:event_tablePacientesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarbutton;
    private javax.swing.JButton cadastrarbutton;
    private javax.swing.JButton carregarcamposbutton;
    private javax.swing.JButton excluirbutton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pacientestext;
    private javax.swing.JTable tablePacientes;
    private javax.swing.JLabel txtCPF;
    private javax.swing.JTextField txtCpfDoDono;
    private javax.swing.JLabel txtDataDNasc;
    private javax.swing.JTextField txtDataDeNascimento;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JTextField txtEmailDoDono;
    private javax.swing.JLabel txtEspecie;
    private javax.swing.JTextField txtEspecieB;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel txtNomePaciente;
    private javax.swing.JLabel txtRaca;
    private javax.swing.JTextField txtRacaB;
    private javax.swing.JLabel txtSexo;
    private javax.swing.JTextField txtSexoB;
    private javax.swing.JLabel txtTelefone;
    private javax.swing.JTextField txtTelefoneDoDono;
    // End of variables declaration//GEN-END:variables
private static final String URL = "jdbc:mysql://127.0.0.1:3306/clinicavet";
private static final String USUARIO = "root"; // Substitua pelo seu usuário do MySQL
private static final String SENHA = "mirandiba10"; // Substitua pela sua senha do MySQL
 
private void cadastrarPaciente() {
    System.out.println("✅ Método cadastrarPaciente() foi chamado!");
    // Capturando os dados do formulário
    String nome = txtNome.getText();
    String cpfDoDono = txtCpfDoDono.getText().trim();
    String telefoneDoDono = txtTelefoneDoDono.getText().trim();
    String emailDoDono = txtEmailDoDono.getText().trim();
    String sexo = txtSexoB.getText().trim();
    String especie = txtEspecieB.getText().trim();
    String raca = txtRacaB.getText().trim();
    String dataNascimento = txtDataDeNascimento.getText().trim();

    if (cpfDoDono.isEmpty() || telefoneDoDono.isEmpty() || especie.isEmpty()) {
        JOptionPane.showMessageDialog(null, "❌ Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        System.out.println("❌ ERRO: Algum campo obrigatório está vazio!");
        return;
    }

    try {
        // Criando o objeto PacienteDTO
        PacienteDTO novoPaciente = new PacienteDTO(0, nome, cpfDoDono, dataNascimento, telefoneDoDono, emailDoDono, sexo, especie, raca);
        
        System.out.println("Dados capturados do formulario: " + novoPaciente.toString());

        // Conectando ao banco e inserindo o paciente
        String query = "INSERT INTO pacientes (nome, cpfDoDono, telefoneDoDono, emailDoDono, sexo, especie, raca, dataNascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL,USUARIO,SENHA);
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, nome);
            pst.setString(2, cpfDoDono);
            pst.setString(3, telefoneDoDono);
            pst.setString(4, emailDoDono);
            pst.setString(5, sexo);
            pst.setString(6, especie);
            pst.setString(7, raca);
            pst.setString(8, dataNascimento);

            pst.executeUpdate();  // Executa a inserção

            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso.");
            listarPacientes(); // Atualiza a tabela
            limparCamposPaciente();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
private void atualizarPaciente() {
        
    
        int idPacienteSelecionado=0;

        if (idPacienteSelecionado != -1) {  // Verifica se um paciente foi selecionado
            // Pega os dados dos campos
            String nome = txtNome.getText();
            String cpfDoDono = txtCpfDoDono.getText();
            String telefoneDoDono = txtTelefoneDoDono.getText();
            String emailDoDono = txtEmailDoDono.getText();
            String sexo = txtSexoB.getText();
            String especie = txtEspecieB.getText();
            String raca = txtRacaB.getText();
            String dataNascimento = txtDataDeNascimento.getText();

            // Cria a query para atualizar o paciente
            String query = "UPDATE pacientes SET nome = ?, cpfDoDono = ?, telefoneDoDono = ?, emailDoDono = ?, sexo = ?, especie = ?, raca = ?, dataNascimento = ? WHERE idPaciente = ?";

            System.out.println("Executando SQL: " + query);  // Debug

            // Chama o método do ConexaoDAO para executar a consulta SQL
            boolean sucesso = conexaoDAO.executarComandoSQL(query, nome, cpfDoDono, telefoneDoDono, emailDoDono, sexo, especie, raca, dataNascimento, idPacienteSelecionado);
            
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso.");
                listarPacientes();  // Atualiza a lista de pacientes
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um paciente para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


private void excluirPaciente() {
        int selectedRow = tablePacientes.getSelectedRow();
        if (selectedRow != -1) {
            // Pega o ID do paciente da linha selecionada
            int idPaciente = (int) tablePacientes.getValueAt(selectedRow, 0);  // Assume que a primeira coluna tem o ID do paciente
            System.out.println("ID do paciente a excluir: " + idPaciente);  // Debug

            String query = "DELETE FROM pacientes WHERE idPaciente = ?";

            // Chama o método do ConexaoDAO para executar a exclusão
            boolean sucesso = conexaoDAO.executarComandoSQL(query, idPaciente);
            
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso.");
                listarPacientes();  // Atualiza a lista de pacientes
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um paciente para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
private void listarPacientes() {
    try {
        String query = "SELECT * FROM pacientes";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement pst = conn.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) tablePacientes.getModel();
            model.setNumRows(0); // Limpa a tabela antes de adicionar novos dados

            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("idPaciente"),
                    rs.getString("nome"),
                    rs.getString("cpfDoDono"),
                    rs.getString("dataNascimento"),
                    rs.getString("telefoneDoDono"),
                    rs.getString("emailDoDono"),
                    rs.getString("sexo"),
                    rs.getString("especie"),
                    rs.getString("raca")
                };
                model.addRow(rowData);
            }
            model.fireTableDataChanged();
            tablePacientes.repaint(); // Atualiza a tabela
            tablePacientes.revalidate();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar os pacientes: " + e.getMessage());
    }
}
private void carregarCamposPaciente() {
    int selectedRow = tablePacientes.getSelectedRow();
    if (selectedRow != -1) {  // Se uma linha for selecionada
        // Pega os dados da linha selecionada e preenche os campos de texto
        int idPaciente = (int) tablePacientes.getValueAt(selectedRow, 0); // ID do paciente (geralmente está na primeira coluna)
        String nome = (String) tablePacientes.getValueAt(selectedRow, 1);
        String cpfDoDono = (String) tablePacientes.getValueAt(selectedRow, 2);
        String telefoneDoDono = (String) tablePacientes.getValueAt(selectedRow, 3);
        String emailDoDono = (String) tablePacientes.getValueAt(selectedRow, 4);
        String sexo = (String) tablePacientes.getValueAt(selectedRow, 5);
        String especie = (String) tablePacientes.getValueAt(selectedRow, 6);
        String raca = (String) tablePacientes.getValueAt(selectedRow, 7);
        String dataNascimento = (String) tablePacientes.getValueAt(selectedRow, 8);

        // Preenche os campos de texto
        txtNome.setText(nome);
        txtCpfDoDono.setText(cpfDoDono);
        txtTelefoneDoDono.setText(telefoneDoDono);
        txtEmailDoDono.setText(emailDoDono);
        txtSexoB.setText(sexo);
        txtEspecieB.setText(especie);
        txtRacaB.setText(raca);
        txtDataDeNascimento.setText(dataNascimento);

        // Armazena o ID do paciente para futura atualização
        int idPacienteSelecionado = idPaciente; // idPacienteSelecionado é uma variável global
    }
    tablePacientes.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent evt) {
        carregarCamposPaciente();
    }
});

}
private void limparCamposPaciente() {
    txtNome.setText(null);
    txtCpfDoDono.setText(null);
    txtDataDeNascimento.setText(null);
    txtTelefoneDoDono.setText(null);
    txtEmailDoDono.setText(null);
    txtSexoB.setText(null);
    txtEspecieB.setText(null);
    txtRacaB.setText(null);
    txtNome.requestFocus();  
}
}
