//页面预加载
$(function(){
	//记住用户名
	setCookieName();
	
	//为记住用户名 绑定事件
	$("#rememberMe").click(function(){
		if(this.checked){
			document.cookie="loginId="+$("#loginId").val()+"; max-age=" + (60*60*24*10);
		}else{
			var exp = new Date();
			exp.setTime(exp.getTime() - 1); 
			document.cookie= "loginId='';expires="+exp.toGMTString(); 
		}
	});
	
	$("#loginId").on("keyup",function(){
		if($("#alertAttr").val() == 'loginId'){
			$("#alertDiv").hide();
		}
	});
	
	$("#password").on("keyup",function(){
		if($("#alertAttr").val() == 'password'){
			$("#alertDiv").hide();
		}
	});
	
	$("#checkCode").on("keyup",function(){
		if($("#alertAttr").val() == 'checkCode'){
			$("#alertDiv").hide();
		}
	});
	
	//为登录操作绑定校验事件
	$("#loginForm").on("submit",function() {
		if ($("#loginId").val().length < 1) {
			$("#alertMsg").html("请输入有效的用户名");
			$("#alertAttr").val("loginId");
			$("#alertDiv").show();
			return false;
		}
		if ($("#password").val().length < 6) {
			$("#alertMsg").html("请输入有效的登录密码");
			$("#alertAttr").val("password");
			$("#alertDiv").show();
			return false;
		}
		if ($("#checkCode").val().length != 4) {
			$("#alertMsg").html("请输入有效的验证码");
			$("#alertAttr").val("checkCode");
			$("#alertDiv").show();
			return false;
		}
		if($("#rememberMe").is(':checked')){
			document.cookie="loginId="+$("#loginId").val()+"; max-age=" + (60*60*24*365);
		}else{
			var exp = new Date();
			exp.setTime(exp.getTime() - 1); 
			document.cookie= "loginId='';expires="+exp.toGMTString(); 
		}
	});
	
	//绑定验证码校验事件
	$("#checkCode").on("keyup", function() {
		var value = $(this).val();
		if (value.length == 4) {
			$.ajax({
				type : "post",
				url : "checkImgCode",
				data : {
					checkCode : value
				},
				success : function(result) {
					if (result.success) {
						$("#alertDiv").hide();
					} else {
						$("#alertMsg").html(result.msg);
						$("#alertDiv").show();
					}
				}
			});
		}
	});
});


//如果cookie存在用户名，则设置登录名为cookie中的名字
function setCookieName(){
	var cookies=document.cookie.split(";");
	for(var i=0;i<cookies.length;i++){
		if(cookies[i].indexOf("loginId")>-1){
			$('#loginId').val(cookies[i].split("=")[1]);
			$("#rememberMe").attr({"checked":true});
			break;
		}else{
			$('input[name="loginId"]').val("");
		}
	}
}

//重新加载图片验证码
function reloadImgCode(){
	document.getElementById("imgCode").src=document.getElementById("imgCode").src + "?nocache="+new Date().getTime();
}