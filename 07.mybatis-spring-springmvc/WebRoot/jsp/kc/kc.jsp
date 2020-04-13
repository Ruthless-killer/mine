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
	$('#kc_table').datagrid({    
	    url:'${pageContext.request.contextPath}/kc/showAll.action',    
	    columns:[[        
	        {field:'name',title:'课程名称',width:100},    
	        {field:'des',title:'备注',width:100,align:'right'}
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
				$('#kc_dialog').dialog({    
				    title: '添加课程信息',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: 'kc/kctj.jsp',    
				    modal: true,
				    //无加载事件
				}); 
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){$.messager.confirm('Confirm', '确认删除?', function(r){
				if (r){
					//alert("删除");
					// exit action;
					if($("#kc_table").datagrid("getSelections").length!=0){
						var d = new Array()
						for (i = 0; i < $("#kc_table").datagrid("getSelections").length; i++) { 
							   d.push($("#kc_table").datagrid("getSelections")[i].id)
							 }
						debugger;
						 $.ajax({
				                cache:true,//保留缓存数据
				                type:"POST",//为post请求
				               url:"${pageContext.request.contextPath}/kc/delet.action",//这是我在后台接受数据的文件名
				                data:{"del":d},
				                async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
				                error:function(request){//请求失败之后的操作
				                    return;
				                },
				                success:function(data){//请求成功之后的操作
				                    console.log("success");
				                    $('#kc_table').datagrid('reload');    // reload the current page data
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
				if($("#kc_table").datagrid("getSelections").length==1){
					//弹出窗口
					$('#kc_dialog').dialog({    
					    title: '修改信息',    
					    width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,    
					    href: 'kc/kcxg.jsp',    
					    modal: true,
					    onLoad:function(){
					    	$("#kcxg_edit_form :hidden:eq(0)").val($("#kc_table").datagrid("getSelected").id);
					    	$("#kcxg_edit_form :text:eq(0)").val($("#kc_table").datagrid("getSelected").name);
					    	//$("#kcxg_edit_form :text:eq(1)").val($("#kc_table").datagrid("getSelected").setdate);
					    	$("#kcxg_edit_form :text:eq(1)").val($("#kc_table").datagrid("getSelected").des);
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
<table id="kc_table" data-options="fit:true"></table> 
<div id="kc_dialog"></div>  
</body>
</html>