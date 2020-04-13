<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#xsxg_edit_submit").click(function(){
		$('#xsxg_edit_form').form('submit', {    
		    url:"${pageContext.request.contextPath}/xs/update.action",    
		    onSubmit: function(){ 
		    	
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
		       		$("#xs_dialog").dialog("close");
		       		$('#xs_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","修改失败,请重新修改");
		       	}
		    }    
		}); 
	})
});
</script>
	<div style="padding: 10px;">
		系统设置 >> 学生管理
		<hr />

		<form action="" method="post" id="xsxg_edit_form">
			<input type="hidden" name="id">
			<input type="hidden" name="classid">
			<table>
				<tr>
					<td>学生学号:</td>
					<td><input type="text" name="sno" /></td>
				</tr>
				<tr>
					<td>学生姓名:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>学生性别:</td>
					<td><input type="text" name="sex" /></td>
				</tr>
				<tr>
					<td>学生生日:</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr>
					<td>学生民族:</td>
					<td><input type="text" name="nation" /></td>
				</tr>
				<tr>
					<td>学生电话:</td>
					<td><input type="text" name="tel" /></td>
				</tr>
				<tr>
					<td>学生邮箱:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>学生地址:</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>学生所属班级:</td>
					<td><input type="text" name="classname" /></td>
				</tr>
				<tr>
					<td>学生密码:</td>
					<td><input type="text" name="password" /></td>
				</tr> 
				<tr>
					<td>学生描述:</td>
					<td><input type="text" name="des" /></td>
				</tr>
				<tr>
					<td colspan="2"><a id="xsxg_edit_submit" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>