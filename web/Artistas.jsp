<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="Artistas.css"/>
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
            <div class="card col-md-4 mt-3">
                <div class="card-body">
                    <h5 class="card-title">Artistas</h5>
                    
                    <div>
                        <form action="Controlador?" method="POST" >
                             
                            <div class="form-group">
                                <label>Tipo de documento</label>
                                <select id="disabledSelect" class="form-control form-control-sm" name="TipoDocumento">
                                            <option>Seleccione su tipo de documento</option>
                                            <option value="Cedula de ciudadania">Cédula de Ciudadania</option>
                                            <option value="Cedula de Extranjeria">Cédula de Extranjeria</option>
                                            <option value="Tarjeta de identidad">Tarjeta de identidad</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Documento</label>
                                <input type="text" class="form-control" name="txtDocumento" value="${ArtistaElj.getNroDocumento()}">
                                <small class="form-text text-muted">Ingrese El No de documento sin espacios ni caracteres especiales</small>
                            </div>
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="txtNombre" value="${ArtistaElj.getNombreUsuario()}">
                            </div>
                            <div class="form-group">
                                <label>Pseudonombre</label>
                                <input type="text" class="form-control" name="txtPseudonombre" value="${ArtistaElj.getPseudonombre()}">
                            </div>
                            <div class="form-group">
                                <label>Correo</label>
                                <input type="text" class="form-control" name="txtcorreo" value="${ArtistaElj.getCorreoUsuario()}">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="Contrasena" value="${ArtistaElj.getContrasena()}">
                            </div>
                            <div class="form-group">
                                <label>Telefono</label>
                                <input type="text" class="form-control" name="Telefono" value="${ArtistaElj.getTelefono()}">
                            </div>
                            <div class="form-group">
                                <label>Nivel de Formacion</label>
                                <select class="form-control form-control-sm" name="levelFormacion">
                                    <option value="Tecnologo">Tecnologo</option>
                                    <option value="Tecnico">Tecnico</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Nombre de Ficha</label>
                                <input type="text" class="form-control" name="NmFicha" value="${ArtistaElj.getNombre_Ficha()}">
                            </div>
                            <div class="form-group">
                                <label>Numero de Ficha</label>
                                <input type="Number" class="form-control" name="NroFicha" value="${ArtistaElj.getNumero_Ficha()}">
                            </div>
                            <div class="form-group">
                                <label>Rol</label>
                                <select class="form-control form-control-sm" name="TipoRol">
                                    <option value="1">Admin</option>
                                    <option value="2">Artista</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <select class="form-control form-control-sm" name="txtestado">
                                    
                                    <option value="Activo">Activo</option>
                                    <option value="Inactivo">Inactivo</option>
                                </select>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="Registar_Artista" >
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" >
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-8 mt-3">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Tipo de documento</th>
                            <th scope="col">Documento</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Imagen del perfil</th>
                            <th scope="col">Pseudonombre</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Contraseña</th>
                            <th scope="col">Telefono</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Acciones</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="Art" items="${Art}">

                            <tr>
                                <th scope="row">${Art.getIdUsuario()}</th>
                                <th>${Art.getTipoDocumento()}</th>
                                <td>${Art.getNroDocumento()}</td>
                                <td>${Art.getNombreUsuario()}</td>
                                <td><img src="${Art.getImg_perfil()}" alt="alt"/></td>
                                <td>${Art.getPseudonombre()}</td>
                                <td>${Art.getCorreoUsuario()}</td>
                                <td>${Art.getContrasena()}</td>
                                <td>${Art.getTelefono()}</td>
                                <td>${usuario.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Redireccionamientos?menu=Artistas&accion=Editar&id=${Art.getIdUsuario()}">Editar</a>
                                    <a class="btn btn-danger" href="Redireccionamientos?menu=Artistas&accion=Eliminar&id=${Art.getIdUsuario()}">Eliminar</a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>