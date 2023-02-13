package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ficha")
public class FichaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idFicha;

    private Integer numeroFicha;

    @OneToMany(mappedBy = "instructorModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RepoPeriModel> repoPeriModels;
    @OneToMany(mappedBy = "fichaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public FichaModel() {
        repoPeriModels=new ArrayList<RepoPeriModel>();
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Integer getNumeroFicha() {
        return numeroFicha;
    }
    public void setNumeroFicha(Integer numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }

    public void addReportPeri(RepoPeriModel repoPeriModel){
        repoPeriModels.add(repoPeriModel);
    }
    private static final long serialVersionUID = 1L;
}
