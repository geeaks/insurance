<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#imgCode{cursor: pointer;width: 100%;height: 100%}
</style>
<!-- 登录表单 -->
<div class="col-md-4 column" style="margin-left: 400px;">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<c:choose>
				<c:when test="${session_user != null}">
					<div class="form-group" style="text-align: center;">
						<div class="col-sm-12" style="margin-top: 30%;">
							<span>尊敬的 <span style="color: red">${session_user.name}</span> ，您已登录</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12" style="margin-top: 20%;">
							<button type="button" class="btn btn-default btn-block" onclick="window.location.href='home'">进入首页</button>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<form id="loginForm" name="loginForm" action="login" method="post" class="form-horizontal" role="form">
						<div id="alertDiv" class="alert alert-dismissable alert-danger" <c:if test="${msg eq null}"> hidden="hidden" </c:if> >
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
							<span id="alertAttr" value="" />
							<span id="alertMsg"><c:if test="${msg ne null}"> ${msg} </c:if></span>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input id="loginId" name="loginId" class="form-control" type="text" placeholder="登录名:手机号码/邮箱" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input id="password" name="password" class="form-control" type="password" placeholder="登录密码" />
							</div>
						</div>
						<script type="text/javascript">
							$(function(){
								$("#loginId").val('${user.name}');
								$("#password").val('123456');
							});
						</script>
						<div class="form-group">
							<div class="col-sm-12">
								<div class="checkbox">
									<label><input id="rememberMe" type="checkbox" />记住用户名</label>
									<a href="password/forgetPwd" class="pull-right">忘记密码了？</a>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<button type="submit" class="btn btn-default btn-block">登录</button>
							</div>
						</div>
						<!-- <div class="form-group">
							<div class="col-sm-12">
								<a href="forgetPassword" class="pull-right">免费注册</a>
							</div>
						</div> -->
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>