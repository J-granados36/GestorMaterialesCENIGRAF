package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column(unique=true)
    private String nombre;
    
    @Column(unique=true)
    private String contrasena;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<RolModel> roles;
    
    
     public UsuarioModel(String nombre, String contrasena, List<RolModel> asList) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public UsuarioModel(String nombre, String contrasena, Collection<RolModel> roles, String enable) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public UsuarioModel() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public Collection<RolModel> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RolModel> roles) {
        this.roles = roles;
    }
}
