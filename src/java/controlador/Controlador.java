/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;


import modelo.Usuario;
import modelo.UsuarioDAO;


import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Admin;
import modelo.Artistas;
import modelo.Compradores;
import modelo.Rol;
import modelo.Transacciones;


/* @WebServlet: Esta anotación indica que la clase es un servlet y especifica cómo se puede acceder a él. 
En este caso, el servlet se llama "Controlador" y se puede acceder a través de la URL "/Controlador". */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})

/* Declara la clase Controlador que extiende HttpServlet, lo que significa que es un servlet que maneja solicitudes 
y respuestas HTTP. */
public class Controlador extends HttpServlet {
    
    /*  Declara una variable estática llamada idUsuario, que podría usarse para almacenar información sobre el usuario. */
    public static int idUsuario;
    
    /* Declara un método llamado processRequest que maneja solicitudes HTTP. Toma dos parámetros: HttpServletRequest para 
    la solicitud entrante y HttpServletResponse para la respuesta saliente. */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* Establece el tipo de contenido de la respuesta a "text/html" con la codificación UTF-8. */
        response.setContentType("text/html;charset=UTF-8");
        
        /* Obtiene el parámetro llamado "accion" de la solicitud, que probablemente se utiliza para 
        determinar la acción que debe realizar el servlet */
          String accion = request.getParameter("accion");
          
        /* Otra vez establece el tipo de contenido de la respuesta a "text/html" con la codificación UTF-8. 
        Esta línea es redundante y podría eliminarse. */
       response.setContentType("text/html;charset=UTF-8");
       
       /*  Imprime en la consola un mensaje indicando que el programa ha llegado a este punto. 
       Puede ser útil para propósitos de depuración. */
       System.out.println("Si llega aqui");
       
