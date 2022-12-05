package com.CENIGRAF.GestorMateriales.ModelBD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    public List<MaquinaModel> maquinaModel;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "instructorambiente",
            joinColumns = {@JoinColumn(name = "idAmbiente")},
            inverseJoinColumns = {@JoinColumn(name = "idInstructor")}
    )
    private List<InstructorModel>instructores= new ArrayList<>();

    public List<InstructorModel> getInstructores() {
        return instructores;
    }

    public void setInstructores(List<InstructorModel> instructores) {
        this.instructores = instructores;
    }

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

    public List<MaquinaModel> getMaquinaModel() {
        return maquinaModel;
    }

    public void setMaquinaModel(List<MaquinaModel> maquinaModel) {
        this.maquinaModel = maquinaModel;
    }
}
