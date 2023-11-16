/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Admin {
    String Correo,Nombre,contrasena,Estado;
    int IdRol_Fk,NroDocumento_fk; 

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdRol_Fk() {
        return IdRol_Fk;
    }

    public void setIdRol_Fk(int IdRol_Fk) {
        this.IdRol_Fk = IdRol_Fk;
    }

    public int getNroDocumento_fk() {
        return NroDocumento_fk;
    }

    public void setNroDocumento_fk(int NroDocumento_fk) {
        this.NroDocumento_fk = NroDocumento_fk;
    }
}