       /*  Inicia un bloque try-catch, utilizado para manejar excepciones. */
       try{
           
           /* Comienza una condición que verifica si la variable accion no es nula. */
           if(accion != null){
               
               /* Inicia un bloque switch basado en el valor de la variable accion */
                switch(accion){
                    
                    /*  Si el valor de accion es "verificar", llama al método verificar y luego sale del bloque switch. */
                    case "verificar":
                        verificar(request, response);
                        break;
                        
                    /*  Si el valor de accion es "Registrar", llama al método Registrar y luego sale del bloque switch. */
                    case "Registrar":
                        Registrar(request, response);
                        
                        break;
                    
                    /* Si el valor de accion es "Actualizar", redirige la solicitud a la URL especificada. */
                    case "Actualizar":
                        request.getRequestDispatcher("Redireccionamientos?menu=Artistas&accion=Update").forward(request, response);
                        break;
                        
                    case "Registar_Artista":
                        AdminRegist(request, response);
                        break;
                }
            /* Cierra el bloque switch y comienza el bloque else, que se ejecutará si la condición del primer if no se cumple. */
            }else{
               
               /* Redirige la respuesta a la página "inicio.jsp". */
               response.sendRedirect("inicio.jsp");
               
           }
           
        /*  Inicia el bloque catch que maneja cualquier excepción que pueda ocurrir. */
       }catch(Exception e){
           
           /* Imprime en la consola un mensaje de error que muestra el mensaje asociado con la excepción. */
            System.out.println("Error" + e.getMessage());
            
            
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
    
    /*  Declaración del método verificar que toma un objeto HttpServletRequest y un objeto HttpServletResponse como parámetros. 
    También indica que puede lanzar excepciones de tipo Exception. */
    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
       HttpSession sesion;//Iniciamos la variable como HttpSession para capturar la informacion del usuario cuando este se loguea
        UsuarioDAO dao;//Iniciliazamos la variable dao para poder traer las consultas
        Usuario usu = new Usuario();//Instancio el modelo usuario para guardar los datos en las propiedades de esta clase
        usu = this.obtenerUsuario(request);//Obtenemos la informacion que ingresan en el login para poder verificar el Nro_documento y la contraseña
        dao = new UsuarioDAO();//Instancio Usuariodao en la variable dao para poder utilizar las consultas
        usu = dao.Validar(usu);
         // Coloca el objeto Usuario en la sesión
         /* Obtiene la sesión actual o crea una nueva y guarda el objeto Usuario en la sesión con el nombre de atributo "usuario" */
        sesion = request.getSession();
        sesion.setAttribute("usuario", usu);
        
        /*  Declara variables para almacenar el rol del usuario y objetos Artistas y Compradores que se utilizarán posteriormente. */
        Rol rol = usu.getRol();
        Artistas art = new Artistas();
        Compradores comp = new Compradores();
        
            /*  Imprime mensajes en la consola para indicar que se está verificando el perfil del usuario y 
            muestra el nombre del cargo del rol. */
            System.out.println("Se esta verificando el perfil");
            System.out.print(rol.getNombreCargo());         
            
            /* Verifica si el objeto Usuario no es nulo y si el nombre del cargo del rol es "ADMINISTRADOR". */
            if(usu != null && rol.getNombreCargo().equals("ADMINISTRADOR")){
                
                /* Establece la sesión para un administrador, guarda el objeto Usuario en la sesión con 
                el nombre de atributo "Admin" y redirige la solicitud a "/Principal.jsp". */
                sesion = request.getSession();
                sesion.setAttribute("Admin", usu);
                this.getServletConfig().getServletContext().getRequestDispatcher("/Principal.jsp").forward(request, response);

            /*  Entra en el bloque else-if si el usuario no es un administrador pero es un artista. */    
            }else if(usu != null && rol.getNombreCargo().equals("ARTISTA")){
                
                /* Establece la sesión para un artista, realiza algunas consultas relacionadas con el artista y 
                redirige la solicitud a "/Mv_Usuarios?menu=Inicio&accion=Cargar_ob". */
                sesion = request.getSession();
                art = dao.Listar_id(idUsuario);
                sesion.setAttribute("Artista", usu);
                sesion.setAttribute("Art", art);
                
                System.out.println("Id usuario ingresado: "+usu.getId());
                System.out.println("myString es de tipo " +  ((Object)art).getClass().getSimpleName());
               
                sesion.setAttribute("Id", idUsuario);
               
                 
                this.getServletConfig().getServletContext().getRequestDispatcher("/Mv_Usuarios?menu=Inicio&accion=Cargar_ob").forward(request, response);
            
            /* Entra en el bloque else-if si el usuario no es ni administrador ni artista, pero es un comprador. */
            }else if(usu != null && rol.getNombreCargo().equals("COMPRADOR")){
                
                /* Establece la sesión para un comprador, realiza algunas consultas relacionadas con el comprador y 
                redirige la solicitud a "/Comprador/inicio_comprador.jsp". */
                sesion = request.getSession();
                sesion.setAttribute("Comprador", usu);
                
                sesion = request.getSession();
                idUsuario = usu.getId();
                comp = dao.Listar_idComp(idUsuario);
                sesion.setAttribute("Comp", comp);
                
                
                System.out.println("Id usuario ingresado: "+usu.getId());
                System.out.println("myString es de tipo " +  ((Object)art).getClass().getSimpleName());
               
                sesion.setAttribute("Id", idUsuario);
                this.getServletConfig().getServletContext().getRequestDispatcher("/Comprador/inicio_comprador.jsp").forward(request, response);
            
            /* Entra en el bloque else si el usuario no es ni administrador, ni artista, ni comprador. 
                Configura la solicitud para despachar a "inicio.jsp" y establece un atributo de error. */    
            }else{
                request.getRequestDispatcher("inicio.jsp");
                request.setAttribute("error", "Por favor llena los espacios");
            }
    
    }

    /* Declaración del método obtenerUsuario, que toma un objeto HttpServletRequest como parámetro y devuelve un objeto Usuario. */
    private Usuario obtenerUsuario(HttpServletRequest request) {
        
        /*  Creación de una nueva instancia de la clase Usuario. */
        Usuario u = new Usuario();
        
            /* Obtiene el valor del parámetro llamado "txtusuario" de la solicitud y lo convierte a un entero, 
            luego establece este valor como el documento del usuario u. */
            u.setDocumento(Integer.parseInt(request.getParameter("txtusuario")));
            
            /* Obtiene el valor del parámetro llamado "txtpassword" de la solicitud y lo establece como la contraseña del usuario u. */
            u.setPassword(request.getParameter("txtpassword"));
        
        /* Devuelve el objeto Usuario que se ha creado y configurado. */
        return u;
       
    }
    
