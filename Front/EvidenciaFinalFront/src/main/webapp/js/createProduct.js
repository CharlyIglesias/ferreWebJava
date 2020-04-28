/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    
    $("#button").click(function(event){
    event.preventDefault();
    title = $("#inputTitle").val();
    price = $("#inputPrice").val();
    description = $("#inputDescription").val();
    qty = $("#inputQty").val();
    image=$('#blah').attr('src');
    console.log(image); //SI JALA
    
    price2 = parseFloat(price);
    qty2 = parseFloat(qty);
    
    var data = {
    "titulo": title,
    "valor": price2,
    "descripcion": description,
    "cantDisponible": qty2,
    "foto_url": image
    };
    
    $.ajax({
        'url': 'http://192.168.1.138:8081/createProduct',
        'type': 'POST',
        'data': JSON.stringify(data),
        headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    }
    }).then(function(data) {
       console.log("data" + data);
       window.location.replace("/EvidenciaFinalFront/product_list.html");
    }).fail(function(error){
        console.log("error:" + error);
        window.location.replace("/EvidenciaFinalFront/product_list.html");
    });
});
  
var myWidget = cloudinary.createUploadWidget({
  cloudName: 'dtmln7c4k', 
  sources: [ 'local', 'url', 'image_search'],
  googleApiKey: 'AIzaSyB7oWyNIpXwnur0A2-RkziQHiGJ6mfz9O0',
  uploadPreset: 'mba5txfa'}, (error, result) => { 
    if (!error && result && result.event === "success") { 
      console.log('Done! Here is the image info: ', result.info); 
      console.log(result.info['secure_url']);
      $('#blah').attr('src', result.info['secure_url']);
    }
  }
)
document.getElementById("blah").addEventListener("click", function(){
    myWidget.open();
  }, false);

});


