/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhoan
 */
public class Transacciones {
    
    public boolean trasn_art(Usuario usu, Artistas Art) throws SQLException{
        // Inicializa una variable booleana "rta" en false.
        boolean rta = false;
        
        // Crea una instancia de la clase UsuarioDAO.
        UsuarioDAO usuDao = new UsuarioDAO();
        
         Conexion cn = new Conexion(); // Crea una nueva instancia de Conexion
         Connection con = cn.Conexion(); // Úsala
        
        try{
            // Deshabilita el modo de autocommit para la conexión.
            con.setAutoCommit(false);
            
            // Llama al método "registrar" de la clase UsuarioDAO, pasando la información del usuario y la conexión.
            usuDao.registrar(usu, con);
            // Asigna el ID del usuario recién creado al objeto Artistas "Art".
            Art.setIdUsuario(usu.getId());
           
            // Llama al método "registrar_art" de la clase UsuarioDAO, pasando la información del artista y la conexión.
            usuDao.registrar_art(Art, con);
            Art.getIdUsuario();
            
            // Imprime en la consola el ID del usuario asociado al artista.
            System.out.println("si esta bien");
            
            // Confirma la transacción.
            con.commit();
            // Restaura el modo de autocommit a true.
            con.setAutoCommit(true);
            
            // Establece la variable de respuesta en true.
            rta=true;
   
        }catch(SQLException e){
            // En caso de excepción SQL:
            
            // Imprime la traza de la excepción.
            e.printStackTrace();
            
            // Muestra un mensaje de error.
            JOptionPane.showMessageDialog(null, "Error al registrarse");
            System.out.println(e);
            
            try{
                // Intenta hacer un rollback para deshacer la transacción.
                con.rollback();
                // Cierra la conexión.
                con.close();
                
            }catch(SQLException ex){
                // En caso de excepción al hacer rollback o cerrar la conexión, imprime la traza de la excepción.
                Logger.getLogger(Transacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
        }
        // Retorna la variable de respuesta.
        return rta;
    
    }
    
    public boolean trasn_comp(Usuario usu, Compradores comp) throws SQLException{
        
        // Inicializa una variable booleana "rtacomp" en false.
        boolean rtacomp = false;
        
        // Crea una instancia de la clase UsuarioDAO.
        UsuarioDAO usuDao = new UsuarioDAO();
        
       Conexion cn = new Conexion(); // Crea una nueva instancia de Conexion
       Connection con = cn.Conexion(); // Úsala para obtener una conexión
        
        try{
            // Deshabilita el modo de autocommit para la conexión.
            con.setAutoCommit(false);
            
            // Llama al método "registrar" de la clase UsuarioDAO, pasando la información del usuario y la conexión.
            usuDao.registrar(usu,con);
            // Asigna el ID del usuario recién creado al objeto Compradores "comp".
             comp.setIdUsuario(usu.getId());
             // Imprime en la consola un mensaje indicando que ha llegado a comprador.
            System.out.println("Si llega a comprador");
            // Llama al método "registrar_comp" de la clase UsuarioDAO, pasando la información del comprador y la conexión.
            usuDao.registrar_comp(comp, con);
            // Imprime en la consola el ID del usuario asociado al comprador.
            comp.getIdUsuario();
            
            // Confirma la transacción.
            con.commit();
            // Restaura el modo de autocommit a true.
            con.setAutoCommit(true);
            
            // Establece la variable de respuesta en true.
            rtacomp=true;
   
        }catch(SQLException e){
            // En caso de excepción SQL:
        
            // Imprime la traza de la excepción.
            e.printStackTrace();
            
            // Muestra un mensaje de error.
            JOptionPane.showMessageDialog(null, "Error al registrarse");
            System.out.println(e);
            
            try{
                // Intenta hacer un rollback para deshacer la transacción.
                con.rollback();
                // Cierra la conexión.
                con.close();
                
            }catch(SQLException ex){
                // En caso de excepción al hacer rollback o cerrar la conexión, imprime la traza de la excepción.
                Logger.getLogger(Transacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
        }
        // Retorna la variable de respuesta.
        return rtacomp;
    
    }
    
    public boolean trasn_admin(Usuario usu, Admin admin) throws SQLException{
        // Inicializa una variable booleana "rtadmin" en false.
        boolean rtadmin = false;
        
        // Crea una instancia de la clase UsuarioDAO.
        UsuarioDAO usuDao = new UsuarioDAO();
        
       Conexion cn = new Conexion(); // Crea una nueva instancia de Conexion
       Connection con = cn.Conexion(); // Úsala para obtener una conexión
        
        try{
            // Deshabilita el modo de autocommit para la conexión.
            con.setAutoCommit(false);
            
            // Llama al método "registrar" de la clase UsuarioDAO, pasando la información del usuario y la conexión.
            usuDao.registrar(usu,con);
            // Asigna el número de documento del usuario recién creado al objeto Admin "admin".
            admin.setNroDocumento_fk(usu.getDocumento());
            // Imprime en la consola un mensaje indicando que ha llegado a administrador.
            System.out.println("Si llega a Administrador");
            
            // Llama al método "registrar_admin" de la clase UsuarioDAO, pasando la información del administrador y la conexión.
            usuDao.registrar_admin(admin, con);
            // Imprime en la consola el número de documento del usuario asociado al administrador.
            admin.getNroDocumento_fk();
            
            // Confirma la transacción.
            con.commit();
            // Restaura el modo de autocommit a true.
            con.setAutoCommit(true);
            
            // Establece la variable de respuesta en true.
            rtadmin=true;
   
        }catch(SQLException e){
              // En caso de excepción SQL:
        
            // Imprime la traza de la excepción.
            e.printStackTrace();
            
            // Muestra un mensaje de error.
            JOptionPane.showMessageDialog(null, "Error al registrarse");
            System.out.println(e);
            
            try{
                // Intenta hacer un rollback para deshacer la transacción.
                con.rollback();
                // Cierra la conexión.
                con.close();
                
            }catch(SQLException ex){
                // En caso de excepción al hacer rollback o cerrar la conexión, imprime la traza de la excepción.
                Logger.getLogger(Transacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
        }
        // Retorna la variable de respuesta.
        return rtadmin;
    
    }
}
