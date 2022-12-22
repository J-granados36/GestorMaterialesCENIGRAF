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
    private String nombreAmbiente;
    private String descripcion;

    @OneToMany(mappedBy = "ambienteModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MaquinaModel> maquinaModels;

    @OneToMany(mappedBy = "ambienteModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInstructor")
    private InstructorModel instructorModel;
    public Integer getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Integer idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getNombreAmbiente() {
        return nombreAmbiente;
    }

    public void setNombreAmbiente(String nombreAmbiente) {
        this.nombreAmbiente = nombreAmbiente;
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

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }

    public InstructorModel getInstructorModel() {
        return instructorModel;
    }

    public void setInstructorModel(InstructorModel instructorModel) {
        this.instructorModel = instructorModel;
    }
}
