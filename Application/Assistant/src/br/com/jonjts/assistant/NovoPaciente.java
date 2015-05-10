/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant;

import br.com.jonjts.assistant.control.DadosBioquimicosControl;
import br.com.jonjts.assistant.control.DadosDieteticosControle;
import br.com.jonjts.assistant.control.ExameClinicoControle;
import br.com.jonjts.assistant.control.ExameFisicoControle;
import br.com.jonjts.assistant.control.ExamesBioquimicosExtrasControl;
import br.com.jonjts.assistant.control.HistoricoClinicoControle;
import br.com.jonjts.assistant.control.PacienteControle;
import br.com.jonjts.assistant.control.TratoGastroIntestinalControl;
import br.com.jonjts.assistant.entity.DadosBioquimicos;
import br.com.jonjts.assistant.entity.DadosDieteticos;
import br.com.jonjts.assistant.entity.ExameClinico;
import br.com.jonjts.assistant.entity.ExameFisico;
import br.com.jonjts.assistant.entity.ExamesBioquimicosExtras;
import br.com.jonjts.assistant.entity.HistoricoClinico;
import br.com.jonjts.assistant.entity.Paciente;
import br.com.jonjts.assistant.entity.TratoGastroIntestinal;
import java.awt.event.KeyEvent;
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
import javax.swing.JFrame;
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
    private Main main;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdfHM = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private ExameFisicoTela exameFisicoS;
    private DadosDieteticosTela dadosDieteticosTela;
    private HistoricoClinicoTela historicoClinicoTela;
    private DadosBioquimicosTela dadosBioquimicosTela;
    private TratoGastroIntestinalTela tratoGastroIntestinalTela;
    //BOs
    private PacienteControle pacienteControle = new PacienteControle();
    private HistoricoClinicoControle historicoClinicoControle = new HistoricoClinicoControle();
    private ExameClinicoControle exameClinicoControle = new ExameClinicoControle();
    private ExameFisicoControle exameFisicoControle = new ExameFisicoControle();
    private DadosDieteticosControle dadosDieteticosControle = new DadosDieteticosControle();
    private DadosBioquimicosControl dadosBioquimicosControl = new DadosBioquimicosControl();
    private ExamesBioquimicosExtrasControl examesBioquimicosExtrasControl = new ExamesBioquimicosExtrasControl();
    private TratoGastroIntestinalControl tratoGastroIntestinalControl = new TratoGastroIntestinalControl();

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

        if (paciente != null) {
            loadAllInformations();
            loadCbExameClinico();
            try {
                final HistoricoClinico get = historicoClinicoControle.get(paciente.getId());
                historicoClinicoTela.setHistoricoClinico(get);
                historicoClinicoTela.loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar Historico clinico.");
                Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            disableTabs();
        }
        loadExameFisico();
        loadDadosDieteticos();
        loadDadosBioquimicos();
        loadTratoGastroIntestinal();

        fixLayout();
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
            allExameClinico = exameClinicoControle.get(paciente.getId());
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
        historicoClinicoTela.loadData();
        //loadExameFisico();
    }

    private void loadExameFisico() {
        try {
            ExameClinico selectedItem = (ExameClinico) cbExameClinico.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                ExameFisico get = exameFisicoControle.get(selectedItem.getId());
                if (get != null) {
                    exameFisicoS.setExameFisico(get);
                    exameFisicoS.loadData();
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

    private void loadDadosDieteticos() {
        try {
            ExameClinico selectedItem = (ExameClinico) cbExameClinico.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                DadosDieteticos get = dadosDieteticosControle.get(selectedItem.getId());
                if (get != null) {
                    dadosDieteticosTela.setDadosDieteticos(get);
                    dadosDieteticosTela.loadData();
                } else {
                    limparTelaDadosDieteticos();
                }
            } else {
                limparTelaDadosDieteticos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Exame Fisico");
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTratoGastroIntestinal() {
        try {
            ExameClinico selectedItem = (ExameClinico) cbExameClinico.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                TratoGastroIntestinal get = tratoGastroIntestinalControl.get(selectedItem.getId().longValue());
                if (get != null) {
                    tratoGastroIntestinalTela.setTratoGastroIntestinal(get);
                    tratoGastroIntestinalTela.loadData();
                } else {
                    limparTelaTratoGastroIntestinal();
                }
            } else {
                limparTelaTratoGastroIntestinal();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Trato Gastro Intestinal.");
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

    private void loadDadosBioquimicos() {
        try {
            ExameClinico selectedItem = (ExameClinico) cbExameClinico.getSelectedItem();
            if (selectedItem != null && selectedItem.getData() != null && selectedItem.getId() != null) {
                DadosBioquimicos get = dadosBioquimicosControl.get(selectedItem.getId());
                if (get != null) {
                    dadosBioquimicosTela.setDadosBioquimicos(get);
                    dadosBioquimicosTela.loadData();
                } else {
                    limparTelaDadosBioquimicos();
                }
            } else {
                limparTelaDadosBioquimicos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar Daos Bioquímicos");
            Logger.getLogger(NovoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparTelaTratoGastroIntestinal() {
        tratoGastroIntestinalTela.setTratoGastroIntestinal(null);
        tratoGastroIntestinalTela.clearData();
    }

    private void limparTelaDadosBioquimicos() {
        dadosBioquimicosTela.setDadosBioquimicos(null);
        dadosBioquimicosTela.clearData();
    }

    private void limparTelaExameFisico() {
        exameFisicoS.setExameFisico(null);
        exameFisicoS.clearData();
    }

    private void limparTelaDadosDieteticos() {
        dadosDieteticosTela.setDadosDieteticos(null);
        dadosDieteticosTela.clearData();
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
        final String email = paciente.getEmail();
        txtEmail.setText(email != null ? email : "");

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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        pnlExameFisico = new javax.swing.JPanel();
        exameFisicoS = new br.com.jonjts.assistant.ExameFisicoTela(this);
        pnlExameFisico.add(exameFisicoS.getRootPane());
        btnSalvarExameFisico = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        dadosDieteticosTela = new DadosDieteticosTela(this);
        jPanel3.add(dadosDieteticosTela.getRootPane());
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        dadosBioquimicosTela = new DadosBioquimicosTela(this);
        jPanel4.add(dadosBioquimicosTela.getRootPane());
        btnSalvarDadosBioquimicos = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        tratoGastroIntestinalTela = new TratoGastroIntestinalTela(this);
        jPanel5.add(tratoGastroIntestinalTela.getRootPane());
        jButton4 = new javax.swing.JButton();
        lblDtCadastro = new javax.swing.JLabel();
        cbExameClinico = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 585));

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

        jButton1.setMnemonic(KeyEvent.VK_S);
        jButton1.setText("Salvar Paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdadePaciente)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSexoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 224, Short.MAX_VALUE)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(125, 125, 125)))
                .addComponent(jButton1)
                .addContainerGap())
        );

        tbpPaciente.addTab("Paciente", jPanel1);

        historicoClinicoTela = new HistoricoClinicoTela(this);
        jPanel2.add(historicoClinicoTela.getRootPane());

        jButton3.setText("Salvar Historico Clinico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(710, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
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
                .addContainerGap(739, Short.MAX_VALUE)
                .addComponent(btnSalvarExameFisico)
                .addGap(29, 29, 29))
        );
        pnlExameFisicoLayout.setVerticalGroup(
            pnlExameFisicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExameFisicoLayout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(btnSalvarExameFisico)
                .addContainerGap())
        );

        tbpPaciente.addTab("Exame Físico", pnlExameFisico);

        jButton2.setText("Salvar Dados Dietéticos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(725, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        tbpPaciente.addTab("Dados Dietéticos", jPanel3);

        btnSalvarDadosBioquimicos.setText("Salvar Dados Bioquímicos");
        btnSalvarDadosBioquimicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDadosBioquimicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(732, Short.MAX_VALUE)
                .addComponent(btnSalvarDadosBioquimicos)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(btnSalvarDadosBioquimicos)
                .addContainerGap())
        );

        tbpPaciente.addTab("Exames Bioquímicos", jPanel4);

        jButton4.setText("Salvar Gastro Intestinal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 750, Short.MAX_VALUE)
                .addComponent(jButton4))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        tbpPaciente.addTab("Trato Gastro Intestinal", jPanel5);

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
                .addComponent(lblDtCadastro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbExameClinico, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(tbpPaciente)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbExameClinico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cbExameClinicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExameClinicoActionPerformed
        loadExameFisico();
        loadDadosDieteticos();
        loadDadosBioquimicos();
        loadTratoGastroIntestinal();
    }//GEN-LAST:event_cbExameClinicoActionPerformed

    private void btnSalvarExameFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarExameFisicoActionPerformed
        exameFisicoS.save();
    }//GEN-LAST:event_btnSalvarExameFisicoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dadosDieteticosTela.save();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        historicoClinicoTela.save();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSalvarDadosBioquimicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDadosBioquimicosActionPerformed
        dadosBioquimicosTela.save();
    }//GEN-LAST:event_btnSalvarDadosBioquimicosActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tratoGastroIntestinalTela.save();
    }//GEN-LAST:event_jButton4ActionPerformed

    public TratoGastroIntestinal insertTratoGastroIntestinal(TratoGastroIntestinal tratoGastroIntestinal) throws Exception {
        saveExameExameClinico();
        ExameClinico selectedExameClinico = getSelectedExameClinico();
        tratoGastroIntestinal.setIdExameClinico(selectedExameClinico.getId());
        tratoGastroIntestinal.setIdPaciente(paciente.getId());
        return tratoGastroIntestinalControl.insert(tratoGastroIntestinal);
    }

    public void updateTratoGastroIntestinal(TratoGastroIntestinal tratoGastroIntestinal) throws Exception {
        tratoGastroIntestinal.setIdPaciente(paciente.getId());
        tratoGastroIntestinalControl.update(tratoGastroIntestinal);
    }

    public DadosBioquimicos insertDadosBioquimicos(DadosBioquimicos bioquimicos, List<ExamesBioquimicosExtras> list) throws Exception {
        saveExameExameClinico();
        ExameClinico name = getSelectedExameClinico();
        list = dadosBioquimicosTela.bindGrid(paciente, name, list);
        examesBioquimicosExtrasControl.insert(list);

        bioquimicos.setIdExameClinico(name.getId());
        bioquimicos.setIdPaciente(paciente.getId());
        return dadosBioquimicosControl.insert(bioquimicos);
    }

    private ExameClinico getSelectedExameClinico() {
        final ExameClinico name = (ExameClinico) cbExameClinico.getSelectedItem();
        return name;
    }

    public void updateDadosBioquimicos(DadosBioquimicos bioquimicos, List<ExamesBioquimicosExtras> list) throws Exception {
        saveExameExameClinico();
        final ExameClinico selectedExameClinico = getSelectedExameClinico();
        list = dadosBioquimicosTela.bindGrid(paciente, selectedExameClinico, list);
        examesBioquimicosExtrasControl.update(list, selectedExameClinico.getId());
        dadosBioquimicosControl.update(bioquimicos);
    }

    public void updateHistoricoClinico(HistoricoClinico historicoClinico) throws Exception {
        historicoClinico.setIdPaciente(paciente.getId());
        historicoClinicoControle.update(historicoClinico);
    }

    public HistoricoClinico insertHistoricoClinico(HistoricoClinico historicoClinico) throws Exception {
        historicoClinico.setIdPaciente(paciente.getId());
        return historicoClinicoControle.insert(historicoClinico);
    }

    public void updateExameFisico(ExameFisico exameFisico) throws Exception {
        saveExameExameClinico();
        exameFisicoControle.update(exameFisico);
    }

    public void updateDadosDieteticos(DadosDieteticos dadosDieteticos) throws Exception {
        saveExameExameClinico();
        dadosDieteticosControle.update(dadosDieteticos);
    }

    public DadosDieteticos saveDadosDietateticos(DadosDieteticos dadosDieteticos) throws Exception {
        saveExameExameClinico();
        dadosDieteticos.setIdExameClinico(((ExameClinico) cbExameClinico.getSelectedItem()).getId());
        dadosDieteticos.setIdPaciente(paciente.getId());
        return dadosDieteticosControle.insert(dadosDieteticos);
    }

    public ExameFisico saveExameFisico(ExameFisico exameFisico) throws Exception {
        saveExameExameClinico();
        exameFisico.setIdExameClinico(((ExameClinico) cbExameClinico.getSelectedItem()).getId());
        exameFisico.setIdPaciente(paciente.getId());
        return exameFisicoControle.insert(exameFisico);
    }

    private void saveExameExameClinico() throws Exception {
        ExameClinico selectedItem = getSelectedExameClinico();
        if (selectedItem == null || selectedItem.getId() == null) {
            ExameClinico exameClinico = new ExameClinico();
            exameClinico = new ExameClinico(paciente.getId(), new Date());
            exameClinico = exameClinicoControle.insert(exameClinico);

            selectedItem.setId(exameClinico.getId());
            selectedItem.setIdPaciente(exameClinico.getIdPaciente());
        }
    }

    private void updatePaciente() throws ParseException, Exception {
        preencherPaciente();
        pacienteControle.update(paciente);
        finishedBoOperation();
    }

    private void insertPaciente() throws Exception, ParseException {
        paciente = new Paciente();
        paciente.setDataCadastro(new Date());
        preencherPaciente();
        paciente = pacienteControle.insert(paciente);
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
        paciente.setEmail(txtEmail.getText());
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

    public Paciente getPaciente() {
        return paciente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarDadosBioquimicos;
    private javax.swing.JToggleButton btnSalvarExameFisico;
    private javax.swing.JComboBox cbEscolaridade;
    private javax.swing.JComboBox cbExameClinico;
    private javax.swing.JComboBox cbSexoPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDtCadastro;
    private javax.swing.JLabel lblIdadePaciente;
    private javax.swing.JPanel pnlExameFisico;
    private javax.swing.JTabbedPane tbpPaciente;
    private javax.swing.JTextField txtDtNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNomePaciente;
    private javax.swing.JTextArea txtObjetivo;
    private javax.swing.JTextField txtProfissao;
    // End of variables declaration//GEN-END:variables

}
