<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>首页</title>
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
	<!-- 用户信息卡片 -->
	<div class="col-md-4 card-container">
		<div class="card">
			<div class="card-title" style="padding-bottom:15px;">用户信息<a href="#">详情</a></div>
			<div style="margin-top:8px;">
				用户姓名：<span id="">${session_user.name}</span>
			</div>
			<div style="margin-top:20px;">
				用户性别：<span id="">${session_user.sex}</span>
			</div>
			<div style="margin-top:20px;">
				用户年龄：<span id="">${session_user.age}</span>
			</div>
		</div>
	</div>
	<!-- 用户记事卡片 -->
	<div class="col-md-4 card-container">
		<div class="card">
			<div class="card-title" style="padding-bottom:15px;">最近投保<a href="#">更多</a></div>
			<ul>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1448015745416">百年附加定期寿险 2015-11-20</a>
				</li>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446805841359">人保财险母婴安心保险 2015-11-20</a>
				</li>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446601799312">民生康吉重大疾病保险 2015-11-20</a>
				</li>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446601799312">联众附加少儿医疗意外伤害保险 2015-11-20</a>
				</li>
			</ul>
		</div>
	</div>
	<!--公告卡片 -->
	<div class="col-md-4 card-container">
		<div class="card">
			<div class="card-title" style="padding-bottom:15px;">消息中心<a href="#">更多</a></div>
			<ul>
				<li>
					<a href="newsCenter/messageDetail?noticeId=1448015745416">矿工职业保险投注成功</a>
					<span style="margin-right:40px;" class="pull-right">2015/11/20</span>
				</li>
				
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446805841359">出海互助险理赔有了新进展</a>
					<span style="margin-right:40px;" class="pull-right">2016/11/06</span>
				</li>
				
				<li>
					<a href="newsCenter/messageDetail?noticeId=1446601799312">地质灾害险说明</a>
					<span style="margin-right:40px;" class="pull-right">2015/11/04</span>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
	<div class="container"  style="background: white; width: 102.1%;margin-left: 3px;">
	</div>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
