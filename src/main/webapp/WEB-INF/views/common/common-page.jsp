<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-xs-12">
	<c:if test="${pageBean.currentPage != 0}">
		<div class="pull-right" >
			<a href="javascript:submit('first')" style="margin-right:10px">&lt;&lt;首页 </a>
				<c:if test="${pageBean.currentPage ne 1}">
					<a href="javascript:submit('prev')" style="margin-right:20px" >&lt;上一页 </a> 
				</c:if>
				${pageBean.rsFirstNumber}-${pageBean.rsLastNumber-1}条，共${pageBean.totalRecords}条 
				<c:if test="${pageBean.currentPage lt pageBean.totalPages}">
					<a href="javascript:submit('next')" style="margin-left:20px" >下一页&gt;</a>
				</c:if>
			<a href="javascript:submit('last')" style="margin-left:10px">尾页&gt;&gt;</a>
		</div>
	</c:if>
</div>
<script type="text/javascript">
	function submit(type){
		var currentPage=1;
		switch(type){
			case "prev":
				currentPage=${pageBean.currentPage-1};
				break;
			case "next":
				currentPage=${pageBean.currentPage+1};
				break;
			case "first":
				currentPage=1;
				break;
			case "last":
				currentPage=pageBean.totalPage;
				break;
		};
		$.post("${basePath}/xxx/xxx",{currentPage:currentPage,length:20},function(data){
			
		});
	};
</script>