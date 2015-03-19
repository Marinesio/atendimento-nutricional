/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.entity;

import br.com.jonjts.assistant.persistence.TratoGastroIntestinalPersistence;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "trato_gastro_intestinal", daoClass = TratoGastroIntestinalPersistence.class)
public class TratoGastroIntestinal {

    @DatabaseField(columnName = "id", id = true)
    private Long id;

    @DatabaseField(columnName = "id_exame_clinico", canBeNull = false)
    private Long idExameClinico;

    @DatabaseField(columnName = "id_paciente", canBeNull = false)
    private Long idPaciente;

    @DatabaseField(columnName = "apetite_atual")
    private String apetiteAtual;

    @DatabaseField(columnName = "dificuldade_mastigacao")
    private String dificuldadeMastigacao;

    @DatabaseField(columnName = "transito_intestinal")
    private String transitoIntestinal;

    @DatabaseField(columnName = "refluxo")
    private String refluxo;

    @DatabaseField(columnName = "nauseas")
    private String nauseas;

    @DatabaseField(columnName = "vomitos")
    private String vomitos;

    @DatabaseField(columnName = "pirose")
    private String pirose;

    @DatabaseField(columnName = "disfagia")
    private String disfagia;

    @DatabaseField(columnName = "odinofagia")
    private String odinofagia;

    public TratoGastroIntestinal() {
        super();
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

    public String getApetiteAtual() {
        return apetiteAtual;
    }

    public void setApetiteAtual(String apetiteAtual) {
        this.apetiteAtual = apetiteAtual;
    }

    public String getDificuldadeMastigacao() {
        return dificuldadeMastigacao;
    }

    public void setDificuldadeMastigacao(String dificuldadeMastigacao) {
        this.dificuldadeMastigacao = dificuldadeMastigacao;
    }

    public String getTransitoIntestinal() {
        return transitoIntestinal;
    }

    public void setTransitoIntestinal(String transitoIntestinal) {
        this.transitoIntestinal = transitoIntestinal;
    }

    public String getRefluxo() {
        return refluxo;
    }

    public void setRefluxo(String refluxo) {
        this.refluxo = refluxo;
    }

    public String getNauseas() {
        return nauseas;
    }

    public void setNauseas(String nauseas) {
        this.nauseas = nauseas;
    }

    public String getVomitos() {
        return vomitos;
    }

    public void setVomitos(String vomitos) {
        this.vomitos = vomitos;
    }

    public String getPirose() {
        return pirose;
    }

    public void setPirose(String pirose) {
        this.pirose = pirose;
    }

    public String getDisfagia() {
        return disfagia;
    }

    public void setDisfagia(String disfagia) {
        this.disfagia = disfagia;
    }

    public String getOdinofagia() {
        return odinofagia;
    }

    public void setOdinofagia(String odinofagia) {
        this.odinofagia = odinofagia;
    }

}
