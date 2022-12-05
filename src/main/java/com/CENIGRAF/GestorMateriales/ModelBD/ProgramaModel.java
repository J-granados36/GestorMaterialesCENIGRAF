package com.CENIGRAF.GestorMateriales.ModelBD;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "programa")
public class ProgramaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idPrograma;

    private String nombre;


    //PROGRAMA O-M FICHAS
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"programa"})
    public List<FichaModel>fichaModel;

    //PROGRAMA M-O ALMACEN



    //programa o-m instructor
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"programa"})
    public List<InstructorModel>instructorModels;

    public void setFichaModel(List<FichaModel> fichaModel) {
        this.fichaModel = fichaModel;
    }

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

    public List<FichaModel> getFichaModel() {
        return fichaModel;
    }

    public void setFichaModels(List<FichaModel> fichaModels) {
        this.fichaModel = fichaModels;
    }


    public List<InstructorModel> getInstructorModels() {
        return instructorModels;
    }

    public void setInstructorModels(List<InstructorModel> instructorModels) {
        this.instructorModels = instructorModels;
    }
}
