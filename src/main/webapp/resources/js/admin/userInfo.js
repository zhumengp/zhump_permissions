
$(function(){
		$('#table').bootstrapTable({
		    url: path+'/user/list.action',
		    striped: true,
		    //showRefresh: true,
			//showColumns: true,
		    minimumCountColumns: 2,
			clickToSelect: true,
			detailView: true,
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
			    	{field: 'name',title: '账号',align:'center'},
			    	{field: 'head_img',title: '头像',align:'center'},
			    	{field: 'phone',title: '手机号',align:'center'},
			    	{field: 'email',title: '邮箱',align:'center'},
			    	{field: 'create_time',title: '创建时间',align:'center'},
			    	{field: 'login_time',title: '最后登录时间',align:'center'},
			    	{field: 'locked',title: '状态',align:'center'}
			    	
		    	]
		});	
	})
	
	function deleteUserDialog(){
		var rows = $('#table').bootstrapTable('getSelections');
		if(rows.length == 0){
			alert("请选择一条数据")
		}else{
			$.ajax({
				url:path+'/user/deleteUser.action?userId='+rows[0].userId,
				type:'get',
				dataType:'json',
				success:function (data){
					alert('删除成功')
					$('#table').bootstrapTable('refresh');
				}
			});
		}
	}

	/**
	添加用户信息
	**/
	function insertUserDialog(){
		window.location.href = path+'/user/create.action';
	}
	
	/**
	修改用户信息
	**/
	function updateUserDialog(){
		var rows = $('#table').bootstrapTable('getSelections');
		if(rows.length == 0){
			alert('请选项一条数据');
		}else{
			window.location.href = path + '/user/edit.action?userId='+rows[0].id;
		}
	}
	
	
	
	function stateFormatter(value, row, index){
		if(row.state == true)  
	    return {checked : true };  
	    return value;  
	}
	
	function authorizationDialog(){
		var rows = $('#tables').bootstrapTable('getSelections');
		console.info(rows);
		var ids = [];
		var userId = $("#userId").val();
		console.info("userId:"+userId);
		if (rows != undefined && rows != null) {
			for (var i=0; i<rows.length; i++) {
				ids.push(rows[i].id);
			}
		}
		$.ajax({
			url:path+'/userRole/insertUserRole.action',
			data:{
				"userId": userId,
				"ids":ids
			},
			type:'post',
			dataType:'json',
			success:function (data){
				console.info(data.data.state);
				$("#myModal").modal('hide');
				if(data.data.state == "OK"){
					alert(data.data.msg);
				}
			}
		});
	}


	function  roleDlaog(){
        alert(1);
		//没有选中用户的的时候给客户端一个提示
		var rows = $('#table').bootstrapTable('getSelections');

		if(rows.length == 0){

			alert('请选择一条数据');
		}else{
            console.info("rows:"+rows[0]);
			$('#myModal').modal({backdrop : 'static',keyboard : false});
			$('#myModal').modal('show');
			$('#userId').val(rows[0].id);
			 $('#tables').bootstrapTable({
			    url: path+'/userRole/userRoleList.action?userId='+rows[0].id,
			    //striped: true,
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
			    		{checkbox: true,formatter:'stateFormatter'},
				    	{field: 'name',title: '角色名',align:'center'},
				    	{field: 'description',title: '描述',align:'center'}
			    	]
			}); 
		}
	}
	