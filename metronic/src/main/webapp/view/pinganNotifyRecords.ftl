			<div class="row-fluid">
					<div class="span12">

						<!-- BEGIN SAMPLE FORM PORTLET-->   

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>二维码支付回调异步通知查询</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body form">
								
								<!-- BEGIN FORM-->

								<form action="#" class="form-horizontal">
									
								<div class="row-fluid">
									<div class="span6">
									<div class="control-group">

										<label class="control-label">订单号</label>

										<div class="controls">

											<input type="text" class="m-wrap" id="ordNo">		

										</div>
										</div>
									</div>
									
								<div class="span6">	
									<div class="control-group">

										<label class="control-label">支付状态</label>

										<div class="controls">

											<select class="m-wrap" id="status">

												<option value="">全部</option>

												<option value="1">支付成功</option>

												<option value="4">支付失败</option>

											</select>

										</div>
										</div>
									</div>
									
									<div class="form-actions">

										<button type="button" class="btn blue" onclick="find()">查询</button>

										<button type="button" class="btn">取消</button>                            

									</div>
									
								</div>	
								</form>

								<!-- END FORM-->       

							</div>

						</div>

						<!-- END SAMPLE FORM PORTLET-->

					</div>

		</div>
		
		<!-- BEGIN PAGE CONTENT-->
			<div class="row-fluid">
					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>二维码支付回调异步通知列表</div>
								 
								<div class="actions">

									<div class="btn-group">

										<a class="btn" href="#" data-toggle="dropdown">

										行

										<i class="icon-angle-down"></i>

										</a>

										<div id="fcn_table_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">

											<label><input type="checkbox" checked data-column="1">订单号</label>

											<label><input type="checkbox" checked data-column="2">支付状态</label>

											<label><input type="checkbox" checked data-column="3">金额(单位:分)</label>

											<label><input type="checkbox" checked data-column="4">支付时间</label>
											
											<label><input type="checkbox" checked data-column="5">入库时间</label>

										</div>

									</div>

								</div>
								
							</div>

							<div class="portlet-body">

								<table class="table table-striped table-bordered table-hover table-full-width" id="fcn_table">
								
								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>
				<!-- END PAGE CONTENT-->

			</div>

	<!-- END FOOTER -->
 
<script type="text/javascript">

 var oTable = $('#fcn_table').dataTable( {
    	"bProcessing": true,
		    "bServerSide": true,
		    "sAjaxSource": "fm/page",
		    "fnServerParams": function ( aoData ) {
		           aoData.push( { "name": "ordNo", "value": $("#ordNo").val() } );
		           aoData.push( { "name": "status", "value": $("#status").val() } );
		        },
            "aoColumns": [
               { "sTitle": "序号",   "mData": "id","bSearchable": false,"bSortable": false },
        	   { "sTitle": "订单号",   "mData": "ordNo","bSearchable": false,"bSortable": false },
	           { "sTitle": "支付状态",  "mData": "status","bSortable": false ,
        		   "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
			             if ( sData == 1 ) {
			               	$(nTd).html('<span class="label label-success">支付成功</span>')
			             }
			             if ( sData == 4 ) {
      			               $(nTd).html('<span class="label label-danger">支付失败</span>')
      			     }
			           }
	           },
	           { "sTitle": "金额(单位:分)", "mData": "amount" ,"bSearchable": false,"bSortable": false},
	           { "sTitle": "支付时间",  "mData": "payTime","bSearchable": false,"bSortable": false },
	           { "sTitle": "入库时间",   "mData": "createTime" ,"bSearchable": false,"bSortable": false}
		         ],
        "aLengthMenu": [
            [10, 25, 50],
            [10, 25, 50] // change per page values here
        ],
        // set the initial value
        "iDisplayLength": 10,
        "aaSorting": [[0,'desc']],
        "oLanguage": {
            "sUrl": "media/js/chinese.json",
        },
    });
	
	var fcn_table=function() {
   

    jQuery('#fcn_table_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify
																					// table
																					// search
																					// input
    jQuery('#fcn_table_wrapper .dataTables_length select').addClass("m-wrap small"); // modify
																					// table
																					// per
																					// page
																					// dropdown
    jQuery('#fcn_table_wrapper .dataTables_length select').select2(); // initialzie
																		// select2
																		// dropdown

    $('#fcn_table_column_toggler input[type="checkbox"]').change(function(){
        /*
		 * Get the DataTables object again - this is not a recreation, just
		 * a get of the object
		 */
        var iCol = parseInt($(this).attr("data-column"));
        var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
        oTable.fnSetColumnVis(iCol, (bVis ? false : true));
    });
}

		function find(){
		
			oTable._fnAjaxUpdate();
		}
</script>
	<script>

		jQuery(document).ready(function() {    


			 fcn_table();
		});
		
		
	</script>
