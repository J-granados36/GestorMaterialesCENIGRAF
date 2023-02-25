package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;

@Entity
public class ElementoSolicitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEs;

    private Long codigoSena;
    private String decripcionBien;
    private String unidadMedida;
    private Integer existenciaAlmacen;
    private Integer cantidadSolicitada;
    private String observaciones;

    @ManyToOne
    @JoinColumn
    private RepoPeriModel repoPeriModel;

    public ElementoSolicitado(Long codigoSena, String decripcionBien, String unidadMedida, Integer existenciaAlmacen, Integer cantidadSolicitada, String observaciones, RepoPeriModel repoPeriModel) {
        this.codigoSena = codigoSena;
        this.decripcionBien = decripcionBien;
        this.unidadMedida = unidadMedida;
        this.existenciaAlmacen = existenciaAlmacen;
        this.cantidadSolicitada = cantidadSolicitada;
        this.observaciones = observaciones;
        this.repoPeriModel = repoPeriModel;
    }

    public ElementoSolicitado(Integer cantidad, String unidadMedida, Integer cantidadSolicitada, Integer existenciaAlmacen, Integer observaciones, String decripcionBien, Integer codigoSena, RepoPeriModel s) {
    }

    public ElementoSolicitado() {

    }

    public Integer getTotal(){
        return this.cantidadSolicitada + this.cantidadSolicitada;
    }

    public Integer getIdEs() {
        return idEs;
    }

    public void setIdEs(Integer idEs) {
        this.idEs = idEs;
    }

    public Long getCodigoSena() {
        return codigoSena;
    }

    public void setCodigoSena(Long codigoSena) {
        this.codigoSena = codigoSena;
    }

    public String getDecripcionBien() {
        return decripcionBien;
    }

    public void setDecripcionBien(String decripcionBien) {
        this.decripcionBien = decripcionBien;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getExistenciaAlmacen() {
        return existenciaAlmacen;
    }

    public void setExistenciaAlmacen(Integer existenciaAlmacen) {
        this.existenciaAlmacen = existenciaAlmacen;
    }

    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public RepoPeriModel getRepoPeriModel() {
        return repoPeriModel;
    }

    public void setRepoPeriModel(RepoPeriModel repoPeriModel) {
        this.repoPeriModel = repoPeriModel;
    }
}
