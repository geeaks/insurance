<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>页面没有找到</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="../common/common-topnav.jsp" />
<div id="rope-anim" style="z-index:3;position:absolute;left:0px;top:60px">
<svg width="1920" >
	<path stroke-width="3" d="M0,80S960,44.32499999999999,1920,80" stroke="#bbbbbb" fill="none"></path>
</svg>
</div>
<div id="molo-image" style="position: absolute; top: 126px; z-index: 999; left: 790px;" align="center">
	<img style="display: inline; margin-top: -40px;" id="molo" src="/images/molome_404.png">
</div>
<div id="error" style="text-align: center; padding-top: 450px; height: 86px;">
	<span style="font-size:36px;color:#7C999B;font-weight:bold">500 Error</span>
	<br />
	<span style="font-size:26px;color:#AAAAAA">系统内部错误</span>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>