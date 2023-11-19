/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Artistas;
import modelo.Compradores;
import modelo.Obras;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modelo.carrito;
import modelo.subastas;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*  Esta anotación indica al contenedor web que la clase Mv_Usuarios se asociará con la URL "/Mv_Usuarios". 
La anotación @WebServlet se utiliza en aplicaciones web Java para definir un servlet. */
@WebServlet(name = "Mv_Usuarios", urlPatterns = {"/Mv_Usuarios"})

/* Declaración de la clase Mv_Usuarios, que extiende la clase HttpServlet. 
Esto significa que Mv_Usuarios es un servlet que manejará las solicitudes HTTP. */
public class Mv_Usuarios extends HttpServlet {
    public static int idUsu;
    String DocumentoComp;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /* Declaración del método processRequest, que toma un objeto HttpServletRequest y un objeto HttpServletResponse como parámetros 
    y puede lanzar excepciones de tipo ServletException e IOException. Este método es responsable de procesar las solicitudes HTTP */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* Establece el tipo de contenido de la respuesta HTTP como "text/html" con el juego de caracteres UTF-8. */
        response.setContentType("text/html;charset=UTF-8");
        
                /* Obtiene el valor del parámetro "menu" de la solicitud HTTP y lo guarda en la variable menu. */
                String menu = request.getParameter("menu");
                
                /* Obtiene el valor del parámetro "accion" de la solicitud HTTP y lo guarda en la variable accion. */
                String accion = request.getParameter("accion"); 
                
        
        /* Crea una instancia de la clase Artistas. */
        Artistas art = new Artistas();
        
        /*  Crea una instancia de la clase Compradores */
        Compradores comp = new Compradores();
        
