<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../static/head.jsp"></jsp:include>
<jsp:include page="../static/footer.jsp"></jsp:include>
<title>修改用户信息</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>编辑用户</h5>
					</div>
					<div id="userAddInfo" class="ibox-content">
						<form id="updateUserForm" class="form-horizontal" method="post">
						<input id="userId" type="hidden" value="${userInfo.id}"></input>
						<div>
							<div class="form-group">
								<label class="col-md-2 control-label">登录名：</label>
	                            <div class="col-md-7">
	                                <input name="name"  type="text" class="form-control" value="${userInfo.name}" >
	                                <span id="nameUser_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">手机号：</label>
	                            <div class="col-md-7">
	                                <input name="phone"  type="text" class="form-control" value="${
	                                .phone}" >
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                         <div class="form-group">
	                        	<label class="col-md-2 control-label">邮箱：</label>
	                            <div class="col-md-7">
	                                <input name="email"  type="text" class="form-control" value="${userInfo.email}" >
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="row">
	                        	<div class="col-sm-5"></div>
								<div class="col-sm-6">
									<button id="userSubmit" type="button" class="btn btn-primary" onclick="updateUserSubmit();">提交</button>
								</div>
							</div>
	                        </div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function updateUserSubmit(){
			var userId = $("#userId").val();
			console.info(userId)
			$.ajax({
				url:'${pageContext.request.contextPath}/user/update.action?id='+userId,
				data:$('#updateUserForm').serialize(),
				dataType:'json',
				type:'post',
				success:function(data){
					alert("修改成功！！！");
				}
			})
		}
	
	</script>
</body>
</html>