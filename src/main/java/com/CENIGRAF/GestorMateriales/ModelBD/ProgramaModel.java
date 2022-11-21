package com.CENIGRAF.GestorMateriales.ModelBD;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "programa")
public class ProgramaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idPrograma;

    private String nombre;

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
