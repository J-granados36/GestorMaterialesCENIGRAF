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
    private String nombreInstructor;
    private Integer cedula;

    private String celular;

    private String correo;

    @OneToMany(mappedBy = "instructorModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProgramaModel> programaModels;

    @OneToMany(mappedBy = "instructorModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AmbienteModel> ambienteModels;

    @OneToMany(mappedBy = "instructorModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<ProgramaModel> getProgramaModels() {
        return programaModels;
    }

    public void setProgramaModels(List<ProgramaModel> programaModels) {
        this.programaModels = programaModels;
    }

    public List<AmbienteModel> getAmbienteModels() {
        return ambienteModels;
    }

    public void setAmbienteModels(List<AmbienteModel> ambienteModels) {
        this.ambienteModels = ambienteModels;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }
}
