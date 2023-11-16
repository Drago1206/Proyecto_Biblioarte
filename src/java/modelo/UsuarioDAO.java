/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jhoan
 */
public class UsuarioDAO {
    
    // Variable de instancia para almacenar un resultado (puede ser el resultado de una consulta o una operación).
    int r;
    
 
    // Método para validar las credenciales de un usuario.
    public Usuario Validar(Usuario usu) throws SQLException {
        
        // Inicializa una referencia a un objeto Usuario en null.
        Usuario usuario = null;
        
        // Declaraciones para la conexión a la base de datos.
        Conexion con;
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // Consulta SQL para validar las credenciales del usuario.
        String sql = "SELECT U.NroDocumento, U.IdUsuario, C.NombreRol "
                + "FROM tb_registro U"+" "
                + "INNER JOIN tb_rol C ON U.IdRol_Fk = C.IdRol "+" "
                + "WHERE U.Estado = 1 AND U.NroDocumento = "
                + "'"+ usu.getDocumento()+ "' AND U.contrasena ='"+ usu.getPassword() +"' ";
                
        // Crea una instancia de la clase Conexion.        
        con = new Conexion();
        try{
            // Obtiene una conexión a la base de datos.
            cn = con.Conexion();
            // Crea un objeto Statement para ejecutar la consulta SQL
            st = cn.createStatement();
            // Ejecuta la consulta SQL y obtiene un conjunto de resultados.
            rs = st.executeQuery(sql);

            // Imprime la consulta SQL en la consola (útil para propósitos de depuración).
            System.out.print(sql);
            
               // Itera a través de los resultados obtenidos.
               while(rs.next()){
                // Crea una nueva instancia de Usuario.
                usu = new Usuario();
                 /* Crea una instancia de Rol y establece su nombre con el valor obtenido de la columna 
                 "NombreRol" en el conjunto de resultados.*/
                Rol rol = new Rol();
                rol.setNombreCargo(rs.getString("NombreRol"));
                
                // Establece los atributos del objeto Usuario con los valores obtenidos de las columnas del conjunto de resultados.
                usu.setRol(rol);
                usu.setDocumento(rs.getInt("NroDocumento"));
                usu.setNombre(usu.getNombre());
                usu.setId(rs.getInt("IdUsuario"));
                
                // Imprime en la consola el ID del usuario.
               System.out.print(usu.getId());
               
               // Establece el estado del usuario como "Activo".
                usu.setEstado("Activo");
               }
            
        }catch(Exception e){
            // En caso de excepción, imprime el mensaje de error.
            System.out.println("Error" + e.getMessage());
        }
        // Retorna el objeto Usuario resultante (puede ser null si no se encontraron coincidencias en la base de datos).
        return usu;
    }
    
    public Usuario registrar(Usuario usuario, Connection cn){
        // Declaración del objeto PreparedStatement para ejecutar la consulta parametrizada.
        PreparedStatement ps;
        
        // Consulta SQL para insertar un nuevo registro de usuario.
        String sql ="INSERT INTO `tb_registro`(`NroDocumento`, `NombreUsuario`, `CorreoUsuario`, `contrasena`, `telefono`, `Pseudonombre`, `TipoDocument`, `IdRol_fk`)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try{
            // Prepara la consulta SQL con la opción de devolver claves generadas.
            ps= cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            // Establece los valores de los parámetros en la consulta SQL.
            ps.setInt(1, usuario.getDocumento());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getPseudonombre());
            ps.setString(7, usuario.getTipoDocumento());
            ps.setInt(8, usuario.getId_rol());
            
            // Ejecuta la actualización en la base de datos.
            ps.executeUpdate();
            
            // Obtiene las claves generadas después de la ejecución de la consulta.
            ResultSet rs = ps.getGeneratedKeys();
            
