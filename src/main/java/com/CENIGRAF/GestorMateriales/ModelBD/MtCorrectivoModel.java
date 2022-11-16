package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MtCorrectivo")
public class MtCorrectivoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMtCorrectivo;
    private String nombre;
    private String descripcion;

    public Integer getIdMtCorrectivo() {
        return idMtCorrectivo;
    }

    public void setIdMtCorrectivo(Integer idMtCorrectivo) {
        this.idMtCorrectivo = idMtCorrectivo;
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
}