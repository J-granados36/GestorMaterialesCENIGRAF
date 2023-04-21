package com.CENIGRAF.GestorMateriales.Repository;

public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String contrasena;
    private String roles;

    public UsuarioDTO(Integer idUsuario, String nombre, String contrasena, String roles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public UsuarioDTO(String nombre, String contrasena, String roles) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public UsuarioDTO(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioDTO() {
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
}
