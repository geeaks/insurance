<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common-header.jsp" />
<title>系统内部错误</title>
</head>
<body>
<!-- 顶部导航栏 -->
<jsp:include page="../common/common-topnav.jsp" />
<div class="container">
	原因：${exception}
	<br /><br />
	<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
		<p>${trace}</p>
	</c:forEach> 
	<jsp:include page="../common/common-footnav.jsp" />
</div>
</body>
</html>