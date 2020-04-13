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
	$("#ct_edit_submit").click(function(){
		$('#ct_edit_form').form('submit', {    
		   	url:"${pageContext.request.contextPath}/ct/ct.action",    
		    onSubmit: function(){ 
		    	
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		       if(data==1){
		    	   alert("出题成功");
		       }else{
		    	   alert("出题失败");
		       }
		      
		    }    
		}); 
	})
});
</script>
	<div style="padding: 10px;">
		系统设置 >> 教师信息管理
		<hr />

		<form action="" method="post" id="ct_edit_form">
			<h1>请填写要生成试卷的信息</h1>
			<table>
				<tr>
					<td>试卷名称:</td>
					<td><input type="text" name="papername" /></td>
				</tr>
				<tr>
					<td>所属课程:</td>
					<td><input type="text" name="coursename" /></td>
				</tr>
				<tr>
					<td>选择题数量:</td>
					<td><input type="number" name="selectnumber" /></td>
					<td>每题分值:</td>
					<td><input type="text" name="selectscore" /></td>
				</tr>
				<tr>
					<td>判断题数量:</td>
					<td><input type="number" name="judgenumber" /></td>
					<td>每题分值:</td>
					<td><input type="number" name="judgescore" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><a id="ct_edit_submit" href="#"
						class="easyui-linkbutton" data-options="iconCls:'icon-search'">保存</a>
					</td>
				</tr>
				
				
			</table>
		</form>
	</div>

</body>
</html>