/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant;

import br.com.jonjts.assistant.control.DadosBioquimicosControl;
import br.com.jonjts.assistant.control.ExameClinicoControle;
import br.com.jonjts.assistant.control.ExamesBioquimicosExtrasControl;
import br.com.jonjts.assistant.entity.DadosBioquimicos;
import br.com.jonjts.assistant.entity.ExameClinico;
import br.com.jonjts.assistant.entity.Paciente;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas
 */
public class CompararDadosBioquimicos extends javax.swing.JFrame {

    private ExameClinicoControle exameClinicoControle = new ExameClinicoControle();
    private DadosBioquimicosControl dadosBioquimicosControl = new DadosBioquimicosControl();
    private List<ExameClinico> allExameClinico1;
    private List<ExameClinico> allExameClinico2;
    private Paciente paciente;

    public CompararDadosBioquimicos() {
        initComponents();
    }
    
    public void loadcbExames(){
        loadCbExameClinico1();
        loadCbExameClinico2();
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
        setTitle(paciente.getNome());
        fieldsDadosBioquimicos1.setPaciente(paciente);
        fieldsDadosBioquimicos2.setPaciente(paciente);
    }
    
    
    private boolean existToday(List<ExameClinico> list) {
        for (ExameClinico e : list) {
            if (e.isToday()) {
                return true;
            }
        }
        return false;
    }

    private void loadCbExameClinico2() {
        try {
            allExameClinico2 = exameClinicoControle.get(paciente.getId());
            if (!existToday(allExameClinico2)) {
                ExameClinico ec = new ExameClinico();
                ec.setData(new Date());
                allExameClinico2.add(0, ec);
            }
            cbExame2.setModel(new DefaultComboBoxModel(allExameClinico2.toArray()));
            cbExame2.setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadCbExameClinico1() {
        try {
            allExameClinico1 = exameClinicoControle.get(paciente.getId());
            if (!existToday(allExameClinico1)) {
                ExameClinico ec = new ExameClinico();
                ec.setData(new Date());
                allExameClinico1.add(0, ec);
            }
            cbExame.setModel(new DefaultComboBoxModel(allExameClinico1.toArray()));
            cbExame.setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldsDadosBioquimicos1 = new br.com.jonjts.assistant.FieldsDadosBioquimicos();
        fieldsDadosBioquimicos2 = new br.com.jonjts.assistant.FieldsDadosBioquimicos2();
        cbExame = new javax.swing.JComboBox();
        cbExame2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cbExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExameActionPerformed(evt);
            }
        });

        cbExame2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExame2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldsDadosBioquimicos1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbExame, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldsDadosBioquimicos2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbExame2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldsDadosBioquimicos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbExame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbExame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldsDadosBioquimicos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExameActionPerformed
        try {
            ExameClinico selectedItem = (ExameClinico) cbExame.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                DadosBioquimicos get = dadosBioquimicosControl.get(selectedItem.getId());
                if (get != null) {
                    fieldsDadosBioquimicos1.loadData(get);
                } else {
                    fieldsDadosBioquimicos1.clearData();
                }
            } else {
                fieldsDadosBioquimicos1.clearData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Daos Bioquímicos");
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbExameActionPerformed

    private void cbExame2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExame2ActionPerformed
        try {
            ExameClinico selectedItem = (ExameClinico) cbExame2.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                DadosBioquimicos get = dadosBioquimicosControl.get(selectedItem.getId());
                if (get != null) {
                    fieldsDadosBioquimicos2.loadData(get);
                } else {
                    fieldsDadosBioquimicos2.clearData();
                }
            } else {
                fieldsDadosBioquimicos2.clearData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Daos Bioquímicos");
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbExame2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbExame;
    private javax.swing.JComboBox cbExame2;
    private transient br.com.jonjts.assistant.FieldsDadosBioquimicos fieldsDadosBioquimicos1;
    private transient br.com.jonjts.assistant.FieldsDadosBioquimicos2 fieldsDadosBioquimicos2;
    // End of variables declaration//GEN-END:variables
}
