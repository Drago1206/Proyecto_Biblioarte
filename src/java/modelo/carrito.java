/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class carrito {
     int id_obra, id_usu_art, Nro_categoria,cantidad;

    String Nombre_obra, Descripcion_obra, Tecnica,Url,Modo_vent;
    float valor_obra, subtotal;
    Artistas artista;
    Compradores comprador;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    
    
    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public int getId_usu_art() {
        return id_usu_art;
    }

    public void setId_usu_art(int id_usu_art) {
        this.id_usu_art = id_usu_art;
    }

    public int getNro_categoria() {
        return Nro_categoria;
    }

    public void setNro_categoria(int Nro_categoria) {
        this.Nro_categoria = Nro_categoria;
    }

    public String getNombre_obra() {
        return Nombre_obra;
    }

    public void setNombre_obra(String Nombre_obra) {
        this.Nombre_obra = Nombre_obra;
    }

    public String getDescripcion_obra() {
        return Descripcion_obra;
    }

    public void setDescripcion_obra(String Descripcion_obra) {
        this.Descripcion_obra = Descripcion_obra;
    }

    public String getTecnica() {
        return Tecnica;
    }

    public void setTecnica(String Tecnica) {
        this.Tecnica = Tecnica;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getModo_vent() {
        return Modo_vent;
    }

    public void setModo_vent(String Modo_vent) {
        this.Modo_vent = Modo_vent;
    }

    public float getValor_obra() {
        return valor_obra;
    }

    public void setValor_obra(float valor_obra) {
        this.valor_obra = valor_obra;
    }

    public Artistas getArtista() {
        return artista;
    }

    public void setArtista(Artistas artista) {
        this.artista = artista;
    }

    public Compradores getComprador() {
        return comprador;
    }

    public void setComprador(Compradores comprador) {
        this.comprador = comprador;
    }
    
    
    
}