            // Verifica si hay claves generadas.
            if(rs.next()){
                // Establece el ID generado en el objeto Usuario.
                usuario.setId(rs.getInt(1));
            }
          
        }catch(SQLException ex){
            // En caso de excepción, imprime la traza de la excepción.
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retorna el objeto Usuario con el ID actualizado.
        return usuario;
    }
    
    
    
    
    public Compradores registrar_comp(Compradores comp,  Connection cn){
    
        
       // Declaración del objeto PreparedStatement para ejecutar la consulta parametrizada.
        PreparedStatement ps;
        
        ResultSet rs;
        // Consulta SQL para insertar un nuevo registro de comprador.
        String sql ="INSERT INTO `tb_comprador`(`NombreUsuario`, `IdRol_fk`, `NroDocumento_fk`, `CorreoUsuario`, `contrasena`, `Telefono`,  `Pseudonombre`, `TipoDocumento`,`IdUsuario_fk`)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try{
          
            // Prepara la consulta SQL.
            ps= cn.prepareStatement(sql);
            
            // Establece los valores de los parámetros en la consulta SQL.
            ps.setString(1, comp.getNombreUsuario());
            ps.setInt(2, comp.getIdRol_fk());
            ps.setInt(3, comp.getNroDocumento());
            ps.setString(4, comp.getCorreoUsuario());
            ps.setString(5, comp.getContrasena());
            ps.setString(6, comp.getTelefono());
            
            ps.setString(7, comp.getPseudonombre());
            ps.setString(8, comp.getTipoDocumento());
            ps.setInt(9, comp.getIdUsuario());
            
            // Ejecuta la actualización en la base de datos.
            ps.executeUpdate();
          
        }catch(SQLException ex){
            // En caso de excepción, imprime la traza de la excepción.
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retorna el objeto Compradores.
        return comp;
    }
    
    public Artistas registrar_art(Artistas Art , Connection cn){
        
        // Declaración del objeto PreparedStatement para ejecutar la consulta parametrizada.
        PreparedStatement ps;
        
        // Consulta SQL para insertar un nuevo registro de artista.
        String sql ="INSERT INTO `tb_artista`(`NombreUsuario`, `IdRol_fk`,`NroDocumento_fk`, `CorreoUsuario`, `contrasena`, `Telefono`, `Pseudonombre`, `TipoDocumento`, `Nivel_Formacion`, `Nombre_Ficha`, `Numero_Ficha`, `IdUsuario_fk`)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
           // Crea una nueva instancia de Conexion
          // Prepara la consulta SQL.
          ps= cn.prepareStatement(sql);
          
          // Establece los valores de los parámetros en la consulta SQL.
          ps.setString(1, Art.getNombreUsuario());
            ps.setInt(2, Art.getIdRol_fk());
            ps.setInt(3, Art.getNroDocumento());
            ps.setString(4, Art.getCorreoUsuario());
            ps.setString(5, Art.getContrasena());
            ps.setString(6, Art.getTelefono());
            
            ps.setString(7, Art.getPseudonombre());
            ps.setString(8, Art.getTipoDocumento());
            ps.setString(9, Art.getNivel_Formacion());
            ps.setString(10, Art.getNombre_Ficha());
            ps.setString(11, Art.getNumero_Ficha());
            ps.setInt(12, Art.getIdUsuario());
            
            // Ejecuta la actualización en la base de datos.
            ps.executeUpdate();
            
        }catch(SQLException ex){
            // En caso de excepción, imprime la traza de la excepción.
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retorna el objeto Artistas
        return Art;
    }
    
    public static List Listar_Art(){
        
        // Declaraciones para la conexión a la base de datos.
        Conexion con;
        Connection cn;
        Statement st;
        ResultSet rs;
        
        // Consulta SQL para obtener todos los registros de la tabla `tb_artista`.
        String sql ="SELECT * FROM `tb_artista` ";
        
        // Lista que almacenará objetos Artistas.
        List <Artistas> lista = new ArrayList();
        // Crea una instancia de la clase Conexion.
        con = new Conexion();
        
        try{
        // Obtiene una conexión a la base de datos.
        cn= con.Conexion();
        // Crea un objeto Statement para ejecutar la consulta SQL.
        st = cn.createStatement();
        // Ejecuta la consulta SQL y obtiene un conjunto de resultados.
        rs= st.executeQuery(sql);
        
        // Imprime la consulta SQL en la consola (útil para propósitos de depuración).
        System.out.print(sql);
        
        // Itera a través de los resultados obtenidos.
        while(rs.next()){
            // Crea una nueva instancia de Artistas.
            Artistas art= new Artistas();
            
            // Establece los atributos del objeto Artistas con los valores obtenidos de las columnas del conjunto de resultados.
            art.setIdUsuario(rs.getInt("IdUsuario_fk"));
            art.setIdRol_fk(rs.getInt("idRol_fk"));
            art.setNombreUsuario(rs.getString("NombreUsuario"));
            art.setTipoDocumento(rs.getString("TipoDocumento"));
            art.setNroDocumento(rs.getInt("NroDocumento_fk"));
            art.setCorreoUsuario(rs.getString("CorreoUsuario"));
            art.setContrasena(rs.getString("contrasena"));
            art.setPseudonombre(rs.getString("Pseudonombre"));
            art.setTelefono(rs.getString("Telefono"));
            art.setEstado(rs.getString("Estado"));
            art.setImg_perfil(rs.getString("Imagen_perfil"));
            
            // Agrega el objeto Artistas a la lista.
            lista.add(art);   
        }
        }catch(Exception e){
            // En caso de excepción, imprime el mensaje de error.
            System.out.println("Error" + e.getMessage());
        } 
        // Retorna la lista de artistas.
        return lista;
    }
    
    
    public Artistas Listar_id(int id ){
        
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Artistas art = new Artistas();
        
        // Consulta SQL para obtener información detallada de un artista por su ID.
        String sql ="SELECT `NombreUsuario`, `IdRol_fk`, `IdUsuario_fk`, `NroDocumento_fk`, `CorreoUsuario`, `contrasena`, `Telefono`, `Estado`, `Pseudonombre`, `TipoDocumento`,`Imagen_perfil`,`Nivel_Formacion`,`Nombre_Ficha`,`Numero_Ficha`"
                + "FROM `tb_artista` WHERE IdUsuario_fk = " + id;
        con = new Conexion();
        cn= con.Conexion();
        
         try{
             // Imprime la consulta SQL en la consola (útil para propósitos de depuración).
        System.out.println(sql);

        // Luego, prepara la sentencia SQL usando PreparedStatement
        ps = cn.prepareStatement(sql);
        

        // Ejecuta la consulta
        rs = ps.executeQuery();
         
        // Itera a través de los resultados obtenidos.
        while(rs.next()){
            
            // Establece los atributos del objeto Artistas con los valores obtenidos de las columnas del conjunto de resultados.
            art.setIdUsuario(rs.getInt("IdUsuario_fk"));
            art.setIdRol_fk(rs.getInt("idRol_fk"));
            art.setNombreUsuario(rs.getString("NombreUsuario"));
            art.setTipoDocumento(rs.getString("TipoDocumento"));
            art.setNroDocumento(rs.getInt("NroDocumento_fk"));
            art.setCorreoUsuario(rs.getString("CorreoUsuario"));
            art.setContrasena(rs.getString("contrasena"));
            art.setPseudonombre(rs.getString("Pseudonombre"));
            art.setTelefono(rs.getString("Telefono"));
            art.setEstado(rs.getString("Estado"));   
            art.setImg_perfil(rs.getString("Imagen_perfil"));
            art.setNivel_Formacion(rs.getString("Nivel_Formacion"));
            art.setNombre_Ficha(rs.getString("Nombre_Ficha"));
            art.setNumero_Ficha(rs.getString("Numero_Ficha"));
        }
        }catch(Exception e){
            // En caso de excepción, imprime el mensaje de error.
            System.out.println("Error" + e.getMessage());
        }  finally {
        // Asegúrate de cerrar los recursos (ResultSet, PreparedStatement y Connection)
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return art;
    }
    
    public Compradores Listar_idComp(int id){
        // Declaraciones para la conexión a la base de datos.
               Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Compradores comp = new Compradores();
        
        // Consulta SQL para obtener información detallada de un comprador por su ID.
        String sql ="SELECT * FROM `tb_comprador` WHERE IdUsuario_fk ="+id;
        con = new Conexion();
        cn= con.Conexion();
        
         try{
             // Imprime la consulta SQL en la consola (útil para propósitos de depuración).
        System.out.println(sql);

        // Luego, prepara la sentencia SQL usando PreparedStatement
        ps = cn.prepareStatement(sql);
        

        // Ejecuta la consulta
        rs = ps.executeQuery();
         
        // Itera a través de los resultados obtenidos.
        while(rs.next()){
            
            // Establece los atributos del objeto Compradores con los valores obtenidos de las columnas del conjunto de resultados.
            comp.setIdUsuario(rs.getInt("IdUsuario_fk"));
            comp.setIdRol_fk(rs.getInt("idRol_fk"));
            comp.setNombreUsuario(rs.getString("NombreUsuario"));
            comp.setTipoDocumento(rs.getString("TipoDocumento"));
            comp.setNroDocumento(rs.getInt("NroDocumento_fk"));
            comp.setCorreoUsuario(rs.getString("CorreoUsuario"));
            comp.setContrasena(rs.getString("contrasena"));
            comp.setPseudonombre(rs.getString("Pseudonombre"));
            comp.setTelefono(rs.getString("Telefono"));
            comp.setEstado(rs.getString("Estado"));   
            comp.setImg_perfil(rs.getString("Imagen_perfil"));
           
        }
        }catch(Exception e){
            // En caso de excepción, imprime el mensaje de error.
            System.out.println("Error" + e.getMessage());
        }  finally {
        // Asegúrate de cerrar los recursos (ResultSet, PreparedStatement y Connection)
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        return comp;
    }
    
    public static int Eliminar_art(int id ){
        // Declaraciones para la conexión a la base de datos.
        Connection cn;
        Conexion con = new Conexion();
        cn = con.Conexion();
        PreparedStatement ps;
        
        // Consulta SQL para eliminar un registro de artista por su ID.
        String sql = "DELETE FROM `tb_artista` WHERE `IdUsuario_fk` = " + id;
        
        try {
            // Luego, prepara la sentencia SQL usando PreparedStatement
            ps = cn.prepareStatement(sql);
            // Ejecuta la actualización para eliminar el registro.
            ps.executeUpdate();
        } catch (SQLException ex) {
            // En caso de excepción, imprime la traza de la excepción.
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retorna 0 (puede ser modificado según el diseño del sistema).
        return 0;
        
        
    }
    
    public static int Actualizar_Art(Artistas art){
        
        Conexion con = null;
        Connection cn;
        PreparedStatement ps;
      
        
        
        String sql = "UPDATE `tb_artista` SET `NombreUsuario`=?,`IdRol_fk`=?,`NroDocumento_fk`=?,`CorreoUsuario`=?,`contrasena`=?,`Telefono`=?,`Estado`=?,`Pseudonombre`=?,`TipoDocumento`=? WHERE `IdUsuario_fk` ="+art.getIdUsuario();
        System.out.println(sql);
        con = new Conexion();
        cn= con.Conexion(); 
        try {
            
            ps = cn.prepareStatement(sql);

            ps.setString(1, art.getNombreUsuario());
            ps.setInt(2, art.getIdRol_fk());
            ps.setInt(3, art.getNroDocumento());
            ps.setString(4, art.getCorreoUsuario());
            ps.setString(5, art.getContrasena());
            ps.setString(6, art.getTelefono());
            ps.setString(7, art.getEstado());
            ps.setString(8, art.getPseudonombre());
            ps.setString(9, art.getTipoDocumento());
           
            System.out.print(art.getIdUsuario());
            
            ps.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
       
    }
    
    public static int Actualizar_comp(Compradores comp){
         
        Conexion con = null;
        Connection cn;
        PreparedStatement ps;
      
        
        
        String sql = "UPDATE `tb_comprador` SET `NombreUsuario`=?,`IdRol_fk`=?,`IdUsuario_fk`=?,`NroDocumento_fk`=?,`CorreoUsuario`=?,`contrasena`=?,`Telefono`=?,`Estado`=?,`Pseudonombre`=?,`TipoDocumento`=? WHERE IdUsuario_fk =?";
        System.out.println(sql);
        con = new Conexion();
        cn= con.Conexion(); 
        try {
            
            ps = cn.prepareStatement(sql);

            ps.setString(1, comp.getNombreUsuario());
            ps.setInt(2, comp.getIdRol_fk());
            ps.setInt(3, comp.getNroDocumento());
            ps.setString(4, comp.getCorreoUsuario());
            ps.setString(5, comp.getContrasena());
            ps.setString(6, comp.getTelefono());
            ps.setString(7, comp.getEstado());
            ps.setString(8, comp.getPseudonombre());
            ps.setString(9, comp.getTipoDocumento());
            ps.setInt(10, comp.getIdUsuario());
            ps.setString(11, comp.getImg_perfil());
            
            ps.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
     public static int Actualizar_ArtPerfil(Artistas art){
        
        Conexion con = null;
        Connection cn;
        PreparedStatement ps;
      
        
        
        String sql = "UPDATE `tb_artista` SET `NombreUsuario`=?,`CorreoUsuario`=?,`Telefono`=?,`Pseudonombre`=?,`Imagen_perfil`=?  WHERE `IdUsuario_fk` ="+art.getIdUsuario();
        System.out.println(sql);
        con = new Conexion();
        cn= con.Conexion(); 
        try {
            
            ps = cn.prepareStatement(sql);

            ps.setString(1, art.getNombreUsuario());     
            ps.setString(2, art.getCorreoUsuario());         
            ps.setString(3, art.getTelefono());        
            ps.setString(4, art.getPseudonombre());
            ps.setString(5, art.getImg_perfil());
            System.out.print(art.getImg_perfil());
            
            
            ps.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
       
    }
     public static int ActualizarCompPerfil(Compradores comp){
         
        Conexion con = null;
        Connection cn;
        PreparedStatement ps;
      
        
        
        String sql = "UPDATE `tb_artista` SET `NombreUsuario`=?,`CorreoUsuario`=?,`Telefono`=?,`Pseudonombre`=?,`Imagen_perfil`=?  WHERE `IdUsuario_fk` ="+comp.getIdUsuario();
        System.out.println(sql);
        con = new Conexion();
        cn= con.Conexion(); 
        try {
            
            ps = cn.prepareStatement(sql);

            ps.setString(1, comp.getNombreUsuario());     
            ps.setString(2, comp.getCorreoUsuario());         
            ps.setString(3, comp.getTelefono());        
            ps.setString(4, comp.getPseudonombre());
            ps.setString(5, comp.getImg_perfil());
            System.out.print(comp.getImg_perfil());
            
            
            ps.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
       
    }
    
    public Admin registrar_admin(Admin admin, Connection cn){
        PreparedStatement ps;

        String sql ="INSERT INTO `tb_admin`(`IdRol_Fk`, `NroDocumento_fk`, `Correo`, `Nombre`, `contrasena`, `Estado`) "
                + "VALUES (?,?,?,?,?,?)";
        try{
            ps= cn.prepareStatement(sql);
            ps.setInt(1, admin.getIdRol_Fk());
            ps.setInt(2, admin.getNroDocumento_fk());
            ps.setString(3, admin.getCorreo());
            ps.setString(4, admin.getNombre());
            ps.setString(5, admin.getContrasena());
            ps.setString(6, admin.getEstado());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
    
  
     public Obras Agregar_obras(Obras obr){
             Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Artistas art = new Artistas();
        Ventas_realizadas vent = new Ventas_realizadas();
        
        
       
        String sql = "INSERT INTO `tb_obras_art`(`img_obra`, `Id_usu_Art`, `Nombre_Obra`, `Descripcion_Obra`, `Tecnica`, `Nro_categoria_fk`, `Valor_obra`, `Modo_venta`, `NroDocumento`) "
                + "VALUES ('?','?','?','?','?','?','?','?','?')";
        try{
           // Crea una nueva instancia de Conexion
        con = new Conexion();
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
            ps.setInt(1, obr.getId_obra());
            ps.setString(2, obr.getUrl());
            ps.setInt(3, obr.getArtista().getIdUsuario());
            ps.setString(4, obr.getNombre_obra());
            ps.setString(5, obr.getDescripcion_obra());
            ps.setString(6, obr.getTecnica());
            ps.setInt(7, obr.getNro_categoria());
            ps.setFloat(8, obr.getValor_obra());
            ps.setString(9, obr.getModo_vent());
            ps.setInt(10, obr.getArtista().getNroDocumento());
            
            ps.executeUpdate();
            System.out.print("Se ejecuto las consultas de insertar obra");
            
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public  static List Listar(){
        Obras obras = null;
        Conexion con;
        Connection cn;
        Statement st;
        ResultSet rs;
        
        String sql ="SELECT O.*, A.NombreUsuario, A.NroDocumento_fk, A.Estado FROM tb_obras_art O "
                + "INNER JOIN tb_artista A ON O.NroDocumento = A.NroDocumento_fk;";
        
        List <Obras> lista = new ArrayList();
        con = new Conexion();
        
        try{
        cn= con.Conexion();
        st = cn.createStatement();
        rs= st.executeQuery(sql);
        
        System.out.print(sql);
        
        while(rs.next()){
            obras = new Obras();
            Artistas art= new Artistas();
            
            obras.setId_obra(rs.getInt("O.id_obra"));
            obras.setUrl(rs.getString("O.img_obra"));
            art.setNombreUsuario(rs.getString("NombreUsuario"));
            art.setNroDocumento(rs.getInt("NroDocumento"));
            art.setEstado(rs.getString("Estado"));
            obras.setArtista(art);
            
            obras.setTecnica(rs.getString("Tecnica"));
            obras.setNombre_obra(rs.getString("O.Nombre_Obra"));
            obras.setDescripcion_obra(rs.getString("O.Descripcion_Obra"));
            obras.setValor_obra(rs.getFloat("O.Valor_obra"));
            obras.setModo_vent(rs.getString("O.Modo_venta"));
            
            lista.add(obras);   
        }
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        } 
        return lista;
    }
    public Obras ListarOb_id(int id ){
        
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Obras obras = new Obras();
        
        String sql ="SELECT O.*, A.NombreUsuario, A.IdUsuario_fk, A.NroDocumento_fk, A.Estado, A.Nivel_Formacion, Nombre_Ficha, Numero_Ficha FROM tb_obras_art O " +
                 "INNER JOIN tb_artista A ON O.NroDocumento = A.NroDocumento_fk WHERE id_obra =  " + id;
        System.out.print(sql);
        
        con = new Conexion();
        cn= con.Conexion();
        
          try{
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
        rs= ps.executeQuery();
        
        
        
        while(rs.next()){
            
            System.out.print("Si esta bien la consulta");
            obras = new Obras();
            Artistas art= new Artistas();
            
            obras.setId_obra(rs.getInt("O.id_obra"));
            obras.setUrl(rs.getString("O.img_obra"));
            
            art.setIdUsuario(rs.getInt("IdUsuario_fk"));
            art.setNombreUsuario(rs.getString("NombreUsuario"));
            art.setNroDocumento(rs.getInt("NroDocumento"));
            art.setNivel_Formacion(rs.getString("Nivel_Formacion"));
            art.setNombre_Ficha(rs.getString("Nombre_Ficha"));
            art.setNumero_Ficha(rs.getString("Numero_Ficha"));
            art.setEstado(rs.getString("Estado"));
            
            obras.setArtista(art);
            
            obras.setNombre_obra(rs.getString("O.Nombre_Obra"));
            obras.setDescripcion_obra(rs.getString("O.Descripcion_Obra"));
            obras.setValor_obra(rs.getFloat("O.Valor_obra"));
            obras.setTecnica(rs.getString("Tecnica"));
            
             
        }
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        } 
        return obras;
    
    }
    public Obras ListarOb_idUsu(int id){
     Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Obras obras = new Obras();
        
        String sql ="SELECT O.*, A.NombreUsuario, A.IdUsuario_fk, A.NroDocumento_fk, A.Estado, A.Nivel_Formacion, A.Nombre_Ficha, A.Numero_Ficha FROM tb_obras_art O " +
                 "INNER JOIN tb_artista A ON O.NroDocumento = A.NroDocumento_fk WHERE A.IdUsuario_fk =  " + id;
        System.out.print(sql);
        
        con = new Conexion();
        cn= con.Conexion();
        
          try{
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
        rs= ps.executeQuery();
        
        
        
        while(rs.next()){
            
            System.out.print("Si esta bien la consulta");
            obras = new Obras();
            Artistas art= new Artistas();
            
            obras.setId_obra(rs.getInt("O.id_obra"));
            obras.setUrl(rs.getString("O.img_obra"));
            
            art.setIdUsuario(rs.getInt("IdUsuario_fk"));
            art.setNombreUsuario(rs.getString("NombreUsuario"));
            art.setNroDocumento(rs.getInt("NroDocumento"));
            art.setNivel_Formacion(rs.getString("Nivel_Formacion"));
            art.setNombre_Ficha(rs.getString("Nombre_Ficha"));
            art.setNumero_Ficha(rs.getString("Numero_Ficha"));
            art.setEstado(rs.getString("Estado"));
            
            obras.setArtista(art);
            
            obras.setNombre_obra(rs.getString("O.Nombre_Obra"));
            obras.setDescripcion_obra(rs.getString("O.Descripcion_Obra"));
            obras.setValor_obra(rs.getFloat("O.Valor_obra"));
            obras.setTecnica(rs.getString("Tecnica"));
            
             
        }
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        } 
        return obras;
    
        
    
    }
    
    public Obras ElminarOb(int id){
        Connection cn;
        Conexion con = new Conexion();
        cn = con.Conexion();
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM `tb_obras_art` WHERE `id_obra` = " + id;
        
        try {
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    
    }
    
    public static int ActualizarOb(Obras obras){
           Conexion con = null;
           Connection cn;
           PreparedStatement ps ;
      
        
        
        String sql = "UPDATE `tb_obras_art` SET Nombre_Obra=?, Descripcion_Obra=?, Tecnica=?, Valor_obra=? WHERE id_obra = ?";
        
        con = new Conexion();
        cn= con.Conexion(); 
        try {
            
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            
            

          
          
           ps.setString(1, obras.getNombre_obra());
           ps.setString(2, obras.getDescripcion_obra());
           ps.setString(3, obras.getTecnica());
        
           ps.setFloat(4, obras.getValor_obra());
           
           ps.setInt(5, obras.getId_obra());
           System.out.print("Si estan llegando toods los datos");
            
            ps.executeUpdate();
 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
       
        
    }
    
    public List<Ventas_realizadas> Ventas(String name){
     Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        List<Ventas_realizadas> ventasList = new ArrayList<>();
        
        
        String sql ="SELECT Art.NombreUsuario, Art.NroDocumento_fk, Art.Pseudonombre, Comp.NombreUsuario, Comp.NroDocumento_fk, Comp.Telefono, Obr.Nombre_Obra, Obr.id_obra, Obr.img_obra, Obr.Tecnica, Vent.fecha_venta, Vent.Valor_total, Vent.Num_venta" +" "
                    +"FROM tb_ventas_realizadas Vent" +" "
                    +"INNER JOIN tb_artista Art ON Nro_documentoArt_fk = Art.NroDocumento_fk" + " "
                    +"INNER JOIN tb_comprador Comp ON Nro_documentoComp_fk = Comp.NroDocumento_fk" +" "
                    +"INNER JOIN tb_obras_art  Obr ON id_obra_fk = Obr.id_Obra" +" "
                    +"WHERE Obr.Nombre_Obra = ?";
        
        System.out.print(sql);
        
        con = new Conexion();
        cn= con.Conexion();
        
        try{
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
        
        ps.setString(1, name);
        rs = ps.executeQuery();
        
        while(rs.next()){
          Ventas_realizadas Vent = new Ventas_realizadas();
          Artistas art = new Artistas();
          Obras obr = new Obras();
          Compradores comp = new Compradores();
          
          
          art.setNombreUsuario(rs.getString("Art.NombreUsuario"));
          art.setNroDocumento(rs.getInt("Art.NroDocumento_fk"));
          art.setPseudonombre(rs.getString("Art.Pseudonombre"));
          Vent.setArt(art);
          
          comp.setNombreUsuario(rs.getString("Comp.NombreUsuario"));
          comp.setNroDocumento(rs.getInt("Comp.NroDocumento_fk"));
          comp.setTelefono(rs.getString("Comp.Telefono"));
          Vent.setComp(comp);
          
          obr.setId_obra(rs.getInt("Obr.id_obra"));
          obr.setNombre_obra(rs.getString("Obr.Nombre_Obra"));
          obr.setUrl(rs.getString("Obr.img_obra"));
          obr.setTecnica(rs.getString("Obr.Tecnica"));
          Vent.setObr(obr);
          
          Vent.setFecha_venta(rs.getDate("Vent.fecha_venta"));
          Vent.setValor_total(rs.getFloat("Vent.Valor_total"));
          Vent.setNum_venta(rs.getInt("Vent.Num_venta"));
          
          ventasList.add(Vent);
          System.out.print("Se ejecutaron todas las consultas de ventas");
          
        }
        
        
        
        }catch(SQLException ex){
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    return ventasList;
    }
    
    public Artistas BuscarPorDocumento(String document) {
    Connection cn = null;
    Conexion con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Artistas art = new Artistas();
    
    String sql = "SELECT `NombreUsuario`, `NroDocumento_fk` FROM `tb_artista` WHERE `NroDocumento_fk` = ?";
    con = new Conexion();
    cn = con.Conexion();

    try {
        System.out.println(sql);

        // Prepara la sentencia SQL usando PreparedStatement
        ps = cn.prepareStatement(sql);
        ps.setString(1, document); // Establece el valor del parámetro

        
        rs = ps.executeQuery();

        while (rs.next()) {
            art.setNombreUsuario(rs.getString("NombreUsuario"));
            art.setNroDocumento(rs.getInt("NroDocumento_fk"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        // Asegúrate de cerrar los recursos (ResultSet, PreparedStatement y Connection)
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return art;
}
    public Obras BuscarporNombre(String name){
    
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Obras obras = new Obras();
        
        String sql ="SELECT * FROM tb_obras_art O  " +
                 " WHERE Nombre_Obra = ? ";
        System.out.print(sql);
        
        con = new Conexion();
        cn= con.Conexion();
        
          try{
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
        ps.setString(1, name);
        
        rs= ps.executeQuery();

        while(rs.next()){
            
            obras = new Obras();
           
            obras.setNombre_obra(rs.getString("O.Nombre_Obra"));
            obras.setDescripcion_obra(rs.getString("O.Descripcion_Obra"));
            obras.setValor_obra(rs.getFloat("O.Valor_obra"));
            obras.setTecnica(rs.getString("Tecnica"));
            
        }
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        } 
        return obras;

    }
    public String NumFactura(){
    
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String numVenta = "";
        String sql ="SELECT MAX(Nro_factura) FROM tb_facturas_ventas " ;
        System.out.print(sql);
        
        con = new Conexion();
        cn= con.Conexion();
        
          try{
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
        rs= ps.executeQuery();

        while(rs.next()){
            numVenta = rs.getString(1);
            System.out.print(numVenta);
        }
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        } 
        return numVenta;
    }
    
    public void InsertarFacturas( Ventas_realizadas vent){
        
        Connection cn = null;
        Conexion con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Obras obr = new Obras();
        Artistas art = new Artistas();
        
        
       
        String sql ="INSERT INTO `tb_facturas_ventas`(`Nro_factura`, `Nombre_Artista`, `NroDocumentoArt_fk`, `NombreObra`, `Tecnica`, `NombreComprador`, `NroDocumentoComp_fk`, `FechaVenta`, `Total`, `NroVenta_fk`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
           // Crea una nueva instancia de Conexion
        con = new Conexion();
        cn= con.Conexion();
        ps = cn.prepareStatement(sql);
            ps.setInt(1, vent.getNroFactura());
            ps.setString(2, vent.getArt().getNombreUsuario());
            ps.setInt(3, vent.getArt().getNroDocumento());
            ps.setString(4, vent.getObr().getNombre_obra());
            ps.setString(5, vent.getObr().getTecnica());
            ps.setString(6, vent.getComp().getNombreUsuario());
            ps.setInt(7, vent.getComp().getNroDocumento());
            ps.setDate(8, vent.getFecha_venta());
            ps.setFloat(9, vent.getValor_total());
            ps.setInt(10, vent.getNum_venta());
            
            ps.executeUpdate();
            System.out.print("Se ejecuto las consultas de registro de factura");
            
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

}
