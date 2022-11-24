package com.CENIGRAF.GestorMateriales.ModelBD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "almacen")
public class AlmacenModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAlmacen;

    //ALMACEN O-M ELEMENTOS
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"almacen"})
    public List<ElementoModel>elementoModel;


    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public List<ElementoModel> getElementoModel() {
        return elementoModel;
    }

    public void setElementoModel(List<ElementoModel> elementoModel) {
        this.elementoModel = elementoModel;
    }
}
