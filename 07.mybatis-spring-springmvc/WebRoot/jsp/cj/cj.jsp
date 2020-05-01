<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">   
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>   
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script> 
<title>院系信息管理</title>
</head>
<body>

<script type="text/javascript">
/**
 * easyUI时间戳转日期格式
 */
function formatDatebox(val) {
	//alert(value);
	 var date = new Date(val);
     var y = date.getFullYear();
     var m = date.getMonth() + 1;
     var d = date.getDate();
   //  alert(y);
     return y + '-' + m + '-' + d;

}


$(function(){
	$('#cj_table').datagrid({    
	    url:'${pageContext.request.contextPath}/cj/showAll.action',    
	    columns:[[ 
	    	{field:'studentname',title:'学生姓名',width:100}, 
	    	{field:'coursename',title:'课程名称',width:100},
	    	{field:'papername',title:'试卷名称',width:100},
	    	{field:'grade',title:'成绩',width:100},
	        
	    ]],
	    pagination:true,
	    pageList:[2,4,6],
	    fitColumns:true,
	    striped:true,
	    rownumbers:true,
	});
})
</script>
<table id="cj_table" data-options="fit:true"></table> 
<div id="cj_dialog"></div>  
</body>
</html>