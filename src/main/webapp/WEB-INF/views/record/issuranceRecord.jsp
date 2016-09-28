<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>投保记录</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="../common/common-topnav.jsp" />
<div class="container">
	<!-- 导航栏 -->
	<jsp:include page="../common/home-nav.jsp" />
	<!-- 信息主体部分 -->
	<!-- 卡片 -->
<div class="row clearfix">
	<div class="col-md-12 column">
		<table class="table">
			<thead>
				<tr>
					<th>保险名称</th>
					<th>投保额度</th>
					<th>发起人</th>
					<th>状态</th>
					<th>起始事件</th>
					<th>结束时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="issurance" items="${list}" varStatus="index" >
					<tr <c:if test="${index.index % 2 == 0}"> class="success" </c:if>
					<c:if test="${index.index % 2 == 1}"> class="warning" </c:if>>
						<td>${issurance.issuranceName}</td>
						<td>${issurance.amount}</td>
						<td>${issurance.userName}</td>
						<td>
							<c:choose>
								<c:when test="${issurance.status eq 'S'}">
									成功
								</c:when>
								<c:otherwise>
									已过期
								</c:otherwise>
							</c:choose>
						</td>
						<td>${issurance.startDate}</td>
						<td>${issurance.endDate}</td>
						<td>
							<a href="#">参保</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
<jsp:include page="../common/common-footnav.jsp" />
</body>
</html>
