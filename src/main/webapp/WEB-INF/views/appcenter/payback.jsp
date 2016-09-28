<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>申请理赔</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="../common/common-topnav.jsp" />
<div class="container">
	<!-- 导航栏 -->
	<jsp:include page="../common/home-nav.jsp" />
	<!-- 信息主体部分 -->
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-3 column" style="margin-left: 400px;" >
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h4 class="text-center text-warning">
						申请理赔
					</h4>
				</div>
			</div>
			<form method="post" action="${basePath}/appCenter/payback" role="form" style="margin-top: 20px;">
				<div class="form-group">
					<label for="exampleInputEmail1">保险名称</label>
					<input class="form-control" name="issuranceName" type="text" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">理赔额度</label>
					<input class="form-control" name="amount" type="text" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">原因说明</label>
					<textarea class="form-control" name="remark" rows="3"></textarea> 
				</div>
				<button class="btn btn-block btn-large btn-info" type="submit">发起</button>
			</form>
		</div>
	</div>
</div>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
