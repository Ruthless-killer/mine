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


<body>
<form action="" method="post" id="answer_form">
 <c:forEach items="${cj }" var="per1">
	${per1.grade }

 	
     <br>
</c:forEach>

</form>
<br>
</body>
</html>