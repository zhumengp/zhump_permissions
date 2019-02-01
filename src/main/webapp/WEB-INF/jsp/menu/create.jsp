<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="../static/head.jsp"></jsp:include>
<jsp:include page="../static/footer.jsp"></jsp:include>
<title>添加菜单</title>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>添加菜单</h5>
					</div>
					<div id="userAddInfo" class="ibox-content">
						<form id="addUserForm" class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 control-label">标题：</label>
	                            <div class="col-md-7">
	                                <input id="name"  type="text" class="form-control" placeholder="标题" >
	                                <span id="nameUser_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">上级：</label>
	                            <div class="col-md-4">
									<select class="form-control" name="Province" id="Province">
										<option>==请选择===</option>
									</select>
									<select class="form-control" name="Province" id="c_Province">
									<option>==请选择===</option>
									</select>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">权限值：</label>
	                            <div class="col-md-7">
	                                <input id="permissions_value"  type="text" class="form-control" placeholder="权限值" >
	                                <span id="permissions_value_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">url：</label>
	                            <div class="col-md-7">
	                                <input id="permissions_url"  type="text" class="form-control" placeholder="url" >
	                                <span id="permissions_url_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="form-group">
	                        	<label class="col-md-2 control-label">状态：</label>
	                            <div class="col-md-7">
	                                <div class="col-md-7" id="radio">	                            
		                                <input type="radio"  value="1"  style="margin-top: 9px;" name="type"checked>&nbsp;&nbsp;<label>正常</label>
		                             	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="0"  name="type" >&nbsp;&nbsp;<label>异常</label>
		                            </div>	
	                                <span id="password_span"></span>
	                            </div>
	                        </div>
	                        <div class="hr-line-dashed"></div>
	                        <div class="row">
	                        	<div class="col-sm-5"></div>
								<div class="col-sm-6">
									<button id="userSubmit" type="button" class="btn btn-primary" onclick="Submit();">提交</button>
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
	
	
	
	function Submit(){
		var username = $('#name').val();
		var realname = $('#realname').val();
		var value = $('#permissions_value').val();
		var url = $('#permissions_url').val();
		var status = $('#radio input[name="type"]:checked').val();
		$.ajax({
			url:path+'/resources/add.action',
			data:{
				"username":username,
				"realname":realname,
				"permissions_value":value,
				"permissions_url":url,
				"status":status
			},
			dataType:'json',
			type:'post',
			success:function(data){
				alert("插入成功！！！");
			}
		})
	}
	
	
	</script>
</body>
</html>