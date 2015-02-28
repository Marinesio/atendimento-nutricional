/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant;

import br.com.jonjts.assistant.controle.ExameClinicoControle;
import br.com.jonjts.assistant.controle.ExameFisicoControle;
import br.com.jonjts.assistant.controle.HistoricoClinicoControle;
import br.com.jonjts.assistant.controle.PacienteControle;
import br.com.jonjts.assistant.dto.ExameClinico;
import br.com.jonjts.assistant.dto.ExameFisico;
import br.com.jonjts.assistant.dto.HistoricoClinico;
import br.com.jonjts.assistant.dto.Paciente;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Jonas
 */
public class NovoPaciente extends Tamplate {

    private Paciente paciente;
    private HistoricoClinico historicoClinico;
    private Main main;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHM = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private ExameFisicoTela exameFisicoS;
    private DadosDieteticosTela dadosDieteticosTela;
    //BOs
    private PacienteControle pacienteBO = new PacienteControle();
    private HistoricoClinicoControle historicoClinicoBO = new HistoricoClinicoControle();
    private ExameClinicoControle exameClinicoBO = new ExameClinicoControle();
    private ExameFisicoControle exameFisicoBO = new ExameFisicoControle();
    private List<ExameClinico> allExameClinico;

    /**
     * Creates new form NovoPaciente
     *
     * @param paciente
     * @param main
     */
    public NovoPaciente(Paciente paciente, Main main) {
        this.paciente = paciente;
        this.main = main;
        initComponents();
        fixLayout();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                if (JOptionPane.showConfirmDialog(null, "Deseja fechar " + getTitle() + "?") == JOptionPane.OK_OPTION) {
                    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });

        prepareTabPaciente();
        disableAllItemHistoricoClinico();

