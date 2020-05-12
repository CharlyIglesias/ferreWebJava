/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    var estaLoggeado = sessionStorage.getItem("adminToken");
    var estaLoggeado2 = sessionStorage.getItem("loginToken");
    if(estaLoggeado == null && estaLoggeado2 == null){
      $('.login').html('<a class="nav-link" href="../EvidenciaFinalFront/login.html">Login</a>');
    }else{
      $('.login').html('<a class="nav-link" onclick="logout()" href="../EvidenciaFinalFront/login.html">Logout</a>');
    }


    var esAdmin = sessionStorage.getItem("adminToken");
    if(esAdmin !== null && esAdmin !== "null"){
      $('.admin').removeClass('d-none');
    }

});

     function logout(){
      sessionStorage.setItem("adminToken", null);
      sessionStorage.setItem("loginToken", null);
      sessionStorage.setItem("cartToken", null);

    }


