/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.dto;

import br.com.jonjts.assistant.dao.HistoricoClinicoDAO;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "historico_clinico", daoClass = HistoricoClinicoDAO.class)
public class HistoricoClinico {
    
    public static final String FILD_ID = "id";
    public static final String FILD_ID_PACIENTE = "id_paciente";
    public static final String FILD_DOENCA_ATUAL = "doenca_atual";
    public static final String FILD_ATENCEDENTES_PATOLOGICOS = "antecedentes_patologicos";
    public static final String FILD_ATENCEDENTES_FAMILIARES = "antecedentes_familiares";
    
    public static final String FILD_etilismo = "etilismo";
    public static final String FILD_TEMPO_etilismo = "tempo_etilismo";
    public static final String FILD_FREQUENCIA_etilismo = "frequencia_etilismo";
    public static final String FILD_tabagismo = "tabagismo";
    public static final String FILD_TEMPO_tabagismo = "tempo_tabagismo";
    public static final String FILD_FREQUENCIA_tabagismo = "frequencia_tabagismo";
    public static final String FILD_exercicio_fisico = "exercicio_fisico";
    public static final String FILD_TEMPO_exercicio_fisico = "tempo_exercicio_fisico";
    public static final String FILD_FREQUENCIA_exercicio_fisico = "frequencia_exercicio_fisico";
    
    @DatabaseField(columnName = FILD_ID, id= true, canBeNull = false)
    private Long id;
    
    @DatabaseField(columnName = FILD_ID_PACIENTE, canBeNull = false)
    private Long idPaciente;
    
    @DatabaseField(columnName = FILD_DOENCA_ATUAL)
    private String doencaAtual;
    
    @DatabaseField(columnName = FILD_ATENCEDENTES_PATOLOGICOS)
    private String atencedentesPatologicos;
    
    @DatabaseField(columnName = FILD_ATENCEDENTES_FAMILIARES)
    private String atencedentesFamiliares;
    
    @DatabaseField(columnName = FILD_etilismo)
    private String etilismo;
    
    @DatabaseField(columnName = FILD_TEMPO_etilismo)
    private String tempoEtilismo;
    
    @DatabaseField(columnName = FILD_FREQUENCIA_etilismo)
    private String frequenciaEtilismo;
    
    @DatabaseField(columnName = FILD_tabagismo)
    private String tabagismo;
    
    @DatabaseField(columnName = FILD_TEMPO_tabagismo)
    private String tempoTabagismo;
    
    @DatabaseField(columnName = FILD_FREQUENCIA_tabagismo)
    private String frequenciaTabagismo;
    
    @DatabaseField(columnName = FILD_exercicio_fisico)
    private String exercicioFisico;
    
    @DatabaseField(columnName = FILD_TEMPO_exercicio_fisico)
    private String tempoExercicioFisico;
    
    @DatabaseField(columnName = FILD_FREQUENCIA_exercicio_fisico)
    private String frequenciaExercicioFisico;

    public HistoricoClinico() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDoencaAtual() {
        return doencaAtual;
    }

    public void setDoencaAtual(String doencaAtual) {
        this.doencaAtual = doencaAtual;
    }

    public String getAtencedentesPatologicos() {
        return atencedentesPatologicos;
    }

    public void setAtencedentesPatologicos(String atencedentesPatologicos) {
        this.atencedentesPatologicos = atencedentesPatologicos;
    }

    public String getAtencedentesFamiliares() {
        return atencedentesFamiliares;
    }

    public void setAtencedentesFamiliares(String atencedentesFamiliares) {
        this.atencedentesFamiliares = atencedentesFamiliares;
    }

    public String getEtilismo() {
        return etilismo;
    }

    public void setEtilismo(String etilismo) {
        this.etilismo = etilismo;
    }

    public String getTempoEtilismo() {
        return tempoEtilismo;
    }

    public void setTempoEtilismo(String tempoEtilismo) {
        this.tempoEtilismo = tempoEtilismo;
    }

    public String getFrequenciaEtilismo() {
        return frequenciaEtilismo;
    }

    public void setFrequenciaEtilismo(String frequenciaEtilismo) {
        this.frequenciaEtilismo = frequenciaEtilismo;
    }

    public String getTabagismo() {
        return tabagismo;
    }

    public void setTabagismo(String tabagismo) {
        this.tabagismo = tabagismo;
    }

    public String getTempoTabagismo() {
        return tempoTabagismo;
    }

    public void setTempoTabagismo(String tempoTabagismo) {
        this.tempoTabagismo = tempoTabagismo;
    }

    public String getFrequenciaTabagismo() {
        return frequenciaTabagismo;
    }

    public void setFrequenciaTabagismo(String frequenciaTabagismo) {
        this.frequenciaTabagismo = frequenciaTabagismo;
    }

    public String getExercicioFisico() {
        return exercicioFisico;
    }

    public void setExercicioFisico(String exercicioFisico) {
        this.exercicioFisico = exercicioFisico;
    }

    public String getTempoExercicioFisico() {
        return tempoExercicioFisico;
    }

    public void setTempoExercicioFisico(String tempoExercicioFisico) {
        this.tempoExercicioFisico = tempoExercicioFisico;
    }

    public String getFrequenciaExercicioFisico() {
        return frequenciaExercicioFisico;
    }

    public void setFrequenciaExercicioFisico(String frequenciaExercicioFisico) {
        this.frequenciaExercicioFisico = frequenciaExercicioFisico;
    }

    public HistoricoClinico(Long idPaciente, String doencaAtual, String atencedentesPatologicos, String atencedentesFamiliares, String etilismo, String tempoEtilismo, String frequenciaEtilismo, String tabagismo, String tempoTabagismo, String frequenciaTabagismo, String exercicioFisico, String tempoExercicioFisico, String frequenciaExercicioFisico) {
        this.idPaciente = idPaciente;
        this.doencaAtual = doencaAtual;
        this.atencedentesPatologicos = atencedentesPatologicos;
        this.atencedentesFamiliares = atencedentesFamiliares;
        this.etilismo = etilismo;
        this.tempoEtilismo = tempoEtilismo;
        this.frequenciaEtilismo = frequenciaEtilismo;
        this.tabagismo = tabagismo;
        this.tempoTabagismo = tempoTabagismo;
        this.frequenciaTabagismo = frequenciaTabagismo;
        this.exercicioFisico = exercicioFisico;
        this.tempoExercicioFisico = tempoExercicioFisico;
        this.frequenciaExercicioFisico = frequenciaExercicioFisico;
    }

    public HistoricoClinico(Long id, Long idPaciente, String doencaAtual, String atencedentesPatologicos, String atencedentesFamiliares, String etilismo, String tempoEtilismo, String frequenciaEtilismo, String tabagismo, String tempoTabagismo, String frequenciaTabagismo, String exercicioFisico, String tempoExercicioFisico, String frequenciaExercicioFisico) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.doencaAtual = doencaAtual;
        this.atencedentesPatologicos = atencedentesPatologicos;
        this.atencedentesFamiliares = atencedentesFamiliares;
        this.etilismo = etilismo;
        this.tempoEtilismo = tempoEtilismo;
        this.frequenciaEtilismo = frequenciaEtilismo;
        this.tabagismo = tabagismo;
        this.tempoTabagismo = tempoTabagismo;
        this.frequenciaTabagismo = frequenciaTabagismo;
        this.exercicioFisico = exercicioFisico;
        this.tempoExercicioFisico = tempoExercicioFisico;
        this.frequenciaExercicioFisico = frequenciaExercicioFisico;
    }

}
    
