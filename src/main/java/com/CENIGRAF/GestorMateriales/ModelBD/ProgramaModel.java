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

    private String nombrePrograma;

    @OneToMany(mappedBy = "programaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<FichaModel> fichaModels;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInstructor")
    private InstructorModel instructorModel;

    @OneToMany(mappedBy = "programaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public List<FichaModel> getFichaModels() {
        return fichaModels;
    }

    public void setFichaModels(List<FichaModel> fichaModels) {
        this.fichaModels = fichaModels;
    }

    public InstructorModel getInstructorModel() {
        return instructorModel;
    }

    public void setInstructorModel(InstructorModel instructorModel) {
        this.instructorModel = instructorModel;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }
}
