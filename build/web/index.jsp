<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/login.css"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 
        <title>BIBLIOARTE</title>
    </head>
    <body>
    <nav class="navbar">
		<div class="container-fluid " style="background: #00AD00;">
			<a class="navbar-brand"><img src="img/sena-removebg-preview.png" alt=""></a>
            <div class="mx-auto text-light h1" style="width: 315px;">
                BIBLIOARTE
            </div>
		</div>
	</nav>

        
        <div class="container center-block" >
            <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img src="...." class="card-img-top" alt="...">
            <div class="card-body">
                
                <form  action="Controlador?accion=verificar"  method="post">
                    <div class="form-group">
                        <label>No de Documento</label>
                        <input type="text" class="form-control" name="txtusuario">
                        <small id="emailHelp" class="form-text text-muted">Ingrese su documento sin espacios ni puntos</small>
                        <label>${error}</label>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Contraseña</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="txtpassword">
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Permanecer logueado</label>
                    </div>
                    <button type="submit" class="btn btn-success" name="verificar" value="verificar">Ingresar</button>
                </form>
            </div>
        </div>
              </div>  
            </div>
 
       
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
