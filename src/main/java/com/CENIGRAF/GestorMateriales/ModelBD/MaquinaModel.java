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
    private String nombre;
    private Integer placa;
    private Date adquisicion;

    //ambiente m-o maquina
    //MAQUINA M-M MTCORRECTIVO
    @ManyToMany
    @JsonIgnoreProperties({"Maquina"})
    public List<MtCorrectivoModel>mtCorrectivoModels;


    //MAQUINA M-M MTPREVENTIVO
    @ManyToMany
    @JsonIgnoreProperties({"Maquina"})
    public List<MtPreventivoModel>mtPreventivoModels;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<MtCorrectivoModel> getMtCorrectivoModels() {
        return mtCorrectivoModels;
    }

    public void setMtCorrectivoModels(List<MtCorrectivoModel> mtCorrectivoModels) {
        this.mtCorrectivoModels = mtCorrectivoModels;
    }

    public List<MtPreventivoModel> getMtPreventivoModels() {
        return mtPreventivoModels;
    }

    public void setMtPreventivoModels(List<MtPreventivoModel> mtPreventivoModels) {
        this.mtPreventivoModels = mtPreventivoModels;
    }
}
