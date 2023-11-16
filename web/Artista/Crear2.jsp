<%-- 
    Document   : Crear2
    Created on : 16/11/2023, 4:54:45 p. m.
    Author     : jhoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section>
              
                                                
             
                                                
                                                
                                                <!-- Se solicita el ingreso del correo -->
                                                
                                                <input type="hidden" value="${obr.getArtista().getIdUsuario()}">
                                                <input type="hidden" name="txtdocumento" value="${obr.getArtista().getNroDocumento()}">
                                                <p class="text-center" style="color: #00AD00;">${obr.getArtista().getNombreUsuario()}</p>
                                                <p class="text-center" style="color: #00AD00;">${obr.getArtista().getNivel_Formacion()}</p>
                                                <div class="espaci mb-3">
                                                    <form action="Mv_Usuarios?menu=Inicio&accion=crear&cc=${obr.getArtista().getNroDocumento()}" method="post" enctype="multipart/form-data">
                                                    <img src="src" alt="alt"/>
                                                    <input type="file" class="btn1 btn-outline-secondary" style="text-decoration: none; border: 2px solid #00AD00;">
                                                        
                                                    <input type="text"  class="form-control" id="exampleInputPassword1" placeholder="Nombre de la obra" name="NameObr">
                                                  
          
                                                    <input type="text"  class="form-control" id="exampleInputPassword1" placeholder="Tecnica" name="Tecnica">
                                                
                                               
                                                    <input type="text"  class="form-control" id="exampleInputPassword1" placeholder="Descripción" name="Descripcion">
                                               
                                                
                                                    <input type="text"  class="form-control" id="exampleInputPassword1" placeholder="Valor de la obra" name="Precio">
                                                
                                                
                                                    <select class="form-control" id="exampleInputPassword1"  name="txtCategoria">
                                                    <option >Seleccione la categoria de la obra</option>
                                                    <option value="1">Lapiz de grafito</option>
                                                    <option value="2">Lapices de colores</option>
                                                    <option value="3">Tecnicas con rotuladores</option>
                                                    <option value="4">Carboncillo</option>
                                                    <option value="5">Ceras</option>
                                                    <option value="6">Pastel</option>
                                                    <option value="7">Tempera</option>
                                                    <option value="8">Acuarela</option>
                                                    <option value="9">Oleo</option>
                                                    </select>
                                                
                                                    <select name="txtModoVenta" class="form-control" id="exampleInputPassword1" >
                                                    <option>De click y seleccione el modo de venta que le convenga</option>
                                                    <option value="VentaDirecta">Venta directa</option>
                                                    <option value="Subasta">Subasta</option>
                                                    </select>
                                                    <input class="btn text-light" style="background-color: #00AD00;" type="submit">
                                                 </form>
                                                </div>
                                                
                
                                                <br>
                                                <!-- Botón para registrarse -->
                                               
                                                    
                                                  
                                                     <!-- <button class="btn text-light" style="background-color: #00AD00;" type="button"><a style=" color: white; text-decoration: none" href="">Iniciar</a></button> -->
                                              
                                               
        </section>
    </body>
</html>
