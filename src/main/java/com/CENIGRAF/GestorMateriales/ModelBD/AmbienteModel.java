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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInstructor",nullable = false)
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

}
