<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container" style="width: 104.6%; margin-left: -10px;">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<!-- 导航栏 -->
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header navbar-left">
					<img class="img-rounded" style="display:inline;width: 32%;height: 32%" src="${basePath}/static/images/logo.jpg" alt="logo">
				</div>
				<div style="margin-top:20px;margin-left: -80px;" class="navbar-header navbar-left">
					<span>
						<h3 style="display:inline">互助保险平台</h3>
					</span>
				</div>
				<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav navbar-left">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								记录查询<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${basePath}/record/issurance">投保记录</a></li>
								<li class="divider"></li>
								<li><a href="${basePath}/record/payback">理赔记录</a></li>
							</ul>
						</li>
						<li class="divider-vertical"><br></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								应用中心<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${basePath}/appCenter/gotoOriginateIssurance">发起投保</a></li>
								<li class="divider"></li>
								<li><a href="${basePath}/appCenter/gotoPayback">申请理赔</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="navbar-header navbar-right">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2"> 
					</button>
					<a class="navbar-brand" href="${basePath}/home">我的首页</a>
				</div>
			</nav>
		</div>
	</div>
</div>
