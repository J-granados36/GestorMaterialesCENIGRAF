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

    @OneToMany(mappedBy = "personalCenigrafModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RepoPeriModel> repoPeriModels;

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

    public void addReportPeri(RepoPeriModel repoPeriModel){
        repoPeriModels.add(repoPeriModel);
    }
    private static final long serialVersionUID = 1L;
}
