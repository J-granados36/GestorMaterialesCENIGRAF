package com.CENIGRAF.GestorMateriales.ModelBD;

import com.lowagie.text.pdf.PdfPCell;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Elemento")
public class ElementoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idElemento;
    private String nombreElemento;
    private String descripcion;
    private String UndMedida;
    private Integer cantidad;

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUndMedida() {
        return UndMedida;
    }

    public void setUndMedida(String undMedida) {
        UndMedida = undMedida;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    }
