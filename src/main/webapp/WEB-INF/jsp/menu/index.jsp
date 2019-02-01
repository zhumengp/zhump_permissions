<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <jsp:include page="../static/head.jsp"></jsp:include>
    <jsp:include page="../static/footer.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/Menu.js"></script>
    <title>菜单管理</title>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
           <div class="col-sm-12">
                <div class="ibox float-e-margins">
                        <div class="ibox-title">
                                <h5>菜单管理</h5>
                        </div>
                <div class="ibox-content">
                        <button class="btn btn-primary" type="button" onclick="insertMenuDialog();">
                                <i class="fa fa-plus"></i>&nbsp;添加
                        </button>
                        <button class="btn btn-danger" type="button" onclick="deleteMenuDialog();">
                                <i class="fa fa-times"></i>&nbsp;删除
                        </button>
                        <button class="btn btn-info" type="button" onclick="updateMenuDialog();">
                                <i class="fa fa-pencil"></i>&nbsp;编辑
                        </button>
                        <table id="table" class="table table-responsive table-hover table-condensed text-center" style="margin-bottom: 0px;"></table>
                        <div id="page" class="text-center">
                                <div class="hr-line-dashed"></div>
                                <ul id="UserPageList"></ul>
                        </div>
                </div>
            </div>
        </div>
     </div>
        </div>
        </div>
        </body>
        </html>