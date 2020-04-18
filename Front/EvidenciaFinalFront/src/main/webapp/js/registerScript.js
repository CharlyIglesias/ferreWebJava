/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    
    $("#button").click(function(event){
    event.preventDefault();
    
    name = $("#inputName").val();
    address = $("#addressInput").val();
    phone = $("#inputPhone").val();
    username = $("#inputEmail").val();
    password = $("#inputPassword").val();
    password2 = $("#inputPassword2").val();
    
    if(password !== password2){
        $("#error").removeClass("d-none");
    }
    
    var data = {
    "email": username,
    "password": password,
    "token": "200",
    "role": "ROLE_CONSUMER",
    "telefono" : phone,
    "direccion" : address,
    "nombre" : name
    };
    
    $.ajax({
        'url': 'http://localhost:8081/register',
        'type': 'POST',
        'data': JSON.stringify(data),
        headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    }
    
    }).then(function(data) {
       console.log("data" + data);
    }).fail(function(error){
        console.log("error:" + error);
    })
})
});


