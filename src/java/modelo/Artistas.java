/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author jhoan
 */
public class Artistas implements Serializable{
    int idRol_fk, idUsuario, NroDocumento;
    String NombreUsuario,CorreoUsuario,contrasena,Telefono,Estado,Pseudonombre,TipoDocumento,img_perfil,Nivel_Formacion,Nombre_Ficha,Numero_Ficha;

    public String getNivel_Formacion() {
        return Nivel_Formacion;
    }

    public void setNivel_Formacion(String Nivel_Formacion) {
        this.Nivel_Formacion = Nivel_Formacion;
    }

    public String getNombre_Ficha() {
        return Nombre_Ficha;
    }

    public void setNombre_Ficha(String Nombre_Ficha) {
        this.Nombre_Ficha = Nombre_Ficha;
    }

    public String getNumero_Ficha() {
        return Numero_Ficha;
    }

    public void setNumero_Ficha(String Numero_Ficha) {
        this.Numero_Ficha = Numero_Ficha;
    }
    
    
    public String getImg_perfil() {
        return img_perfil;
    }

    public void setImg_perfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    public int getIdRol_fk() {
        return idRol_fk;
    }

    public void setIdRol_fk(int idRol_fk) {
        this.idRol_fk = idRol_fk;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(int NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String CorreoUsuario) {
        this.CorreoUsuario = CorreoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
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
