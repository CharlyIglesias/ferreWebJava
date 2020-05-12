/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {

    
    $("#button").click(function(event){
    event.preventDefault();
    username = $("#inputEmail").val();
    password = $("#inputPassword").val();
    
    console.log(username);
    console.log(password);
    var data = {
    "email": username,
    "password": password
    }
    $.ajax({
        'url': 'http://localhost:8081/login',
        'type': 'POST',
        'data': JSON.stringify(data),
        headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    
    }).then(function(data) {
       console.log("data" + data);
       if(username == 'admin@admin.com'){
        console.log(data['token']);
        sessionStorage.setItem("adminToken", data['token']);
       }else{
        sessionStorage.setItem("loginToken", data['token']);
       }
       
       if(data !== null && data !== ""){
        window.location.replace("/EvidenciaFinalFront/home.html?searchString=");
       }else{
        $(".error").removeClass('d-none');
       }
       console.log(data['token'])
    }).fail(function(error){
        console.log("error:" + error);
    })
})
});

function logout(){
    sessionStorage.setItem("adminToken", null);
    sessionStorage.setItem("loginToken", null);
    sessionStorage.setItem("cartToken", null);
  }


