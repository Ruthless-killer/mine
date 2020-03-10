<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function ks2(sobj) {
		var docurl = sobj.options[sobj.selectedIndex].value;
		if (docurl != "") {
			open(docurl, '_blank');
			sobj.selectedIndex = 0;
			sobj.blur();
		}
	}
</script>
<body>
	请选择考试科目
	<br />
	<select onclick="ks2(this)" name="select">
		<c:forEach items="${list}" varStatus="i" var="item">
			<option><input type="button" value="${list.name}" />
			</option>

		</c:forEach>
	</select>

</body>
</html>