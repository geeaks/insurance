<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>发起自助保险</title>
<script type="text/javascript">
	$(function() {
		$(".form_datetime").datetimepicker({
			format : 'yyyy-mm-dd',
			weekStart : 1,
			autoclose : true,
			startView : 2,
			minView : 2,
			forceParse : false,
			language : 'zh-CN'
		});
	});
</script>
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
						发起自助保险
					</h4>
				</div>
			</div>
			<form id="" method="post" action="${basePath}/appCenter/originateIssurance" role="form" style="margin-top: 20px;">
				<div class="form-group">
					<label for="exampleInputEmail1">保险名称</label>
					<input class="form-control" name="issuranceName" id="exampleInputEmail1" type="text" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">投保额度</label>
					<input class="form-control" name="amount" id="exampleInputEmail1" type="text" />
				</div>
				<div class="form-group">
					<label for="startdate">开始日期</label>
					<input type="text" name="startDate" readonly class="form-control form_datetime">
				</div>
				<div class="form-group">
					<label for="enddate">结束日期</label>
					<input type="text" name="endDate" readonly class="form-control form_datetime">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">用途说明</label>
					<textarea class="form-control" name="issuranceDesc" rows="3"></textarea> 
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
