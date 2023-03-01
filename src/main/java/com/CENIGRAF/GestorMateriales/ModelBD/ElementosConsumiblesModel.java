package com.CENIGRAF.GestorMateriales.ModelBD;


import javax.persistence.*;
import java.io.Serializable;

//producto duplicada
@Entity
@Table(name = "elementos_consumibles")
public class ElementosConsumiblesModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEc;
    private Integer codigoSena;
    private String decripcionBien;
    private String unidadMedida;
    private Integer existenciaAlmacen;
    private Integer cantidadSolicitada;
    private Integer observaciones;
    //Atributo imagen pendiente
    @ManyToOne
    @JoinColumn
    private RepoPeriModel repoPeriModel;


    public ElementosConsumiblesModel(Integer idEc, Integer codigoSena, String decripcionBien, String unidadMedida, Integer existenciaAlmacen, Integer cantidadSolicitada, Integer observaciones,RepoPeriModel repoPeriModel) {
        IdEc = idEc;
        this.codigoSena = codigoSena;
        this.decripcionBien = decripcionBien;
        this.unidadMedida = unidadMedida;
        this.existenciaAlmacen = existenciaAlmacen;
        this.cantidadSolicitada = cantidadSolicitada;
        this.observaciones = observaciones;
        this.repoPeriModel = repoPeriModel;
    }

    public ElementosConsumiblesModel(Integer codigoSena, String decripcionBien, String unidadMedida, Integer existenciaAlmacen, Integer cantidadSolicitada, Integer observaciones,RepoPeriModel repoPeriModel) {
        this.codigoSena = codigoSena;
        this.decripcionBien = decripcionBien;
        this.unidadMedida = unidadMedida;
        this.existenciaAlmacen = existenciaAlmacen;
        this.cantidadSolicitada = cantidadSolicitada;
        this.observaciones = observaciones;
        this.repoPeriModel = repoPeriModel;
    }

    public ElementosConsumiblesModel() {
    }

    public boolean sinExistencia(){
        return this.existenciaAlmacen <=0;
    }

    public Integer getExistenciaAlmacen() {
        return existenciaAlmacen;
    }

    public void setExistenciaAlmacen(Integer existenciaAlmacen) {
        this.existenciaAlmacen = existenciaAlmacen;
    }

    public void restarExistencia(Integer existenciaAlmacen){
        this.existenciaAlmacen -= existenciaAlmacen;
    }

    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public Integer getIdEc() {
        return IdEc;
    }

    public void setIdEc(Integer idEc) {
        IdEc = idEc;
    }

    public Integer getCodigoSena() {
        return codigoSena;
    }

    public void setCodigoSena(Integer codigoSena) {
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


    public Integer getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(Integer observaciones) {
        this.observaciones = observaciones;
    }

    public RepoPeriModel getRepoPeriModel() {
        return repoPeriModel;
    }

    public void setRepoPeriModel(RepoPeriModel repoPeriModel) {
        this.repoPeriModel = repoPeriModel;
    }

    private static final long serialVersionUID = 1L;
}
