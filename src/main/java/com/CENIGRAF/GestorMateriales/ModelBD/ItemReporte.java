package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Reportes_items")

public class ItemReporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemReporte;
    private Integer totalSolicitado;
    //relacion unidireccional
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idElemento")
    private ElementoModel elementoModel;


    //METODOS
    public Integer getIdItemReporte() {
        return idItemReporte;
    }

    public void setIdItemReporte(Integer idItemReporte) {
        this.idItemReporte = idItemReporte;
    }

    public Integer getTotalSolicitado() {
        return totalSolicitado;
    }

    public void setTotalSolicitado(Integer toltalSolicitado) {
        this.totalSolicitado = toltalSolicitado;
    }

    //sumatoria de elementos
    //id del elemento == suma++ al total solicitado
    public Integer calcularItem() {
        if (elementoModel.getNombreElemento() == elementoModel.getNombreElemento()) {
            return totalSolicitado.intValue();
        }
        return totalSolicitado.intValue();
    }
    //return totalSolicitado.intValue()+ elementoModel.getIdElemento();

    private static final long serialVersionUID = 1L;
}
