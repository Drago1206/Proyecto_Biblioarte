/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


 $("#form").submit(function(e){
        e.preventDefault();
        console.log($('#NomObr').val())
        $.ajax({
            url: 'Script',
            type: 'POST',
            data: {
            menu:'Obras',
            accion:'Crear',
            NomObr: $('#NomObr').val(),
            Tecnica: $('#Tecnica').val(),
            Descripcion: $('#Descripcion').val(),
            Precio: $('#Precio').val(),
            Categoria: $('#Categoria option:selected').val(),
            Modovent: $('#ModoVent option:selected').val(),
            Urlimg: $('#img').val(),
            IdUsu: $('#IdUsu').val(),
            Documento: $('#Documento').val(),
            NombreUsu: $('#NombreUsu').val(),
            Nivel_Formacion: $('#Nivel_Formacion').val()},
            
            contentType: 'application/x-www-form-urlencoded',
             dataType: 'text',
            success: function (response) {
                console.log(response)
                
                
            }, error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    });
  


