package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MtCorrectivo")
public class MtCorrectivoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMtCorrectivo;
    private String nombre;
    private String descripcion;


    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "maquinacorrectivo",
            joinColumns = {@JoinColumn(name = "idMaquina")},
            inverseJoinColumns = {@JoinColumn(name = "idMtCorrectivo")}
    )
    private List<MaquinaModel> maquinas= new ArrayList<>();

    public List<MaquinaModel> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<MaquinaModel> maquinas) {
        this.maquinas = maquinas;
    }

    public Integer getIdMtCorrectivo() {
        return idMtCorrectivo;
    }

    public void setIdMtCorrectivo(Integer idMtCorrectivo) {
        this.idMtCorrectivo = idMtCorrectivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}