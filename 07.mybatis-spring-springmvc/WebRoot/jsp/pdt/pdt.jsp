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
<title>判断题管理</title>
</head>
<body>
<script type="text/javascript">
function abc(obj){
	/* var tem=$("#role_table").datagrid("getSelected");
	alert(tem); */
	/* if($("#role_table").datagrid("getSelections").length==1){} */
	$('#role_dialog').dialog({    
	 //   title: '院系管理',    
	    width: 400,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: 'xzt/xztck.jsp',    
	    modal: true,
	    onLoad:function(){
	    	$("#xztxg_edit_form :hidden:eq(0)").val($("#xzt_table").datagrid("getSelected").id);
	    	$("#xztxg_edit_form :hidden:eq(1)").val($("#xzt_table").datagrid("getSelected").courseid);
	    	$("#xztxg_edit_form :text:eq(0)").val($("#xzt_table").datagrid("getSelected").question);
	    	$("#xztxg_edit_form :text:eq(1)").val($("#xzt_table").datagrid("getSelected").answer);
	    	$("#xztxg_edit_form :text:eq(2)").val($("#xzt_table").datagrid("getSelected").teachername);
	    	$("#xztxg_edit_form :text:eq(0)").val($("#xzt_table").datagrid("getSelected").coursername);
	    	
	    }
		
	}); 
	$('#role_table').datagrid('clearSelections');
	
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
	$('#pdt_table').datagrid({    
	    url:'${pageContext.request.contextPath}/pdt/showAll.action',    
	    columns:[[        
	        {field:'question',title:'题目',width:100},    
	        {field:'answer',title:'标准答案',width:100,align:'right'},    
	        {field:'teachername',title:'出题人',width:100,align:'right'},
	        {field:'coursename',title:'课程',width:100,align:'right'},
	        {field:'coursename',title:'备注',width:100,align:'right'}
	        /* {field:'qwe',title:'操作',width:100,align:'right',
	        	formatter: function(value,row,index){
					return "<a href='javascript:void(0)' onclick='javascript:abc(this);return false;'>查看</a>";
				}
	        } */
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
				$('#xzt_dialog').dialog({    
				    title: '添加信息',    
				    width: 400,    
				    height: 200,    
				    closed: false,    
				    cache: false,    
				    href: 'xzt/xzttj.jsp',    
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
						if($("#pdt_table").datagrid("getSelections").length!=0){
							var dd = new Array();
							for (i = 0; i < $("#xzt_table").datagrid("getSelections").length; i++) { 
								   dd.push($("#xzt_table").datagrid("getSelections")[i].id)
							}
							 $.ajax({
					                cache:true,//保留缓存数据
					                type:"POST",//为post请求
					                url:"${pageContext.request.contextPath}/pdt/delet.action",//这是我在后台接受数据的文件名
					                
					                data:{"dele":dd,"s":"hello"},
					                async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
					                error:function(request){//请求失败之后的操作
					                    return;
					                },
					                success:function(data){//请求成功之后的操作
					                    console.log("success");
					                    $('#xzt_table').datagrid('reload');    // reload the current page data
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
				if($("#pdt_table").datagrid("getSelections").length==1){
					//弹出窗口
					$('#pdt_dialog').dialog({    
					    title: '修改信息',    
					    width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,    
					    href: 'pdt/pdtxg.jsp',    
					    modal: true,
					    onLoad:function(){
					    	$("#pdtxg_edit_form :hidden:eq(0)").val($("#pdt_table").datagrid("getSelected").id);
					    	$("#pdtxg_edit_form :hidden:eq(1)").val($("#pdt_table").datagrid("getSelected").courseid);
					    	$("#pdtxg_edit_form :text:eq(0)").val($("#pdt_table").datagrid("getSelected").question);
					    	$("#pdtxg_edit_form :text:eq(1)").val($("#pdt_table").datagrid("getSelected").answer);
					    	$("#pdtxg_edit_form :text:eq(2)").val($("#pdt_table").datagrid("getSelected").teachername);
					    	$("#pdtxg_edit_form :text:eq(3)").val($("#pdt_table").datagrid("getSelected").coursename);
					    	
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
<table id="pdt_table" data-options="fit:true"></table> 
<div id="pdt_dialog"></div>  
</body>
</html>