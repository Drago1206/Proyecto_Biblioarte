/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Artistas;
import modelo.Compradores;
import modelo.Obras;
import modelo.UsuarioDAO;
import modelo.Ventas_realizadas;
import modelo.subastas;

/**
 *
 * @author jhoan
 */
public class Script extends HttpServlet {
    public static int DocumentArt;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("application/json;charset=UTF-8");
   String menu = request.getParameter("menu");
   String accion = request.getParameter("accion");
   Obras obras = new Obras();
   Artistas Artistas = new Artistas();
   Ventas_realizadas vent = new Ventas_realizadas();
   UsuarioDAO dao = new UsuarioDAO();
   
   
   
   
   switch (menu){
       case "Obras":
           switch (accion){
               case "Crear":
                    String search = request.getParameter("NomObr");
                    String Tecnica = request.getParameter("Tecnica");
                    String Descripcion = request.getParameter("Descripcion");
                    String Precio = request.getParameter("Precio");
                    String Categoria = request.getParameter("Categoria");
                    String ModoVent = request.getParameter("Modovent");
                    String Url = request.getParameter("Urlimg");
                    String Documento = request.getParameter("Documento");
                    String IdUsu = request.getParameter("IdUsu");
                    String NombreUsu = request.getParameter("NombreUsu");
                    String Nivel_Formacion = request.getParameter("Nivel_Formacion");
                    
                    Artistas.setIdUsuario(Integer.parseInt(request.getParameter("IdUsu")));
                    Artistas.setNroDocumento(Integer.parseInt(request.getParameter("Documento")));
                    Artistas.setNivel_Formacion(Nivel_Formacion);
                    obras.setArtista(Artistas);
                    
                    
                    obras.setNombre_obra(search);
                    obras.setTecnica(Tecnica);
                    obras.setDescripcion_obra(Descripcion);
                    obras.setNro_categoria(Integer.parseInt(Categoria));
                    
                    obras.setValor_obra(Float.parseFloat(Precio));
                    obras.setModo_vent(ModoVent);
                    

                        File archivo = new File(Url);
                        
                        if (archivo!= null) {
                                        
                        /* Crea una instancia de File para representar la ubicación donde se guardará el archivo */
                        File f = new File("D:\\xampp\\htdocs\\img\\" + archivo.getName());
                                        
                        obras.setUrl("http://localhost/img/"+f.getName());
                                        
                                        /*  Imprime en la consola la URL de la imagen. */
                        System.out.println("URL de la imagen: " + obras.getUrl());
                        } 
                        dao.Agregar_obras(obras);

                        // Obtener el nombre del archivo
                    String nombreArchivo = archivo.getName();
                    System.out.println(nombreArchivo);
                    System.out.println(search);
                    System.out.println(Tecnica);
                    System.out.println(Descripcion);
                    System.out.println(Precio);
                    System.out.println(Categoria);
                    System.out.println(ModoVent);
                    System.out.println(Url);
                    System.out.println(Documento);
                    System.out.println(IdUsu);
                    System.out.println(NombreUsu);
                    System.out.println(Nivel_Formacion);
                    
                    
                   
                                    
                        /* Verifica si el elemento no es un campo de formulario (es un archivo). */
                        
                                
                    }
            case"SubastasArt":
                        switch (accion){
                            case"versub":
                               String documento = request.getParameter("document");
                                if(documento != null){
                                    subastas sub = new subastas();
                                    sub = dao.Listar_subastas(documento);
                                    
                                    HttpSession sesion = request.getSession();
                                    sesion.setAttribute("sub", sub);
                                    request.getRequestDispatcher("Artista/Subastas.jsp").forward(request, response);
                                    
                                }else{
                                    System.out.print("El documento esta llegando nulo");
                                }
                                
                                break;
                        }
                   }        
   
    // Convertir la lista de proyectos a JSON
    //Gson gson = new Gson();
    //String json = gson.toJson();
    
    
    // Escribir el JSON en la respuesta
    //try (PrintWriter out = response.getWriter()) {
        //out.print("llega el nombre de la obra");
    //}
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
