/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.dto;

import br.com.jonjts.assistant.persistencia.DadosDieteticosPersistencia;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "dados_dieteticos", daoClass = DadosDieteticosPersistencia.class)
public class DadosDieteticos {
    
    @DatabaseField(columnName = "id", id = true)
    private Long id;
    
    @DatabaseField(columnName = "id_paciente", canBeNull = false)
    private Long idPaciente;
    
    @DatabaseField(columnName = "id_exame_clinico" , canBeNull = false)
    private Long idExameClinico;
    
    @DatabaseField(columnName = "aversao")
    private String aversao;
    
    @DatabaseField(columnName = "preferencia")
    private String preferencia;
    
    @DatabaseField(columnName = "intolerancia")
    private String intolerancia;
    
    @DatabaseField(columnName = "alergias")
    private String alergias;
    
    @DatabaseField(columnName = "ingestao_hidrica")
    private String ingestaoHidrica;
    
    @DatabaseField(columnName = "liquidos_associados")
    private String liquidosAssociados;

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

    public String getAversao() {
        return aversao;
    }

    public void setAversao(String aversao) {
        this.aversao = aversao;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public String getIntolerancia() {
        return intolerancia;
    }

    public void setIntolerancia(String intolerancia) {
        this.intolerancia = intolerancia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getIngestaoHidrica() {
        return ingestaoHidrica;
    }

    public void setIngestaoHidrica(String ingestaoHidrica) {
        this.ingestaoHidrica = ingestaoHidrica;
    }

    public String getLiquidosAssociados() {
        return liquidosAssociados;
    }

    public void setLiquidosAssociados(String liquidosAssociados) {
        this.liquidosAssociados = liquidosAssociados;
    }

    
    
    
}
