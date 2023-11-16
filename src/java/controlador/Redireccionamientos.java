/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Artistas;
import modelo.Obras;
import modelo.UsuarioDAO;
import modelo.Ventas_realizadas;

/**
 *
 * @author jhoan
 */
public class Redireccionamientos extends HttpServlet {
    int idArtista;
    int idObras ;
    int Num_Fact=0;
    String NroDocumento;
    String NombreObra;
    Obras obras = new Obras();
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Este método procesa las solicitudes HTTP enviadas al servlet.
    // Recibe dos parámetros: HttpServletRequest para la solicitud y HttpServletResponse para la respuesta.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Configura el tipo de contenido de la respuesta como HTML con codificación UTF-8.
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtiene el parámetro "menu" de la solicitud HTTP.
        String menu = request.getParameter("menu");
        
        // Obtiene el parámetro "accion" de la solicitud HTTP.
        String accion = request.getParameter("accion");
        
            // Verifica si el parámetro "menu" no es nulo.
            if(menu != null){
                
                // Inicia un bloque switch basado en el valor de "menu".
                switch(menu){
                    
                    // En caso de que "menu" sea igual a "Home".
                    case "Home":
                        
                        // Redirecciona la solicitud a "Principal.jsp".
                        request.getRequestDispatcher("Principal.jsp").forward(request,response);
                        break;
                        
                    case "Salir":
                        request.getRequestDispatcher("inicio.jsp").forward(request,response);
                        break;
                    
                    // En caso de que "menu" sea igual a "Artistas".
                    case "Artistas":
                        
                        // Inicia otro bloque switch basado en el valor de "accion".
                        switch(accion){
                            
                            // En caso de que "accion" sea igual a "Listar".
                            case "Listar":
                                
                                // Llama al método estático "Listar_Art" de la clase UsuarioDAO y almacena el resultado en "lista".
                                List lista = UsuarioDAO.Listar_Art();
                                
                                 // Establece un atributo llamado "Art" en el objeto request con el valor de la lista.
                                request.setAttribute("Art", lista);
                                
                                break;
                            
                            // En caso de que "accion" sea igual a "Editar".
                            case "Editar":
                               
                                // Convierte el parámetro "id" de la solicitud a un entero y lo almacena en la variable "idArtista".
                                idArtista = Integer.parseInt(request.getParameter("id"));
                                
                                // Crea una instancia de la clase UsuarioDAO.
                                UsuarioDAO usudao = new UsuarioDAO();
                                /* Llama al método estático "Listar_id" de la clase UsuarioDAO, 
                                pasando el "idArtista" como argumento, y almacena el resultado en "art".*/
                                Artistas art = usudao.Listar_id(idArtista);
                                idArtista = art.getIdUsuario();
                                // Imprime en la consola el valor del atributo "idUsuario" del objeto "art".
                                System.out.println(art.getIdUsuario());
                                // Establece un atributo llamado "ArtistaElj" en el objeto request con el valor del objeto "art".
                                request.setAttribute("ArtistaElj", art);
                                
                                
                                break;
                                
                            
                            // En caso de que "accion" sea igual a "Update".
                            case "Update":
                                
                                // Imprime en la consola un mensaje indicando que ha llegado al otro controlador.
                                System.out.println("Si llega al otro controlador");
                                // Imprime en la consola el valor de "idArtista".
                                System.out.println(idArtista);
                                
                                // Crea una nueva instancia de la clase Artistas.
                                art = new Artistas();
                                //
                                System.out.print("El id del artista actualizado: "+idArtista);
                                
                                // Establece los atributos de la instancia "art" con los valores obtenidos de los parámetros de la solicitud.
                                art.setNroDocumento(Integer.parseInt(request.getParameter("txtDocumento")));
                                art.setContrasena(request.getParameter("Contrasena"));
                                art.setNombreUsuario(request.getParameter("txtNombre"));
                                art.setCorreoUsuario(request.getParameter("txtcorreo"));
                                art.setTipoDocumento(request.getParameter("TipoDocumento"));
                                art.setEstado(request.getParameter("txtestado"));
                                art.setTelefono(request.getParameter("Telefono"));
                                art.setPseudonombre(request.getParameter("txtPseudonombre"));
                                art.setIdRol_fk(Integer.parseInt(request.getParameter("TipoRol")));
                                art.setIdUsuario(idArtista);
                                
                                // Llama al método estático "Actualizar_Art" de la clase UsuarioDAO, pasando la instancia "art" como argumento.
                                UsuarioDAO.Actualizar_Art(art);
                                
                                //if(art.getIdRol_fk()!=2){
                                    //UsuarioDAO.Eliminar_art(idArtista);
                                    //System.out.print("El Artista paso a ser Admin");
                                    
                                //}
   
                                // Redirecciona la solicitud a otro recurso ("Redireccionamientos?menu=Artistas&accion=Listar").
                                request.getRequestDispatcher("Redireccionamientos?menu=Artistas&accion=Listar").forward(request, response);
                                break;
                            
                            // En caso de que "accion" sea igual a "Eliminar".
                            case "Eliminar":  
                                // Convierte el parámetro "id" de la solicitud a un entero y lo almacena en la variable "idArtista".
                                idArtista = Integer.parseInt(request.getParameter("id"));
                                /* Llama al método estático "Eliminar_art" de la clase UsuarioDAO, 
                                pasando el "idArtista" como argumento para eliminar el artista de la base de datos*/
                                UsuarioDAO. Eliminar_art(idArtista);
                                
                                // Redirecciona la solicitud a otro recurso ("Redireccionamientos?menu=Artistas&accion=Listar").
                                request.getRequestDispatcher("Redireccionamientos?menu=Artistas&accion=Listar").forward(request, response);
                                
                                break;
                        }
                        
                        // Redirecciona la solicitud a "Artistas.jsp".
                        request.getRequestDispatcher("Artistas.jsp").forward(request,response);
                        
                        break;
                        
                        
                    // En caso de que "menu" sea igual a "Obras".    
                    case "Obras":
                        
                        // Inicia otro bloque switch basado en el valor de "accion".
                         switch(accion){
                             
                            // En caso de que "accion" sea igual a "Listar".
                            case "Listar":
                                // Llama al método estático "Listar" de la clase UsuarioDAO y almacena el resultado en "lista".
                                List lista = UsuarioDAO.Listar();
                                // Establece un atributo llamado "obras" en el objeto request con el valor de la lista.
                                request.setAttribute("obras", lista);
                                break;
                            
                            // En caso de que "accion" sea igual a "Editar".
                            case "Editar":
                                
                                // Convierte el parámetro "id" de la solicitud a un entero y lo almacena en la variable "idObras".
                                idObras = Integer.parseInt(request.getParameter("id"));
                                // Crea una instancia de la clase Obras.
                                Obras obras = new Obras();
                                // Crea una instancia de la clase UsuarioDAO.
                                UsuarioDAO usudao = new UsuarioDAO();
                                
                                /* Llama al método estático "ListarOb_id" de la clase UsuarioDAO, 
                                pasando el "idObras" como argumento, y almacena el resultado en "obras" */
                                obras = usudao.ListarOb_id(idObras);
                                // Imprime en la consola el valor del atributo "id_obra" del objeto "obras".
                                System.out.print(obras.getId_obra());
                                // Establece un atributo llamado "Obras" en el objeto request con el valor del objeto "obras".
                                request.setAttribute("Obras", obras);
                                
                                break;
                                
                            
                            // En caso de que "accion" sea igual a "Actualizar".
                            case "Actualizar":
                                // Crea una nueva instancia de la clase Obras.
                                obras = new Obras();
                                
                                /* Imprime en la consola el valor del atributo "id_obra" de la instancia "obras". 
                                En este punto, "id_obra" aún no tiene un valor específico*/
                                System.out.print(obras.getId_obra());
                                // Obtiene el parámetro "id" de la solicitud.
                                String idObrasStr = request.getParameter("id");

                                // Verifica si el parámetro "id" no es nulo ni está vacío.
                                if (idObrasStr != null && !idObrasStr.isEmpty()) {
                                    try {
                                        // Intenta convertir el valor de "idObrasStr" a un entero y lo asigna a la variable "idObras".
                                        idObras = Integer.parseInt(idObrasStr);
                                        // Establece el valor de "id_obra" en la instancia "obras" con el valor de "idObras".
                                        obras.setId_obra(idObras);
                                        
                                    } catch (NumberFormatException e) {
                                        // Manejar el error: El valor de 'id' no es un número válido.
                                        System.out.println("Error: El valor de 'id' no es un número válido.");
                                    }
                                } else {
                                    // Manejar el error: No se proporcionó un valor válido para 'id'.
                                    System.out.println("Error: No se proporcionó un valor válido para 'id'.");
                                }
                                
                                // Establece los atributos de la instancia "obras" con los valores obtenidos de los parámetros de la solicitud.
                                obras.setNombre_obra(request.getParameter("txtNombreObra"));
                                obras.setTecnica(request.getParameter("txtTecnica"));
                                obras.setDescripcion_obra(request.getParameter("txtDescripcion"));
                                obras.setValor_obra(Float.parseFloat(request.getParameter("txtPrecio")));

                                // Imprime en la consola algunos mensajes de depuración.
                                System.out.print("EL controlador está bien: " + obras.getNombre_obra());
                                System.out.print("El id de la obra es: "+obras.getId_obra());

                                // Crea una nueva instancia de la clase UsuarioDAO.
                                usudao = new UsuarioDAO();
                                
                                /* Llama al método estático "ActualizarOb" de la clase UsuarioDAO, 
                                pasando la instancia "obras" como argumento para realizar la actualización en la base de datos*/ 
                                usudao.ActualizarOb(obras);

                                // Redirecciona la solicitud a otro recurso ("Redireccionamientos?menu=Obras&accion=Listar").
                                request.getRequestDispatcher("Redireccionamientos?menu=Obras&accion=Listar").forward(request, response);
                                break;
                            
                            // En caso de que "accion" sea igual a "Eliminar".
                            case "Eliminar":
                                // Convierte el parámetro "id" de la solicitud a un entero y lo almacena en la variable "idObras".
                                idObras = Integer.parseInt(request.getParameter("id"));
                                // Crea una nueva instancia de la clase UsuarioDAO.
                                usudao = new UsuarioDAO();
                                
                                /* Llama al método estático "ElminarOb" de la clase UsuarioDAO, 
                                pasando el "idObras" como argumento, para eliminar la obra de la base de datos*/
                                obras = usudao.ElminarOb(idObras);
                                
                                // Redirecciona la solicitud a otro recurso ("Redireccionamientos?menu=Obras&accion=Listar").
                                request.getRequestDispatcher("Redireccionamientos?menu=Obras&accion=Listar").forward(request, response);
                                
                                break;
                        }
                         // Redirecciona la solicitud a "Obras.jsp".
                        request.getRequestDispatcher("Obras.jsp").forward(request,response);
                        break;  
                    
                    // En caso de que "menu" sea igual a "Ventas".
                    case "Ventas":
                        
                        // Inicia otro bloque switch basado en el valor de "accion"
                        switch(accion){
                            
                            // En caso de que "accion" sea igual a "Listar".
                            case "Listar":
                                
                               // Crea una instancia de la clase UsuarioDAO.
                               UsuarioDAO usudao = new UsuarioDAO();
                               /*Obtiene el número de factura llamando al método estático 
                               "NumFactura" de la clase UsuarioDAO y lo almacena en la variable "NumFact"*/
                               String NumFact = usudao.NumFactura();
                               
                               // Imprime en la consola el valor de "NumFact"
                               System.out.print(NumFact);
                               

                               // Verifica si "NumFact" es nulo.
                               if(NumFact == null){   
                                   // Si es nulo, establece "NumFact" en "1".
                                   NumFact ="1";                                 
                               }else{
                                    // Si no es nulo, convierte "NumFact" a un entero, le suma 1 y lo asigna a "Num_Fact".
                                   Num_Fact = Integer.parseInt(NumFact)+1;
                               }
                               // Establece un atributo llamado "Numfact" en el objeto request con el valor de "Num_Fact".
                               request.setAttribute("Numfact", Num_Fact);
                                break;
                            
                            // En caso de que "accion" sea igual a "BuscarArt".
                            case "BuscarArt":
                                // Imprime en la consola un mensaje indicando que ha llegado a buscar el artista.
                                System.out.print("Si llega a buscar artista");
                                // Obtiene el parámetro "NroDocumento" de la solicitud.
                                NroDocumento = (request.getParameter("NroDocumento"));
                                
                                // Crea una instancia de la clase Artistas.
                                Artistas art = new Artistas();
                                // Crea una nueva instancia de la clase UsuarioDAO.
                                usudao = new UsuarioDAO();
                                // Imprime en la consola el valor del atributo "NroDocumento" del objeto "art".
                                System.out.print(art.getNroDocumento());
                                /* Llama al método estático "BuscarPorDocumento" de la clase UsuarioDAO, 
                                pasando el "NroDocumento" como argumento, y almacena el resultado en "art"*/
                                art = usudao.BuscarPorDocumento(NroDocumento);
                                // Establece un atributo llamado "art" en el objeto request con el valor del objeto "art".
                                request.setAttribute("art", art);
                                
                                
                                break;
                                
                            // En caso de que "accion" sea igual a "BuscarObra".    
                            case "BuscarObra":
                                
                                    // Imprime en la consola un mensaje indicando que ha llegado a buscar una obra.
                                    System.out.print("Si llega a buscar obra");
                                    // Obtiene el parámetro "NombreObra" de la solicitud.
                                    NombreObra = request.getParameter("NombreObra");
                                    // Imprime en la consola el valor de "NombreObra".
                                    System.out.print(NombreObra);
                                   
                                    
                                    // Crea una nueva instancia de la clase UsuarioDAO.
                                    usudao = new UsuarioDAO();
                                    
                                    /* Obtiene el número de factura llamando al método estático "NumFactura" 
                                    de la clase UsuarioDAO y lo almacena en la variable "NumFact".*/
                                    NumFact = usudao.NumFactura();
                                    
                                    // Imprime en la consola un mensaje indicando que ha llegado a la consulta.
                                    System.out.print("Si llega a la consulta");    
                                    /* Llama al método estático "Ventas" de la clase UsuarioDAO, pasando "NombreObra" 
                                    como argumento, y almacena el resultado en "list"*/
                                    List list= usudao.Ventas(NombreObra) ;  
                                    // Establece un atributo llamado "Ventas" en el objeto request con el valor de "list".
                                    request.setAttribute("Ventas", list);
                                    // Establece un atributo llamado "Numfact" en el objeto request con el valor de "Num_Fact".
                                    request.setAttribute("Numfact", Num_Fact);                               
                                    
                                    // Redirecciona la solicitud a "Ventas.jsp".
                                    request.getRequestDispatcher("Ventas.jsp").forward(request,response);
                                   
                                    break;  
                                    
                            // En caso de que "accion" sea igual a "GenerarVenta".
                            case"GenerarVenta":
                                
                                // Imprime en la consola un mensaje indicando que ha llegado a generar ventas.
                                System.out.print("Si llega a generar ventas");
                                
                                // Crea una nueva instancia de la clase UsuarioDAO.
                                usudao = new UsuarioDAO();
                                // Imprime en la consola el valor de "NombreObra".
                                System.out.print(NombreObra);
                                /* Llama al método estático "Ventas" de la clase UsuarioDAO, pasando "NombreObra" 
                                como argumento, y almacena el resultado en "list".*/
                                list = usudao.Ventas(NombreObra);
                                // Crea una lista de ventas realizadas.
                                List<Ventas_realizadas> ventasGeneradas = new ArrayList<>();
                                
                                // Recorre la lista original y crea una instancia de Ventas_realizadas para cada elemento.
                                for(int i = 0; i < list.size(); i++) {   
                                    Ventas_realizadas vent = new Ventas_realizadas();
                                    Ventas_realizadas ventaExistente = (Ventas_realizadas) list.get(i); // Obtiene una instancia de Ventas_realizadas de la lista original
                                    
                                    /*Copia los valores de Art, Comp, Obr, Valor_total, Fecha_venta y Num_venta 
                                    desde la venta existente a la nueva venta.*/
                                        vent.setNroFactura(Num_Fact);
                                        vent.setArt(ventaExistente.getArt()); // Copia los valores de Art
                                        vent.setComp(ventaExistente.getComp()); // Copia los valores de Comp
                                        vent.setObr(ventaExistente.getObr()); // Copia los valores de Obr
                                        
                                        vent.setValor_total(ventaExistente.getValor_total());
                                        vent.setFecha_venta(ventaExistente.getFecha_venta());
                                        vent.setNum_venta(ventaExistente.getNum_venta());
                                        
                                      /*Llama al método estático "InsertarFacturas" de la clase UsuarioDAO, 
                                      pasando la nueva venta como argumento para insertarla en la base de datos*/
                                      usudao.InsertarFacturas(vent);
                                }
                                break;
                                
                            // En caso de que "accion" sea igual a "NuevaVenta".    
                            case"NuevaVenta":
                                // Redirecciona la solicitud a otro recurso ("Redireccionamientos?menu=Ventas&accion=Listar").
                                request.getRequestDispatcher("Redireccionamientos?menu=Ventas&accion=Listar").forward(request, response);
                                break;
                        
                        }
                        // Redirecciona la solicitud a "Ventas.jsp".
                        request.getRequestDispatcher("Ventas.jsp").forward(request,response);
                        break;
                        
                }      
                       
            }else{
            
            }
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
