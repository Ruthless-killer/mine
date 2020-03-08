<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	function c1(){
		window.location.href="../kaoshi1.jsp"
	}
	function c2(){
		window.location.href="../chaxun1.jsp"
	}
		
	
</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<h1>欢迎进入在线考试系统</h1>
			当前用户:<font> ${student.name}</font>


		</div>
		<div>
			<input type="button" name="ks" value="我要考试" onclick="c1" />
			<input type="button" name="cx" value="查询成绩" onclick="c2" />
			
		</div>


	</body>
</html>
