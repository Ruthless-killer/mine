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
	$("#kcxg_edit_submit").click(function(){
		$('#kcxg_edit_form').form('submit', {   
			
		    url:"${pageContext.request.contextPath}/kc/saveOne.action",    
		    onSubmit: function(){ 
		    	
		    	//var setd =$("#major_id").val;
		    	
		   
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
		       		$("#kc_dialog").dialog("close");
		       		$('#kc_table').datagrid('reload');
		       	}else{
		       		$.messager.alert("系统信息","修改失败,请重新修改");
		       	}
		    }    
		}); 
	})
}); 
</script>
	<div style="padding: 10px;">
		系统设置 >> 课程管理
		<hr />

		<form action="" method="post" id="kcxg_edit_form">
			<!--<input type="hidden" name = "id"/>  -->
			<table>
				<tr>
					<td>课程名称:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>专业备注:</td>
					<td><input type="text" name="des" /></td>
				</tr>
				<tr>
					<td colspan="2"><a id="kcxg_edit_submit" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>