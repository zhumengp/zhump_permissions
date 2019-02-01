    $(function(){
        $('#table').bootstrapTable({
            url: path+'/resources/list.action',
            striped: true,
            //showRefresh: true,
            //showColumns: true,
            minimumCountColumns: 2,
            clickToSelect: true,
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
                {field: 'systemId',title: '系统编号',align:'center'},
                {field: 'parent_id',title: '父id',align:'center'},
                {field: 'name',title: '名称',align:'center'},
                {field: 'type',title: '类型',align:'center'},
                {field: 'permissions_value',title: '权限值',align:'center'},
                {field: 'permissions_url',title: 'url',align:'center'},
                {field: 'icon',title: '图标',align:'center'},
                {field: 'status',title: '状态',align:'center'},
                {field: 'create_time',title: '创建是时间',align:'center'},
                {field: 'orders',title: '排序',align:'center'}
            ]
        });
    })


    /**
     修改权限信息
     **/
    function updateMenuDialog(){
        var rows = $('#table').bootstrapTable('getSelections');
        if(rows.length == 0){
            alert('请选项一条数据');
        }else{
            window.location.href = path + '/resources/eidt.action?menuId='+rows[0].id;
        }
    }

    function insertMenuDialog() {
        window.location.href = path + '/resources/add.action';
    }