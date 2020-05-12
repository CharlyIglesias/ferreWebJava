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

    var envio = validateAll(name, address, phone, username, password, password2);
    
    if(envio == true){
        var data = {
        "email": username,
        "password": password,
        "token": "200",
        "role": "ROLE_CONSUMER",
        "telefono" : parseInt(phone),
        "direccion" : address,
        "nombre" : name
        };
        
        $.ajax({
            'url': 'http://localhost:8081/register',
            'type': 'POST',
            'data': JSON.stringify(data),
            headers: { 
            'Content-Type': 'application/json' 
        }
        
        }).then(function(data) {
        console.log("data" + data);
        window.location.replace("/EvidenciaFinalFront/home.html?searchString=");
        }).fail(function(error){
            console.log("error:" + error);
        })
    }

    
})
});

function validateAll(name, address, phone, username, password, password2){

    var valido = true;
    
    if(name == null || name == ""){
        $("#errorName").removeClass("d-none");
        valido = false;
    }else{
        $("#errorName").addClass("d-none");
    }
    if(address == null || address == ""){
        $("#errorAddress").removeClass("d-none");
        valido = false;
    }else{
        $("#errorAddress").addClass("d-none");
    }
    valido = validatePhone(phone, valido);

    valido = validateEmail(username, valido);
        
    if(password !== password2 || password == ""){
        $("#errorPassword").removeClass("d-none");
        valido = false;
    }else{
        $("#errorPassword").addClass("d-none");
    }

    return valido;

}

function validateEmail(username, valido){
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(username)){
        $("#errorEmail").addClass("d-none");
        return valido;
    }else{
        $("#errorEmail").removeClass("d-none");
        return false;
    }
        
    }

function validatePhone(phone, valido){
    var phoneno = /^\d{10}$/;
  
        if(phone.match(phoneno)){
            $("#errorPhone").addClass("d-none");
            return valido
        }else{
            $("#errorPhone").removeClass("d-none");
            return false;
        }
    }



