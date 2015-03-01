/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "exame_fisico", daoClass = ExameFisico.class)
public class ExameFisico {
    
    public static final String FILD_ID = "id";
    public static final String FILD_EDEMAS = "edemas";
    public static final String FILD_CABELO= "cabelo";
    
    
    
    @DatabaseField(columnName = FILD_ID, id = true)
    private Long id;
    
    @DatabaseField(columnName = "id_exame_clinico", canBeNull = false)
    private Long idExameClinico;
    
    @DatabaseField(columnName = "id_paciente", canBeNull = false)
    private Long idPaciente;
    
    @DatabaseField(columnName = FILD_EDEMAS)
    private String edemas;
    
    @DatabaseField(columnName = FILD_CABELO)
    private String cabelo;

    @DatabaseField(columnName = "unhas")
    private String unhas;
    
    @DatabaseField(columnName = "hidratacao")
    private String hidratacao;
    
    public ExameFisico() {
    }

    public ExameFisico(Long id, Long idExameClinico, Long idPaciente, String edemas, String cabelo, String unhas, String hidratacao) {
        this.id = id;
        this.idExameClinico = idExameClinico;
        this.idPaciente = idPaciente;
        this.edemas = edemas;
        this.cabelo = cabelo;
        this.unhas = unhas;
        this.hidratacao = hidratacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdExameClinico() {
        return idExameClinico;
    }

    public void setIdExameClinico(Long idExameClinico) {
        this.idExameClinico = idExameClinico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEdemas() {
        return edemas;
    }

    public void setEdemas(String edemas) {
        this.edemas = edemas;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public String getUnhas() {
        return unhas;
    }

    public void setUnhas(String unhas) {
        this.unhas = unhas;
    }

    public String getHidratacao() {
        return hidratacao;
    }

    public void setHidratacao(String hidratacao) {
        this.hidratacao = hidratacao;
    }

    
}
