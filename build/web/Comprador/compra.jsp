
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- Contenedor del encabezado -->
        <div class="container-fluid"  style="background: #00AD00;">
            <div >
                <a class="navbar-brand d-none d-md-block text-light" href="Artista/Perfil.jsp">
                    <img src="Artista/Iconos/perfil.png" alt="" style=" width: 30px; height: 30px;" class="d-inline-block">
                    Biblioarte
                </a>
            </div>
            
            <form class="d-flex">
                <div class="search-bar">
                    <input type="text" class="search-input" placeholder="Buscar">
                    <button class="search-button">
                        <i class="fas fa-search icon ">
                            <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="35" height="25" viewBox="0,0,256,256">
                            <g fill="#fffefe" fill-rule="nonzero" stroke="none" stroke-width="1
                            " stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><g transform="scale(5.12,5.12)"><path d="M21,3c-9.37891,0 -17,7.62109 -17,17c0,9.37891 7.62109,17 17,17c3.71094,0 7.14063,-1.19531 9.9375,-3.21875l13.15625,13.125l2.8125,-2.8125l-13,-13.03125c2.55469,-2.97656 4.09375,-6.83984 4.09375,-11.0625c0,-9.37891 -7.62109,-17 -17,-17zM21,5c8.29688,0 15,6.70313 15,15c0,8.29688 -6.70312,15 -15,15c-8.29687,0 -15,-6.70312 -15,-15c0,-8.29687 6.70313,-15 15,-15z"></path></g></g>
    
                            </svg></i>
                    </button>
                </div>
            </form>
            
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse pe-5" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Categorias
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Naturaleza</a></li>
                            <li><a class="dropdown-item" href="#">Surrealista</a></li>
                            <li><a class="dropdown-item" href="#">Abstracto</a></li>
                            <li><a class="dropdown-item" href="#">Otros.</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Menú
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                             <li><a class="dropdown-item" href="inicio_comprador.jsp"><img class="icon" src="Inicio.png"> Inicio</a></li>

                            <li><a class="dropdown-item" href="Perfil.jsp" ><img class="icon" src="Iconos/mi_cuenta.png">  Mi cuenta</a></li>

                            <li><a class="dropdown-item" href="Configuracion.jsp"><img class="icon"  src="Iconos/Config.png" >  Configuracion</a></li>

                            <li><a class="dropdown-item" href="subastas.jsp"><img class="icon"  src="Iconos/negocia.png" >  Negociaciones</a></li>
                            
                            <li><a class="dropdown-item" href="/../inicio.jsp"><img class="icon"  src="Iconos/cerrar-sesion.png" >  Salir</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
            
            <div class="container mt-4">
            <h2>Mis Compras</h2>
            <div class="row">            
                <table class="table tab-pane">
                    <thead class="thead-light">
                        <tr class="text-center">
                            <th>CODIGO DE COMPRA</th>                               
                            <th>Fecha de Compra</th>
                            <th>Monto</th>                                                   
                            <th>Codigo de Pago</th>                                                   
                            <th>Estado</th>                                                   
                            <th></th>                                                   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${myCompras}">
                            <tr class="text-center">
                                <td>C00${p.getId()}</td>                                  
                                <td>${p.getFecha()}</td>
                                <td>${p.getMonto()}</td>                                                                                                       
                                <td>P00${p.getIdPago()}</td>                                                                                                       
                                <td>${p.getEstado()}</td>                                                                                                       
                                <td>
                                    <a href="Controlador?accion=verDetalle&idcompra=${p.getId()}">Ver Detalle</a>
                                </td>                                                                                                       
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>             
            </div>          
        </div> 

        <!-- Modal Iniciar Session o Registrarse -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="container col-lg-9">                   
                    <div class="modal-content">                   
                        <div class="pr-2 pt-1">                         
                            <button type="button" class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                            </button>                    
                        </div>
                        <div class="text-center">                         
                            <img src="img/user.png" width="100" height="100">                         
                        </div>
                        <div class="modal-header text-center">                      
                            <ul class="nav nav-pills">                           
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="pill" href="#pills-iniciar">Iniciar Sesion</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="pill" href="#pills-registrar">Registrarse</a>
                                </li>                          
                            </ul>  
                        </div>
                        <div class="modal-body"> 
                            <div class="tab-content" id="pills-tabContent">
                                <!-- Iniciar Session -->
                                <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                    <form action="Controlador">
                                        <div class="form-group">
                                            <label>Email address</label>
                                            <input type="email" name="txtemail" class="form-control" placeholder="email@example.com">
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input type="password" name="txtpass" class="form-control" placeholder="Password">
                                        </div>                                   
                                        <button type="submit" name="accion" value="Validar" class="btn btn-danger btn-block">Iniciar</button>
                                    </form>
                                </div>
                                <!-- Registrarse -->
                                <div class="tab-pane fade" id="pills-registrar" role="tabpanel">
                                    <form action="Controlador">                               
                                        <div class="form-group">
                                            <label>Nombres</label>
                                            <input type="text" name="txtnom" class="form-control" placeholder="Leo Perez">
                                        </div>
                                        <div class="form-group">
                                            <label>Dni</label>
                                            <input type="number" name="txtdni" class="form-control" placeholder="01245678">
                                        </div>
                                        <div class="form-group">
                                            <label>Direccion</label>
                                            <input type="text" name="txtdire" class="form-control" placeholder="Chiclayo - La Victoria">
                                        </div>
                                        <div class="form-group">
                                            <label>Email address</label>
                                            <input type="email" name="txtemail" class="form-control" placeholder="email@example.com">
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input type="password" name="txtpass" class="form-control" placeholder="Password">
                                        </div>                                  
                                        <button type="submit" data-toggle="modal" data-target="#myModal" name="accion" value="Registrar" class="btn btn-danger btn-block">Crear Cuenta</button>
                                    </form>
                                </div>                          
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
