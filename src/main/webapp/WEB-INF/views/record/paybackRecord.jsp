<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>理赔记录</title>
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
					<th>理赔金额</th>
					<th>理赔状态</th>
					<th>理赔时间</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="payback" items="${list}" varStatus="index" >
					<tr <c:if test="${index.index % 2 == 0}"> class="success" </c:if>
					<c:if test="${index.index % 2 == 1}"> class="warning" </c:if>>
						<td>${payback.issuranceName}</td>
						<td>${payback.amount}</td>
						<td>
							<c:choose>
								<c:when test="${payback.status eq 'S'}">
									成功
								</c:when>
								<c:otherwise>
									已过期
								</c:otherwise>
							</c:choose>
						</td>
						<td>${payback.paybackDate}</td>
						<td>${payback.remark}</td>
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
