/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.dto;

import br.com.jonjts.assistant.persistencia.ExameClinicoPersistencia;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "exame_clinico", daoClass = ExameClinicoPersistencia.class)
public class ExameClinico implements Serializable{
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public static final String FILD_ID = "id";
    public static final String FILD_ID_PACIENTE = "id_paciente";
    public static final String FILD_DATE = "data";
    
    @DatabaseField(columnName = FILD_ID, id = true)
    private Long id;
    
    @DatabaseField(columnName = FILD_ID_PACIENTE, canBeNull = false)
    private Long idPaciente;
    
   @DatabaseField(columnName = FILD_DATE, format = "dd/MM/yyyy") 
    private Date data;

    public ExameClinico() {
        super();
    }

    public ExameClinico(Long id, Long idPaciente, Date data) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.data = data;
    }

    public ExameClinico(Long idPaciente, Date data) {
        this.idPaciente = idPaciente;
        this.data = data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if(isToday()){
            return "Hoje";
        }
        return sdf.format(getData());
    }
    
    public boolean isToday(){
        if(data != null){
            Date d = new Date();
            if(d.getDay() == data.getDay() && d.getMonth() == data.getMonth() && d.getYear() == data.getYear()){
                return true;
            }
        }
        return false;
    }
   
    
}
