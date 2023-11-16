/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Usuario {
    int id, documento, id_rol;
    String nombre, correo, password,telefono,Estado,Pseudonombre,TipoDocumento;    
    Rol rol;

    public Usuario() {
    }

    public Usuario(int id, int documento,int id_rol ,String nombre, String correo, String Estado,  String Pseudonombre, String TipoDocumento, String telefono ,String password, Rol rol) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.Estado = Estado;
        this.password = password;
        this.rol = rol;
        this.Pseudonombre= Pseudonombre;
        this.TipoDocumento= TipoDocumento;
        this.telefono= telefono;
        this.id_rol= id_rol;
        
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
     public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPseudonombre() {
        return Pseudonombre;
    }

    public void setPseudonombre(String Pseudonombre) {
        this.Pseudonombre = Pseudonombre;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }
    
}
