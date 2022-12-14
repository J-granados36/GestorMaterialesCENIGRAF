package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "inventario")
public class InventarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idInventario;
    private String nombreElemento;
    private String descripcionElemento;
    private String undMedida;
    private Integer cantidadAlmacen;
    private Integer estado;

    @OneToMany(mappedBy = "inventarioModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public Integer getIdInventario() {
        return idInventario;
    }
    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getDescripcionElemento() {
        return descripcionElemento;
    }

    public void setDescripcionElemento(String descripcionElemento) {
        this.descripcionElemento = descripcionElemento;
    }

    public String getUndMedida() {
        return undMedida;
    }

    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }

    public Integer getCantidadAlmacen() {
        return cantidadAlmacen;
    }

    public void setCantidadAlmacen(Integer cantidadAlmacen) {
        this.cantidadAlmacen = cantidadAlmacen;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }
}
