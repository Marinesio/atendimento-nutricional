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
    private Boolean dificuldadeMastigacao;

    @DatabaseField(columnName = "transito_intestinal")
    private String transitoIntestinal;

    @DatabaseField(columnName = "refluxo")
    private Boolean refluxo;

    @DatabaseField(columnName = "nauseas")
    private Boolean nauseas;

    @DatabaseField(columnName = "vomitos")
    private Boolean vomitos;

    @DatabaseField(columnName = "pirose")
    private Boolean pirose;

    @DatabaseField(columnName = "disfagia")
    private Boolean disfagia;

    @DatabaseField(columnName = "odinofagia")
    private Boolean odinofagia;

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

    public Boolean getDificuldadeMastigacao() {
        return dificuldadeMastigacao;
    }

    public void setDificuldadeMastigacao(Boolean dificuldadeMastigacao) {
        this.dificuldadeMastigacao = dificuldadeMastigacao;
    }

    public String getTransitoIntestinal() {
        return transitoIntestinal;
    }

    public void setTransitoIntestinal(String transitoIntestinal) {
        this.transitoIntestinal = transitoIntestinal;
    }

    public Boolean getRefluxo() {
        return refluxo;
    }

    public void setRefluxo(Boolean refluxo) {
        this.refluxo = refluxo;
    }

    public Boolean getNauseas() {
        return nauseas;
    }

    public void setNauseas(Boolean nauseas) {
        this.nauseas = nauseas;
    }

    public Boolean getVomitos() {
        return vomitos;
    }

    public void setVomitos(Boolean vomitos) {
        this.vomitos = vomitos;
    }

    public Boolean getPirose() {
        return pirose;
    }

    public void setPirose(Boolean pirose) {
        this.pirose = pirose;
    }

    public Boolean getDisfagia() {
        return disfagia;
    }

    public void setDisfagia(Boolean disfagia) {
        this.disfagia = disfagia;
    }

    public Boolean getOdinofagia() {
        return odinofagia;
    }

    public void setOdinofagia(Boolean odinofagia) {
        this.odinofagia = odinofagia;
    }

}
