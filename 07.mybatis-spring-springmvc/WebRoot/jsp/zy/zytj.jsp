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
	$("#zyxg_edit_submit").click(function(){
		$('#zyxg_edit_form').form('submit', {   
			
		    url:"${pageContext.request.contextPath}/zy/saveOne.action",    
		    onSubmit: function(){ 
		    	
		    	var setd =$("#major_id").val;
		    	
		   
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
		       		$("#zy_dialog").dialog("close");
		       		$('#zy_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","保存失败,请重新保存");
		       	}
		    }    
		}); 
	})
});
</script>
	<div style="padding: 10px;">
		系统设置 >> 院系管理
		<hr />

		<form action="" method="post" id="zyxg_edit_form">
			<input type="hidden" name="id" />
			<input type="hidden" name="deptId" /> 
			<table>
				<tr>
					<td>专业名称:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>专业创建时间:</td>
					<td><input type="text" name="setDate" /></td>
				</tr>
				<tr>
					<td>所属学院:</td>
					<td><input type="text" name="deptName" /></td>
				</tr>
				<tr>
					<td>专业备注:</td>
					<td><input type="text" name="des" /></td>
				</tr>
				<tr>
					<td colspan="2"><a id="zyxg_edit_submit" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>