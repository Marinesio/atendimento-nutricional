/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.dto;

import br.com.jonjts.assistant.dao.PacienteDAO;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "paciente", daoClass = PacienteDAO.class)
public class Paciente implements Serializable{

    public static final String FILD_ID = "id";
    public static final String FILD_NOME = "nome";
    public static final String FILD_SEXO = "sexo";
    public static final String FILD_DATA_NASCIMENTO = "data_nascimento";
    public static final String FILD_PROFISSAO = "profissao";
    public static final String FILD_OBJETIVO_CONSULTA = "objetivo_consulta";
    public static final String FILD_DATA_CADASTRO = "data_cadastro";
    public static final String FILD_ESCOLARIDADE = "escolaridade";
    
    @DatabaseField(columnName = FILD_ID)
    private Long id;
    
    @DatabaseField(columnName = FILD_NOME, canBeNull = false)
    private String nome;
    
    @DatabaseField(columnName = FILD_SEXO, canBeNull = false)
    private String sexo;
    
    @DatabaseField(columnName = FILD_DATA_NASCIMENTO, format = "dd/MM/yyyy")
    private Date dataNascimento;
    
    @DatabaseField(columnName = FILD_PROFISSAO)
    private String profissao;
    
    @DatabaseField(columnName = FILD_OBJETIVO_CONSULTA, canBeNull = false)
    private String objetivoConsulta;
    
    @DatabaseField(columnName = FILD_DATA_CADASTRO, canBeNull = false, format = "dd/MM/yyyy hh:mm")
    private Date dataCadastro;
    
    @DatabaseField(columnName = FILD_ESCOLARIDADE)
    private String escolaridade;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String sexo, Date dataNascimento, String profissao, String objetivoConsulta, Date dataCadastro, String escolaridade) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.objetivoConsulta = objetivoConsulta;
        this.dataCadastro = dataCadastro;
        this.escolaridade = escolaridade;
    }

    public Paciente(String nome, String sexo, Date dataNascimento, String profissao, String objetivoConsulta, Date dataCadastro, String escolaridade) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.objetivoConsulta = objetivoConsulta;
        this.dataCadastro = dataCadastro;
        this.escolaridade = escolaridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getObjetivoConsulta() {
        return objetivoConsulta;
    }

    public void setObjetivoConsulta(String objetivoConsulta) {
        this.objetivoConsulta = objetivoConsulta;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    
    
}

