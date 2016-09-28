<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>error</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="../common/common-topnav.jsp" />
<div class="container">
	<!-- 导航栏 -->
	<jsp:include page="../common/home-nav.jsp" />
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<h4 style="text-align: center;">
						很遗憾，操作失败!
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
