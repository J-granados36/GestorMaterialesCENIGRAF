package com.CENIGRAF.GestorMateriales.ModelBD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Elemento")
public class ElementoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idElemento;
    private String nombre;
    private String descripcion;
    private String UndMedida;
    private Integer cantidad;


    //Elementos m-o Almacen
    @ManyToOne
    @JoinColumn(name = "idAlmacen")
    @JsonIgnoreProperties({"Elemento"})
    private AlmacenModel almacenModel;



    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public AlmacenModel getAlmacenModel() {
        return almacenModel;
    }

    public void setAlmacenModel(AlmacenModel almacenModel) {
        this.almacenModel = almacenModel;
    }
}
