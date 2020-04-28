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
                            "url" : 'http://192.168.1.138:8081/getProductos',
                           "dataSrc": '', 
                        },
                        
                            "processing": false,
                            "order": [1,'asc'],
                            "language": {
                                "emptyTable": emptyTableMessage
                            },
                            "columns": [
                                {"data": "titulo", "searchable": true, "orderable": false},
                                {"data": "descripcion", "searchable": true, "orderable": false},
                                {"data": "valor", "searchable": false, "orderable": false},
                                {"data":"foto_url","orderable": false, "render": function ( data, type, row ) {

                                      return '<a target="_blank" href="'+data+'"style="max-width: 75px;"><img src="'+data+'" style="width:50%; max-width: 65px;"></a>';  
                                    // Combine the first and last names into a single table field
                                } },
                                {"data": "cantDisponible", "searchable": true, "orderable": false},
                                {"data":"","orderable": false, "render": function ( data, type, row ) {

                                      return '<a target="_blank" href="'+data+'"style="max-width: 75px;">Edit</a>';  
                                    // Combine the first and last names into a single table field
                                } },
                            ]
                        });
                }
           }