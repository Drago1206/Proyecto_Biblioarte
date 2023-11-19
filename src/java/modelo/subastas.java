/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author jhoan
 */
public class subastas {
    String fecha_actual,idComp, idArt;
    float valor_Ofrecido, Valor_Ini;
    int  idObras, idsubasta;
    Obras obras;
    Artistas art;
    Compradores comp;

    public int getIdsubasta() {
        return idsubasta;
    }

    public void setIdsubasta(int idsubasta) {
        this.idsubasta = idsubasta;
    }
    
    

    public Obras getObras() {
        return obras;
    }

    public void setObras(Obras obras) {
        this.obras = obras;
    }

    public Artistas getArt() {
        return art;
    }

    public void setArt(Artistas art) {
        this.art = art;
    }

    public Compradores getComp() {
        return comp;
    }

    public void setComp(Compradores comp) {
        this.comp = comp;
    }
    
    

    public float getValor_Ofrecido() {
        return valor_Ofrecido;
    }

    public void setValor_Ofrecido(float valor_Ofrecido) {
        this.valor_Ofrecido = valor_Ofrecido;
    }

    public float getValor_Ini() {
        return Valor_Ini;
    }

    public void setValor_Ini(float Valor_Ini) {
        this.Valor_Ini = Valor_Ini;
    }

    public String getIdComp() {
        return idComp;
    }

    public void setIdComp(String idComp) {
        this.idComp = idComp;
    }

    public String getIdArt() {
        return idArt;
    }

    public void setIdArt(String idArt) {
        this.idArt = idArt;
    }

    public int getIdObras() {
        return idObras;
    }

    public void setIdObras(int idObras) {
        this.idObras = idObras;
    }
    
    

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

   
    
    
}
