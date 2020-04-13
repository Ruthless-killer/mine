<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teacher menu</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/icon.css">
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#dy').tree({
			//url : 'yx/dytj.jsp',
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "院系信息管理") == null) {
					//alert(node);
					$('#main_tabs').tabs('add', {
						title : "院系信息管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'yx/yx.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#zy').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "专业信息管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "专业信息管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'zy/zy.jsp',
						closable : true
					});
				} else {
					//alert(node);
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#bj').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "班级信息管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "班级信息管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'bj/bj.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#xs').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "学生信息管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "学生信息管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'xs/xs.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#js').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "教师信息管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "教师信息管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'js/js.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#kc').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "课程信息管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "课程信息管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'kc/kc.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#xzt').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "选择题管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "选择题管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'xzt/xzt.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#pdt').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "判断题管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "判断题管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'pdt/pdt.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#ct').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "出题") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "出题",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'ct/ct.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
	$(function() {
		$('#cj').tree({
			
			onClick : function(node) {
				if ($("#main_tabs").tabs("getTab", "成绩管理") == null) {
					//alert(node.text);
					$('#main_tabs').tabs('add', {
						title : "成绩管理",
						selected : true,
						//content:'<b>adsfadsf</b>'
						//只能引进来<body>标签的内容
						href : 'cj/cj.jsp',
						closable : true
					});
				} else {
					$("#main_tabs").tabs("select", node.text);
				}
				//alert("aaa");
			}
		});
	})
</script>
</head>
<body>
<body class="easyui-layout">
	<div data-options="region:'north',title:'至尊管理系统'"
		style="height: 100px;">
		<div
			style="width: 400px; height: 70px; float: left; font-size: 20px; font-weight: bold; line-height: 70px; padding-left: 20px;">
			题库管理系统</div>
		<div
			style="width: 200px; height: 70px; float: right; line-height: 70px;">
			您好,${user.userName },欢迎登录!</div>
	</div>
	<!-- <div data-options="region:'south',title:'底部声明'" style="height:100px;">
    	<div style="height:70px; line-height: 70px; text-align:center;color:gray">
    		
    	</div>
    </div>    -->
	<div data-options="region:'west',title:'菜单'" style="width: 200px;">
		<ul id="tt" class="easyui-tree">
			<li><span>系统管理</span>
				<ul>
					<li><span><a id="dy" href="#">院系信息管理</a></span></li>
					<li><span><a id="zy" href="#">专业信息管理</a></span></li>
					<li><span><a id="bj" href="#">班级信息管理</a></span></li>
					<li><span><a id="kc" href="#">课程信息管理</a></span></li> 
					<li><span><a id="xs" href="#">学生信息管理</a></span></li>
					<li><span><a id="js" href="#">教师信息管理</a></span></li> 
					
				</ul>
			</li>
			<li><span>题库管理</span>
				<ul>
					<li><span><a id="xzt" href="#">选择题</a></span></li>
					<li><span><a id="pdt" href="#">判断题</a></span></li>
				</ul>
			</li>
			<li><span>考试管理</span>
				<ul>
					<li><span><a id="ct" href="#">生成试卷</a></span></li>
					<li><span><a id="cj" href="#">成绩管理</a></span></li>
				</ul>
			</li>

		</ul>
	</div>
	<div data-options="region:'center',title:'内容'"
		style="padding: 5px; background: #eee;">
		<div id="main_tabs" class="easyui-tabs"
			style="width: 500px; height: 250px;" data-options="fit:true">
			<div title="首页" style="padding: 20px;">tab1 阿斯蒂芬</div>

		</div>
	</div>
</body>

</body>
</html>