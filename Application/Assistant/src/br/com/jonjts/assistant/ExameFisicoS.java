/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant;

import br.com.jonjts.assistant.dto.ExameFisico;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas
 */
public class ExameFisicoS extends javax.swing.JFrame {

    private ExameFisico exameFisico;
    private NovoPaciente novoPaciente;

    public ExameFisicoS(NovoPaciente novoPaciente) {
        this.novoPaciente = novoPaciente;
        initComponents();
    }

    public void carregarExameFisico() {
        txtCabelo.setText(exameFisico.getCabelo() == null ? "" : exameFisico.getCabelo());
        txtEdemas.setText(exameFisico.getEdemas() == null ? "" : exameFisico.getEdemas());
        txtHidratacao.setText(exameFisico.getHidratacao() == null ? "" : exameFisico.getHidratacao());
        txtUnhas.setText(exameFisico.getUnhas() == null ? "" : exameFisico.getUnhas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEdemas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCabelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnhas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHidratacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Edemas:");

        jLabel2.setText("Cabelo:");

        jLabel3.setText("Unhas:");

        jLabel4.setText("Hidratação:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdemas, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(txtCabelo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnhas)
                            .addComponent(txtHidratacao))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtEdemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCabelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUnhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHidratacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void save() {
        if (exameFisico == null) {
            exameFisico = new ExameFisico();
            insertExameFisico();
        } else {
            updateExameFisico();
        }
    }

    private void updateExameFisico() {
        try {
            preencherExameFisico();
            novoPaciente.updateExameFisico(exameFisico);
            JOptionPane.showMessageDialog(null, "Salvo");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao Salvar Exame Fisico");
        }
    }

    private void insertExameFisico() {
        try {
            exameFisico = new ExameFisico();
            preencherExameFisico();
            exameFisico = novoPaciente.saveExameFisico(exameFisico);
            JOptionPane.showMessageDialog(null, "Salvo");
        } catch (Exception ex) {
            ex.printStackTrace();
            exameFisico = null;
            JOptionPane.showMessageDialog(null, "Falha ao Salvar Exame Fisico");
        }
    }

    private void preencherExameFisico() {
        exameFisico.setCabelo(txtCabelo.getText());
        exameFisico.setEdemas(txtEdemas.getText());
        exameFisico.setHidratacao(txtHidratacao.getText());
        exameFisico.setUnhas(txtUnhas.getText());
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void limparTudoNessaPorra(){
        txtCabelo.setText("");
        txtEdemas.setText("");
        txtHidratacao.setText("");
        txtUnhas.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCabelo;
    private javax.swing.JTextField txtEdemas;
    private javax.swing.JTextField txtHidratacao;
    private javax.swing.JTextField txtUnhas;
    // End of variables declaration//GEN-END:variables
}
