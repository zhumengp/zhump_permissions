<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/plyr/plyr.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/sweetalert2/sweetalert2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/zTree_v3/css/metroStyle/metroStyle.css">
    <link href="${pageContext.request.contextPath}/resources/css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-table.css">
    <jsp:include page="../static/footer.jsp"></jsp:include>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/zTree_v3/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/zTree_v3/js/jquery.ztree.excheck.js"></script>
    <script type="text/javascript">
        $(function(){
            $('#table').bootstrapTable({
                url: '${pageContext.request.contextPath}/role/list.action',
                striped: true,
                //search: true,
                //showRefresh: true,
                //showColumns: true,
                minimumCountColumns: 2,
                clickToSelect: true,
                //detailView: true,
                detailFormatter: 'detailFormatter',
                pagination: true,
                paginationLoop: false,
                sidePagination: 'server',
                silentSort: false,
                smartDisplay: false,
                escape: true,
                searchOnEnterKey: true,
                idField: 'id',
                maintainSelected: true,
                toolbar: '#toolbar',
                columns: [
                    {field: 'ck',checkbox: true},
                    {field: 'id',title: '编号',align:'center'},
                    {field: 'name',title: '角色名',align:'center'},
                    {field: 'create_time',title: '创建时间',align:'center'},
                    {field: 'description',title: '描述',align:'center'}
                ]
            });
        })
        function  roleDlaog(){
            //没有选中用户的的时候给客户端一个提示
            var rows = $('#table').bootstrapTable('getSelections');
            if(rows.length == 0){
                alert('请选择一条数据');
            }else{
                $('#myModal').modal({backdrop : 'static',keyboard : false});
                $('#myModal').modal('show');
                $('#roleId').val(rows[0].id);
                console.info(rows[0].id);
                initZtree(rows[0].id);
            }
        }

        function initZtree(id){
            var setting = {
                check: {
                    enable: true,
                    chkboxType: { "Y" : "p", "N" : "s" }
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                }

            };
            $.ajax({
                url:path+'/resources/menuTree.action?roleId='+id,
                success:function (data){
                    console.info(data);
                    $.fn.zTree.init($("#ztree"), setting, data.data);
                },
                error:function(){
                    alert('error')
                }
            });

        }

        function permissionSubmit() {
            var roleId = $('#roleId').val();
            var zTree = $.fn.zTree.getZTreeObj("ztree");
            console.info("id: "+zTree);
            var changeNodes = zTree.getCheckedNodes();
            console.info("节点:"+changeNodes);
            var ids = [];
            if(changeNodes != null && changeNodes != undefined){
                for (var i = 0; i < changeNodes.length; i ++) {
                    ids.push(changeNodes[i].id);
                }
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/roleMenu/add.action',
                data:{
                    "roleId": roleId,
                    "ids":ids
                },
                type:'post',
                dataType:'json',
                success:function (data){
                    console.info(data.code);
                    $("#myModal").modal('hide');
                    if(data.code == "1"){
                        alert(data.mes);
                    }
                }
            });
        }

    </script>
    <title>Insert title here</title>

</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>角色查询</h5>
                </div>
                <div class="ibox-content">
                    <button class="btn btn-success btn-sm" onclick="roleDlaog();">
                        <span class="glyphicon glyphicon-user"></span>权限授权
                    </button>
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
        <input type="hidden" id="roleId">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    权限授权
                </h4>
            </div>
            <div class="modal-body">
                <ul id="ztree" class="ztree"></ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="permissionSubmit();">
                    提交更改
                </button>
            </div>
        </div>
    </div>
</body>
</html>