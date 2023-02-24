package com.CENIGRAF.GestorMateriales.ModelBD;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "programa")
public class ProgramaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idPrograma;

    private String nombrePrograma;

    @OneToMany(mappedBy = "personalCenigrafModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RepoPeriModel> repoPeriModels;

    public ProgramaModel() {
        repoPeriModels=new ArrayList<RepoPeriModel>();
    }
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

    public void addReportPeri(RepoPeriModel repoPeriModel){
        repoPeriModels.add(repoPeriModel);
    }
    private static final long serialVersionUID = 1L;
}
