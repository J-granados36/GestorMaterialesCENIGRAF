package com.CENIGRAF.GestorMateriales.ModelBD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Ambiente")
public class AmbienteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAmbiente;
    private String nombre;
    private String descripcion;


    //AMBIENTE O-M MAQUINA
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"Ambiente"})
    public List<MaquinaModel>maquinaModels;

    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
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

    public List<MaquinaModel> getMaquinaModels() {
        return maquinaModels;
    }

    public void setMaquinaModels(List<MaquinaModel> maquinaModels) {
        this.maquinaModels = maquinaModels;
    }
}