    /* Declaración del método Registrar, que toma un objeto HttpServletRequest y un objeto HttpServletResponse
    como parámetros y puede lanzar excepciones de tipo Exception */
    private void Registrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /*  Declaración de las variables sesion de tipo HttpSession y dao de tipo UsuarioDAO. */
        HttpSession sesion;
        UsuarioDAO dao;
        
        /*  Creación de instancias de las clases Usuario, Artistas, Compradores, y
        Admin que se utilizarán para almacenar la información de usuario. */
        Usuario usu = new Usuario();
        Artistas art = new Artistas();
        Compradores comp = new Compradores();
        Admin admin = new Admin();
        
        /*  Llama al método obtenerRegist para obtener la información del usuario a partir de la solicitud y la almacena en el objeto usu. */
        usu = this.obtenerRegist(request);
        System.out.print("El id del rol que llega a registrar es: "+usu.getId_rol());
        
       /* Crea instancias de las clases UsuarioDAO y Transacciones. */
        dao = new UsuarioDAO();
        Transacciones trasn = new Transacciones();
        
        
        /* Verifica si el rol del usuario es "Admin" (según el valor de id_rol), y si es así, llama al método obtenerAdmin para obtener la 
        información del administrador y luego realiza la transacción con el método trasn_admin. */
       if(usu.getId_rol()==1){
           admin = this.obtenerAdmin(request);
           trasn.trasn_admin(usu, admin);
        } 
       
        /* Verifica si el rol del usuario es "Artista" y si es así, llama al método obtenerRegistArt para obtener 
       la información del artista y luego realiza la transacción con el método trasn_art. */
        if(usu.getId_rol()==2){
           art = this.obtenerRegistArt(request);
           trasn.trasn_art(usu, art);
           
           System.out.print("Eligio Artista");
        
           
        /*  Verifica si el rol del usuario es "Comprador" y si es así, llama al método obtenerRegistComp para obtener 
           la información del comprador y luego realiza la transacción con el método trasn_comp. */
        }if(usu.getId_rol()==3){
           comp = this.obtenerRegistComp(request);
           trasn.trasn_comp(usu, comp);
         
           System.out.print("Eligio Comprador");
           
        /* Entra en el bloque else si el rol del usuario no es ni "Admin", ni "Artista", ni "Comprador". 
           Imprime un mensaje en la consola indicando que no se ha recibido el ID del rol. */
       }else{
           System.out.println("No esta llegando el id del rol");
       }
        
