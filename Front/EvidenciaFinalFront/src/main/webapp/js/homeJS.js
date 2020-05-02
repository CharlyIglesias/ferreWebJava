/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
        
    $.ajax({
        'url': 'http://192.168.1.138:8081/getProductos',
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

       var html2 = '<div class="row">'+
       '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[1]['id']+'">'+
           '<div class="card" style="width: 20rem;height: 13rem;">'+
                 '<img class="card-img-top imageChiquita" src="'+data[1]['foto_url']+'" alt="Card image cap">'+
                 '<hr style="border-top: 1px solid #e6e6e6">'+
                 '<div class="card-body body2">'+
                     '<div class="row">'+
                         '<div class="col-8">'+
                             '<h6 class="card-title">'+data[1]['titulo']+'</h6>'+
                         '</div>'+
                         '<div class="col-4">'+
                           '<p class="font-weight-light centered" style="font-size:17px;">$'+data[1]['valor']+'</p>'+
                         '</div>'+
                     '</div>'+
                 '</div>'+
           '</div>'+
       '</a>'+
   '</div>'+
   '<div class="row">'+
       '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[2]['id']+'">'+
           '<div class="card" style="width: 20rem; height: 13rem;">'+
                 '<img class="card-img-top imageChiquita" src="'+data[2]['foto_url']+'" alt="Card image cap">'+
                 '<hr style="border-top: 1px solid #e6e6e6">'+
                 '<div class="card-body body2">'+
                     '<div class="row">'+
                         '<div class="col-8">'+
                             '<h6 class="card-title">'+data[2]['titulo']+'</h6>'+
                         '</div>'+
                         '<div class="col-4">'+
                           '<p class="font-weight-light centered" style="font-size:17px;">$'+data[2]['valor']+'</p>'+
                         '</div>'+
                     '</div>'+
                 '</div>'+
           '</div>'+
       '</a>'+
   '</div>'

   var html3 = '<div class="row">'+
   '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[3]['id']+'">'+
       '<div class="card" style="width: 20rem;height: 13rem;">'+
             '<img class="card-img-top imageChiquita" src="'+data[3]['foto_url']+'" alt="Card image cap">'+
             '<hr style="border-top: 1px solid #e6e6e6">'+
             '<div class="card-body body2">'+
                 '<div class="row">'+
                     '<div class="col-8">'+
                         '<h6 class="card-title">'+data[3]['titulo']+'</h6>'+
                     '</div>'+
                     '<div class="col-4">'+
                       '<p class="font-weight-light centered" style="font-size:17px;">$'+data[3]['valor']+'</p>'+
                     '</div>'+
                 '</div>'+
             '</div>'+
       '</div>'+
   '</a>'+
'</div>'+
'<div class="row">'+
   '<a class="nodecored" href="../EvidenciaFinalFront/productDetail.html?id='+data[4]['id']+'">'+
       '<div class="card" style="width: 20rem; height: 13rem;">'+
             '<img class="card-img-top imageChiquita" src="'+data[4]['foto_url']+'" alt="Card image cap">'+
             '<hr style="border-top: 1px solid #e6e6e6">'+
             '<div class="card-body body2">'+
                 '<div class="row">'+
                     '<div class="col-8">'+
                         '<h6 class="card-title">'+data[4]['titulo']+'</h6>'+
                     '</div>'+
                     '<div class="col-4">'+
                       '<p class="font-weight-light centered" style="font-size:17px;">$'+data[4]['valor']+'</p>'+
                     '</div>'+
                 '</div>'+
             '</div>'+
       '</div>'+
   '</a>'+
'</div>'
   
   $('#grandeIzq').html(html1); 
   $('#chicoEnmedio').html(html2);
   $('#chicoDer').html(html3);
       
      // window.location.replace("/EvidenciaFinalFront/product_list.html");
    }).fail(function(error){
        console.log("error:" + error);
       // window.location.replace("/EvidenciaFinalFront/product_list.html");
    });

});

 


