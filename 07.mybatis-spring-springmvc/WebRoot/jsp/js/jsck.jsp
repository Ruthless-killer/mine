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
	$("#jsxg_edit_submit").click(function(){
		$('#jsxg_edit_form').form('submit', {    
		   // url:"${pageContext.request.contextPath}/js/saveOne.action",    
		    onSubmit: function(){ 
		    	
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
		       		$("#js_dialog").dialog("close");
		       		$('#js_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","保存失败,请重新修改");
		       	}
		    }    
		}); 
	})
});
</script>
	<div style="padding: 10px;">
		系统设置 >> 教师信息管理
		<hr />

		<form action="" method="post" id="jsxg_edit_form">
			<input type="hidden" name = "id" />
			<input type="hidden" name = "powerid" />
			<table>
				<tr>
					<td>教师编号:</td>
					<td><input type="text" name="tno" /></td>
				</tr>
				<tr>
					<td>教师名称:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input type="text" name="sex" /></td>
				</tr>
				<tr>
					<td>出生日期:</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr>
					<td>民族:</td>
					<td><input type="text" name="nation" /></td>
				</tr>
				<tr>
					<td>电话:</td>
					<td><input type="text" name="tel" /></td>
				</tr>
				<tr>
					<td>email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>家庭地址:</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>职位:</td>
					<td><input type="text" name="position" /></td>
				</tr>
				<!-- <tr>
					<td>密码:</td>
					<td><input type="text" name="password" /></td>
				</tr> -->
				
				
				<tr>
					<td>描述:</td>
					<td><input type="text" name="des" /></td>
				</tr>
				
			</table>
		</form>
	</div>

</body>
</html>