        /*  Imprime en la consola los valores de los parámetros "TipoDocumento" y "TipoRol" de la solicitud. */
        System.out.println(request.getParameter("TipoDocumento"));
        System.out.println(request.getParameter("TipoRol"));
    }
    
    /* Declaración del método obtenerRegist, que toma un objeto HttpServletRequest como parámetro y devuelve un objeto Usuario. */
    private Usuario obtenerRegist(HttpServletRequest request) {
        
        /*  Creación de una nueva instancia de la clase Usuario. */
        Usuario u = new Usuario();
        
        /*  Obtiene el valor del parámetro llamado "txtDocumento" de la solicitud, 
        lo convierte a un entero y lo establece como el documento del usuario u. */
        u.setDocumento(Integer.parseInt(request.getParameter("txtDocumento")));
        
        /* Obtiene el valor del parámetro llamado "Contrasena" de la solicitud y lo establece como la contraseña del usuario u. */
        u.setPassword(request.getParameter("Contrasena"));
        
        /*  Obtiene el valor del parámetro llamado "txtNombre" de la solicitud y lo establece como el nombre del usuario u. */
        u.setNombre(request.getParameter("txtNombre"));
        
        /* Obtiene el valor del parámetro llamado "txtcorreo" de la solicitud y lo establece como el correo del usuario u. */
        u.setCorreo(request.getParameter("txtcorreo"));
        
        /* Obtiene el valor del parámetro llamado "TipoDocumento" de la solicitud y lo establece como el tipo de documento del usuario u. */
        u.setTipoDocumento(request.getParameter("TipoDocumento"));
        
        /* Obtiene el valor del parámetro llamado "Telefono" de la solicitud y lo establece como el teléfono del usuario u. */
        u.setTelefono(request.getParameter("Telefono"));
        
        /* Obtiene el valor del parámetro llamado "TipoRol" de la solicitud, lo convierte a un entero y lo establece como el ID de 
        rol del usuario u. */
        u.setId_rol(Integer.parseInt(request.getParameter("TipoRol")));
        
        /* Obtiene el valor del parámetro llamado "txtPseudonombre" de la solicitud y lo establece como el pseudónimo del usuario u. */
        u.setPseudonombre(request.getParameter("txtPseudonombre"));
        
        /*  Devuelve el objeto Usuario que se ha creado y configurado. */
        return u;
       
    }

    /* Declaración del método obtenerRegistArt, que toma un objeto HttpServletRequest como parámetro y devuelve un objeto Artistas. */
    private Artistas obtenerRegistArt(HttpServletRequest request) {
        
        /* Creación de una nueva instancia de la clase Artistas. */
        Artistas art = new Artistas();
        
        /* Obtiene el valor del parámetro llamado "txtDocumento" de la solicitud, lo convierte a un entero 
        y lo establece como el número de documento del artista art. */
       art.setNroDocumento(Integer.parseInt(request.getParameter("txtDocumento")));
       
        /* Obtiene el valor del parámetro llamado "Contrasena" de la solicitud y lo establece como la contraseña del artista art. */
        art.setContrasena(request.getParameter("Contrasena"));
        
        /* Obtiene el valor del parámetro llamado "txtNombre" de la solicitud y lo establece como el nombre del artista art */
        art.setNombreUsuario(request.getParameter("txtNombre"));
        
        /* Obtiene el valor del parámetro llamado "txtcorreo" de la solicitud y lo establece como el correo del artista art. */
        art.setCorreoUsuario(request.getParameter("txtcorreo"));
        
        /*  Obtiene el valor del parámetro llamado "TipoDocumento" de la solicitud y lo establece como el tipo de documento del artista art. */
        art.setTipoDocumento(request.getParameter("TipoDocumento"));
        
        /* Obtiene el valor del parámetro llamado "Telefono" de la solicitud y lo establece como el teléfono del artista art. */
        art.setTelefono(request.getParameter("Telefono"));
        
        art.setNivel_Formacion(request.getParameter("levelFormacion"));
        
        art.setNombre_Ficha(request.getParameter("NmFicha"));
        
        art.setNumero_Ficha(request.getParameter("NroFicha"));
        
        /* Obtiene el valor del parámetro llamado "TipoRol" de la solicitud, lo convierte a un entero 
        y lo establece como el ID de rol del artista art. */
        art.setIdRol_fk(Integer.parseInt(request.getParameter("TipoRol")));
        System.out.print(art.getIdRol_fk());
        
        /* Obtiene el valor del parámetro llamado "txtPseudonombre" de la solicitud y lo establece como el pseudónimo del artista art */
        art.setPseudonombre(request.getParameter("txtPseudonombre"));
        
        /* Devuelve el objeto Artistas que se ha creado y configurado. */
        return art;
    }

    /*  Declaración del método obtenerRegistComp, que toma un objeto HttpServletRequest como parámetro y devuelve un objeto Compradores. */
    private Compradores obtenerRegistComp(HttpServletRequest request) {
        
        /* Creación de una nueva instancia de la clase Compradores */
        Compradores comp = new Compradores();
        
        /* Obtiene el valor del parámetro llamado "txtDocumento" de la solicitud, lo convierte a un entero 
        y lo establece como el número de documento del comprador comp. */
        comp.setNroDocumento(Integer.parseInt(request.getParameter("txtDocumento")));
        
        /* Obtiene el valor del parámetro llamado "Contrasena" de la solicitud y lo establece como la contraseña del comprador comp. */
        comp.setContrasena(request.getParameter("Contrasena"));
        
        /* Obtiene el valor del parámetro llamado "txtNombre" de la solicitud y lo establece como el nombre del comprador comp. */
        comp.setNombreUsuario(request.getParameter("txtNombre"));
        
        /* Obtiene el valor del parámetro llamado "txtcorreo" de la solicitud y lo establece como el correo del comprador comp. */
        comp.setCorreoUsuario(request.getParameter("txtcorreo"));
        
        /* Obtiene el valor del parámetro llamado "TipoDocumento" de la solicitud 
        y lo establece como el tipo de documento del comprador comp. */
        comp.setTipoDocumento(request.getParameter("TipoDocumento"));
        
        /* Obtiene el valor del parámetro llamado "Telefono" de la solicitud y lo establece como el teléfono del comprador comp. */
        comp.setTelefono(request.getParameter("Telefono"));
        
        /* Obtiene el valor del parámetro llamado "TipoRol" de la solicitud, lo convierte a un entero 
        y lo establece como el ID de rol del comprador comp. */
        comp.setIdRol_fk(Integer.parseInt(request.getParameter("TipoRol")));
        
        /* Obtiene el valor del parámetro llamado "txtPseudonombre" de la solicitud 
        y lo establece como el pseudónimo del comprador comp. */
        comp.setPseudonombre(request.getParameter("txtPseudonombre"));
        
        /*  Devuelve el objeto Compradores que se ha creado y configurado */
        return comp;
    }
    
    /* Declaración del método obtenerAdmin, que toma un objeto HttpServletRequest como parámetro y devuelve un objeto Admin. */
    private Admin obtenerAdmin(HttpServletRequest request) {
        
        /* Creación de una nueva instancia de la clase Admin. */
        Admin admin = new Admin();
        
        /* Obtiene el valor del parámetro llamado "txtDocumento" de la solicitud, lo convierte a un entero 
        y lo establece como el número de documento del administrador admin. */
        admin.setNroDocumento_fk(Integer.parseInt(request.getParameter("txtDocumento")));
        
        /* Obtiene el valor del parámetro llamado "Contrasena" de la solicitud 
        y lo establece como la contraseña del administrador admin. */
        admin.setContrasena(request.getParameter("Contrasena"));
        
        /* Obtiene el valor del parámetro llamado "txtNombre" de la solicitud y lo establece como el nombre del administrador admin. */
        admin.setNombre(request.getParameter("txtNombre"));
        
        /* Obtiene el valor del parámetro llamado "txtcorreo" de la solicitud y lo establece como el correo del administrador admin. */
        admin.setCorreo(request.getParameter("txtcorreo"));
        
        /* Obtiene el valor del parámetro llamado "TipoRol" de la solicitud, 
        lo convierte a un entero y lo establece como el ID de rol del administrador admin. */
        admin.setIdRol_Fk(Integer.parseInt(request.getParameter("TipoRol")));
        
        /* Obtiene el valor del parámetro llamado "txtestado" de la solicitud y lo establece como el estado del administrador admin. */
        admin.setEstado(request.getParameter("txtestado"));
        
        /* Devuelve el objeto Admin que se ha creado y configurado. */
        return admin;
    }

    private void AdminRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
         
        /*  Declaración de las variables sesion de tipo HttpSession y dao de tipo UsuarioDAO. */
        HttpSession sesion;
        UsuarioDAO dao;
        
        /*  Creación de instancias de las clases Usuario, Artistas, Compradores, y
        Admin que se utilizarán para almacenar la información de usuario. */
        Usuario usu = new Usuario();
        Artistas art = new Artistas();
        Compradores comp = new Compradores();
        Admin admin = new Admin();
        
        /*  Llama al método obtenerRegist para obtener la información del usuario a partir de la solicitud y la almacena en el objeto usu. */
        usu = this.obtenerRegist(request);
        System.out.print("El id del rol que llega a registrar es: "+usu.getId_rol());
        
       /* Crea instancias de las clases UsuarioDAO y Transacciones. */
        dao = new UsuarioDAO();
        Transacciones trasn = new Transacciones();

        /* Verifica si el rol del usuario es "Artista" y si es así, llama al método obtenerRegistArt para obtener 
       la información del artista y luego realiza la transacción con el método trasn_art. */
        if(usu.getId_rol()==2){
           art = this.obtenerRegistArt(request);
           trasn.trasn_art(usu, art);
           request.getRequestDispatcher("Redireccionamientos?menu=Artistas&accion=Listar").forward(request, response);
           
           System.out.print("Eligio Artista");
        
           
        /* Entra en el bloque else si el rol del usuario no es ni "Admin", ni "Artista", ni "Comprador". 
           Imprime un mensaje en la consola indicando que no se ha recibido el ID del rol. */
       }else{
           System.out.println("No esta llegando el id del rol");
       }
        
        /*  Imprime en la consola los valores de los parámetros "TipoDocumento" y "TipoRol" de la solicitud. */
        System.out.println(request.getParameter("TipoDocumento"));
        System.out.println(request.getParameter("TipoRol"));
    }
    
    
}
