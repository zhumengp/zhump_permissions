<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../static/head.jsp"></jsp:include>
<jsp:include page="../static/footer.jsp"></jsp:include>
<title>编辑权限信息</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>编辑权限</h5>
					</div>
					<div id="userAddInfo" class="ibox-content">
						<form id="updateUserForm" class="form-horizontal" method="post">
						<input id="menuId" type="hidden" value="${menuVO.id}"></input>
						<div>
							<div class="form-group">
								<label class="col-md-2 control-label">权限名：</label>
	                            <div class="col-md-7">
	                                <input name="name"  type="text" class="form-control" value="${menuVO.name}" >
	                                <span id="nameUser_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">权限制：</label>
	                            <div class="col-md-7">
	                                <input name="permissions_value" type="text" class="form-control" value="${menuVO.permissions_value}" >
	                                
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">url：</label>
	                            <div class="col-md-7">
	                                <input name="permissions_url"  type="text" class="form-control" value="${menuVO.permissions_url}" >
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                         <div class="form-group">
	                        	<label class="col-md-2 control-label">图标：</label>
	                            <div class="col-md-7">
	                                <input name="email"  type="text" class="form-control" value="${menuVO.icon}" >
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div> 
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">状态：</label>
	                            <div class="col-md-7">
	                                <div class="col-md-7" id="radio">	                            
		                                <input type="radio"  value="1"  style="margin-top: 9px;" name="sex" <c:if test="${menuVO.status==1}">checked</c:if>>&nbsp;&nbsp;<label>正常</label>
		                             	&nbsp;&nbsp;&nbsp;&nbsp;
		                             	<input type="radio"  value="0"  name="sex" <c:if test="${menuVO.status==0}">checked</c:if>>&nbsp;&nbsp;<label>异常</label>
		                            </div>	
	                                <span id="password_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
							<div class="row">
								<div class="col-sm-5"></div>
								<div class="col-sm-6">
									<span href="window.location.href= ">取消</span>
								</div>
							</div>
	                        <div class="row">
	                        	<div class="col-sm-5"></div>
								<div class="col-sm-6">
									<button id="userSubmit" type="button" class="btn btn-primary" onclick="updateMenuSubmit();">提交</button>
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
		function updateMenuSubmit(){
			var menuId = $("#menuId").val();
			$.ajax({
				url:'${pageContext.request.contextPath}/resources/update.action?id='+menuId,
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