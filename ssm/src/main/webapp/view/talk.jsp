<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
	String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
textarea {
	height: 300px;
	width: 100%;
	resize: none;
	outline: none;
}

input[type=button] {
	float: right;
	margin: 5px;
	width: 100px;
	height: 35px;
	border: none;
	color: white;
	font-weight: bold;
	outline: none;
}

.clear {
	background: red;
}

.send {
	background: green;
}

.sendAll {
	background: blue;
}

.find {
	background: #BDB76B;
}

.clear:active {
	background: yellow;
}

.send:active {
	background: yellow;
}

.sendAll:active {
	background: yellow;
}

.find:active {
	background: yellow;
}

.msg {
	width: 100%;
	height: 25px;
	outline: none;
}

#content {
	border: 1px solid gray;
	width: 100%;
	height: 300px;
	overflow-y: scroll;
}

.from {
	background-color: green;
	width: 80%;
	border-radius: 10px;
	height: 30px;
	line-height: 30px;
	margin: 5px;
	float: left;
	color: white;
	padding: 5px;
	font-size: 22px;
}

.to {
	background-color: gray;
	width: 80%;
	border-radius: 10px;
	height: 30px;
	line-height: 30px;
	margin: 5px;
	float: right;
	color: white;
	padding: 5px;
	font-size: 22px;
}

.name {
	color: gray;
	font-size: 12px;
}

.tmsg_text {
	color: white;
	background-color: rgb(47, 47, 47);
	font-size: 18px;
	border-radius: 5px;
	padding: 2px;
}

.fmsg_text {
	color: white;
	background-color: rgb(66, 138, 140);
	font-size: 18px;
	border-radius: 5px;
	padding: 2px;
}

.sfmsg_text {
	color: white;
	background-color: rgb(148, 16, 16);
	font-size: 18px;
	border-radius: 5px;
	padding: 2px;
}

.tmsg {
	clear: both;
	float: right;
	width: 80%;
	text-align: right;
}

