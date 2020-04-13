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
	$("#pdtxg_edit_submit").click(function(){
		$('#pdtxg_edit_form').form('submit', {    
		    url:"${pageContext.request.contextPath}/pdt/update.action",    
		    onSubmit: function(){ 
		    	
		    	//var setd =$("#yxxg_edit_form :text:eq(1)").val;
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
		       		$("#pdt_dialog").dialog("close");
		       		$('#pdt_table').datagrid('reload');
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

		<form action="" method="post" id="pdtxg_edit_form">
			<input type="hidden" name="id" />
			<input type="hidden" name="courseid" />
			<table>
				<tr>
					<td>题目:</td>
					<td><input type="text" name="question" /></td>
				</tr>
				<tr>
					<td>标准答案:</td>
					<td><input type="text" name="answer" /></td>
				</tr>
				<tr>
					<td>出题老师:</td>
					<td><input type="text" name="teachername" /></td>
				</tr>
				<tr>
					<td>课程:</td>
					<td><input type="text" name="coursename" /></td>
				</tr>
				<tr>
					<td colspan="2"><a id="pdtxg_edit_submit" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>