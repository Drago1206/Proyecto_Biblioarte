/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
console.log("si llega al ajax")
$("#formAct").submit(function(e){
        e.preventDefault();
        console.log($('#nombre').val())
        $.ajax({
            url: 'Mv_Usuarios',
            type: 'POST',
            data: {
            menu:'Perfil',
            accion:'Actualizar',
            Name: $('#nombre').val(),
            correo: $('#correo').val(),
            Alias: $('#Pseudonombre').val(),
            Telefono: $('#nequi').val(),
            Nroficha: $('#Nroficha').val(),
            Nameficha: $('#Nameficha').val(),
            levelF: $('#NivelF option:selected').val(),
            Urlimg: $('#img').val(),
            IdUsu: $('#id_usu').val(),
            },
            
            contentType: 'application/x-www-form-urlencoded',
             dataType: 'text',
            success: function (response) {
                console.log(response)
                
                
            }, error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    });
    
   

