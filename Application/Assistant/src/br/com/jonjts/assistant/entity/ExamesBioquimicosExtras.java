/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.entity;

import br.com.jonjts.assistant.persistence.ExamesBioquimicosPersistence;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "exames_bioquimicos_extras", daoClass = ExamesBioquimicosPersistence.class)
public class ExamesBioquimicosExtras {

    @DatabaseField(columnName = "id", id = true)
    private Long id;

    @DatabaseField(columnName = "id_paciente", foreign = true, foreignAutoRefresh = true)
    private Paciente paciente;

    @DatabaseField(columnName = "id_exame_clinico", foreign = true, foreignAutoRefresh = true)
    private ExameClinico exameClinico;

    @DatabaseField(columnName = "nome")
    private String nome;

    @DatabaseField(columnName = "resultado")
    private String resultado;

    @DatabaseField(columnName = "referencia")
    private String referencia;

    public ExamesBioquimicosExtras() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ExameClinico getExameClinico() {
        return exameClinico;
    }

    public void setExameClinico(ExameClinico exameClinico) {
        this.exameClinico = exameClinico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
