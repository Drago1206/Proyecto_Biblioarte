<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="all.css" rel="stylesheet"> <!--load all styles -->
        <link href="css/obras.css" rel="stylesheet" type="text/css"/>
        <title>Hello, world!</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background: #00AD00">
            <a class="navbar-brand" href="#">BIBLIOARTE</a>
            <button class="navbar-toggler btn-success" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                         <a class="nav-link" href="Redireccionamientos?menu=Home">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Redireccionamientos?menu=Obras&accion=Listar" target="miContenedor">Obras</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Redireccionamientos?menu=Artistas&accion=Listar" target="miContenedor">Artistas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Redireccionamientos?menu=Ventas&accion=Listar" target="miContenedor">Ventas</a>
                    </li>
                </ul>
                
                <div class="btn-group">
                    <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${usuario.getNombre()}
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#"><i class="fas fa-user"></i></a>
                        <a class="dropdown-item" href="#">${usuario.getDocumento()}</a>
                        <a class="dropdown-item" href="#">${usuario.getCorreo()}</a>
                        <div class="dropdown-divider"></div>
                        <form class="dropdown-item" method="POST" action="Redireccionamientos?menu=Obras">
                            <button class=" btn-success center-block" type="submit" name="accion" value="Salir">Cerrar Sesion</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>

        <div class="row">
            <div class="col-md-3">
                <form action="Redireccionamientos?menu=Obras" method="post">
                    
                    <div class="form-group">
                        <label>Nombre de Artista</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" name="txtNombreArt" value="${Obras.getArtista().getNombreUsuario()}">
                    </div>
                    
                    <div class="form-group">
                        <label>Nro_documento Artista</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" name="txtNroDocumentArt" value="${Obras.getArtista().getNroDocumento()}">
                    </div>
                    
                    <div class="form-group">
                        <label>Nombre de Obra</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" name="txtNombreObra" value="${Obras.getNombre_obra()}">
                    </div>
                    
                    <div class="form-group">
                        <label>Tecnica Obra</label>
                        <input type="text" class="form-control" name="txtTecnica" value="${Obras.getTecnica()}">
                    </div>
                    
                    <div class="form-group">
                        <label>Descripcion Obra</label>
                        <input type="text" class="form-control" name="txtDescripcion" value="${Obras.getDescripcion_obra()}">
                    </div>
                    
                    <div class="form-group">
                        <label>Precio</label>
                        <input type="text" class="form-control" name="txtPrecio" value="${Obras.getValor_obra()}">
                    </div>

                    <input type="hidden" name="id" value="${Obras.getId_obra()}">
                    <button type="submit" class="btn btn-success" name="accion" value="Actualizar">Actualizar</button>
                </form>
            </div>
            <div class="col-md-8">
                <table class="table table-striped">
                    <thead>
                           <tr>
                            <th scope="col">Codigo</th>
                            <th scope="col">Nombre_Artista</th>
                            <th scope="col">Numero_Documento</th>
                            <th scope="col">Nombre Obra</th>
                            <th scope="col">Obra</th>
                            <th scope="col">Tecnica</th>
                            <th scope="col">Descripcion</th>   
                            <th scope="col">Precio</th>
                            <th scope="col">Modalidad_Venta</th>
                            <th scope="col">Acciones</th>
                             </tr>
                    </thead>
                    
                    <tbody>
                        <c:forEach var="obras" items="${obras}">
                        <tr>
                            <th scope="row">${obras.getId_obra()}</th>
                            <td>${obras.getArtista().getNombreUsuario()}</td>
                            <td>${obras.getArtista().getNroDocumento()}</td>
                            <td>${obras.getNombre_obra()}</td>
                            <td class="rect"><img src="${obras.getUrl()}" alt="alt"/></td>
                            <td>${obras.getTecnica()}</td>
                            <td>${obras.getDescripcion_obra()}</td>
                            <td>${obras.getValor_obra()}</td>
                            <td>${obras.getModo_vent()}</td>
                            <td>
                                <a class="btn btn-warning" href="Redireccionamientos?menu=Obras&accion=Editar&id=${obras.getId_obra()}">Editar</a>
                                <a class="btn btn-danger" href="Redireccionamientos?menu=Obras&accion=Eliminar&id=${obras.getId_obra()}"><i class="fas fa-trash-alt"></i><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-archive-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M12.643 15C13.979 15 15 13.845 15 12.5V5H1v7.5C1 13.845 2.021 15 3.357 15h9.286zM5.5 7a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5zM.8 1a.8.8 0 0 0-.8.8V3a.8.8 0 0 0 .8.8h14.4A.8.8 0 0 0 16 3V1.8a.8.8 0 0 0-.8-.8H.8z"/>
</svg></a>
                            </td>
                           </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        -->
    </body>
</html>