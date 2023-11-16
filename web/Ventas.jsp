<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Sistema de ventas</title>
        <style>
            @media print{
                .seccion1, .btn, .columna{
                    display:none;
                }
            }
        </style>
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
                        <a class="nav-link" href="Redireccionamientos?menu=Obras&accion=Listar">Obras</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Redireccionamientos?menu=Artistas&accion=Listar">Artistas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Redireccionamientos?menu=Ventas&accion=Listar">Ventas</a>
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
                        <form class="dropdown-item" method="POST" action="Redireccionamientos?accion=Salir">
                            
                        </form>
                    </div>
                </div>
            </div>
        </nav>

                        <form action="Redireccionamientos?menu=Ventas" method="post">
                            <div class="row">
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="NombreObra" class="form-control" placeholder="Nombre de obra" value="${obrs.getNombre_obra()}">
                                    <input type="submit" name="accion" value="BuscarObra" class="btn btn-outline-dark">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-14">
                <div class="card">
                    <div class="card-header">
                        <div class="form-group row">
                             <label class="col-sm-2 col-form-label">Numero de factura</label>
                             <input class="form-control col-md-4" type="text" name="txtnumerofactura" value="${Numfact}">
                        </div>
                       
                    </div>
                    <div class="card-body">
                         <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            
                            <th scope="col">Codigo</th>
                            <th scope="col">Nombre_Artista</th>
                            <th scope="col">Nro_Documento</th>
                            <th scope="col">Nombre de Obra</th>
                            <th scope="col">Obra</th>
                            <th scope="col">Tecnica</th>
                            <th scope="col">Nombre_Comprador</th>
                            <th scope="col">Nro_Documento</th>
                            <th scope="col">Fecha_Venta</th>
                            <th scope="col">Total</th>
                            <th scope="col" class="columna">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                   
                       <c:forEach var="Ventas" items="${Ventas}">
                        <tr>
                            <th scope="row" style="width: 30px;">${Ventas.getObr().getId_obra()}</th>
                            <td style="width: 30px;">${Ventas.getArt().getNombreUsuario()}</td>
                            <td style="width: 350px;">${Ventas.getArt().getNroDocumento()}</td>
                            <td>${Ventas.getObr().getNombre_obra()}</td>
                            <td><img src="${Ventas.getObr().getUrl()}" alt="alt"/></td>
                            <td style="width: 30px;">${Ventas.getObr().getTecnica()}</td>
                            <td style="width: 350px;">${Ventas.getComp().getNombreUsuario()}</td>
                            <td style="width: 350px;">${Ventas.getComp().getNroDocumento()}</td>
                            <td style="width: 350px;">${Ventas.getFecha_venta()}</td>
                            <td style="width: 350px;">${Ventas.getValor_total()}</td>
      
                            <td class="columna">  
                                <a class="btn btn-danger" href="Redireccionamientos?menu=Ventas&accion=EliminarVenta&id=${Ventas.getNum_venta()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>

                       </tbody>
                </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-md-8 text-center">
                            <a class="btn btn-success" onclick="print()" href="Redireccionamientos?menu=Ventas&accion=GenerarVenta">Generar Venta</a>
                            <a class="btn btn-danger" href="Redireccionamientos?menu=Ventas&accion=NuevaVenta">Nueva Venta</a>
                          
                        </div>
                        <div class="col-md-4">
                            <input type=text" name="txttotalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="">
                         </div>
                    </div>
                    
                </div>

            </div>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        -->
    </body>
</html>