        /* Crea una instancia de la clase UsuarioDAO. 
        Parece ser un objeto que maneja las operaciones relacionadas con la base de datos para usuarios. */
        UsuarioDAO usudao = new UsuarioDAO();
        
            
            /*  Verifica si la variable menu no es nula. */
            if(menu != null){
                
                /* Inicia una estructura de control de selección switch basada en el valor de la variable menu. */
                switch (menu) {
                    
                    /*  Entra en este caso si el valor de menu es "Inicio". */
                    case "Inicio":
                        
                        /*  Inicia otra estructura de control de selección switch basada en el valor de la variable accion. */
                        switch (accion){
                            
                            /*  Entra en este caso si el valor de accion es "Cargar_ob". */
                            case "Cargar_ob":
                                
                                /* Llama al método estático Listar de la clase UsuarioDAO que devuelve una lista de objetos Obras 
                                y la asigna a la variable obr. */
                                List<Obras> obr = UsuarioDAO.Listar();
                                
                                /* Obtiene la sesión actual de la solicitud y la guarda en la variable sesion. */
                                HttpSession sesion;
                                sesion = request.getSession();
                                
                                /* Almacena la lista de obras obr en la sesión con el nombre "Obr".*/
                                sesion.setAttribute("Obr", obr);
                                
                                /* Redirige la solicitud a la página "/Artista/inicio.jsp". La información de la solicitud 
                                y la respuesta se pasa a la siguiente página, y la ejecución del servlet se interrumpe. */
                                request.getRequestDispatcher("/Artista/inicio.jsp").forward(request,response);
                                
                                /* Sale del switch interno. */
                                break;
                            
                            /*  Entra en este caso si el valor de accion es "SubirObr". */
                            case "SubirObr":
                                
                                /* Obtiene la sesión actual de la solicitud y la guarda en la variable session. */
                                HttpSession session;
                                session = request.getSession();
                                
                                /*  Obtiene el atributo de sesión llamado "Artista" y 
                                lo interpreta como un objeto de la clase Usuario. Este objeto representa al usuario artista. */
                                Usuario usu = (Usuario) session.getAttribute("Artista");
                                
                                /* Imprime en la consola el ID del usuario artista. */
                                System.out.print("El id que llego al controlador de usuarios es: "+usu.getId());
                                
                                /* Crea una nueva instancia de la clase Obras para representar la nueva obra que se va a subir. */
                                Obras nuevaObra = new Obras();
                                
                                /* Asigna el ID del usuario artista a la variable estática idUsu. */
                                idUsu = usu.getId();
                                
                                /*Llama al método ListarOb_idUsu de la clase UsuarioDAO para obtener la información de la obra asociada 
                                al usuario artista*/
                                nuevaObra = usudao.ListarOb_idUsu(idUsu);
                                
                                /* Almacena la información de la nueva obra en la sesión con el nombre "obr". */
                                session.setAttribute("obr", nuevaObra);
                                
                                /* Redirige la solicitud a la página "/Artista/Crear.jsp". 
                                La información de la solicitud y la respuesta se pasa a la siguiente página, y la ejecución del servlet se interrumpe. */
                                request.getRequestDispatcher("/Artista/Crear2.jsp").forward(request,response);

                                break;
                            
                            /*  Entra en este caso si el valor de accion es "crear". */
                            case "crear":
                                
                                /* Imprime en la consola el nombre de la obra obtenido del parámetro "txtNameObr" de la solicitud. */
                                
                                
                                /* Crea una nueva instancia de la clase Obras para representar la obra que se está creando. */
                                Obras obras = new Obras();
                                
                                /* Crea una nueva instancia de la clase Artistas para representar el artista asociado a la obra. */
                                Artistas artista = new Artistas();
                                
                                /* Imprime en la consola el mensaje "Si llega a crear". */
                                System.out.print("Si llega a crear");
                                
                                /* Asigna el ID del usuario artista a la instancia del artista. */
                                artista.setIdUsuario(idUsu);
                               
                                /*  Imprime en la consola el ID del usuario artista. */
                                System.out.print("El id del usuario en crear es: "+idUsu);
                                artista.setNroDocumento(Integer.parseInt(request.getParameter("Documento")));
                                
                                /* Imprime en la consola el documento del artista*/
                                System.out.print("El documento del artista es: "+artista.getNroDocumento());
                                obras.setArtista(artista);
                                
                                /*  Establece el nombre de la obra con el valor obtenido del parámetro "txtNameObr" de la solicitud. */
                                obras.setNombre_obra(request.getParameter("NomObr"));
                                
                                /* Establece la técnica de la obra con el valor obtenido del parámetro "txtTecnica" de la solicitud. */
                                obras.setTecnica(request.getParameter("Tecnica"));
                                
                                /* Establece la descripción de la obra con el valor obtenido del parámetro "txtDescripcion" de la solicitud. */
                                obras.setDescripcion_obra(request.getParameter("Descripcion"));
                                
                               

                                // Obtén el valor específico de txtPrecio
                                String PrecioValue = request.getParameter("Precio");
                                
                                /* Verifica si txtPrecioValue no es nulo. Si no es nulo, convierte su valor a un tipo de dato float 
                                y lo establece como el valor de la obra (obras.setValor_obra). En caso contrario, imprime en la consola
                                el mensaje "precio: " seguido del valor obtenido directamente de la solicitud. */
                                if (PrecioValue != null) {
                                    obras.setValor_obra(Float.parseFloat(PrecioValue));
                                } else {
                                    System.out.print("precio:  "+request.getParameter("Precio"));
                                }
                                
                                /* Establece el número de categoría de la obra con el valor obtenido del parámetro 
                                "txtCategoria" de la solicitud, después de convertirlo a un tipo de dato int. */
                                obras.setNro_categoria(Integer.parseInt(request.getParameter("Categoria")));
                                
                                /* Establece el modo de venta de la obra con el valor obtenido del parámetro 
                                "txtModoVenta" de la solicitud. */
                                obras.setModo_vent(request.getParameter("Modovent"));
                                
                                /* Inicia un bloque try-catch para manejar posibles excepciones durante la carga de archivos. */
                                try {
                                    
                                /* Crea una instancia de DiskFileItemFactory para gestionar los elementos de archivo en la solicitud. */
                                FileItemFactory file = new DiskFileItemFactory();
                                
                                /* Crea una instancia de ServletFileUpload para manejar la carga de archivos utilizando 
                                la fábrica de elementos de archivo. */
                                ServletFileUpload fileUpload = new ServletFileUpload(file);
                                
                                /* Obtiene la lista de elementos (campos de formulario y archivos) de la solicitud. */
                                List items = fileUpload.parseRequest(request);
                                
                                /* Itera sobre la lista de elementos. */
                                
                                    
                                    /* Obtiene el elemento actual de la lista. */
                                    String Url = request.getParameter("Urlimg");
                                    File archivo = new File(Url);
                                    
                                    /* Verifica si el elemento no es un campo de formulario (es un archivo). */
                                    if (archivo!= null) {
                                        
                                        /* Crea una instancia de File para representar la ubicación donde se guardará el archivo */
                                        File f = new File("D:\\xampp\\htdocs\\img\\" + archivo.getName());
                                        
                                        /*  Escribe el contenido del archivo en el sistema de archivos. */
                                        
                                        
                                        /* Establece la URL de la imagen asociada a la obra con la ruta del archivo guardado. */
                                        obras.setUrl("http://localhost/img/"+f.getName());
                                        
                                        /*  Imprime en la consola la URL de la imagen. */
                                        System.out.println("URL de la imagen: " + obras.getUrl());
                                    } 
                                
                                /*  Llama al método Agregar_obras de la clase UsuarioDAO para agregar la obra a la base de datos. */
                                usudao.Agregar_obras(obras);
                                
                            } catch (Exception e) {
                                e.printStackTrace(); 
                            }
                             /* Redirige la solicitud a la página "/Artista/inicio.jsp". La información de la solicitud 
                                y la respuesta se pasa a la siguiente página, y la ejecución del servlet se interrumpe. */
                             request.getRequestDispatcher("Artista/inicio.jsp").forward(request, response);
                                    break;
                                    
                        
                        
                        }
                        break;
                    
                    /* Entra en este caso si el valor de accion es "Perfil". */
                    case "Perfil":
                        
                        /*  Inicia otro switch interno basado en el valor de accion. */
                        switch (accion) {
                            /*  Entra en este caso si el valor de accion es "Actualizar". */
                            case "Actualizar":
                            
                            /* Crea una nueva instancia de la clase Artistas para representar al artista 
                                cuyo perfil se está actualizando. */
                            art = new Artistas();
                            
                            /*  Imprime en la consola el mensaje "Llega a Actualizar". */
                            System.out.print("Llega a Actualizar");
                            
                            /*Crea una nueva instancia de ArrayList para almacenar los datos del formulario que se están actualizando*/
                            ArrayList<String> lista = new ArrayList<>();
                            
                            /* Obtiene la sesión actual de la solicitud y la guarda en la variable sesion. */
                            HttpSession sesion = request.getSession();

                            //String idUsuario = request.getParameter("txt_idUsuario");
                            
                            /* Imprime en la consola el ID del usuario obtenido del parámetro "id" de la solicitud. */
                            System.out.print("El id usuario : "+ request.getParameter("id"));
                            
                            /* Imprime en la consola el nombre de usuario obtenido del parámetro "alias" de la solicitud */
                            System.out.print("El nombre usuario : "+ request.getParameter("alias"));
                            
                            /* Agrega el ID del usuario a la lista. */
                            lista.add(request.getParameter("id"));
                            /* Agrega el nombre del usuario a la lista. */
                            lista.add(request.getParameter("name"));
                            /* Agrega el alias del usuario a la lista. */
                            lista.add(request.getParameter("alias"));
                            /*  Agrega el correo del usuario a la lista. */
                            lista.add(request.getParameter("correo"));
                            /* Agrega el teléfono del usuario a la lista. */
                            lista.add(request.getParameter("tel"));
                            

                                /*Establece el ID del usuario artista utilizando el primer elemento de la lista convertido a un valor entero.*/ 
                                art.setIdUsuario(Integer.parseInt(lista.get(0)));
                                /*Establece el nombre del usuario artista utilizando el segundo elemento de la lista.*/
                                art.setNombreUsuario(lista.get(1));
                                /* Establece el pseudónimo del usuario artista utilizando el tercer elemento de la lista.*/
                                art.setPseudonombre(lista.get(2));
                                /*Establece el correo del usuario artista utilizando el cuarto elemento de la lista.*/
                                art.setCorreoUsuario(lista.get(3));
                                /*Establece el teléfono del usuario artista utilizando el quinto elemento de la lista.*/
                                art.setTelefono(lista.get(4));
                                /* Imprime en la consola el primer elemento de la lista (el ID del usuario).*/
                                System.out.print(lista.get(0));
                                
                                
                            /*Inicia un bloque try-catch para manejar posibles excepciones durante la carga de archivos*/
                            try {
                                
                                /*Crea una instancia de DiskFileItemFactory para gestionar los elementos de archivo en la solicitud.*/
                                 FileItemFactory file = new DiskFileItemFactory();
                                 
                                 /*Crea una instancia de ServletFileUpload para manejar la carga de archivos utilizando 
                                 la fábrica de elementos de archivo.*/
                                ServletFileUpload fileUpload = new ServletFileUpload(file);
                                
                                /*Obtiene la lista de elementos (campos de formulario y archivos) de la solicitud.*/
                                List items = fileUpload.parseRequest(request);

                                /* Itera sobre la lista de elementos.*/
                                for (Object item : items) {
                                    
                                    /*Obtiene el elemento actual de la lista.*/
                                    FileItem fileItem = (FileItem) item;
                                    
                                    /*Verifica si el elemento no es un campo de formulario (es un archivo).*/
                                    if (!fileItem.isFormField()) {
                                        // Obtener el nombre del archivo
                                        String fileName = fileItem.getName();
                                            /* Imprime en la consola el nombre del archivo.*/
                                            System.out.print("El nombre del archivo es"+fileName);
                                        /* Verifica si el nombre del archivo no es nulo ni está vacío. */
                                        if (fileName != null && !fileName.isEmpty()) {
                                            // Guardar el archivo en el servidor
                                            File f = new File("D:\\xampp\\htdocs\\img\\" + fileName);
                                            /* Escribe el contenido del archivo en el sistema de archivos.*/
                                            fileItem.write(f);

                                            // Configurar la URL de la imagen en el objeto art
                                            art.setImg_perfil("http://localhost/img/" + fileName);
                                            /*Imprime en la consola la URL de la imagen de perfil.*/
                                            System.out.println("URL de la imagen: " + art.getImg_perfil());
                                        }
                                    } else {
                                        lista.add(fileItem.getString());
                                    }
                                }
                                /*Llama al método Actualizar_ArtPerfil de la clase UsuarioDAO para actualizar el perfil 
                                del artista en la base de datos.*/
                                UsuarioDAO.Actualizar_ArtPerfil(art);
                                
                            } catch (Exception e) {
                                e.printStackTrace(); 
                            }
                            /*Redirige la solicitud a la página "/Artista/Configuracion.jsp". La información de la solicitud 
                            y la respuesta se pasa a la siguiente página, y la ejecución del servlet se interrumpe*/
                             request.getRequestDispatcher("Artista/Configuracion.jsp").forward(request, response);
                                    break;


                            /*Entra en este caso si el valor de accion es "Cargar".*/
                            case "Cargar":
                                
                                /*Obtiene la sesión actual de la solicitud y la guarda en la variable sesion.*/
                                sesion = request.getSession();
                                
                                /*Llama al método Listar_id de la clase UsuarioDAO para obtener 
                                la información del artista con ID 52 y guarda el resultado en la variable Art.*/
                                Artistas Art=usudao.Listar_id(52);
                                
                                /*Almacena el objeto Art en la sesión con el nombre de atributo "Art".
                                Esto permitirá que esta información esté disponible en otras partes del código o en otras solicitudes.*/
                                sesion.setAttribute("Art", Art);
                             
                             /*Imprime en la consola el mensaje "LLega a cargar".*/
                             System.out.print("LLega a cargar");
                             
                            /*Redirige la solicitud a la página "/Artista/Configuracion.jsp". La información de la solicitud 
                             y la respuesta se pasa a la siguiente página, y la ejecución del servlet se interrumpe.*/
                            request.getRequestDispatcher("Artista/Configuracion.jsp").forward(request, response);
                            break;
                                    }
                            break;
                
                /*Entra en este caso si el valor de menu es "Compradores".*/
                case "Compradores":
                        
                        /*Inicia otro switch interno basado en el valor de accion.*/
                        switch(accion){
                            
                            case "Cargar_ob":
                                
                                /* Llama al método estático Listar de la clase UsuarioDAO que devuelve una lista de objetos Obras 
                                y la asigna a la variable obr. */
                                List<Obras> obr = UsuarioDAO.Listar();
                                
                                /* Obtiene la sesión actual de la solicitud y la guarda en la variable sesion. */
                                HttpSession sesion;
                                sesion = request.getSession();
                                
                                /* Almacena la lista de obras obr en la sesión con el nombre "Obr".*/
                                sesion.setAttribute("Obr", obr);
                                
                                /* Redirige la solicitud a la página "/Artista/inicio.jsp". La información de la solicitud 
                                y la respuesta se pasa a la siguiente página, y la ejecución del servlet se interrumpe. */
                                request.getRequestDispatcher("/Comprador/inicio_comprador.jsp").forward(request,response);
                                
                                /* Sale del switch interno. */
                                break;
                            /*Entra en este caso si accion es "subastas".*/
                            case "subastas":
                                
                                /*Se obtienen los valores de los parámetros "txtSubasta", "ValorInicial" y "txtValorOfrecido" 
                                de la solicitud y se almacenan en las variables fechaSubasta, valorInc y ValorOfr respectivamente.*/
                                String fechaSubasta = request.getParameter("txtSubasta");
                                String valorInc = request.getParameter("ValorInicial");
                                String ValorOfr = request.getParameter("txtValorOfrecido");
                                
                                break;
                                
                            /*Entra en este caso si accion es "Listarperf".*/
                            case "Listarperf":
                                /*Redirige la solicitud a la página "/Comprador/Perfil.jsp".*/
                                request.getRequestDispatcher("Comprador/Perfil.jsp").forward(request, response);
                                break;
                            
                            /* Entra en este caso si accion es "ConfigPerfil".*/
                            case "ConfigPerfil":
                            
                            /*Se crea una nueva instancia de la clase Compradores llamada comp.*/
                            comp = new Compradores();
                            System.out.print("Llega a Actualizar");
                            
                            /*Se crea una lista llamada lista para almacenar los datos del formulario.*/
                            ArrayList<String> lista = new ArrayList<>();
                            sesion = request.getSession();

                            //String idUsuario = request.getParameter("txt_idUsuario");

                            System.out.print("El id usuario : "+ request.getParameter("id"));
                            System.out.print("El nombre usuario : "+ request.getParameter("alias"));
                            
                            /*Se obtienen los valores de los parámetros "id", "name", "alias", 
                            "correo" y "tel" de la solicitud y se almacenan en la lista lista.*/
                            lista.add(request.getParameter("id"));
                            lista.add(request.getParameter("name"));
                            lista.add(request.getParameter("alias"));
                            lista.add(request.getParameter("correo"));
                            lista.add(request.getParameter("tel"));
                            

                                /*Se establecen las propiedades de la instancia comp con los valores obtenidos de la lista.*/ 
                                /*Se imprime en la consola el valor del primer elemento de la lista.*/
                                comp.setIdUsuario(Integer.parseInt(lista.get(0)));
                                comp.setNombreUsuario(lista.get(1));
                                comp.setPseudonombre(lista.get(2));
                                comp.setCorreoUsuario(lista.get(3));
                                comp.setTelefono(lista.get(4));
                                System.out.print(lista.get(0));
                                
                                
                            /* Inicia un bloque try-catch para manejar posibles excepciones durante la carga de archivos.*/
                            try {
                                
                                /* Crea una instancia de DiskFileItemFactory para gestionar los elementos de archivo en la solicitud.*/
                                 FileItemFactory file = new DiskFileItemFactory();
                                 
                                /*Crea una instancia de ServletFileUpload para manejar la carga de archivos utilizando 
                                 la fábrica de elementos de archivo.*/
                                ServletFileUpload fileUpload = new ServletFileUpload(file);
                                
                                /*Obtiene la lista de elementos (campos de formulario y archivos) de la solicitud.*/
                                List items = fileUpload.parseRequest(request);

                                /* Itera sobre la lista de elementos.*/
                                for (Object item : items) {
                                    
                                    /* Obtiene el elemento actual de la lista.*/
                                    FileItem fileItem = (FileItem) item;
                                    
                                    /*Verifica si el elemento no es un campo de formulario (es un archivo).*/
                                    if (!fileItem.isFormField()) {
                                        // Obtener el nombre del archivo
                                        String fileName = fileItem.getName();
                                            System.out.print("El nombre del archivo es"+fileName);
                                        if (fileName != null && !fileName.isEmpty()) {
                                            // Guardar el archivo en el servidor
                                            File f = new File("D:\\xampp\\htdocs\\img\\" + fileName);
                                            fileItem.write(f);

                                            //Configura la URL de la imagen de perfil en el objeto comp utilizando la ruta del archivo guardado.
                                            comp.setImg_perfil("http://localhost/img/" + fileName);
                                            /*Imprime en la consola la URL de la imagen de perfil.*/
                                            System.out.println("URL de la imagen: " + comp.getImg_perfil());
                                        }
                                    /*Si el elemento es un campo de formulario, se agrega su valor a la lista lista.*/
                                    } else {
                                        lista.add(fileItem.getString());
                                    }
                                }
                             
                                UsuarioDAO.ActualizarCompPerfil(comp);
                            /* Captura y maneja cualquier excepción que pueda ocurrir durante la carga de archivos, 
                                imprimiendo el rastreo de la pila en la consola.*/    
                            } catch (Exception e) {
                                e.printStackTrace(); 
                            }request.getRequestDispatcher("Comprador/Perfil.jsp").forward(request, response);
                                break;  
                           
                             case "AgregarCarrito":

                                sesion = request.getSession();
                                // Obtener la lista de obras del carrito desde la sesión
                                List<carrito> listaCarrito = (List<carrito>) sesion.getAttribute("carrito");

                                // Si la lista no existe en la sesión, crear una nueva
                                if (listaCarrito == null) {
                                    listaCarrito = new ArrayList<>();
                                }

                                int idObr = Integer.parseInt(request.getParameter("id"));
                                System.out.print(idObr);

                                // Buscar la obra en el carrito
                                carrito car = null;
                                for (carrito obraEnCarrito : listaCarrito) {
                                    if (obraEnCarrito.getId_obra() == idObr) {
                                        car = obraEnCarrito;
                                        break;
                                    }
                                }

                                // Si la obra ya está en el carrito, actualizar la cantidad y el subtotal
                                if (car != null) {
                                    int nuevaCantidad = car.getCantidad() + 1;
                                    car.setCantidad(nuevaCantidad);
                                    float subtotal = nuevaCantidad * car.getValor_obra();
                                    car.setSubtotal(subtotal);
                                } else {
                                    // Si la obra no está en el carrito, agregar una nueva obra al carrito
                                    Obras obra = usudao.ListarOb_id(idObr);
                                    car = new carrito();
                                    car.setId_obra(idObr);
                                    car.setNombre_obra(obra.getNombre_obra());
                                    car.setUrl(obra.getUrl());
                                    car.setDescripcion_obra(obra.getDescripcion_obra());
                                    car.setValor_obra(obra.getValor_obra());
                                    car.setCantidad(1);
                                    car.setSubtotal(car.getValor_obra()); // Subtotal es el valor de la obra ya que es la primera vez que se agrega
                                    listaCarrito.add(car);
                                }

                                // Guardar la lista actualizada en la sesión
                                sesion.setAttribute("carrito", listaCarrito);

                                System.out.print(listaCarrito);
                                response.sendRedirect("Comprador/inicio_comprador.jsp");
                                break;
                                
                             case "verlistado":
                                 response.sendRedirect("Comprador/carrito_compras.jsp");
                                 break;
                                
                            
                            case"PropuestaSubasta":
                                
                            int idObra = Integer.parseInt(request.getParameter("id"));
                            Obras obra = new Obras();
                            obra = usudao.ListarOb_id(idObra);
                            LocalDate fechaActual = LocalDate.now();

                            // Formatea la fecha en el formato "YYYY-MM-DD"
                            String fechaActualFormateada = fechaActual.format(DateTimeFormatter.ISO_DATE);
                            System.out.print(fechaActual);

                            // Crea una instancia de la clase subastas
                            subastas subasta = new subastas();

                            // Establece la fecha actual como una cadena
                            subasta.setFecha_actual(fechaActualFormateada);
                            System.out.println(subasta.getFecha_actual());
                            obra.setFecha_subasta(subasta.getFecha_actual());
                            
                            
                            
                            sesion = request.getSession();
                            sesion.setAttribute("ObrasSubasta", obra);
                            
                            
                            response.sendRedirect("Comprador/subastas.jsp");
                                break;
                                
                        case "subastainsert":
                            System.out.print("llega a insertarsubastas");

                            float valor_Ofrecido = Float.parseFloat(request.getParameter("txtValorOfrecido"));
                            float Valor_Ini = Float.parseFloat(request.getParameter("valorIni"));
                            String fecha = request.getParameter("fecha");
                            String idComp = request.getParameter("txtIdComp");
                            String idArt = request.getParameter("txtIdArt");
                            int idObras = Integer.parseInt(request.getParameter("txtIdObr"));
                            
                            System.out.print("El valor ofrecido es de: "+valor_Ofrecido);
                            System.out.print("El valor ofrecido es de: "+Valor_Ini);
                            System.out.print("El id del comprador es: "+idComp);
                            System.out.print("El id del artista es: "+idArt);
                            System.out.print("El id de la obra es: "+idObras);
                            System.out.print("la fecha de la obra es: "+ fecha);
                            
                            if(valor_Ofrecido > Valor_Ini ){
                                
                                subasta = new subastas();
                                subasta.setIdObras(idObras);
                                subasta.setIdArt(idArt);
                                subasta.setIdComp(idComp);
                                subasta.setValor_Ini(Valor_Ini);
                                subasta.setValor_Ofrecido(valor_Ofrecido);
                                subasta.setFecha_actual(fecha);
                                
                                usudao.Agregar_subastas(subasta);
                                
                                
                                sesion = request.getSession();
                                sesion.setAttribute("ofertaExitosa", true);
                                DocumentoComp = subasta.getIdComp();
                                response.sendRedirect("Comprador/subastas.jsp");

                            }

                            break;
      
                        }
            
                }
            
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