        if (paciente != null) {
            loadAllInformations();
            loadCbExameClinico();
        } else {
            disableTabs();
        }
        loadExameFisico();
    }

    private boolean existToday(List<ExameClinico> list) {
        for (ExameClinico e : list) {
            if (e.isToday()) {
                return true;
            }
        }
        return false;
    }

    private void loadCbExameClinico() {
        try {
            allExameClinico = exameClinicoBO.get(paciente.getId());
            if (!existToday(allExameClinico)) {
                ExameClinico ec = new ExameClinico();
                ec.setData(new Date());
                allExameClinico.add(0, ec);
            }
            cbExameClinico.setModel(new DefaultComboBoxModel(allExameClinico.toArray()));
        } catch (Exception ex) {
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadHistoricoClinico() {
        try {
            historicoClinico = historicoClinicoBO.get(paciente.getId());
            if (historicoClinico != null) {
                atencedentesFamiliares = historicoClinico.getAtencedentesFamiliares();
                txtAtencedentesFamilares.setText(atencedentesFamiliares == null ? "" : atencedentesFamiliares);

                atencedentesPatologicos = historicoClinico.getAtencedentesPatologicos();
                txtAtencedentesPatologicos.setText(atencedentesPatologicos == null ? "" : atencedentesPatologicos);

                doencaAtual = historicoClinico.getDoencaAtual();
                txtDoencaAtual.setText(doencaAtual == null ? "" : doencaAtual);

                try {
                    if (historicoClinico.getEtilismo().equals("Sim")) {
                        enableEtilismo();
                        cbEtilismo.setSelectedIndex(0);
                        txtTempoEtilismo.setText(historicoClinico.getTempoEtilismo());
                        txtFrequenciaEtilismo.setText(historicoClinico.getFrequenciaEtilismo());
                    }
                } catch (Exception e) {
                }
                try {
                    if (historicoClinico.getTabagismo().equals("Sim")) {
                        enableTabagismo();
                        cbTabagismo.setSelectedIndex(0);
                        txtTempoTabagismo.setText(historicoClinico.getTempoTabagismo());
                        txtFrequenciaTabagismo.setText(historicoClinico.getFrequenciaTabagismo());
                    }
                } catch (Exception e) {
                }
                try {
                    if (historicoClinico.getExercicioFisico().equals("Sim")) {
                        enableExercicioFisico();
                        cbExercicioFisico.setSelectedIndex(0);
                        txtTempoExercicioFisico.setText(historicoClinico.getTempoExercicioFisico());
                        txtFrequenciaExercicioFisico.setText(historicoClinico.getFrequenciaExercicioFisico());
                    }
                } catch (Exception e) {
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar historico clinico");
        }
    }
    private String doencaAtual;
    private String atencedentesPatologicos;
    private String atencedentesFamiliares;

    private void enableEtilismo() {
        txtTempoEtilismo.setEnabled(true);
        txtFrequenciaEtilismo.setEnabled(true);
    }

    private void enableTabagismo() {
        txtTempoTabagismo.setEnabled(true);
        txtFrequenciaTabagismo.setEnabled(true);
    }

    private void enableExercicioFisico() {
        txtFrequenciaExercicioFisico.setEnabled(true);
        txtTempoExercicioFisico.setEnabled(true);
    }

    private void disableAllItemHistoricoClinico() {
        disableEtilismo();
        disableExercicioFisico();
        disableTabagismo();
    }

    private void disableEtilismo() {
        txtTempoEtilismo.setEnabled(false);
        txtFrequenciaEtilismo.setEnabled(false);
    }

    private void disableTabagismo() {
        txtTempoTabagismo.setEnabled(false);
        txtFrequenciaTabagismo.setEnabled(false);
    }

    private void disableExercicioFisico() {
        txtFrequenciaExercicioFisico.setEnabled(false);
        txtTempoExercicioFisico.setEnabled(false);
    }

    private void enableTabs() {
        for (int i = 1; i < tbpPaciente.getTabCount(); i++) {
            tbpPaciente.setEnabledAt(i, true);
        }
    }

    private void disableTabs() {
        for (int i = 1; i < tbpPaciente.getTabCount(); i++) {
            tbpPaciente.setEnabledAt(i, false);
        }
    }

    private void loadAllInformations() {
        loadPaciente();
        loadHistoricoClinico();
        //loadExameFisico();
    }

    private void loadExameFisico() {
        try {
            ExameClinico selectedItem = (ExameClinico) cbExameClinico.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                ExameFisico get = exameFisicoBO.get(selectedItem.getId());
                if (get != null) {
                    exameFisicoS.setExameFisico(get);
                    exameFisicoS.carregarExameFisico();
                } else {
                    limparTelaExameFisico();
                }
            } else {
                limparTelaExameFisico();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Exame Fisico");
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparTelaExameFisico() {
        exameFisicoS.setExameFisico(null);
        exameFisicoS.limparTudoNessaPorra();
    }

    private void loadPaciente() {
        txtNomePaciente.setText(paciente.getNome());
        txtObjetivo.setText(paciente.getObjetivoConsulta());
        txtDtNascimento.setText(paciente.getDataNascimento() == null ? "" : sdf.format(paciente.getDataNascimento()));
        getIdadePaciente();
        txtProfissao.setText(paciente.getProfissao() == null ? "" : paciente.getProfissao());
        cbSexoPaciente.setSelectedItem(paciente.getSexo());
        cbEscolaridade.setSelectedItem(paciente.getEscolaridade());
        lblDtCadastro.setText("Paciente cadastrado em: " + sdfHM.format(paciente.getDataCadastro()));

    }

    private void prepareTabPaciente() {
        cbEscolaridade.setModel(getModelEscolaridade());
        cbSexoPaciente.setModel(getModelSexo());
    }

    @Override
    protected void fixLayout() {
        super.fixLayout(); //To change body of generated methods, choose Tools | Templates.
        String title = ((paciente == null) ? "Novo Paciente" : paciente.getNome());
        setTitle(title);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpPaciente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbSexoPaciente = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtDtNascimento = new javax.swing.JFormattedTextField(sdf);
        jLabel4 = new javax.swing.JLabel();
        lblIdadePaciente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObjetivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cbEscolaridade = new javax.swing.JComboBox();
        txtProfissao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDoencaAtual = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAtencedentesPatologicos = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAtencedentesFamilares = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbEtilismo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtTempoEtilismo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtFrequenciaEtilismo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbTabagismo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtTempoTabagismo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtFrequenciaTabagismo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbExercicioFisico = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        txtTempoExercicioFisico = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtFrequenciaExercicioFisico = new javax.swing.JTextField();
        btnSalvarHistoricoClinico = new javax.swing.JButton();
        pnlExameFisico = new javax.swing.JPanel();
        exameFisicoS = new br.com.jonjts.assistant.ExameFisicoTela(this);
        pnlExameFisico.add(exameFisicoS.getRootPane());
        btnSalvarExameFisico = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        dadosDieteticosTela = new DadosDieteticosTela(this);
        jPanel3.add(dadosDieteticosTela.getRootPane());
        lblDtCadastro = new javax.swing.JLabel();
        cbExameClinico = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome*:");

        txtNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePacienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Sexo:");

        jLabel3.setText("Dt. Nascimento:");

        txtDtNascimento.setToolTipText("dd/mm/aaaa");
        txtDtNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDtNascimentoFocusLost(evt);
            }
        });

        jLabel4.setText("Idade:");

        jLabel5.setText("Profissão:");

        jLabel6.setText("Objetivo*:");

        txtObjetivo.setColumns(20);
        txtObjetivo.setRows(5);
        jScrollPane1.setViewportView(txtObjetivo);

        jLabel7.setText("Escolaridade:");

        jButton1.setText("Salvar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdadePaciente)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSexoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSexoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblIdadePaciente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        tbpPaciente.addTab("Paciente", jPanel1);

        jLabel8.setText("Historia da Doença Atual:");

        txtDoencaAtual.setColumns(20);
        txtDoencaAtual.setRows(5);
        jScrollPane2.setViewportView(txtDoencaAtual);

        jLabel9.setText("Atencedentes Patológicos:");

        txtAtencedentesPatologicos.setColumns(20);
        txtAtencedentesPatologicos.setRows(5);
        jScrollPane3.setViewportView(txtAtencedentesPatologicos);

        jLabel10.setText("Atencedentes Familiares:");

        txtAtencedentesFamilares.setColumns(20);
        txtAtencedentesFamilares.setRows(5);
        jScrollPane4.setViewportView(txtAtencedentesFamilares);

        jLabel11.setText("Etílismo:");

        cbEtilismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        cbEtilismo.setSelectedIndex(1);
        cbEtilismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEtilismoActionPerformed(evt);
            }
        });

        jLabel12.setText("Tempo:");

        jLabel13.setText("Frequência:");

        jLabel14.setText("Tabagismo:");

        cbTabagismo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        cbTabagismo.setSelectedIndex(1);
        cbTabagismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTabagismoActionPerformed(evt);
            }
        });

        jLabel15.setText("Tempo:");

        jLabel16.setText("Frequência:");

        jLabel17.setText("Exercicio Físico:");

        cbExercicioFisico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        cbExercicioFisico.setSelectedIndex(1);
        cbExercicioFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExercicioFisicoActionPerformed(evt);
            }
        });

        jLabel18.setText("Tempo:");

        jLabel19.setText("Frequência:");

        btnSalvarHistoricoClinico.setText("Salvar Historico Clinico");
        btnSalvarHistoricoClinico.setToolTipText("");
        btnSalvarHistoricoClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarHistoricoClinicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTempoEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFrequenciaEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTempoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFrequenciaTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbExercicioFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTempoExercicioFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFrequenciaExercicioFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalvarHistoricoClinico)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtTempoEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtFrequenciaEtilismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtTempoTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtFrequenciaTabagismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbExercicioFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtTempoExercicioFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtFrequenciaExercicioFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvarHistoricoClinico)
                .addGap(4, 4, 4))
        );

        tbpPaciente.addTab("Historico Clinico", jPanel2);

        btnSalvarExameFisico.setText("Salvar Exame Fisico");
        btnSalvarExameFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarExameFisicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlExameFisicoLayout = new javax.swing.GroupLayout(pnlExameFisico);
        pnlExameFisico.setLayout(pnlExameFisicoLayout);
        pnlExameFisicoLayout.setHorizontalGroup(
            pnlExameFisicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExameFisicoLayout.createSequentialGroup()
                .addContainerGap(600, Short.MAX_VALUE)
                .addComponent(btnSalvarExameFisico)
                .addGap(29, 29, 29))
        );
        pnlExameFisicoLayout.setVerticalGroup(
            pnlExameFisicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExameFisicoLayout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(btnSalvarExameFisico)
                .addContainerGap())
        );

        tbpPaciente.addTab("Exame Físico", pnlExameFisico);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        tbpPaciente.addTab("Dados Dietéticos", jPanel3);

        cbExameClinico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExameClinicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tbpPaciente)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDtCadastro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbExameClinico, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cbExameClinico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(lblDtCadastro)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePacienteActionPerformed

    private void txtDtNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDtNascimentoFocusLost
        getIdadePaciente();
    }

    private void getIdadePaciente() {
        try {
            String dt = txtDtNascimento.getText();
            Date parse = sdf.parse(dt);
            Date date = new Date();

            int yearP = parse.getYear();
            int year = date.getYear();

            int idade = year - yearP;

            parse.setYear(date.getYear());
            if (parse.before(date)) {
                lblIdadePaciente.setText(idade + "");
            } else {
                idade -= 1;
                lblIdadePaciente.setText(idade + "");
            }

        } catch (ParseException ex) {

        }
    }//GEN-LAST:event_txtDtNascimentoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (paciente == null) {
            try {
                insertPaciente();
                loadCbExameClinico();
                saveExameExameClinico();
                enableTabs();
            } catch (Exception ex) {
                paciente = null;
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Verifique os campos obrigatorios");
            }
        } else {
            try {
                updatePaciente();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbEtilismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEtilismoActionPerformed
        if (cbEtilismo.getSelectedItem() == cbEtilismo.getItemAt(1)) {
            disableEtilismo();
        } else {
            enableEtilismo();
        }
    }//GEN-LAST:event_cbEtilismoActionPerformed

    private void cbTabagismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTabagismoActionPerformed
        if (cbTabagismo.getSelectedItem() == cbTabagismo.getItemAt(1)) {
            disableTabagismo();
        } else {
            enableTabagismo();
        }
    }//GEN-LAST:event_cbTabagismoActionPerformed

    private void cbExercicioFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExercicioFisicoActionPerformed
        if (cbExercicioFisico.getSelectedItem() == cbExercicioFisico.getItemAt(1)) {
            disableExercicioFisico();
        } else {
            enableExercicioFisico();
        }
    }//GEN-LAST:event_cbExercicioFisicoActionPerformed

    private void btnSalvarHistoricoClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarHistoricoClinicoActionPerformed
        if (historicoClinico == null) {
            insertHistoricoClinco();
        } else {
            updateHistoricoClinico();
        }
    }//GEN-LAST:event_btnSalvarHistoricoClinicoActionPerformed

    private void cbExameClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExameClinicoActionPerformed
        loadExameFisico();
    }//GEN-LAST:event_cbExameClinicoActionPerformed

    private void btnSalvarExameFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarExameFisicoActionPerformed
        exameFisicoS.save();
    }//GEN-LAST:event_btnSalvarExameFisicoActionPerformed

    public void updateExameFisico(ExameFisico exameFisico) throws Exception {
        saveExameExameClinico();
        exameFisicoBO.update(exameFisico);
    }

    public ExameFisico saveExameFisico(ExameFisico exameFisico) throws Exception {
        saveExameExameClinico();
        exameFisico.setIdExameClinico(((ExameClinico) cbExameClinico.getSelectedItem()).getId());
        exameFisico.setIdPaciente(paciente.getId());
        return exameFisicoBO.insert(exameFisico);
    }

    private void saveExameExameClinico() throws Exception {
        final ExameClinico selectedItem = (ExameClinico) cbExameClinico.getSelectedItem();
        if (selectedItem == null ||selectedItem.getId() == null) {
            ExameClinico exameClinico = new ExameClinico();
            exameClinico = new ExameClinico(paciente.getId(), new Date());
            exameClinico = exameClinicoBO.insert(exameClinico);

            selectedItem.setId(exameClinico.getId());
            selectedItem.setIdPaciente(exameClinico.getIdPaciente());
        }
    }

    private void updateHistoricoClinico() {
        try {
            preencherHistoricoClinico();
            historicoClinicoBO.update(historicoClinico);
            JOptionPane.showMessageDialog(null, "Salvo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Historico Clinico");
        }
    }

    private void insertHistoricoClinco() {
        try {
            historicoClinico = new HistoricoClinico();
            preencherHistoricoClinico();
            historicoClinico = historicoClinicoBO.insert(historicoClinico);
            JOptionPane.showMessageDialog(null, "Salvo");
        } catch (Exception ex) {
            historicoClinico = null;
            JOptionPane.showMessageDialog(null, "Erro ao salvar Historico Clinico");
            ex.printStackTrace();
        }
    }

    private void preencherHistoricoClinico() {
        historicoClinico.setAtencedentesFamiliares(txtAtencedentesFamilares.getText());
        historicoClinico.setAtencedentesPatologicos(txtAtencedentesPatologicos.getText());
        historicoClinico.setDoencaAtual(txtDoencaAtual.getText());
        historicoClinico.setIdPaciente(paciente.getId());

        historicoClinico.setEtilismo((String) cbEtilismo.getSelectedItem());
        historicoClinico.setTempoEtilismo(txtTempoEtilismo.getText());
        historicoClinico.setFrequenciaEtilismo(txtFrequenciaEtilismo.getText());

        historicoClinico.setTabagismo((String) cbTabagismo.getSelectedItem());
        historicoClinico.setTempoTabagismo(txtTempoTabagismo.getText());
        historicoClinico.setFrequenciaTabagismo(txtFrequenciaTabagismo.getText());

        historicoClinico.setExercicioFisico((String) cbExercicioFisico.getSelectedItem());
        historicoClinico.setTempoExercicioFisico(txtTempoExercicioFisico.getText());
        historicoClinico.setFrequenciaExercicioFisico(txtFrequenciaExercicioFisico.getText());
    }

    private void updatePaciente() throws ParseException, Exception {
        preencherPaciente();
        pacienteBO.update(paciente);
        finishedBoOperation();
    }

    private void insertPaciente() throws Exception, ParseException {
        paciente = new Paciente();
        paciente.setDataCadastro(new Date());
        preencherPaciente();
        paciente = pacienteBO.insert(paciente);
        lblDtCadastro.setText("Paciente cadastrado em: " + sdfHM.format(new Date()));
        finishedBoOperation();
    }

    private void finishedBoOperation() {
        main.search();
        setTitle(paciente.getNome());
    }

    private void preencherPaciente() throws ParseException {
        paciente.setNome(txtNomePaciente.getText());
        paciente.setDataNascimento(txtDtNascimento.getText().trim().isEmpty() ? null : sdf.parse(txtDtNascimento.getText()));
        paciente.setEscolaridade((String) cbEscolaridade.getSelectedItem());
        paciente.setObjetivoConsulta(txtObjetivo.getText());
        paciente.setProfissao(txtProfissao.getText());
        paciente.setSexo((String) cbSexoPaciente.getSelectedItem());
    }

    private DefaultComboBoxModel<String> loadCBModels(Vector<String> vector) {
        return new DefaultComboBoxModel<>(vector);
    }

    private DefaultComboBoxModel<String> getModelEscolaridade() {
        return new DefaultComboBoxModel<>(new String[]{"Médio Incompleto", "Médio Completo", "Superior Incompleto", "Superior Completo", "Outro"});
    }

    private DefaultComboBoxModel<String> getModelSexo() {
        return new DefaultComboBoxModel<>(new String[]{"Masculino", "Feminino"});
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
            java.util.logging.Logger.getLogger(NovoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoPaciente(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnSalvarExameFisico;
    private javax.swing.JButton btnSalvarHistoricoClinico;
    private javax.swing.JComboBox cbEscolaridade;
    private javax.swing.JComboBox cbEtilismo;
    private javax.swing.JComboBox cbExameClinico;
    private javax.swing.JComboBox cbExercicioFisico;
    private javax.swing.JComboBox cbSexoPaciente;
    private javax.swing.JComboBox cbTabagismo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDtCadastro;
    private javax.swing.JLabel lblIdadePaciente;
    private javax.swing.JPanel pnlExameFisico;
    private javax.swing.JTabbedPane tbpPaciente;
    private javax.swing.JTextArea txtAtencedentesFamilares;
    private javax.swing.JTextArea txtAtencedentesPatologicos;
    private javax.swing.JTextArea txtDoencaAtual;
    private javax.swing.JTextField txtDtNascimento;
    private javax.swing.JTextField txtFrequenciaEtilismo;
    private javax.swing.JTextField txtFrequenciaExercicioFisico;
    private javax.swing.JTextField txtFrequenciaTabagismo;
    private javax.swing.JTextField txtNomePaciente;
    private javax.swing.JTextArea txtObjetivo;
    private javax.swing.JTextField txtProfissao;
    private javax.swing.JTextField txtTempoEtilismo;
    private javax.swing.JTextField txtTempoExercicioFisico;
    private javax.swing.JTextField txtTempoTabagismo;
    // End of variables declaration//GEN-END:variables
}
