/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
console.log("llega al ajax del comp")
 $("#formActComp").submit(function(e){
        e.preventDefault();
        console.log($('#nombre').val())
        $.ajax({
            url: '../Mv_Usuarios',
            type: 'POST',
            data: {
            menu:'Compradores',
            accion:'ConfigPerfil',
            Name: $('#nombre').val(),
            correo: $('#correo').val(),
            Telefono: $('#nequi').val(),
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
  

