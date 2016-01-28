<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/kkpager.js"></script>
     <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.easyui.min.js"></script>
	
	
	 
	 
</head>
<body>
 <script language="javascript" type="text/javascript" >
	    var datagrid;  
	    var rowEditor=undefined;  
	    $(function(){  
	        datagrid=$("#dg").datagrid({  
	            url:"'../hospital/showAll",//加载的URL  
	            isField:"id",  
	            pagination:true,//显示分页  
	            pageSize:5,//分页大小  
	            pageList:[5,10,15,20],//每页的个数  
	            fit:true,//自动补全  
	            fitColumns:true,  
	            iconCls:"icon-save",//图标  
	            title:"用户管理",  
	            columns:[[      //每个列具体内容  
	                      {  
	                          field:'id',  
	                          title:'医院Id',  
	                          width:100,  
	                          editor : {//是否可编辑  
	                                type : 'validatebox',  
	                                options : {//必须校验  
	                                    required : true  
	                                }  
	                            }  
	                     },     
	                      {field:'hospitalName',title:'医院名',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }},     
	                      {field:'level',title:'医院等级',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }},    
	                        {field:'adress',title:'地址',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }},    
	                        {field:'telephone',title:'电话',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }},    
	                        {field:'email',title:'邮件',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }},    
	                        {field:'hospitalIM',title:'及时通信',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }},    
	                        {field:'weiChatNumber',title:'公众号',width:100,editor : {  
	                            type : 'validatebox',  
	                            options : {  
	                                required : true  
	                            }  
	                        }}
	                  ]],  
	            toolbar:[              //工具条  
	                    {text:"增加",iconCls:"icon-add",handler:function(){//回调函数  
	                        if(rowEditor==undefined)  
	                        {  
	                            datagrid.datagrid('insertRow',{//如果处于未被点击状态，在第一行开启编辑  
	                                index: 0,     
	                                row: {  
	                                }  
	                            });  
	                            rowEditor=0;  
	                            datagrid.datagrid('beginEdit',rowEditor);//没有这行，即使开启了也不编辑  
	                              
	                        }  
	                      
	      
	                    }},  
	                    {text:"删除",iconCls:"icon-remove",handler:function(){  
	                        var rows=datagrid.datagrid('getSelections');  
	                
	                        if(rows.length<=0)  
	                        {  
	                            $.messager.alert('警告','您没有选择','error');  
	                        }  
	                        else if(rows.length>1)  
	                        {  
	                            $.messager.alert('警告','不支持批量删除','error');  
	                        }  
	                        else  
	                        {  
	                            $.messager.confirm('确定','您确定要删除吗',function(t){  
	                                if(t)  
	                                {  
	                                      
	                                    $.ajax({  
	                                        url : '../hospital/delete',  
	                                        data : rows[0],  
	                                        dataType : 'json',  
	                                        success : function(r) {  
	                                            if (r.success) {  
	                                                datagrid.datagrid('acceptChanges');  
	                                                $.messager.show({  
	                                                    msg : r.msg,  
	                                                    title : '成功'  
	                                                });  
	                                                editRow = undefined;  
	                                                datagrid.datagrid('reload');  
	                                            } else {  
	                                                /*datagrid.datagrid('rejectChanges');*/  
	                                                datagrid.datagrid('beginEdit', editRow);  
	                                                $.messager.alert('错误', r.msg, 'error');  
	                                            }  
	                                            datagrid.datagrid('unselectAll');  
	                                        }  
	                                    });  
	                                  
	                                }  
	                            })  
	                        }  
	                          
	                          
	                    }},  
	                    {text:"修改",iconCls:"icon-edit",handler:function(){  
	                        var rows=datagrid.datagrid('getSelections');  
	                        if(rows.length==1)  
	                        {  
	                            if(rowEditor==undefined)  
	                            {  
	                                var index=datagrid.datagrid('getRowIndex',rows[0]);  
	                                 rowEditor=index;  
	                                datagrid.datagrid('unselectAll');  
	                                datagrid.datagrid('beginEdit',index);  
	                                  
	                            }  
	                        }  
	                    }},  
	                    {text:"查询",iconCls:"icon-search",handler:function(){}},  
	                    {text:"保存",iconCls:"icon-save",handler:function(){  
	                          
	                        datagrid.datagrid('endEdit',rowEditor);  
	                        rowEditor=undefined;  
	                    }},  
	                    {text:"取消编辑",iconCls:"icon-redo",handler:function(){  
	                        rowEditor=undefined;  
	                        datagrid.datagrid('rejectChanges')  
	                    }}  
	                    ],  
	            onAfterEdit:function(rowIndex, rowData, changes){  
	                var inserted = datagrid.datagrid('getChanges', 'inserted');  
	                var updated = datagrid.datagrid('getChanges', 'updated');  
	                if (inserted.length < 1 && updated.length < 1) {  
	                    editRow = undefined;  
	                    datagrid.datagrid('unselectAll');  
	                    return;  
	                }  
	      
	                var url = '';  
	                if (inserted.length > 0) {  
	                    url = '../hospital/add';  
	                }  
	                if (updated.length > 0) {  
	                    url = '../hospital/update';  
	                }  
	      
	                $.ajax({  
	                    url : url,  
	                    data : rowData,  
	                    dataType : 'json',  
	                    success : function(r) {  
	                        if (r.success) {  
	                            datagrid.datagrid('acceptChanges');  
	                            $.messager.show({  
	                                msg : r.msg,  
	                                title : '成功'  
	                            });  
	                            editRow = undefined;  
	                            datagrid.datagrid('reload');  
	                        } else {  
	                            /*datagrid.datagrid('rejectChanges');*/  
	                            datagrid.datagrid('beginEdit', editRow);  
	                            $.messager.alert('错误', r.msg, 'error');  
	                        }  
	                        datagrid.datagrid('unselectAll');  
	                    }  
	                });  
	                  
	            },  
	            onDblClickCell:function(rowIndex, field, value){  
	                if(rowEditor==undefined)  
	                {  
	                    datagrid.datagrid('beginEdit',rowIndex);  
	                    rowEditor=rowIndex;  
	                }  
	                  
	            }  
	        });  
	        $("#search").click(function(){  
	          
	      
	        });  
	        datagrid.datagrid('load',{  
                text:$("#text").val()  
            });  
	          
	    })  
	 </script>
<table id="dg" title="医院信息管理" style="width:550px;height:250px"
		toolbar="#toolbar" idField="id"
		rownumbers="true" fitColumns="true" singleSelect="true">
	<thead>
		<tr>
			<th field="id" width="50" editor="{type:'validatebox',options:{required:true}}">医院Id</th>
			<th field="hospitalName" width="50" editor="{type:'validatebox',options:{required:true}}">医院名</th>
			<th field="level" width="50" editor="text">等级</th>
			<th field="address" width="50" editor="{type:'validatebox',options:{validType:'email'}}">地址</th>
			<th field="telephone" width="50" editor="{type:'validatebox',options:{required:true}}">电话</th>
			<th field="email" width="50" editor="{type:'validatebox',options:{required:true}}">邮件</th>
			<th field="hospitalIM" width="50" editor="text">及时通信</th>
			<th field="weiChatNumber" width="50" editor="{type:'validatebox',options:{validType:'email'}}">公众号</th>
		</tr>
	</thead>
</table>




</body>
</html>