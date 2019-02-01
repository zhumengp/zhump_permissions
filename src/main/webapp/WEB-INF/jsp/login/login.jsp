<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"></meta>
	<title>登陆</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login/style.css" /></link>
</head>
<body>

<div class="login-container" style="position: absolute;right: 0px;left: 0px;">
	<h1>后台管理</h1>
	<div class="connect">
		<p id="errId"></p>
	</div>
	<form action="" method="post" id="loginForm">
		<div>
			<input type="text" name="name" class="username" id="username" placeholder="用户名" autocomplete="off"/></input>
		</div>
		<div>
			<input type="password" name="password" class="password" id="password" placeholder="密码" oncontextmenu="return false" /></input>
		</div>

		<button id="submit" type="button" onclick="login()">登 陆</button>
	</form>
	<%-- <a href="${pageContext.request.contextPath}/register/">
		<button type="button" class="register-tis">还有没有账号？</button>
	</a> --%>
</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery.1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/login/common.js"></script>
<!--背景图片自动更换-->
<script src="${pageContext.request.contextPath}/resources/js/login/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/login/supersized-init.js"></script>
<!--表单验证-->
<script src="${pageContext.request.contextPath}/resources/js/login/jquery.validate.min.js"></script>
<script>var BACK_URL = '${param.tokens}';</script>
</body>
<script type="text/javascript">

    function login(){
        console.info("BACK_URL:"+BACK_URL);
        $('#errId').empty().append('');
        if($('#username').val()==''||$('#password').val()==''){
            if($('#username').val()==''){
                $('#errId').empty().append('<label id="username-error" class="error" for="username">账号不能为空......</label>');
            }else{
                $('#errId').empty().append('<label id="username-error" class="error" for="username">密码不能为空......</label>');
            }
        } else {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/sso/login.action',
                data: {name:$("#username").val(),password:$("#password").val(),tokens:BACK_URL},
                dataType: 'json',
                success: function(data) {
                    console.log(data);
                    if(data.code== "1"&& data.mes=="SUCCESS"){
                        location.href='${pageContext.request.contextPath}/sso/index.action';
                        console.log(data.code);
                    }else{
                        $('#errId').empty().append('<label id="username-error" class="error" for="username">'+data.mes+'</label>');
                    }

                },
                error: function(data){

                }
            });
        }
    }
</script>
</html>