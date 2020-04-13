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
	/* $(function(){
	 $("#getUserid").combobox({          
	 //后台返回的 json 数据方法地址         
	 url:'${pageContext.request.contextPath}/dt/selp.action',
	 valueField:'courseid',//相当于option的value值
	 textField:'papername',//相当于<option></option>之间的显示值 value:1000    //默认显示值

	 });
	 }) ; */
	$(window).load(function() {
		//alert("aa");
		$.ajax({
			cache : true,//保留缓存数据
			type : "POST",//为post请求
			url : "${pageContext.request.contextPath}/dt/selp.action",//这是我在后台接受数据的文件名

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
	 function myClick() {
		// alert("aaaaas");
		 //window.location = "http://www.baidu.com";
		 //var= this.name;
		 var papername= document.getElementById("bt").value;
		 debugger;
		 var courseid= document.getElementById("bt").name;
		 
		 $.ajax({
				cache : true,//保留缓存数据
				type : "POST",//为post请求
				url : "${pageContext.request.contextPath}/dt/dt.action",//这是我在后台接受数据的文件名
				data:{"papername":papername,"courseid":courseid},
				async : false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
				error : function(request) {//请求失败之后的操作
					return;
				},
				success : function(data) {//请求成功之后的操作
					console.log("data");
				 	if(data==1){
				 		location.href="sdt.jsp"
				 	}
				 	
					
					// $('#xzt_table').datagrid('reload');    // reload the current page data
				}
			});
	}	
</script>
<body>
	<!--  <input id="getUserid" style="line-height: 20px; border: 1px solid #ccc"> -->

<br>
 <c:forEach items="${list }" var="per1">
 	
 
 	<input type="submit" id = "bt" name=${per1.value } value=${per1.key } onclick="myClick()">
     <br>
</c:forEach>
<br>
</body>
</html>