package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Maquina")
public class MaquinaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMaquina;
    private String nombre;
    private Integer placa;
    private Date adquisicion;

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
}
