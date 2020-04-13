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
<title>学生信息管理</title>
</head>
<body>
<script type="text/javascript">
function abc(obj){
	/* var tem=$("#role_table").datagrid("getSelected");
	alert(tem); */
	/* if($("#role_table").datagrid("getSelections").length==1){} */
	$('#xs_dialog').dialog({    
	   // title: '学生管理',    
	    width: 400,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: 'xs/xsck.jsp',    
	    modal: true,
	    onLoad:function(){
	    	$("#xsxg_edit_form :hidden:eq(0)").val($("#xs_table").datagrid("getSelected").id);
	    	$("#xsxg_edit_form :hidden:eq(0)").val($("#xs_table").datagrid("getSelected").clssid);
	    	$("#xsxg_edit_form :text:eq(0)").val($("#xs_table").datagrid("getSelected").sno);
	    	$("#xsxg_edit_form :text:eq(1)").val($("#xs_table").datagrid("getSelected").name);
	    	$("#xsxg_edit_form :text:eq(2)").val($("#xs_table").datagrid("getSelected").sex);
	    	$("#xsxg_edit_form :text:eq(3)").val(formatDatebox($("#xs_table").datagrid("getSelected").birthday));
	    	$("#xsxg_edit_form :text:eq(4)").val($("#xs_table").datagrid("getSelected").nation);
	    	$("#xsxg_edit_form :text:eq(5)").val($("#xs_table").datagrid("getSelected").tel);
	    	$("#xsxg_edit_form :text:eq(6)").val($("#xs_table").datagrid("getSelected").email);
	    	$("#xsxg_edit_form :text:eq(7)").val($("#xs_table").datagrid("getSelected").address);
	    	$("#xsxg_edit_form :text:eq(8)").val($("#xs_table").datagrid("getSelected").classname);
	    	$("#xsxg_edit_form :text:eq(9)").val($("#xs_table").datagrid("getSelected").des);  
	    }
		
	}); 
	$('#xs_table').datagrid('clearSelections');
	
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
	$('#xs_table').datagrid({    
	    url:'${pageContext.request.contextPath}/xs/showAll.action',    
	    columns:[[  
	    	{field:'sno',title:'学号',width:100},  
	        {field:'name',title:'学生姓名',width:100}, 
	        {field:'sex',title:'学生性别',width:100},  
	        {field:'nation',title:'民族',width:100},  
	        {field:'classid',title:'班级',width:100},
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
				$('#xs_dialog').dialog({    
				    title: '添加信息',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: 'xs/xstj.jsp',    
				    modal: true,
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
						if($("#xs_table").datagrid("getSelections").length!=0){
							var dd = new Array()
							for (i = 0; i < $("#xs_table").datagrid("getSelections").length; i++) { 
								   dd.push($("#xs_table").datagrid("getSelections")[i].id)
								 }
							 $.ajax({
					                cache:true,//保留缓存数据
					                type:"POST",//为post请求
					                url:"${pageContext.request.contextPath}/xs/delet.action",//这是我在后台接受数据的文件名
					                data:{"del":dd},
					                async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
					                error:function(request){//请求失败之后的操作
					                    return;
					                },
					                success:function(data){//请求成功之后的操作
					                    console.log("success");
					                    $('#xs_table').datagrid('reload');    // reload the current page data
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
				if($("#xs_table").datagrid("getSelections").length==1){
					//弹出窗口
					$('#xs_dialog').dialog({    
					    title: '修改信息',    
					    width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,    
					   href: 'xs/xsxg.jsp',    
					    modal: true,
					    onLoad:function(){
					    	$("#xsxg_edit_form :hidden:eq(0)").val($("#xs_table").datagrid("getSelected").id);
					    	$("#xsxg_edit_form :hidden:eq(1)").val($("#xs_table").datagrid("getSelected").classid);
					    	$("#xsxg_edit_form :text:eq(0)").val($("#xs_table").datagrid("getSelected").sno);
					    	$("#xsxg_edit_form :text:eq(1)").val($("#xs_table").datagrid("getSelected").name);
					    	$("#xsxg_edit_form :text:eq(2)").val($("#xs_table").datagrid("getSelected").sex);
					    	$("#xsxg_edit_form :text:eq(3)").val(formatDatebox($("#xs_table").datagrid("getSelected").birthday));
					    	$("#xsxg_edit_form :text:eq(4)").val($("#xs_table").datagrid("getSelected").nation);
					    	$("#xsxg_edit_form :text:eq(5)").val($("#xs_table").datagrid("getSelected").tel);
					    	$("#xsxg_edit_form :text:eq(6)").val($("#xs_table").datagrid("getSelected").email);
					    	$("#xsxg_edit_form :text:eq(7)").val($("#xs_table").datagrid("getSelected").address);
					    	$("#xsxg_edit_form :text:eq(8)").val($("#xs_table").datagrid("getSelected").classname);
					    	$("#xsxg_edit_form :text:eq(9)").val($("#xs_table").datagrid("getSelected").password); 
					    	$("#xsxg_edit_form :text:eq(10)").val($("#xs_table").datagrid("getSelected").des);
					    	
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
<table id="xs_table" data-options="fit:true"></table> 
<div id="xs_dialog"></div>  
</body>
</html>