/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.entity;

import br.com.jonjts.assistant.persistence.DadosDieteticosPersistencia;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.lang.annotation.Target;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "exames_bioquimicos", daoClass = DadosDieteticosPersistencia.class)
public class DadosBioquimicos {
    
    @DatabaseField(columnName = "id", id = true)
    private Long id;
    
    @DatabaseField(columnName = "id_paciente", canBeNull = false)
    private Long idPaciente;
    
    @DatabaseField(columnName = "id_exame_clinico" , canBeNull = false)
    private Long idExameClinico;
    
    @DatabaseField(columnName = "hemogrobina")
    private Double hemogrobina;
    
    @DatabaseField(columnName = "hematrocito")
    private Double hematrocito;
    
    @DatabaseField(columnName = "hemacias")
    private Double hemacias;
    
    @DatabaseField(columnName = "plaquetas")
    private Double plaquetas;
    
    @DatabaseField(columnName = "colesterol_total")
    private Double colesterolTotal;
    
    @DatabaseField(columnName = "ldl")
    private Double ldl;
    
    @DatabaseField(columnName = "hdl")
    private Double hdl;
    
    @DatabaseField(columnName = "triglicerideos")
    private Double triglicerideos;
    
    @DatabaseField(columnName = "glicose_jejum")
    private Double glicoseJejum;
    
    @DatabaseField(columnName = "glicose_pos_prandial")
    private Double glicosePosPrandial;
    
    @DatabaseField(columnName = "ferro_serico")
    private Double ferroSerico;
    
    @DatabaseField(columnName = "ureia")
    private Double ureia;
    
    @DatabaseField(columnName = "creatinina")
    private Double creatinina;
    
    @DatabaseField(columnName = "tgo")
    private Double tgo;
    
    @DatabaseField(columnName = "tgp")
    private Double tgp;
    
    @DatabaseField(columnDefinition = "ferritina")
    private Double ferritina;

    public DadosBioquimicos() {
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

    public Long getIdExameClinico() {
        return idExameClinico;
    }

    public void setIdExameClinico(Long idExameClinico) {
        this.idExameClinico = idExameClinico;
    }

    public Double getHemogrobina() {
        return hemogrobina;
    }

    public void setHemogrobina(Double hemogrobina) {
        this.hemogrobina = hemogrobina;
    }

    public Double getHematrocito() {
        return hematrocito;
    }

    public void setHematrocito(Double hematrocito) {
        this.hematrocito = hematrocito;
    }

    public Double getHemacias() {
        return hemacias;
    }

    public void setHemacias(Double hemacias) {
        this.hemacias = hemacias;
    }

    public Double getPlaquetas() {
        return plaquetas;
    }

    public void setPlaquetas(Double plaquetas) {
        this.plaquetas = plaquetas;
    }

    public Double getColesterolTotal() {
        return colesterolTotal;
    }

    public void setColesterolTotal(Double colesterolTotal) {
        this.colesterolTotal = colesterolTotal;
    }

    public Double getLdl() {
        return ldl;
    }

    public void setLdl(Double ldl) {
        this.ldl = ldl;
    }

    public Double getHdl() {
        return hdl;
    }

    public void setHdl(Double hdl) {
        this.hdl = hdl;
    }

    public Double getTriglicerideos() {
        return triglicerideos;
    }

    public void setTriglicerideos(Double triglicerideos) {
        this.triglicerideos = triglicerideos;
    }

    public Double getGlicoseJejum() {
        return glicoseJejum;
    }

    public void setGlicoseJejum(Double glicoseJejum) {
        this.glicoseJejum = glicoseJejum;
    }

    public Double getGlicosePosPrandial() {
        return glicosePosPrandial;
    }

    public void setGlicosePosPrandial(Double glicosePosPrandial) {
        this.glicosePosPrandial = glicosePosPrandial;
    }

    public Double getFerroSerico() {
        return ferroSerico;
    }

    public void setFerroSerico(Double ferroSerico) {
        this.ferroSerico = ferroSerico;
    }

    public Double getUreia() {
        return ureia;
    }

    public void setUreia(Double ureia) {
        this.ureia = ureia;
    }

    public Double getCreatinina() {
        return creatinina;
    }

    public void setCreatinina(Double creatinina) {
        this.creatinina = creatinina;
    }

    public Double getTgo() {
        return tgo;
    }

    public void setTgo(Double tgo) {
        this.tgo = tgo;
    }

    public Double getTgp() {
        return tgp;
    }

    public void setTgp(Double tgp) {
        this.tgp = tgp;
    }

    public Double getFerritina() {
        return ferritina;
    }

    public void setFerritina(Double ferritina) {
        this.ferritina = ferritina;
    }
    
}
