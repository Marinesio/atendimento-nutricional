/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.entity;

import br.com.jonjts.assistant.persistence.DadosAntropometricosPersistence;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Jonas
 */
@DatabaseTable(tableName = "dados_antropometricos")
public class DadosAntropometricos {
    
    @DatabaseField(id = true)
    private Long id;
    
    @DatabaseField(columnName = "id_exame_clinico", foreign = true, foreignAutoRefresh = true )
    private ExameClinico exameClinico;
    
    @DatabaseField(columnName = "id_paciente", foreign = true, foreignAutoRefresh = true)
    private Paciente paciente;
    
    @DatabaseField
    private Double peso;
    
    @DatabaseField
    private Double altura;
    
    @DatabaseField(columnName = "circuferencia_cintura")
    private Double circuferenciaCintural;
    
    @DatabaseField(columnName = "circuferencia_abdominal")
    private Double circuferenciaAbdominal;
    
    @DatabaseField(columnName = "circuferencia_quadril")
    private Double circuferenciaQuadril;
    
    @DatabaseField(columnName = "circuferencia_braquial")
    private Double circuferenciaBraquial;
    
    @DatabaseField(columnName = "circuferencia_panturrilha")
    private Double circuferenciaPanturrilha;
    
    @DatabaseField(columnName = "circuferencia_muscular_braco")
    private Double circuferenciaMuscularBraco;
    
    @DatabaseField
    private Double pcb;
    
    @DatabaseField
    private Double pct;
    
    @DatabaseField
    private Double pcsi;
    
    @DatabaseField
    private Double pcse;
    
    @DatabaseField(columnName = "pc_abdominal")
    private Double pcAbdominal;
    
    @DatabaseField(columnName = "pc_coxa")
    private Double pcCoxa;
    
    @DatabaseField(columnName = "pc_peitoral")
    private Double pcPeitoral;
    
    @DatabaseField(columnName = "pc_gemenial")
    private Double pcGemenial;
    
    @DatabaseField(columnName = "pc_axilar_media")
    private Double pcAuxiliarMedia;
    
    @DatabaseField
    private Double cmb;

    public DadosAntropometricos() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExameClinico getExameClinico() {
        return exameClinico;
    }

    public void setExameClinico(ExameClinico exameClinico) {
        this.exameClinico = exameClinico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getCircuferenciaCintural() {
        return circuferenciaCintural;
    }

    public void setCircuferenciaCintural(Double circuferenciaCintural) {
        this.circuferenciaCintural = circuferenciaCintural;
    }

    public Double getCircuferenciaAbdominal() {
        return circuferenciaAbdominal;
    }

    public void setCircuferenciaAbdominal(Double circuferenciaAbdominal) {
        this.circuferenciaAbdominal = circuferenciaAbdominal;
    }

    public Double getCircuferenciaQuadril() {
        return circuferenciaQuadril;
    }

    public void setCircuferenciaQuadril(Double circuferenciaQuadril) {
        this.circuferenciaQuadril = circuferenciaQuadril;
    }

    public Double getCircuferenciaBraquial() {
        return circuferenciaBraquial;
    }

    public void setCircuferenciaBraquial(Double circuferenciaBraquial) {
        this.circuferenciaBraquial = circuferenciaBraquial;
    }

    public Double getCircuferenciaPanturrilha() {
        return circuferenciaPanturrilha;
    }

    public void setCircuferenciaPanturrilha(Double circuferenciaPanturrilha) {
        this.circuferenciaPanturrilha = circuferenciaPanturrilha;
    }

    public Double getCircuferenciaMuscularBraco() {
        return circuferenciaMuscularBraco;
    }

    public void setCircuferenciaMuscularBraco(Double circuferenciaMuscularBraco) {
        this.circuferenciaMuscularBraco = circuferenciaMuscularBraco;
    }

    public Double getPcb() {
        return pcb;
    }

    public void setPcb(Double pcb) {
        this.pcb = pcb;
    }

    public Double getPct() {
        return pct;
    }

    public void setPct(Double pct) {
        this.pct = pct;
    }

    public Double getPcsi() {
        return pcsi;
    }

    public void setPcsi(Double pcsi) {
        this.pcsi = pcsi;
    }

    public Double getPcse() {
        return pcse;
    }

    public void setPcse(Double pcse) {
        this.pcse = pcse;
    }

    public Double getPcAbdominal() {
        return pcAbdominal;
    }

    public void setPcAbdominal(Double pcAbdominal) {
        this.pcAbdominal = pcAbdominal;
    }

    public Double getPcCoxa() {
        return pcCoxa;
    }

    public void setPcCoxa(Double pcCoxa) {
        this.pcCoxa = pcCoxa;
    }

    public Double getPcPeitoral() {
        return pcPeitoral;
    }

    public void setPcPeitoral(Double pcPeitoral) {
        this.pcPeitoral = pcPeitoral;
    }

    public Double getPcGemenial() {
        return pcGemenial;
    }

    public void setPcGemenial(Double pcGemenial) {
        this.pcGemenial = pcGemenial;
    }

    public Double getPcAuxiliarMedia() {
        return pcAuxiliarMedia;
    }

    public void setPcAuxiliarMedia(Double pcAuxiliarMedia) {
        this.pcAuxiliarMedia = pcAuxiliarMedia;
    }

    public Double getCmb() {
        return cmb;
    }

    public void setCmb(Double cmb) {
        this.cmb = cmb;
    }
    
    
    
}
