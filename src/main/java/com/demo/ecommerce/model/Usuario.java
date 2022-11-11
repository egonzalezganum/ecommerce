package com.demo.ecommerce.model;

public class Usuario {

    private Integer id;
    private String nombre;
    private String user;
    private String mail;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String user, String mail, String direccion, String telefono, String tipo,
            String password) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.user = user;
        this.mail = mail;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user [id=" + id + ", nombre=" + nombre + ", user=" + user + ", mail=" + mail + ", direccion="
                + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password + "]";
    }

}
