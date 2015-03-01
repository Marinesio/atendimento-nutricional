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
@DatabaseTable(tableName = "exercicio")
public class Exercicio {

    @DatabaseField(columnName = "id", id = true)
    private Long id;

    @DatabaseField(columnName = "id_paciente", foreign = true, foreignAutoRefresh = true)
    private Paciente paciente;

    @DatabaseField(columnName = "tipo", canBeNull = false)
    private String tipo;

    @DatabaseField(columnName = "frequencia", canBeNull = false)
    private String frequencia;

    @DatabaseField(columnName = "duracao", canBeNull = false)
    private String duracao;

    public Exercicio() {
        setDuracao("");
        setFrequencia("");
        setTipo("");
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object obj) {
        Exercicio e = (Exercicio) obj;
        if (this.getId() == e.getId()) {
            return true;
        }
        return false;
    }

}
