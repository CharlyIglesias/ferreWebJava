/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
        
    $.ajax({
        'url': 'http://localhost:8081/getProductos?searchString=',
        'type': 'GET',
        headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    }
    }).then(function(data) {
    var i = 0;
       console.log(data.length);
       var html1 = '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[1]['id']+'">'+
                        '<div class="card mb-3 tarjetas">'+
                        '<div class="row no-gutters">'+
                            '<div class="col-md-5">'+
                                '<img  src="'+data[1]['foto_url']+'" class="card-img" alt="...">'+
                            '</div>'+
                            '<div class="col-md-7">'+
                            '<div class="card-body">'+
                                '<h5 class="card-title">'+data[1]['titulo']+'</h5>'+
                                '<p class="card-text">$'+data[1]['valor']+'</p>'+
                                
                            '</div>'+
                            '</div>'+
                        '</div>'+
                        '</div>'+
                    '</a>'+
                    '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[2]['id']+'">'+
                        '<div class="card mb-3 tarjetas">'+
                        '<div class="row no-gutters">'+
                            '<div class="col-md-5">'+
                                '<img  src="'+data[2]['foto_url']+'" class="card-img" alt="...">'+
                            '</div>'+
                            '<div class="col-md-7">'+
                            '<div class="card-body">'+
                                '<h5 class="card-title">'+data[2]['titulo']+'</h5>'+
                                '<p class="card-text">$'+data[2]['valor']+'</p>'+
                                
                            '</div>'+
                            '</div>'+
                        '</div>'+
                        '</div>'+
                    '</a>';

               var html2 = '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[3]['id']+'">'+
               '<div class="card mb-3 tarjetas">'+
               '<div class="row no-gutters">'+
                   '<div class="col-md-5">'+
                       '<img  src="'+data[3]['foto_url']+'" class="card-img" alt="...">'+
                   '</div>'+
                   '<div class="col-md-7">'+
                   '<div class="card-body">'+
                       '<h5 class="card-title">'+data[3]['titulo']+'</h5>'+
                       '<p class="card-text">$'+data[3]['valor']+'</p>'+
                       
                   '</div>'+
                   '</div>'+
               '</div>'+
               '</div>'+
           '</a>'+
           '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[4]['id']+'">'+
               '<div class="card mb-3 tarjetas">'+
               '<div class="row no-gutters">'+
                   '<div class="col-md-5">'+
                       '<img  src="'+data[4]['foto_url']+'" class="card-img" alt="...">'+
                   '</div>'+
                   '<div class="col-md-7">'+
                   '<div class="card-body">'+
                       '<h5 class="card-title">'+data[4]['titulo']+'</h5>'+
                       '<p class="card-text">$'+data[4]['valor']+'</p>'+
                       
                   '</div>'+
                   '</div>'+
               '</div>'+
               '</div>'+
           '</a>';

           var html3 = '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[0]['id']+'">'+
           '<div class="card mb-3 tarjetas">'+
           '<div class="row no-gutters">'+
               '<div class="col-md-5">'+
                   '<img  src="'+data[0]['foto_url']+'" class="card-img" alt="...">'+
               '</div>'+
               '<div class="col-md-7">'+
               '<div class="card-body">'+
                   '<h5 class="card-title">'+data[0]['titulo']+'</h5>'+
                   '<p class="card-text">$'+data[0]['valor']+'</p>'+
                   
               '</div>'+
               '</div>'+
           '</div>'+
           '</div>'+
       '</a>'+
       '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[5]['id']+'">'+
           '<div class="card mb-3 tarjetas">'+
           '<div class="row no-gutters">'+
               '<div class="col-md-5">'+
                   '<img  src="'+data[5]['foto_url']+'" class="card-img" alt="...">'+
               '</div>'+
               '<div class="col-md-7">'+
               '<div class="card-body">'+
                   '<h5 class="card-title">'+data[5]['titulo']+'</h5>'+
                   '<p class="card-text">$'+data[5]['valor']+'</p>'+
                   
               '</div>'+
               '</div>'+
           '</div>'+
           '</div>'+
       '</a>';
        
           
           
           $('.arriba').html(html1); 
           $('.enmedio').html(html2);
           $('.abajo').html(html3);
        
   
       
      // window.location.replace("/EvidenciaFinalFront/product_list.html");
    }).fail(function(error){
        console.log("error:" + error);
       // window.location.replace("/EvidenciaFinalFront/product_list.html");
    });

});

 


