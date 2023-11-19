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
                                                
                                                <input type="hidden" id="IdUsu" value="${obr.getArtista().getIdUsuario()}">
                                                <input type="hidden" name="txtdocumento" id="Documento" value="${obr.getArtista().getNroDocumento()}">
                                                <p class="text-center" style="color: #00AD00;" id="NombreUsu">${obr.getArtista().getNombreUsuario()}</p>
                                                <p class="text-center" style="color: #00AD00;" id="Nivel_Formacion">${obr.getArtista().getNivel_Formacion()}</p>
                                                <div class="espaci mb-3">
                                                    
                                                    <form  id="form" method="post" enctype="multipart/form-data">
                                                    <img src="src" alt="alt"/>
                                                    <input type="file" class="btn1 btn-outline-secondary" id="img" style="text-decoration: none; border: 2px solid #00AD00;">
                                                        
                                                    <input type="text"  class="form-control" id="NomObr" placeholder="Nombre de la obra" name="NameObr">
                                                  
          
                                                    <input type="text"  class="form-control" id="Tecnica" placeholder="Tecnica" name="Tecnica">
                                                
                                               
                                                    <input type="text"  class="form-control" id="Descripcion" placeholder="Descripción" name="Descripcion">
                                               
                                                
                                                    <input type="text"  class="form-control" id="Precio" placeholder="Valor de la obra" name="Precio">
                                                
                                                
                                                    <select class="form-control" id="Categoria"  name="txtCategoria">
                                                    <option >Seleccione la categoria de la obra</option>
                                                    <option value="1">Lapiz de grafito</option>
                                                    <option value="2">Lapices de colores</option>
                                                    <option value="3">Técnicas artísticas con rotuladores</option>
                                                    <option value="4">Carboncillo</option>
                                                    <option value="5">Ceras</option>
                                                    <option value="6">Pastel</option>
                                                    <option value="7">Tempera</option>
                                                    <option value="8">Acuarela</option>
                                                    <option value="9">Oleo</option>
                                                    </select>
                                                
                                                    <select name="txtModoVenta"  class="form-control" id="ModoVent" >
                                                    <option>De click y seleccione el modo de venta que le convenga</option>
                                                    <option value="VentaDirecta">Venta directa</option>
                                                    <option value="Subasta">Subasta</option>
                                                    </select>
                                                    <input class="btn text-light" style="background-color: #00AD00;" type="submit">
                                                 </form>
                                                </div>
                                                
                
                                                <br>
                                                <!-- Botón para registrarse -->
                                               <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                                               <script src="JS/Script.js"></script>    
                                                  
                                                     <!-- <button class="btn text-light" style="background-color: #00AD00;" type="button"><a style=" color: white; text-decoration: none" href="">Iniciar</a></button> -->
                                              
                                               
        </section>
    </body>
</html>
