/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant;

import br.com.jonjts.assistant.control.ExameClinicoControle;
import br.com.jonjts.assistant.control.PacienteControle;
import br.com.jonjts.assistant.entity.ExameClinico;
import br.com.jonjts.assistant.persistence.DAO;
import br.com.jonjts.assistant.entity.Paciente;
import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jonas
 */
public class Main extends Tamplate {

    private PacienteControle pacienteBO = new PacienteControle();

    /**
     * Creates new form Main
     */
    public Main() {
        super();
        initComponents();
        fixLayout();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                onClose();
            }
        });
        fixLayoutTable();
        try {
            popularTabela(pacienteBO.getAll());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void onClose() throws HeadlessException {
        if (JOptionPane.showConfirmDialog(null, "Deseja fechar " + getTitle() + "?") == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    protected void fixLayout() {
        super.fixLayout(); //To change body of generated methods, choose Tools | Templates.
        setTitle("Assistant");
        setSize(912, 653);
        //setResizable(false);
    }

    private void fixLayoutTable() {
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tbPacientes.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
        //tbPacientes.getColumnModel().getColumn(3).setCellRenderer(leftRenderer);
        //tbPacientes.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbPacientes.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tbPacientes.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tbPacientes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        tbPacientes.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbPacientes.getColumnModel().getColumn(2).setPreferredWidth(15);
        tbPacientes.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbPacientes.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        tbPacientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Object valueAt = tbPacientes.getValueAt(tbPacientes.getSelectedRow(), 0);
                    callNovoPaciente(valueAt);
                }
                btnExcluir.setEnabled(true);
            }
        });

    }

    protected void popularTabela(List<Paciente> list) {
        DefaultTableModel model = (DefaultTableModel) tbPacientes.getModel();
        tbPacientes.getColumnModel().getColumn(0).setWidth(10);
        model.fireTableDataChanged();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        ExameClinicoControle clinicoControle = new ExameClinicoControle();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Paciente p : list) {
            try {
                String idade = p.getDataNascimento() == null ? "" : getIdade(p) + "";
                ExameClinico lastConsulta = clinicoControle.getLastConsulta(p.getId());
                String data = "";
                if (lastConsulta != null) {
                    data = sdf.format(lastConsulta.getData());
                    data = lastConsulta.isToday() ? "Hoje" : data;
                }
                model.addRow(new Object[]{p.getId(), p.getNome(), idade, p.getSexo(), data});
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private int getIdade(Paciente paciente) {
        Date parse = paciente.getDataNascimento();
        Date date = new Date();
        int yearP = parse.getYear();
        int year = date.getYear();
        int idade = year - yearP;
        parse.setYear(date.getYear());
        if (!parse.before(date)) {
            idade -= 1;
        }
        return idade;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPacientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNovoPaciente = new javax.swing.JButton();
        btnCarregarPaciente = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        mbAssistant = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(731, 360));
        setPreferredSize(new java.awt.Dimension(800, 600));

        tbPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nome", "Idade", "Sexo", "Última Consulta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPacientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tbPacientesMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(tbPacientes);

        jLabel1.setText("Pacientes");

        btnNovoPaciente.setText("Novo Paciente");
        btnNovoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPacienteActionPerformed(evt);
            }
        });

        btnCarregarPaciente.setText("Carregar Paciente");
        btnCarregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarPacienteActionPerformed(evt);
            }
        });

        txtPesquisa.setToolTipText("Pesuisar Paciente");
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel2.setText("Pesquisar por nome");

        btnExcluir.setText("Excluir Paciente");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jMenu1.setText("Paciente");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Restaurar Paciente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mbAssistant.add(jMenu1);

        jMenu2.setText("Avançado");

        jMenuItem4.setText("Fazer Backup");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Restaurar Backup");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        mbAssistant.add(jMenu2);

        setJMenuBar(mbAssistant);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCarregarPaciente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarregarPaciente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPacienteActionPerformed
        NovoPaciente novoPaciente = new NovoPaciente(null, Main.this);
        novoPaciente.setVisible(true);
    }//GEN-LAST:event_btnNovoPacienteActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        btnExcluir.setEnabled(false);
        search();
    }

    protected void search() {
        try {
            List<Paciente> searchByName = pacienteBO.searchByName(txtPesquisa.getText());
            popularTabela(searchByName);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnCarregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarPacienteActionPerformed
        if (tbPacientes.getSelectedColumnCount() == 1) {
            Object valueAt = tbPacientes.getValueAt(tbPacientes.getSelectedRow(), 0);
            callNovoPaciente(valueAt);
        }
    }

    protected void callNovoPaciente(Object valueAt) {
        try {
            Paciente p = pacienteBO.get((Long) valueAt);
            NovoPaciente novoPaciente = new NovoPaciente(p, this);
            novoPaciente.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnCarregarPacienteActionPerformed

    private void tbPacientesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPacientesMouseDragged

    }//GEN-LAST:event_tbPacientesMouseDragged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        onSelectedExcluir();
    }

    protected void onSelectedExcluir() throws HeadlessException {
        int[] selectedRows = tbPacientes.getSelectedRows();
        if (JOptionPane.showConfirmDialog(null, "Deseja remover " + selectedRows.length + " paciente(s)?") == JOptionPane.OK_OPTION) {
            for (int i = 0; i < selectedRows.length; i++) {
                try {
                    Long valueAt = (Long) tbPacientes.getValueAt(selectedRows[i], 0);
                    pacienteBO.delete(valueAt.longValue());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir paciente");
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            btnExcluir.setEnabled(false);
            search();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RestorePacienteTela pacienteTela = new RestorePacienteTela(this);
        pacienteTela.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        BackupTela backupTela = new BackupTela(this);
        backupTela.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        RestaurarTela restaurarTela = new RestaurarTela(this);
        restaurarTela.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public JButton getBtnCarregarPaciente() {
        return btnCarregarPaciente;
    }

    public JButton getBtnNovoPaciente() {
        return btnNovoPaciente;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JTable getTbPacientes() {
        return tbPacientes;
    }

    public PacienteControle getPacienteBO() {
        return pacienteBO;
    }

    public JMenuBar getMbAssistant() {
        return mbAssistant;
    }

    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarPaciente;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovoPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar mbAssistant;
    private javax.swing.JTable tbPacientes;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
