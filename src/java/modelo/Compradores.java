/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Compradores {

    int idRol_fk, idUsuario, NroDocumento;
    String NombreUsuario,CorreoUsuario,contrasena,Telefono,Estado,Pseudonombre,TipoDocumento,Img_perfil;

    public String getImg_perfil() {
        return Img_perfil;
    }

    public void setImg_perfil(String Img_perfil) {
        this.Img_perfil = Img_perfil;
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
