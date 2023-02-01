package com.CENIGRAF.GestorMateriales.ModelBD;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Elemento")
public class ElementoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idElemento;
    private String nombreElemento;
    private String descripcion;
    private String UndMedida;
    private Integer cantidad;

    @OneToMany(mappedBy = "elementoModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUndMedida() {
        return UndMedida;
    }

    public void setUndMedida(String undMedida) {
        UndMedida = undMedida;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }
}
