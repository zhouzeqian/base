<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="css/demo.css" type="text/css">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="js/jquery.ztree.exedit.js"></script>

<SCRIPT type="text/javascript">  
        var dragId;var zTree_Menu;  
        var setting = {  
            view: {  
                addHoverDom: addHoverDom,  
                removeHoverDom: removeHoverDom,  
                selectedMulti: true,  
                showLine: true,  
                selectedMulti: true,  
                showIcon: true  
            },  
            edit: {  
                enable: true,  
                showRemoveBtn: setRemoveBtn,  
                removeTitle:"删除分类",  
                renameTitle:"编辑分类",  
                drag: {  
                      prev: true,  
                      next: true,  
                      inner: false  
                },  
                editNameSelectAll: true  
            },  
            data: {  
                simpleData: {  
                    enable: true  
                }  
            },  
            callback: {  
                //beforeDrag: beforeDrag,  
                //beforeClick: beforeClick,  
                beforeEditName: beforeEditName,  
                beforeRemove: beforeRemove,  
                beforeRename: beforeRename,  
                onRemove: onRemove,  
                onRename: onRename
            }  
        };  
        //用于捕获分类编辑按钮的 click 事件，并且根据返回值确定是否允许进入名称编辑状态  
        function beforeEditName(treeId, treeNode) {  
               var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
               zTree.selectNode(treeNode);  
               return true;  
        }  
         //移除分类前执行  
        function beforeRemove(treeId, treeNode) {  
               var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
               zTree.selectNode(treeNode);  
               var confirmFlag = confirm("确认删除分类[ " + treeNode.name + " ]吗？" )  
               var confirmVal = false;  
               if(confirmFlag){  
                    var data = {id:treeNode.id};  
                   $.ajax({  
                        async: false,  
                        type: "post",  
                        data:data,  
                        url: "<%=request.getContextPath()%>/address/delete",  
                        success: function(json){  
                               if(json == true ){  
                                   confirmVal = true;  
                              } else{  
                   alert('亲，删除失败！');  
                              }  
                        },  
                        error: function(){  
                              alert('亲，删除失败！');  
                        }  
                   });  
              }  
               return confirmVal;  
        }  
         //执行删除操作后提示  
        function onRemove(e, treeId, treeNode) {  
              alert('亲，删除成功！');  
        }  
         //用于捕获分类编辑名称结束（Input 失去焦点 或 按下 Enter 键）之后，更新分类名称数据之前的事件回调函数  
        function beforeRename(treeId, treeNode, newName) {  
        	   
               if (newName.length == 0 || newName.indexOf("请输入名称")>=0) {  
            	var confirmFlag = confirm("请输入名称" ) 
            	if(confirmFlag){
                    var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
                    setTimeout( function(){zTree.editName(treeNode)}, 10);  
                    return false; 
            	}
            	else{
            		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            		zTree.removeNode(treeNode);
            		return false;
            	}
              }  
               if(newName.length > 15){  
           alert('亲，分类名称过长！');  
                   var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
                   setTimeout( function(){zTree.editName(treeNode)}, 10);  
                   return false;  
              }  
              native_name = treeNode.name;  
              return true;  
        }  
         //执行编辑操作  
        function onRename(e, treeId, treeNode) {  
               if(native_name == treeNode.name){  
                    return;  
               }
               var data = {id:treeNode.id,type:treeNode.level,parentId:treeNode.pId,name:treeNode.name};  
               //新增
               if(treeNode.id==null){
                   $.ajax({  
                       async: false,  
                       type: "post", 
                       data: data,
                       url: "<%=request.getContextPath()%>/address/add",  
                       success : function(json){  
                    	   if(json != true ){ 
                    		   treeNode.id=json;
                 				alert('操作成功!');  
                       } else{  
                 			alert('亲，操作失败，请稍后再试！');  
                       }  
                       },  
                       error : function(){  
                             alert('亲，网络有点不给力呀！');  
                       }  
                  }); 
               }
               //修改
               else{
               $.ajax({  
                   async: false,  
                   type: "post",  
                   data:data,  
                   url: "<%=request.getContextPath()%>/address/update",  
                   success : function(json){  
                         if(json == true ){  
                  				alert('操作成功!');  
                        } else{  
                  			alert('亲，操作失败，请稍后再试！');  
                        }  
                   },  
                   error : function()    {  
                		alert('亲，网络有点不给力呀');  
                   }  
              	}); 
            }
        }  
          
         //添加子节点
        function addHoverDom(treeId, treeNode) {  
               var sObj = $("#" + treeNode.tId + "_span"); 
               //level自定义菜单级数
               if (treeNode.editNameFlag || $("#addBtn_" +treeNode.tId).length>0 || treeNode.level == 3) return;  
               var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加分类' onfocus='this.blur();'></span>";  
               sObj.after(addStr);  
               var btn = $("#addBtn_" +treeNode.tId);  
               if (btn) btn.bind("click" , function(){  
                    var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
                    var treeNodes;         
                    treeNodes = zTree.addNodes(treeNode, {id:null, pId:treeNode.id, name:"请输入名称" });
                    zTree.editName(treeNodes[0]);
                    return false;  
              }); 
        }  
         
        //添加父节点 
        function addParent() { 
        	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
        	treeNode = zTree.addNodes(null, {id:null, pId:0, isParent:false, name:"请输入名称"});
        	treeNode[0].pId=0;
        	zTree.editName(treeNode[0]);
        }  
         //父级分类去除删除功能  
        function setRemoveBtn(treeId, treeNode) {  
           return !treeNode.isParent;  
        }  
          
         //鼠标移开按钮消失  
        function removeHoverDom(treeId, treeNode) {  
              $( "#addBtn_"+treeNode.tId).unbind().remove();  
        };  
          
         //添加按钮点击事件  
        //function addClick(){  
         //     $( "#addParent").bind("click" , {isParent:true}, add);  
        //}  
     
         //移除分类  
        function remove(e) {  
               var zTree = $.fn.zTree.getZTreeObj("treeDemo"),  
              nodes = zTree.getSelectedNodes(),  
              treeNode = nodes[0];  
               if (nodes.length == 0) {  
                    alert( "亲，请先选择一个分类!" );  
                    return;  
              }  
               var callbackFlag = $("#callbackTrigger" ).attr("checked");  
              zTree.removeNode(treeNode, callbackFlag);  
        };  
          
         //展开全部分类  
        function expandAllFlag(){  
              zTree_Menu.expandAll( true);  
        }  
         //合并全部分类  
        function combineAllFlag(){  
              zTree_Menu.expandAll( false);  
        }  
          
         //加载ztree  
        function onloadZTree(){  
               var ztreeNodes;  
              $.ajax( {  
                   async : true, //是否异步  
                   cache : false, //是否使用缓存  
                   type : 'post', //请求方式,post  
                   dataType : "json", //数据传输格式  
                   url : "<%=request.getContextPath()%>/address/find", //请求链接  
			error : function() {
				alert('亲，网络有点不给力呀！');
			},
			success : function(data) {
				// ztreeNodes = eval( "["+data+"]" ); //将string类型转换成json对象  
				$.fn.zTree.init($("#treeDemo"), setting, data);
				zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
				//   $( "#selectAll").bind("click" , selectAll);  
				//expandAllFlag();  
				// addClick(); 
				var nodes = zTree_Menu.getNodes();
				//zTree_Menu.expandNode(nodes[0], true, false, true);
			}
		});
	}

	//初始化操作  
	$(document).ready(function() {
		onloadZTree();
	});
</SCRIPT>
</head>
<body>
<h1>zTree高级功能测试</h1>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
	<div class="btn-group">
				<button type="button" class="btn btn-primary" onclick="addParent()">新增父节点</button>
    			<button type="button" class="btn btn-primary" onclick="expandAllFlag()">展开</button>
    			<button type="button" class="btn btn-primary" onclick="combineAllFlag()">合并</button>
 	</div>
 	<p>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="right">
		
	</div>
</div>
	
</body>
</html>
