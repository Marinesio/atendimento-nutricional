/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant;

import br.com.jonjts.assistant.entity.DadosBioquimicos;
import br.com.jonjts.assistant.entity.Paciente;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Jonas
 */
public class FieldsDadosBioquimicos2 extends javax.swing.JPanel {

    private Paciente paciente;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    private DecimalFormat decimalFormat = (DecimalFormat) numberFormat;

    public FieldsDadosBioquimicos2() {
        this.paciente = paciente;
        decimalFormat.setGroupingUsed(false);
        initComponents();
    }

    public void clearData() {
        txtColesterolTotal.setText("");
        txtCreatinina.setText("");
        txtFerretina.setText("");
        txtFerroSerico.setText("");
        txtGlicoseJejum.setText("");
        txtGlicosePosPrandial.setText("");
        txtHDL.setText("");
        txtHemacias.setText("");
        txtHematocrito.setText("");
        txtHemoglobina.setText("");
        txtLDL.setText("");
        txtPlaquetas.setText("");
        txtTGO.setText("");
        txtTGP.setText("");
        txtTriglicerideos.setText("");
        txtUreia.setText("");
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DadosBioquimicos getDadosBioquimicos() {
        DadosBioquimicos dadosBioquimicos = new DadosBioquimicos();
        final String colesterol = txtColesterolTotal.getText();
        dadosBioquimicos.setColesterolTotal(colesterol.isEmpty() ? null : Double.parseDouble(colesterol));
        final String creatinina = txtCreatinina.getText();
        dadosBioquimicos.setCreatinina(creatinina.isEmpty() ? null : Double.parseDouble(colesterol));
        final String ferretina = txtFerretina.getText();
        dadosBioquimicos.setFerritina(ferretina.isEmpty() ? null : Double.parseDouble(ferretina));
        final String ferroSerico = txtFerroSerico.getText();
        dadosBioquimicos.setFerroSerico(ferroSerico.isEmpty() ? null : Double.parseDouble(ferroSerico));
        final String glicoseJejum = txtGlicoseJejum.getText();
        dadosBioquimicos.setGlicoseJejum(glicoseJejum.isEmpty() ? null : Double.parseDouble(glicoseJejum));
        final String glicosePosPrandial = txtGlicosePosPrandial.getText();
        dadosBioquimicos.setGlicosePosPrandial(glicosePosPrandial.isEmpty() ? null : Double.parseDouble(glicosePosPrandial));
        final String hdl = txtHDL.getText();
        dadosBioquimicos.setHdl(hdl.isEmpty() ? null : Double.parseDouble(hdl));
        final String hemacias = txtHemacias.getText();
        dadosBioquimicos.setHemacias(hemacias.isEmpty() ? null : Double.parseDouble(hemacias));
        final String hematocrito = txtHematocrito.getText();
        dadosBioquimicos.setHematrocito(hematocrito.isEmpty() ? null : Double.parseDouble(hematocrito));
        final String hemogrobina = this.txtHemoglobina.getText();
        dadosBioquimicos.setHemogrobina(hemogrobina.isEmpty() ? null : Double.parseDouble(hemogrobina));
        final String ldl = txtLDL.getText();
        dadosBioquimicos.setLdl(ldl.isEmpty() ? null : Double.parseDouble(ldl));
        final String plaquetas = txtPlaquetas.getText();
        dadosBioquimicos.setPlaquetas(plaquetas.isEmpty() ? null : Double.parseDouble(plaquetas));
        final String tgo = txtTGO.getText();
        dadosBioquimicos.setTgo(tgo.isEmpty() ? null : Double.parseDouble(tgo));
        final String tgp = txtTGP.getText();
        dadosBioquimicos.setTgp(tgp.isEmpty() ? null : Double.parseDouble(tgp));
        final String triglicerideos = txtTriglicerideos.getText();
        dadosBioquimicos.setTriglicerideos(triglicerideos.isEmpty() ? null : Double.parseDouble(triglicerideos));
        final String ureia = txtUreia.getText();
        dadosBioquimicos.setUreia(ureia.isEmpty() ? null : Double.parseDouble(ureia));
        return dadosBioquimicos;
    }

    public void loadData(DadosBioquimicos dadosBioquimicos) {
        final Double colesterolTotal = dadosBioquimicos.getColesterolTotal();
        txtColesterolTotal.setText(colesterolTotal == null ? "" : colesterolTotal + "");
        final Double creatinina = dadosBioquimicos.getCreatinina();
        txtCreatinina.setText(creatinina == null ? "" : creatinina + "");
        final Double ferritina = dadosBioquimicos.getFerritina();
        txtFerretina.setText(ferritina == null ? "" : ferritina + "");
        final Double ferroSerico = dadosBioquimicos.getFerroSerico();
        txtFerroSerico.setText(ferroSerico == null ? "" : ferroSerico + "");
        final Double glicoseJejum = dadosBioquimicos.getGlicoseJejum();
        txtGlicoseJejum.setText(glicoseJejum == null ? "" : glicoseJejum + "");
        final Double glicosePosPrandial = dadosBioquimicos.getGlicosePosPrandial();
        txtGlicosePosPrandial.setText(glicosePosPrandial == null ? "" : glicoseJejum + "");
        final Double hdl = dadosBioquimicos.getHdl();
        txtHDL.setText(hdl == null ? "" : hdl + "");
        final Double hemacias = dadosBioquimicos.getHemacias();
        txtHemacias.setText(hemacias == null ? "" : hemacias + "");
        final Double hematrocito = dadosBioquimicos.getHematrocito();
        txtHematocrito.setText(hemacias == null ? "" : hematrocito + "");
        final Double hemogrobina = dadosBioquimicos.getHemogrobina();
        txtHemoglobina.setText(hemogrobina == null ? "" : hemogrobina + "");
        final Double ldl = dadosBioquimicos.getLdl();
        txtLDL.setText(ldl == null ? "" : ldl + "");
        final Double plaquetas = dadosBioquimicos.getPlaquetas();
        txtPlaquetas.setText(plaquetas == null ? "" : plaquetas + "");
        final Double tgo = dadosBioquimicos.getTgo();
        txtTGO.setText(tgo == null ? "" : tgo + "");
        final Double tgp = dadosBioquimicos.getTgp();
        txtTGP.setText(tgp == null ? "" : tgp + "");
        final Double triglicerideos = dadosBioquimicos.getTriglicerideos();
        txtTriglicerideos.setText(triglicerideos == null ? "" : triglicerideos + "");
        final Double ureia = dadosBioquimicos.getUreia();
        txtUreia.setText(ureia == null ? "" : ureia + "");

        checkEveryBody();
    }

    private void checkEveryBody() {
        checkColesterolTotal();
        checkCreatina();
        checkFerritina();
        checkFerroSerico();
        checkGlicoseJejum();
        checkGlicosePos();
        checkHDL();
        checkHemacias();
        checkHemaglobina();
        checkHematrocrito();
        checkLdl();
        checkPlaquetas();
        checkTGO();
        checkTGP();
        checkTriglicerideos();
        checkUreia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtPlaquetas = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel41 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        try {
            txtColesterolTotal =(javax.swing.JFormattedTextField)java.beans.Beans.instantiate(getClass().getClassLoader(), "br/com/jonjts/assistant.FieldsDadosBioquimicos_txtColesterolTotal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        txtTGO = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel10 = new javax.swing.JLabel();
        txtLDL = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel12 = new javax.swing.JLabel();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setGroupingUsed(false);
        txtHemoglobina = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel2 = new javax.swing.JLabel();
        txtHematocrito = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel4 = new javax.swing.JLabel();

        txtHemacias = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtTGP = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel48 = new javax.swing.JLabel();
        txtHDL = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel49 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTriglicerideos = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel16 = new javax.swing.JLabel();
        txtGlicosePosPrandial = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel18 = new javax.swing.JLabel();
        txtGlicoseJejum = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel20 = new javax.swing.JLabel();
        txtFerroSerico = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel22 = new javax.swing.JLabel();
        txtFerretina = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel24 = new javax.swing.JLabel();
        txtUreia = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel26 = new javax.swing.JLabel();
        txtCreatinina = new javax.swing.JFormattedTextField(decimalFormat);
        jLabel28 = new javax.swing.JLabel();

        jLabel29.setText("12.0 a 18,0 g/dL");
        jLabel29.setToolTipText("12.0 a 18,0 g/dL");

        jLabel30.setText("37% a 52%");
        jLabel30.setToolTipText("37 a 52%");

        jLabel31.setText("Homens adultos: 4,6 a 6,2 milhões; Mulheres adultas: 4,2 a 5,4 milhões; Crianças: 3,8 a 5,5 milhões");
        jLabel31.setToolTipText("Homens adultos: 4.6 a 6.2 milhões\nMulheres adultas: 4.2 a 5.4 milhões\nCrianças: 3.8 a 5.5 milhões");

        jLabel32.setText("150.000 a 450.000 mm³");
        jLabel32.setToolTipText("150.000 a 450.000 mm³");

        jLabel33.setText("Desejável: < 200  mg/dL alto risco: > 240  mg/dL");
        jLabel33.setToolTipText("Desejável: < 200  mg/dL alto risco: > 240  mg/dL");

        jLabel34.setText("Desejável: < 130  mg/dL alto risco: > 160  mg/dL");
        jLabel34.setToolTipText("Desejável: < 130  mg/dL alto risco: > 160  mg/dL");

        jLabel35.setText("Fator de risco: <35  mg/dL fator de risco  negativo: > 60  mg/dL");
        jLabel35.setToolTipText("Fator de risco: <35  mg/dL fator de risco  negativo: > 60  mg/dL");

        jLabel36.setText("Desejável: < 200  mg/dL alto risco: > 400  mg/dL");
        jLabel36.setToolTipText("Desejável: < 200  mg/dL alto risco: > 400  mg/dL");

        jLabel37.setText("70 a 99 mg/dL");
        jLabel37.setToolTipText("70 a 99 mg/dL");

        jLabel38.setText("< 180mg/dL");
        jLabel38.setToolTipText("< 145mg/dL");

        jLabel6.setText("milhões");

        jLabel39.setText("40-160 ug/dL");
        jLabel39.setToolTipText("40-160 ug/dL");

        jLabel40.setText("Mulheres: 6-159  ng/ml; Homens: 28-397  ng/ml");
        jLabel40.setToolTipText("Mulheres: 6-159  ng/ml; Homens: 28-397  ng/ml");

        txtPlaquetas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPlaquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlaquetasActionPerformed(evt);
            }
        });
        txtPlaquetas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPlaquetasKeyReleased(evt);
            }
        });

        jLabel41.setText("15 a 56  mg/dL");
        jLabel41.setToolTipText("15 a 56  mg/dL");

        jLabel8.setText("mm³");

        jLabel42.setText("Mulher: 0,57 a 1,11 mg/dL Homem: 0,62 a 1,25  mg/dL");
        jLabel42.setToolTipText("Mulher: 0,57 a 1,11 mg/dL Homem: 0,62 a 1,25  mg/dL");

        txtColesterolTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtColesterolTotalKeyReleased(evt);
            }
        });

        txtTGO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTGO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTGOKeyReleased(evt);
            }
        });

        jLabel10.setText("mg/dl");

        txtLDL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLDL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLDLKeyReleased(evt);
            }
        });

        jLabel12.setText("mg/dL");

        txtHemoglobina.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHemoglobina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHemoglobinaKeyReleased(evt);
            }
        });

        jLabel2.setText("g/dL");

        txtHematocrito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHematocrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHematocritoKeyReleased(evt);
            }
        });

        jLabel4.setText("%");

        txtHemacias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHemacias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHemaciasKeyReleased(evt);
            }
        });

        jLabel45.setText("U/L");

        jLabel46.setText("38 U/L");

        txtTGP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTGP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTGPKeyReleased(evt);
            }
        });

        jLabel48.setText("U/L");

        txtHDL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtHDL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHDLKeyReleased(evt);
            }
        });

        jLabel49.setText("41 U/L");

        jLabel14.setText("mg/dL");

        txtTriglicerideos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTriglicerideos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTriglicerideosKeyReleased(evt);
            }
        });

        jLabel16.setText("mg/dL");

        txtGlicosePosPrandial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGlicosePosPrandial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGlicosePosPrandialKeyReleased(evt);
            }
        });

        jLabel18.setText("mg/dL");

        txtGlicoseJejum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGlicoseJejum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGlicoseJejumKeyReleased(evt);
            }
        });

        jLabel20.setText("mg/dL");

        txtFerroSerico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFerroSerico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFerroSericoKeyReleased(evt);
            }
        });

        jLabel22.setText("ug/dL");

        txtFerretina.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFerretina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFerretinaKeyReleased(evt);
            }
        });

        jLabel24.setText("ng/ml");

        txtUreia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUreia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUreiaKeyReleased(evt);
            }
        });

        jLabel26.setText("mg/dL");

        txtCreatinina.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCreatinina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCreatininaKeyReleased(evt);
            }
        });

        jLabel28.setText("mg/dL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTGO, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTGP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel48)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel46))
                        .addGap(277, 277, 277))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtHemoglobina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtHematocrito, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel30)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtHemacias, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtPlaquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtColesterolTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCreatinina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel28))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtUreia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel26))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtFerretina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel24))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtGlicoseJejum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel18))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtFerroSerico, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtGlicosePosPrandial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel20))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtTriglicerideos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel16))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtHDL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtLDL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40))
                                .addComponent(jLabel41)
                                .addComponent(jLabel42)))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHemoglobina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel29))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHematocrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHemacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel31))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColesterolTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTriglicerideos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGlicoseJejum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGlicosePosPrandial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFerroSerico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFerretina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUreia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreatinina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlaquetasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlaquetasKeyReleased
        checkPlaquetas();
    }//GEN-LAST:event_txtPlaquetasKeyReleased

    private void txtColesterolTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColesterolTotalKeyReleased
        checkColesterolTotal();
    }//GEN-LAST:event_txtColesterolTotalKeyReleased

    private void txtTGOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTGOKeyReleased
        checkTGO();
    }//GEN-LAST:event_txtTGOKeyReleased

    private void txtLDLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLDLKeyReleased
        checkLdl();
    }//GEN-LAST:event_txtLDLKeyReleased

    private void txtHemoglobinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHemoglobinaKeyReleased
        checkHemaglobina();
    }//GEN-LAST:event_txtHemoglobinaKeyReleased

    private void txtHematocritoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHematocritoKeyReleased
        checkHematrocrito();
    }//GEN-LAST:event_txtHematocritoKeyReleased

    private void txtHemaciasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHemaciasKeyReleased
        checkHemacias();
    }//GEN-LAST:event_txtHemaciasKeyReleased

    private void txtTGPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTGPKeyReleased
        checkTGP();
    }//GEN-LAST:event_txtTGPKeyReleased

    private void txtHDLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHDLKeyReleased
        checkHDL();
    }//GEN-LAST:event_txtHDLKeyReleased

    private void txtTriglicerideosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTriglicerideosKeyReleased
        checkTriglicerideos();
    }//GEN-LAST:event_txtTriglicerideosKeyReleased

    private void txtGlicosePosPrandialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGlicosePosPrandialKeyReleased
        checkGlicosePos();
    }//GEN-LAST:event_txtGlicosePosPrandialKeyReleased

    private void txtGlicoseJejumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGlicoseJejumKeyReleased
        checkGlicoseJejum();
    }//GEN-LAST:event_txtGlicoseJejumKeyReleased

    private void txtFerroSericoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFerroSericoKeyReleased
        checkFerroSerico();
    }//GEN-LAST:event_txtFerroSericoKeyReleased

    private void txtFerretinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFerretinaKeyReleased
        checkFerritina();
    }//GEN-LAST:event_txtFerretinaKeyReleased

    private void txtUreiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUreiaKeyReleased
        checkUreia();
    }//GEN-LAST:event_txtUreiaKeyReleased

    private void txtCreatininaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreatininaKeyReleased
        checkCreatina();
    }//GEN-LAST:event_txtCreatininaKeyReleased

    private void txtPlaquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlaquetasActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_txtPlaquetasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private static transient volatile javax.swing.JFormattedTextField txtColesterolTotal;
    private javax.swing.JFormattedTextField txtCreatinina;
    private javax.swing.JFormattedTextField txtFerretina;
    private javax.swing.JFormattedTextField txtFerroSerico;
    private javax.swing.JFormattedTextField txtGlicoseJejum;
    private javax.swing.JFormattedTextField txtGlicosePosPrandial;
    private javax.swing.JFormattedTextField txtHDL;
    private javax.swing.JFormattedTextField txtHemacias;
    private javax.swing.JFormattedTextField txtHematocrito;
    private javax.swing.JFormattedTextField txtHemoglobina;
    private javax.swing.JFormattedTextField txtLDL;
    private javax.swing.JFormattedTextField txtPlaquetas;
    private javax.swing.JFormattedTextField txtTGO;
    private javax.swing.JFormattedTextField txtTGP;
    private javax.swing.JFormattedTextField txtTriglicerideos;
    private javax.swing.JFormattedTextField txtUreia;
    // End of variables declaration//GEN-END:variables

    private void checkHematrocrito() {
        String text = txtHematocrito.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble >= 37 && parseDouble <= 52) {
                txtHematocrito.setForeground(Color.black);
            } else {
                txtHematocrito.setForeground(Color.RED);
            }
        } else {
            txtHematocrito.setForeground(Color.black);
        }
    }

    private void checkHemacias() {
        String text = txtHemacias.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (isGuri()) {
                if (parseDouble >= 3.8 && parseDouble <= 5.5) {
                    txtHemacias.setForeground(Color.black);
                } else {
                    txtHemacias.setForeground(Color.red);
                }
            } else {
                if (isMacho()) {
                    if (parseDouble >= 4.6 && parseDouble <= 6.2) {
                        txtHemacias.setForeground(Color.black);
                    } else {
                        txtHemacias.setForeground(Color.red);
                    }
                } else {
                    if (parseDouble >= 4.2 && parseDouble <= 5.4) {
                        txtHemacias.setForeground(Color.black);
                    } else {
                        txtHemacias.setForeground(Color.red);
                    }
                }
            }
        } else {
            txtHemacias.setForeground(Color.black);
        }
    }

    private void checkHemaglobina() {
        String text = txtHemoglobina.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble >= 12 && parseDouble <= 18) {
                txtHemoglobina.setForeground(Color.black);
            } else {
                txtHemoglobina.setForeground(Color.red);
            }
        } else {
            txtHematocrito.setForeground(Color.black);
        }
    }

    private void checkPlaquetas() {
        String text = txtPlaquetas.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble >= 150.000 && parseDouble <= 450.000) {
                txtPlaquetas.setForeground(Color.black);
            } else {
                txtPlaquetas.setForeground(Color.red);
            }
        } else {
            txtPlaquetas.setForeground(Color.black);
        }
    }

    private void checkFerritina() {
        String text = txtFerretina.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (isMacho()) {
                if (parseDouble >= 29 && parseDouble <= 397) {
                    txtFerretina.setForeground(Color.black);
                } else {
                    txtFerretina.setForeground(Color.red);
                }
            } else {
                if (parseDouble >= 6 && parseDouble <= 159) {
                    txtFerretina.setForeground(Color.black);
                } else {
                    txtFerretina.setForeground(Color.red);
                }
            }
        } else {
            txtFerretina.setForeground(Color.black);
        }
    }

    private void checkFerroSerico() {
        final String text = txtFerroSerico.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble >= 40 && parseDouble <= 160) {
                txtFerroSerico.setForeground(Color.black);
            } else {
                txtFerroSerico.setForeground(Color.red);
            }
        } else {
            txtFerroSerico.setForeground(Color.black);
        }
    }

    private void checkColesterolTotal() {
        String text = txtColesterolTotal.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble < 200) {
                txtColesterolTotal.setForeground(Color.black);
            } else if (parseDouble > 240) {
                txtColesterolTotal.setForeground(Color.red);
            } else {
                txtColesterolTotal.setForeground(Color.blue);
            }
        } else {
            txtColesterolTotal.setForeground(Color.black);
        }
    }

    private void checkLdl() {
        String text = txtLDL.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble < 130) {
                txtLDL.setForeground(Color.black);
            } else if (parseDouble > 160) {
                txtLDL.setForeground(Color.red);
            } else {
                txtLDL.setForeground(Color.blue);
            }
        } else {
            txtLDL.setForeground(Color.black);
        }
    }

    private void checkHDL() {
        String text = txtHDL.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble <= 34 || parseDouble >= 60) {
                txtHDL.setForeground(Color.red);
            } else if (parseDouble == 0) {
                txtHDL.setForeground(Color.BLACK);
            } else {
                txtHDL.setForeground(Color.black);
            }
        } else {
            txtHDL.setForeground(Color.BLACK);
        }
    }

    private void checkGlicoseJejum() {
        String text = txtGlicoseJejum.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble >= 70 && parseDouble <= 99) {
                txtGlicoseJejum.setForeground(Color.black);
            } else if (parseDouble == 0) {
                txtGlicoseJejum.setForeground(Color.black);
            } else {
                txtGlicoseJejum.setForeground(Color.red);
            }
        } else {
            txtGlicoseJejum.setForeground(Color.black);
        }
    }

    private void checkTriglicerideos() {
        String text = txtTriglicerideos.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble < 200) {
                txtTriglicerideos.setForeground(Color.black);
            } else if (parseDouble > 400) {
                txtTriglicerideos.setForeground(Color.red);
            } else {
                txtTriglicerideos.setForeground(Color.blue);
            }
        } else {
            txtTriglicerideos.setForeground(Color.black);
        }
    }

    private void checkGlicosePos() {
        String text = txtGlicosePosPrandial.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble < 180) {
                txtGlicosePosPrandial.setForeground(Color.black);
            } else {
                txtGlicosePosPrandial.setForeground(Color.red);
            }
        } else {
            txtGlicosePosPrandial.setForeground(Color.black);
        }
    }

    private void checkUreia() {
        String text = txtUreia.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble >= 15 && parseDouble <= 56) {
                txtUreia.setForeground(Color.black);
            } else {
                txtUreia.setForeground(Color.red);
            }
        } else {
            txtUreia.setForeground(Color.black);
        }
    }

    private void checkCreatina() {
        String text = txtCreatinina.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (isMacho()) {
                if (parseDouble >= 0.62 && parseDouble <= 1.25) {
                    txtCreatinina.setForeground(Color.black);
                } else {
                    txtCreatinina.setForeground(Color.red);
                }
            } else {
                if (parseDouble >= 0.57 && parseDouble <= 1.11) {
                    txtCreatinina.setForeground(Color.black);
                } else {
                    txtCreatinina.setForeground(Color.red);
                }
            }
        } else {
            txtCreatinina.setForeground(Color.black);
        }
    }

    private void checkTGO() {
        String text = txtTGO.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble == 38) {
                txtTGO.setForeground(Color.black);
            } else {
                txtTGO.setForeground(Color.red);
            }
        } else {
            txtTGO.setForeground(Color.black);
        }
    }

    private void checkTGP() {
        String text = txtTGP.getText();
        if (!text.isEmpty()) {
            double parseDouble = Double.parseDouble(text);
            if (parseDouble == 41) {
                txtTGP.setForeground(Color.black);
            } else {
                txtTGP.setForeground(Color.red);
            }
        } else {
            txtTGP.setForeground(Color.black);
        }
    }

    private boolean isGuri() {
        try {
            Date dt = paciente.getDataNascimento();
            String format = sdf.format(dt);
            Date parse = sdf.parse(format);
            Date date = new Date();

            int yearP = parse.getYear();
            int year = date.getYear();

            int idade = year - yearP;

            parse.setYear(date.getYear());
            if (!parse.before(date)) {
                idade -= 1;
            }
            return idade <= 12;
        } catch (ParseException ex) {
            Logger.getLogger(DadosBioquimicosTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean isMacho() {
        String sexo = paciente.getSexo();
        return sexo.charAt(0) == 'M';
    }

}
