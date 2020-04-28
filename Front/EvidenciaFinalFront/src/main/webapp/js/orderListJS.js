/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function () {
               
            createTable('All');
           });
       
           size= 0;
           function createTable(status) {
                if(status == "All") {
                    emptyTableMessage= "You didn't have any products.";
                    table = $('#myTable').DataTable({
                        "ajax":{
                            "url" : 'http://192.168.1.138:8081/getPedidos',
                           "dataSrc": '', 
                        },
                        
                            "processing": false,
                            "order": [1,'asc'],
                            "language": {
                                "emptyTable": emptyTableMessage
                            },
                            "columns": [
                                {"data": "fecha", "searchable": true, "orderable": false},
                                {"data": "subtotal", "searchable": true, "orderable": false},
                                {"data": "iva", "searchable": false, "orderable": false},
                                {"data": "total", "searchable": true, "orderable": false},
                                {"data":"","orderable": false, "render": function ( data, type, row ) {

                                      return '<a target="_blank" href="'+data+'"style="max-width: 75px;">View Details</a>';  
                                    // Combine the first and last names into a single table field
                                } },
                            ]
                        });
                }
           }