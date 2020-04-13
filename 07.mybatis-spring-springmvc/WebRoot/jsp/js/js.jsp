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
function abc(obj){
	/* var tem=$("#role_table").datagrid("getSelected");
	alert(tem); */
	/* if($("#role_table").datagrid("getSelections").length==1){} */
	$('#js_dialog').dialog({    
	    title: '院系管理',    
	    width: 400,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: 'js/jsck.jsp',    
	    modal: true,
	    onLoad:function(){
	    	$("#jsxg_edit_form :hidden:eq(0)").val($("#js_table").datagrid("getSelected").id);
	    	$("#jsxg_edit_form :hidden:eq(1)").val($("#js_table").datagrid("getSelected").powerid);
	    	$("#jsxg_edit_form :text:eq(0)").val($("#js_table").datagrid("getSelected").tno);
	    	$("#jsxg_edit_form :text:eq(1)").val($("#js_table").datagrid("getSelected").name);
	    	$("#jsxg_edit_form :text:eq(2)").val(formatDatebox($("#js_table").datagrid("getSelected").birthday));
	    	$("#jsxg_edit_form :text:eq(3)").val(formatDatebox($("#js_table").datagrid("getSelected").birthday));
	    	$("#jsxg_edit_form :text:eq(4)").val($("#js_table").datagrid("getSelected").nation);
	    	$("#jsxg_edit_form :text:eq(5)").val($("#js_table").datagrid("getSelected").tel);
	    	$("#jsxg_edit_form :text:eq(6)").val($("#js_table").datagrid("getSelected").email);
	    	$("#jsxg_edit_form :text:eq(7)").val($("#js_table").datagrid("getSelected").address);
	    	$("#jsxg_edit_form :text:eq(8)").val($("#js_table").datagrid("getSelected").position);
	    	//$("#jsxg_edit_form :text:eq(8)").val($("#js_table").datagrid("getSelected").password);
	    	//alert($("#role_table").datagrid("getSelected").setdate);
	    	$("#jsxg_edit_form :text:eq(9)").val($("#js_table").datagrid("getSelected").des);
	    }
		
	}); 
	$('#js_table').datagrid('clearSelections');
	
}
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
	$('#js_table').datagrid({    
	    url:'${pageContext.request.contextPath}/js/showAll.action',    
	    columns:[[     
	    	{field:'tno',title:'教师编号',width:100},   
	        {field:'name',title:'教师名称',width:100},    
	        {field:'sex',title:'性别',width:100},   
	        {field:'birthday',title:'出生日期',width:100,align:'right',formatter:formatDatebox},   
	        {field:'nation',title:'民族',width:100,align:'right'},   
	        {field:'des',title:'备注',width:100,align:'right'},
	        {field:'qwe',title:'操作',width:100,align:'right',
	        	formatter: function(value,row,index){
					return "<a href='javascript:void(0)' onclick='javascript:abc(this);return false;'>查看</a>";
				}
	        }
	    ]],
	    pagination:true,
	    pageList:[2,4,6],
	    fitColumns:true,
	    striped:true,
	    rownumbers:true,
	    toolbar: [{
			iconCls: 'icon-add',
			text:'增加',
			handler: function(){
				//alert('正在建设中');
				$('#js_dialog').dialog({    
				    title: '添加信息',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: 'js/jstj.jsp',    
				    modal: true,
				    onLoad:function(){
				    	
				    	
				    }
				}); 
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
				//alert('正在建设中');
				$.messager.confirm('Confirm', '确认删除?', function(r){
					if (r){
						//alert("删除");
						// exit action;
						if($("#bj_table").datagrid("getSelections").length!=0){
							var dd = new Array()
							for (i = 0; i < $("#js_table").datagrid("getSelections").length; i++) { 
								   dd.push($("#js_table").datagrid("getSelections")[i].id)
								 }
							 $.ajax({
					                cache:true,//保留缓存数据
					                type:"POST",//为post请求
					               url:"${pageContext.request.contextPath}/js/delet.action",//这是我在后台接受数据的文件名
					                data:{"del":dd},
					                async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
					                error:function(request){//请求失败之后的操作
					                    return;
					                },
					                success:function(data){//请求成功之后的操作
					                    console.log("success");
					                    $('#bj_table').datagrid('reload');    // reload the current page data
					                }
					            });
						}else{
							return false;
						}
						
					}
				});
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				if($("#js_table").datagrid("getSelections").length==1){
					//弹出窗口
					$('#js_dialog').dialog({    
					    title: '修改信息',    
					    width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,    
					   	href: 'js/jsxg.jsp',    
					    modal: true,
					    onLoad:function(){
					    	$("#jsxg_edit_form :hidden:eq(0)").val($("#js_table").datagrid("getSelected").id);
					    	$("#jsxg_edit_form :hidden:eq(1)").val($("#js_table").datagrid("getSelected").powerid);
					    	$("#jsxg_edit_form :text:eq(0)").val($("#js_table").datagrid("getSelected").tno);
					    	$("#jsxg_edit_form :text:eq(1)").val($("#js_table").datagrid("getSelected").name);
					    	$("#jsxg_edit_form :text:eq(2)").val($("#js_table").datagrid("getSelected").sex);
					    	$("#jsxg_edit_form :text:eq(3)").val(formatDatebox($("#js_table").datagrid("getSelected").birthday));
					    	$("#jsxg_edit_form :text:eq(4)").val($("#js_table").datagrid("getSelected").nation);
					    	$("#jsxg_edit_form :text:eq(5)").val($("#js_table").datagrid("getSelected").tel);
					    	$("#jsxg_edit_form :text:eq(6)").val($("#js_table").datagrid("getSelected").email);
					    	$("#jsxg_edit_form :text:eq(7)").val($("#js_table").datagrid("getSelected").address);
					    	$("#jsxg_edit_form :text:eq(8)").val($("#js_table").datagrid("getSelected").position);
					    	$("#jsxg_edit_form :text:eq(9)").val($("#js_table").datagrid("getSelected").password);
					    	//alert($("#role_table").datagrid("getSelected").setdate);
					    	$("#jsxg_edit_form :text:eq(10)").val($("#js_table").datagrid("getSelected").des);
					    	
					    }
					}); 
				}else{
					$.messager.alert("系统信息","请选择<b style='color:red;'>一行</b>")
				}
			}
		}]

	});
})
</script>
<table id="js_table" data-options="fit:true"></table> 
<div id="js_dialog"></div>  
</body>
</html>