package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ficha")
public class FichaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idFicha;

    private Integer numeroFicha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPrograma",nullable = false)
    private ProgramaModel programaModel;

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
}
