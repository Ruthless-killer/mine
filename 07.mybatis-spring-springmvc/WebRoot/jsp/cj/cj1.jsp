<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="../../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../js/easyui/themes/icon.css">
<script type="text/javascript" src="../../js/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="../../js/easyui/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>

<script type="text/javascript">
  $(window).load(function() {
	//alert("aa");
	$.ajax({
		cache : true,//保留缓存数据
		type : "POST",//为post请求
		url : "${pageContext.request.contextPath}/cj/showOne.action",//这是我在后台接受数据的文件名

		async : false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
		error : function(request) {//请求失败之后的操作
			return;
		},
		success : function(data) {//请求成功之后的操作
			console.log("data");
			
			// $('#xzt_table').datagrid('reload');    // reload the current page data
		}
	});
})  

</script>
<body>
<h1>查看成绩</h1>
<div class="table-a">
<table  border="1">
<c:forEach items="${cj }" var="per1">
 	<tr >
 	<td>${per1.coursename }</td>
 	<td>${per1.grade }</td>
 	</tr>
     <br>
</c:forEach>
</table>



</div>
 

<br>
</body>
</html>