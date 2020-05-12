/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = window.location.search.substring(1),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;
    
        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');
    
            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
            }
        }
    };
    var id = null;
    var id = getUrlParameter('id');
    var data = {
        'id': id
    };
    console.log(id);
    
if(id !== undefined){
    $.ajax({
        'url': 'http://localhost:8081/findProductById?id='+id,
        'type': 'GET',
        headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    }
    }).then(function(data) {
       console.log("data" + data);
       console.log(data['title']);
       $('#title').text(data['titulo']);
       $('#price').text('$'+ data['valor']);
       $('#description').text(data['descripcion']);
       $('#blah').attr('src', data['foto_url']);
      // window.location.replace("/EvidenciaFinalFront/product_list.html");
    }).fail(function(error){
        console.log("error:" + error);
       // window.location.replace("/EvidenciaFinalFront/product_list.html");
    });
}else{
    console.log("Deberia mostrar el glade");
}
    
 $("#button").click(function(event){
    addToCart(id);
});

function addToCart(productId){
    $.post("http://localhost:8081/addProductToCart", {"productId": productId, "cartToken": sessionStorage.getItem("cartToken")}, function(data){
       sessionStorage.setItem("cartToken", data);
        showToast();
    });
}
function showToast(){
        $('.toast').toast('show')
    }
});
