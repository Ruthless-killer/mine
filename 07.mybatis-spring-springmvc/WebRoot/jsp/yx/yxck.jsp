<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#yxxg_edit_submit").click(function(){
		$('#yxxg_edit_form').form('submit', {    
		    url:"${pageContext.request.contextPath}/updateDept.action",    
		    onSubmit: function(){ 
		    	
		    	var setd =$("#yxxg_edit_form :text:eq(1)").val;
		    	//alert("点击提交")
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		       	if(data==1){
		       		$.messager.show({
		       			title:'系统消息',
		       			msg:'修改成功',
		       			timeout:3000,
		       			showType:'slide'
		       		});
		       		//弹出框关闭
		       		$("#role_dialog").dialog("close");
		       		$('#role_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","修改失败,请重新修改");
		       	}
		    }    
		}); 
	})
});
</script>
	<div style="padding: 10px;">
		系统设置 >> 院系管理
		<hr />

		<form action="" method="post" id="yxxg_edit_form">
			<input type="hidden" name="id" />
			<table>
				<tr>
					<td>院系名称:</td>
					<td><input type="text" readonly unselectable="on" name="name" /></td>
				</tr>
				<tr>
					<td>院系创建时间:</td>
					<td><input type="text" readonly unselectable="on" name="setdate" /></td>
				</tr>
				<tr>
					<td>院系备注:</td>
					<td><input type="text" readonly unselectable="on" name="des" /></td>
				</tr>
				<!-- <tr>
					<td colspan="2"><a id="yxxg_edit_submit" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>
					</td>
				</tr> -->
			</table>
		</form>
	</div>

</body>
</html>