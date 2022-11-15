package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MtPreventivo")
public class MtPreventivoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMtPreventivo;
    private String nombre;
    private String descripcion;

    public Integer getIdMtPreventivo() {
        return idMtPreventivo;
    }

    public void setIdMtPreventivo(Integer idMtPreventivo) {
        this.idMtPreventivo = idMtPreventivo;
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
