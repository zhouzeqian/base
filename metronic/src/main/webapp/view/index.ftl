<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>metronic示例</title>
<#include "head.ftl"/>
</head>
<body class="page-header-fixed">
<#include "top.ftl"/>
	<!-- BEGIN CONTAINER -->

	<div class="page-container">

<#include "menu.ftl"/>
		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid" id="container">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid" id="title">

					<div class="span12">

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							概要

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="${request.contextPath}">首页</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">概要</a></li>


						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<div class="row-fluid" id="content">

					<div class="span12">

						<ul class="timeline">

							<li class="timeline-yellow">

								<div class="timeline-time">

									<span class="date">31/12/16</span>

									<span class="time">9:45</span>

								</div>

								<div class="timeline-icon"><i class="icon-trophy"></i></div>

								<div class="timeline-body">

									<h2>连连筹订单支付异步通知</h2>

									<div class="timeline-content">
										连连支付支付平台对商户的付款请求数据处理完成后，会将处理
										的结果（付款成功、付款失败，退款都会通知，商户也可以通过
										付款结果查询来查询付款状态）数据通过服务器主动通知的方式
										通知给商户的通知地址，此地址就是付款请求时的notify_url。
										通知机制为：总共通知6次，通知的时间间隔频率为6分钟，直
										到通知被商户成功接受为止，如果通知6次后也没有被商户接受
										成功则不再发通知，由商户通过付款结果查询接口进行查询。通
										知服务通过https  post方式提交给商户服务端，商户服务端通
										过数据流读写的方法获得通知字符串。
									</div>

									<div class="timeline-footer">

										<a href="#" class="nav-link pull-right">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>  

									</div>

								</div>

							</li>

							<li class="timeline-blue">

								<div class="timeline-time">

									<span class="date">18/4/17</span>

									<span class="time">15:04</span>

								</div>

								<div class="timeline-icon"><i class="icon-facetime-video"></i></div>

								<div class="timeline-body">

									<h2>连连支付银行卡代付异步通知</h2>

									<div class="timeline-content">
										连连支付支付平台对商户的代付请求数据处理完成后，会将处理
										的结果（代付成功、代付失败都会通知，商户也可以通过代付结
										果查询来查询代付状态）数据通过服务器主动通知的方式通知给
										商户的通知地址，此地址就是代付请求时的notify_url。通知机
										制为：总共通知5次，通知的时间间隔频率为6分钟，直到通知
										被商户成功接受为止，如果通知5次后也没有被商户接受成功则
										不再发通知，由商户通过代付结果查询接口进行查询。通知服务
										通过https  post方式提交给商户服务端，商户服务端通过数据流
										读写的方法获得通知字符串。
									</div>

									<div class="timeline-footer">

										<a href="#" class="nav-link">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>                         

									</div>

								</div>

							</li>

							<li class="timeline-green">

								<div class="timeline-time">

									<span class="date">18/9/17</span>

									<span class="time">10:18</span>

								</div>

								<div class="timeline-icon"><i class="icon-comments"></i></div>

								<div class="timeline-body">

									<h2>二维码支付回调异步通知</h2>

									<div class="timeline-content">
说明：请先在运营平台设置好回调地址及回调类型，一般在交易状态发生改变的情况两秒内会收到回调，如果消息队列过长，可能会有延时，如果接收回调的服务器无响，会按照30秒的倍数增长间隔推送（30,60,90,120,150），24小时后会终止回调。
										系统会回调运营平台指定的URL，所有表单都以get方式提交，支持http和https地址，url地址中允许使用?号和&号。
										开发者在收到回调后，请在页面返回notify_success，回调任务抓取到关键字符串notify_success，则代表回调成功。
										
									</div>

									<div class="timeline-footer">

										<a href="#" class="nav-link">

										Read more <i class="m-icon-swapright m-icon-white"></i>                              

										</a>                        

									</div>

								</div>

							</li>


						</ul>

					</div>

				</div>

		

			</div>

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2016 &copy; 浙江开心连连网络有限公司.

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

	<!-- END FOOTER -->

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		});

	</script>
	<!-- END JAVASCRIPTS -->
</body>

<!-- END BODY -->

</html>