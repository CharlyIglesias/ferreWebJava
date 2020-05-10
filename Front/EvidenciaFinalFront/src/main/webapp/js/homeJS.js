/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
        
    $.ajax({
        'url': 'http://localhost:8081/getProductos',
        'type': 'GET',
        headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    }
    }).then(function(data) {
    var i = 0;
       console.log(data.length);
       var html1 = '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[0]['id']+'">'+
               '<div class="card" style="width: 20rem; height: 26rem; margin: 0px auto;">'+
                    '<img class="card-img-top image" src="'+data[0]['foto_url']+'" alt="Card image cap">'+
                   '<hr style="border-top: 1px solid #e6e6e6">'+
                   '<div class="card-body">'+
                       '<h5 class="card-title">'+data[0]['titulo']+'</h5>'+
                       '<p class="font-weight-light centered" style="font-size:17px;">$'+data[0]['valor']+'</p>'+
                   '</div>'+
                 '</div>'+
               '</a>';
   
   $('#grandeIzq').html(html1);
       
      // window.location.replace("/EvidenciaFinalFront/product_list.html");
    }).fail(function(error){
        console.log("error:" + error);
       // window.location.replace("/EvidenciaFinalFront/product_list.html");
    });

});

 


