
		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">

				<li>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				

				<li class="start active">

					<a href="${request.contextPath}">

					<i class="icon-home"></i> 

					<span class="title">概要</span>

					<span class="selected"></span>

					</a>

				</li>

				<li>

					<a href="javascript:;">

					<i class="icon-th"></i> 

					<span class="title">异步通知详情</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="#" onclick="loading(this,'view/pinganNotifyRecords.ftl')">

							连连筹订单支付异步通知</a>

						</li>

					</ul>

				</li>
				
				<li>

					<a href="javascript:;">

					<i class="icon-map-marker"></i> 

					<span class="title">测试</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li>

							<a href="#" onclick="loading(this,'fm/test')">

							测试</a>

						</li>
					</ul>

				</li>

			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->
