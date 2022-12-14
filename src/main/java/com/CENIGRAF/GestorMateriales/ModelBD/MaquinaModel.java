package com.CENIGRAF.GestorMateriales.ModelBD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Maquina")
public class MaquinaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMaquina;
    private String nombreMaquina;
    private Integer placa;
    private Date adquisicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAmbiente")
    private AmbienteModel ambienteModel;

    @OneToMany(mappedBy = "maquinaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MtPreventivoModel> mtPreventivoModels;

    @OneToMany(mappedBy = "maquinaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MtCorrectivoModel> mtCorrectivoModels;

    @OneToMany(mappedBy = "maquinaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;
    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public Integer getPlaca() {
        return placa;
    }

    public void setPlaca(Integer placa) {
        this.placa = placa;
    }

    public Date getAdquisicion() {
        return adquisicion;
    }

    public void setAdquisicion(Date adquisicion) {
        this.adquisicion = adquisicion;
    }

    public AmbienteModel getAmbienteModel() {
        return ambienteModel;
    }

    public void setAmbienteModel(AmbienteModel ambienteModel) {
        this.ambienteModel = ambienteModel;
    }

    public List<MtPreventivoModel> getMtPreventivoModels() {
        return mtPreventivoModels;
    }

    public void setMtPreventivoModels(List<MtPreventivoModel> mtPreventivoModels) {
        this.mtPreventivoModels = mtPreventivoModels;
    }

    public List<MtCorrectivoModel> getMtCorrectivoModels() {
        return mtCorrectivoModels;
    }

    public void setMtCorrectivoModels(List<MtCorrectivoModel> mtCorrectivoModels) {
        this.mtCorrectivoModels = mtCorrectivoModels;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }
}
