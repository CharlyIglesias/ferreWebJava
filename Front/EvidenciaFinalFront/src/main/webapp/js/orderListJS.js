/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var subtotal = 0;
var shippingFee = 0;
 $(document).ready(function () {
               
            createTable('All');
           });
       
           size= 0;
           function createTable(status) {
                if(status == "All") {
                    emptyTableMessage= "You didn't have any products.";
                    table = $('#myTable').DataTable({
                        "ajax":{
                            "url" : 'http://localhost:8081/getPedidos',
                           "dataSrc": '', 
                        },
                        
                            "processing": false,
                            "order": [1,'asc'],
                            "language": {
                                "emptyTable": emptyTableMessage
                            },
                            "columns": [
                                {"data": "fecha", "searchable": true, "orderable": false},
                                {"data": "", "searchable": true, "orderable": false, "render": function(data, type, full){
                                        full.carrito.productos.forEach(index =>{
                                            subtotal += index.producto.valor * index.cantidad;
                                         });
                                         return "$"+subtotal;
                                }},
                                {"data": "", "searchable": false, "orderable": false, "render": function(data, type, full){
                                        shippingFee = full.carrito.envio.price;
                                        return "$"+shippingFee;
                                }},
                                {"data": "", "searchable": true, "orderable": false, "render": function(data, type, row){
                                        return "$"+(parseFloat(subtotal) + parseFloat(shippingFee));
                                }},
                                {"data":"id","orderable": false, "render": function ( data, type, row ) {

                                      return '<a target="_blank" href="/EvidenciaFinalFront/order_details.html?pedidoId='+data+'"style="max-width: 75px;">View Details</a>';  
                                    // Combine the first and last names into a single table field
                                } },
                            ]
                        });
                }
           }