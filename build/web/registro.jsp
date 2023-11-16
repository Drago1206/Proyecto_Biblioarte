<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="css/registro.css">

	<!-- Fuentes -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,300;1,400&display=swap" rel="stylesheet">    
    </head>
    <body>
        <nav class="navbar">
		<div class="container-fluid " style="background: #00AD00;">
            <a class="nav" href="inicio.html"><img class="im" src="img/flecha1.png" alt=""></a>
			<a class="navbar-brand"><img src="img/sena-removebg-preview.png" alt=""></a>
            <div class="mx-auto text-light h1" style="width: 365px;">
                BIBLIOARTE
            </div>
		</div>
	</nav>

    <section class="">
        <div class="container">
            <div class="row justify-content-center pt-5">
                <div class="col-md-5">
                    <div class="card mb-3 shadow-lg p-3 mb- bg-body ">
                        <div class="card-body">
                            <!-- Se inicializa el formulario para el registro -->
                            <form action="Controlador?accion=Registrar" method="post">
                                <div class="mb-3">
                                    <!-- Se comienzan a pedir los datos necesarios -->
                                    <div class="mb-3">
                                        <!-- Se pide el tipo de documento -->
                                        <label for="disabledSelect" class="form-label">Tipo de documento</label>
                                        <select id="disabledSelect" class="form-select" name="TipoDocumento">
                                            <option>Seleccione su tipo de documento</option>
                                            <option value="Cedula de ciudadania">Cédula de Ciudadania</option>
                                            <option value="Cedula de Extranjeria">Cédula de Extranjeria</option>
                                            <option value="Tarjeta de identidad">Tarjeta de identidad</option>
                                        </select>
                                    </div>
                                    <!-- Se solicita el número de documento -->
                                    <label for="exampleInputEmail1" class="form-label">Número de documento</label>
                                    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="txtDocumento">
                                </div>
                                <!-- Se solicita el nombre del usuario -->
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Nombre</label>
                                    <input type="text" class="form-control" id="exampleInputPassword1" name="txtNombre">
                                </div>
                                <!-- Se solicita el ingreso del Pseudonombre que manejará el usuario -->
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Pseudonombre</label>
                                    <input type="text" class="form-control" id="exampleInputPassword1" name="txtPseudonombre">
                                </div>
                                <!-- Se solicita el ingreso del correo -->
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Correo</label>
                                    <input type="email" class="form-control" id="exampleInputPassword1" name="txtcorreo">
                                </div>
                                <!-- Se pide el número de telefono -->
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Número de teléfono</label>
                                    <input type="number" class="form-control" id="exampleInputPassword1" name="Telefono">
                                </div>
                                <!-- Se solicita ingreso de una contraseña para tener la cuenta segura -->
                                <div class="mb-3">
                                    <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="Contrasena">
                                </div>
                                    <div class="mb-3">
                                        <!-- Se pide el tipo de documento -->
                                        <label for="disabledSelect" class="form-label">Tipo de Rol</label>
                                        <select id="disabledSelect" class="form-select" name="TipoRol">
                                            <option>Seleccione su rol</option>
                                            <option value="2">Artista</option>
                                            <option value="3">Comprador</option>
                                        </select>
                                    </div>

                                <!-- Botón para registrarse -->
                                <div class="d-grid gap-2 col-3 mx-auto">
                                    <button class="btn text-light" style="background-color: #00AD00;" type="submit"><a style="color: white; text-decoration: none;">Registrarse</a></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    </body>
</html>