.fmsg {
	clear: both;
	float: left;
	width: 80%;
}
</style>
<script>
		var path = '<%=basePath%>';
		var uid=${uid eq null?-1:uid};
		if(uid==-1){
			location.href="<%=basePath2%>";
		}
		var from=uid;
		var fromName='${name}';
		var to=uid==1?2:1;
		
		var websocket;
		if ('WebSocket' in window) {
			websocket = new WebSocket("ws://" + path + "/ws?uid="+uid);
		} else if ('MozWebSocket' in window) {
			websocket = new MozWebSocket("ws://" + path + "/ws"+uid);
		} else {
			websocket = new SockJS("http://" + path + "/ws/sockjs"+uid);
		}
		websocket.onopen = function(event) {
			console.log("WebSocket:已连接");
			console.log(event);
		};
		websocket.onmessage = function(event) {
			var data=JSON.parse(event.data);
			console.log("WebSocket:收到一条消息",data);
			if(data.onlineUsers!=null){
				$('#uid').empty();
				$.each(data.onlineUsers, function(i, item) {
		            $('#uid').append("<option value='"+item.uid+"'>"+item.name+"</option>");
		        });
			}else{
				if(uid!=data.fromId){
					var textCss=data.fromId==-1?"sfmsg_text":"fmsg_text";
					$("#content").append("<div class='fmsg'><label class='name'>"+data.fromName+"&nbsp;"+data.sendTime+"</label><div class='"+textCss+"'>"+data.msgContent+"</div></div>");
					scrollToBottom();
				}
			}
			
		};
		websocket.onerror = function(event) {
			console.log("WebSocket:发生错误 ");
			console.log(event);
		};
		websocket.onclose = function(event) {
			console.log("WebSocket:已关闭");
			console.log(event);
		}
			function sendMsg(){
				var v=$("#msg").val();
				if(v==""){
					return;
				}else{
					var data={};
					data["from"]=from;
					data["fromName"]=fromName;
					data["to"]=to;
					data["text"]=v;
					websocket.send(JSON.stringify(data));
					$("#text").append("<div class='tmsg'><label class='name'>我&nbsp;"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</label><div class='tmsg_text'>"+data.text+"</div></div>");
					scrollToBottom();
					$("#msg").val("");
				}
			}
			
			function scrollToBottom(){
				var div = document.getElementById('content');
				div.scrollTop = div.scrollHeight;
			}
			
			Date.prototype.Format = function (fmt) { //author: meizz 
			    var o = {
			        "M+": this.getMonth() + 1, //月份 
			        "d+": this.getDate(), //日 
			        "h+": this.getHours(), //小时 
			        "m+": this.getMinutes(), //分 
			        "s+": this.getSeconds(), //秒 
			        "q+": Math.floor((this.getMonth() + 3)/ 3), //季度 
			        "S": this.getMilliseconds() //毫秒 
			    };
			    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			    for (var k in o)
			    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			    return fmt;
			}
			
			function send(){
					//sendMsg();   
					var text=$('#msg').val();
					if(text==null||$.trim(text)==""){
						$('#msg').val(null);
						$('#msg').attr("placeholder","消息内容不能为空或空字符串！");
					}
					else{
					$("#content").append("<div class='tmsg'><label class='name'>我&nbsp;"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</label><div class='tmsg_text'>"+$('#msg').val()+"</div></div>");
					$.ajax({
						type:'POST',
						url:'/ssm/ws/push',
						data:{mid:uid,uid:$('#uid').val(),text:text},
						dataType: "json",
						success:function(data){
							
						}
					});
					$("#msg").val("");
					}
				}
			
			
			function sendAll(){
				//sendMsg();   
				var text=$('#msg').val();
				if(text==null||$.trim(text)==""){
					$('#msg').val(null);
					$('#msg').attr("placeholder","消息内容不能为空或空字符串！");
				}
				else{
				$("#content").append("<div class='tmsg'><label class='name'>我&nbsp;"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</label><div class='tmsg_text'>"+$('#msg').val()+"</div></div>");
				$.ajax({
					type:'POST',
					url:'/ssm/ws/broadcast',
					data:{mid:uid,text:text},
					dataType: "json",
					success:function(data){
						
					}
				});
				$("#msg").val("");
				}
			}
			
			function clearAll(){
				$("#content").empty();
			}
			
			function find(){
				$.ajax({
					type:'GET',
					url:'/ssm/user/find',
					data:{id:uid},
					dataType: "json",
					success:function(data){
						alert(data);
						$('#userInfo').empty();
						$('#userInfo').append("<tr><td>"+data.id+"</td><td>"+data.username+"</td><td>"+data.email+"</td><td>"+data.lastLoginTime+"</td></tr>")
					}
				});
			}
		</script>
</head>
<body>
	<h5>${name}已上线 <span><a href="/ssm/user/logout">退出</a></span></h5>
	<div id="content"></div>	
	<input type="text" placeholder="请输入要发送的信息" id="msg" class="msg">
	发送给：
	<select id="uid">
	</select>
	<input type="button" value="发送" class="send" onclick="send()">
	<input type="button" value="群发" class="sendAll" onclick="sendAll()">
	<input type="button" value="清空" class="clear" onclick="clearAll()">
	<!-- 这里只有配置角色为admin的才能访问 ,参照spring-shiro里权限配置-->
	<shiro:hasRole name="admin">
	<input type="button" value="获取用户信息" class="find" onclick="find()">
	</shiro:hasRole>
	<br>
	<table class="table table-striped">
		<caption>用户信息</caption>
		<thead>
			<tr>
				<th>id</th>
				<th>用户名</th>
				<th>邮箱</th>
				<th>登录时间</th>
			</tr>
		</thead>
		<tbody id="userInfo">
		</tbody>
	</table>
</body>
</html>
