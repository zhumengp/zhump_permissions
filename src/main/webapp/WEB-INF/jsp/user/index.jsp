<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <jsp:include page="../static/head.jsp"></jsp:include>
    <jsp:include page="../static/footer.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/userInfo.js"></script>
    <title>Insert title here</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>用户管理</h5>

                </div>
                <div class="ibox-content">
                        <button class="btn btn-success" type="button" onclick="roleDlaog();">
                            <i class="glyphicon glyphicon-user"></i>&nbsp;授权角色
                        </button>

                        <button class="btn btn-primary" type="button" onclick="insertUserDialog();">
                            <i class="fa fa-plus"></i>&nbsp;添加
                        </button>
                        <button class="btn btn-danger" type="button" onclick="deleteUserDialog();">
                            <i class="fa fa-times"></i>&nbsp;删除
                        </button>
                    <%-- <shiro:hasPermission name="user:update:read"> --%>
                    <button class="btn btn-info" type="button" onclick="updateUserDialog();">
                        <i class="fa fa-pencil"></i>&nbsp;编辑
                    </button>
                    <%-- </shiro:hasPermission> --%>
                    <table id="table" class="table table-responsive table-hover table-condensed text-center" style="margin-bottom: 0px;">

                    </table>
                    <div id="page" class="text-center">
                        <div class="hr-line-dashed"></div>
                        <ul id="UserPageList"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 角色授权模态窗 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <input type="hidden" id="userId">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    角色授权
                </h4>
            </div>
            <div class="modal-body">
                <table id="tables" >
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="authorizationDialog();">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</body>
</html>