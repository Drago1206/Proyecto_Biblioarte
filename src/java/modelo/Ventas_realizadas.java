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
public class Ventas_realizadas {
    
    int Num_venta,NroFactura,id_obra_fk , Id_usu_art_Fk, Id_usu_comprador_FK;
    float Valor_total;
    Date fecha_venta;
    Obras obr;
    Artistas Art;
    Compradores comp;

    public int getNroFactura() {
        return NroFactura;
    }

    public void setNroFactura(int NroFactura) {
        this.NroFactura = NroFactura;
    }

    public Obras getObr() {
        return obr;
    }

    public void setObr(Obras obr) {
        this.obr = obr;
    }

    public Artistas getArt() {
        return Art;
    }

    public void setArt(Artistas Art) {
        this.Art = Art;
    }

    public Compradores getComp() {
        return comp;
    }

    public void setComp(Compradores comp) {
        this.comp = comp;
    }
    

    public int getNum_venta() {
        return Num_venta;
    }

    public void setNum_venta(int Num_venta) {
        this.Num_venta = Num_venta;
    }

    public int getId_obra_fk() {
        return id_obra_fk;
    }

    public void setId_obra_fk(int id_obra_fk) {
        this.id_obra_fk = id_obra_fk;
    }

    public int getId_usu_art_Fk() {
        return Id_usu_art_Fk;
    }

    public void setId_usu_art_Fk(int Id_usu_art_Fk) {
        this.Id_usu_art_Fk = Id_usu_art_Fk;
    }

    public int getId_usu_comprador_FK() {
        return Id_usu_comprador_FK;
    }

    public void setId_usu_comprador_FK(int Id_usu_comprador_FK) {
        this.Id_usu_comprador_FK = Id_usu_comprador_FK;
    }

    public float getValor_total() {
        return Valor_total;
    }

    public void setValor_total(float Valor_total) {
        this.Valor_total = Valor_total;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
}
