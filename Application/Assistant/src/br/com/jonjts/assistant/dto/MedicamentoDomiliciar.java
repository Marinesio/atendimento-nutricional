/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "medicamento_domiciliar")
public class MedicamentoDomiliciar {

    @DatabaseField(columnName = "id", id = true)
    private Long id;

    @DatabaseField(columnName = "id_paciente", foreign = true, foreignAutoRefresh = true)
    private Paciente paciente;

    @DatabaseField(columnName = "nome", canBeNull = false)
    private String nome;

    @DatabaseField(columnName = "frequencia", canBeNull = false)
    private String frequencia;

    public MedicamentoDomiliciar(Long id, Paciente idPaciente, String nome, String frequencia) {
        this.id = id;
        this.paciente = idPaciente;
        this.nome = nome;
        this.frequencia = frequencia;
    }

    public MedicamentoDomiliciar() {
        setFrequencia("");
        setNome("");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getIdPaciente() {
        return paciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.paciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object obj) {
        MedicamentoDomiliciar md = (MedicamentoDomiliciar) obj;
        if(this.getId() == md.getId()){
            return true;
        }
        return false;
    }
    
    

}
