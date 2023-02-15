package com.CENIGRAF.GestorMateriales.ModelBD;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "elementos_consumibles")
public class ElementosConsumiblesModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEc;
    private Long codigoSena;
    private String decripcionBien;
    private String unidadMedida;
    private Integer cantidadAlmacen;
    private String observaciones;
    //Atributo imagen pendiente


    public ElementosConsumiblesModel(Integer idEc, Long codigoSena, String decripcionBien, String unidadMedida, Integer cantidadAlmacen, String observaciones) {
        IdEc = idEc;
        this.codigoSena = codigoSena;
        this.decripcionBien = decripcionBien;
        this.unidadMedida = unidadMedida;
        this.cantidadAlmacen = cantidadAlmacen;
        this.observaciones = observaciones;
    }

    public ElementosConsumiblesModel() {
    }

    public Integer getIdEc() {
        return IdEc;
    }

    public void setIdEc(Integer idEc) {
        IdEc = idEc;
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

    public Integer getCantidadAlmacen() {
        return cantidadAlmacen;
    }

    public void setCantidadAlmacen(Integer cantidadAlmacen) {
        this.cantidadAlmacen = cantidadAlmacen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    private static final long serialVersionUID = 1L;
}
