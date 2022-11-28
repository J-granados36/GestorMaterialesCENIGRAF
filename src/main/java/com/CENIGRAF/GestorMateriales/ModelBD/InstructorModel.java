package com.CENIGRAF.GestorMateriales.ModelBD;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Instructor")
public class InstructorModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idInstructor;
    private String nombre;
    private Integer cedula;

    private String celular;


    //INSTRUCTOR M-O PROGRAMA
    @ManyToOne
    @JoinColumn(name = "idPrograma")
    @JsonIgnoreProperties({"Instructor"})
    private ProgramaModel programaModel;
    //INTRUCTOR M-M AMBIENTE

    @ManyToMany(mappedBy = "instructores")
    public List<AmbienteModel> Ambientes;

    public List<AmbienteModel> getAmbientes() {
        return Ambientes;
    }

    public void setAmbientes(List<AmbienteModel> ambientes) {
        Ambientes = ambientes;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ProgramaModel getProgramaModel() {
        return programaModel;
    }

    public void setProgramaModel(ProgramaModel programaModel) {
        this.programaModel = programaModel;
    }
}
