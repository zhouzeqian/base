var TableAdvanced = function () {

     var initTable2 = function() {
        var oTable = $('#sample_2').dataTable( {
        	"bProcessing": true,
   		    "bServerSide": true,
   		    "sAjaxSource": "olp",
   		    "fnServerParams": function ( aoData ) {
   			           aoData.push( { "name":"businessType","value":0 } );
   			         },
            "aoColumns": [
       		           { "sTitle": "商户编号",   "mData": "oidPartner","bSearchable": false,"bSortable": false },
    		           { "sTitle": "商户订单时间",  "mData": "dtOrder","bSortable": false },
    		           { "sTitle": "商户唯一订单号", "mData": "noOrder" ,"bSearchable": false,"bSortable": false},
    		           { "sTitle": "连连支付支付单号",  "mData": "oidPaybill","bSearchable": false,"bSortable": false },
    		           { "sTitle": "交易金额",  "mData": "moneyOrder" ,"bSearchable": false,"bSortable": false},
    		           { "sTitle": "支付结果",  "mData": "resultPay" ,"bSearchable": false,"bSortable": false,
    		        	   "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
      			             if ( sData == "SUCCESS" ) {
      			               	$(nTd).html('<span class="label label-success">支付成功</span>')
      			             }
      			             if ( sData == "WAITING" ) {
	        			               $(nTd).html('<span class="label label-info">等待支付</span>')
	        			     }
      			           }
    		        	   
    		           },
    		           { "sTitle": "清算日期",  "mData": "settleDate","bSearchable": false ,"bSortable": false},
    		           { "sTitle": "入库时间",    "mData": "createTime" ,"bSearchable": false,"bSortable": false}
    		         ],
            "aLengthMenu": [
                [10, 25, 50],
                [10, 25, 50] // change per page values here
            ],
            // set the initial value
            "iDisplayLength": 10,
            "aaSorting": [[7,'desc']],
            "oLanguage": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "订单号搜索:",
                "sUrl": "",
                "sEmptyTable": "未搜索到数据",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
        });

        jQuery('#sample_2_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify
																						// table
																						// search
																						// input
        jQuery('#sample_2_wrapper .dataTables_length select').addClass("m-wrap small"); // modify
																						// table
																						// per
																						// page
																						// dropdown
        jQuery('#sample_2_wrapper .dataTables_length select').select2(); // initialzie
																			// select2
																			// dropdown

        $('#sample_2_column_toggler input[type="checkbox"]').change(function(){
            /*
			 * Get the DataTables object again - this is not a recreation, just
			 * a get of the object
			 */
            var iCol = parseInt($(this).attr("data-column"));
            var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
            oTable.fnSetColumnVis(iCol, (bVis ? false : true));
        });
    }

     
     
    return {

        // main function to initiate the module
        init: function () {
            
            if (!jQuery().dataTable) {
                return;
            }
            initTable2();
        }

    };

}();