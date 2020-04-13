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
	$("#bjxg_edit_submit").click(function(){
		$('#bjxg_edit_form').form('submit', {    
		   // url:"${pageContext.request.contextPath}/bj/saveOne.action",    
		    onSubmit: function(){ 
		    	
		    	var setd =$("#bjxg_edit_form :text:eq(1)").val;
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
		       		$("#bj_dialog").dialog("close");
		       		$('#bj_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","修改失败,请重新修改");
		       	}
		    }    
		}); 
	})
});
</script>
	<div style="padding: 10px;">
		系统设置 >> 班级管理
		<hr />

		<form action="" method="post" id="bjxg_edit_form">
			
			<table>
				<tr>
					<td>班级名称:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>所属专业:</td>
					<td><input type="text" name="majorName" /></td>
				</tr>
				<tr>
					<td>班主任:</td>
					<td><input type="text" name="teacherName" /></td>
				</tr>
				<tr>
					<td>描述:</td>
					<td><input type="text" name="des" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>