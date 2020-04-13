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
$(function(){
	$("#answer_submit").click(function(){
		$('#answer_form').form('submit', {   
			
		    url:"${pageContext.request.contextPath}/dt/save.action",    
		    onSubmit: function(param){ 
		    	var a = ${pb.size()};
		    	var myElement = $('input:radio:checked');
		    	var selquestion = new Array();
		    	var selanswer = new Array();
		    	var judquestion = new Array();
		    	var judanswer = new Array();
		    	for (var i = 0; i < myElement.length; i++) {
		    		if(myElement[i].value >4){
		    			judquestion.push(myElement[i].name);
		    			judanswer.push(myElement[i].value-4);
		    			debugger;
		    		}else{
		    			selquestion.push(myElement[i].name);
			    		selanswer.push(myElement[i].value);
		    			
		    		}
		    		//debugger;
				}
		    	param.selquestion=selquestion;
		    	param.selanswer=selanswer;
		    	param.judquestion=judquestion;
		    	param.judanswer=judanswer;
		    	var papername = "${pb[0].papername}";
		    	param.papername=papername;
		    	var studentid = "${pb[0].studentid}";
		    	param.studentid=studentid;
		    	param.courseid="${pb[0].courseid}";
		    	//alert("点击提交")
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(data){    
		       	if(data==1){
		       		$.messager.show({
		       			title:'系统消息',
		       			msg:'提交成功',
		       			timeout:3000,
		       			showType:'../succ.jsp'
		       			
		       		});
		       		location.href="sdt.jsp";
		       		//弹出框关闭
		       	}else{
		       		$.messager.alert("系统信息","修改失败,请重新修改");
		       	}
		    }    
		}); 
	})
}); 
	
	 
</script>
<body>
<form action="" method="post" id="answer_form">
 <c:forEach items="${pb }" var="per1">
	 <c:if test="${per1.type == 1}">
	   ${per1.question }<br><br>
	   <input type="radio"  name=${per1.question } value="1" />A
	   <input type="radio" name=${per1.question } value="2" />B
	    <input type="radio" name=${per1.question } value="3" />C
	     <input type="radio" name=${per1.question } value="4" />D
	    
	</c:if>
 	<c:if test="${per1.type == 2}">
	   ${per1.question }<br><br>
	   <input type="radio" checked="checked" name=${per1.question } value="5" />TRUE
	   <input type="radio"  name=${per1.question } value="6" />FALSE
	</c:if>

 	
     <br>
</c:forEach>
<a id="answer_submit" href="#"  class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a>
</form>
<br>
</body>
</html>