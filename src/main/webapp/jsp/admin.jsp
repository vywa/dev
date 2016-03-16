<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>

  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.js"></script>
     <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>
	   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css">  
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/icon.css">  
        
    <script language="JavaScript">
        $(document).ready(function () {
 
        });
    </script>
    <style>
        .footer {
            width: 100%;
            text-align: center;
            line-height: 35px;
            
        }
 
        .top-bg {
            background-color: #d8e4fe;
            height: 80px;
        }
 
    </style>
    
</head>
 
<body class="easyui-layout">
    <div region="north" border="true" split="true" style="overflow: hidden; height: 80px;" >
        <div class="top-bg"  style="margin:0 auto; ">
        <div style="text-align:center; ">衡云后台管理系统</div>
        </div>
    
    </div>
    
    <div region="south" border="true" split="true" style="overflow: hidden; height: 40px;">
        <div class="footer">版权所有：<a href="http://www.tianhengyl.com/">衡云科技</a></div>
    </div>
    
    
   <div region="west" split="true" title="衡云后台管理菜单" style="width: 200px;">
 
        <div id="aa" class="easyui-accordion" style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">
 
            <div title="系统管理" iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree">
                    <li>
                        <span>系统管理</span>
                        <ul>
                            <li>
                                <span>用户管理</span>
                               <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">医生查看</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">病人查看</a></span>
                                    </li>
                                    <li>
                                        <span>管理员查看</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>日志查看</span>
                                 <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">访问日志</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">异常日志</a></span>
                                    </li>
                                    <li>
                                        <span><a href="#">非法操作日志</a></span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>登陆管理</span>
                                 <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">在线用户</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">登陆历史</a></span>
                                    </li>
                                    <li>
                                        <span>活跃用户</span>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                   
                </ul>
            </div>
           <div title="医院管理" iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree">
                    <li>
                        <span>医院管理</span>
                        <ul>
                            <li>
                                <span>医院管理</span>
                               <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">医生查看</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">病人查看</a></span>
                                    </li>
                                    <li>
                                        <span>管理员查看</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>科室管理</span>
                                 <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">访问日志</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">异常日志</a></span>
                                    </li>
                                    <li>
                                        <span><a href="#">非法操作日志</a></span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>医生管理</span>
                                 <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">在线用户</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">登陆历史</a></span>
                                    </li>
                                    <li>
                                        <span>活跃用户</span>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                   
                </ul>
            </div>
               <div title="在线会诊" iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree">
                    <li>
                        <span>会诊管理</span>
                        <ul>
                            <li>
                                <span>医生随访</span>
                               <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">医生查看</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">病人查看</a></span>
                                    </li>
                                    <li>
                                        <span>管理员查看</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>病人回访</span>
                                 <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">访问日志</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">异常日志</a></span>
                                    </li>
                                    <li>
                                        <span><a href="#">非法操作日志</a></span>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                   
                </ul>
            </div>
                 <div title="论坛管理" iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree">
                    <li>
                        <span>论坛管理</span>
                        <ul>
                            <li>
                                <span>帖子管理</span>
                               <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">医生查看</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">病人查看</a></span>
                                    </li>
                                    <li>
                                        <span>回复管理</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>模板管理</span>
                                 <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">访问日志</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">异常日志</a></span>
                                    </li>
                                    <li>
                                        <span><a href="#">非法操作日志</a></span>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                   
                </ul>
            </div>
                <div title="在线商城" iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree">
                    <li>
                        <span>在线商城</span>
                        <ul>
                            <li>
                                <span>我的订单</span>
                               <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">医生查看</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">病人查看</a></span>
                                    </li>
                                    <li>
                                        <span>商品在线</span>
                                    </li>
                                </ul>
                            </li> 
                               <li>
                                <span>商品在线</span>
                               <ul>
                                    <li>
                                        <span><a target="mainFrame" href="http://www.baidu.com">医生查看</a></span>
                                   </li>
                                    <li>
                                        <span><a href="#">病人查看</a></span>
                                    </li>
                                    <li>
                                        <span>商品在线</span>
                                    </li>
                                </ul>
                            </li> 
                        </ul>
                    </li>
                   
                </ul>
            </div>
              </div>
             
    </div>
    </div>
    <div id="mainPanle" region="center" style="overflow: hidden;">
   
    <div id="tabs" class="easyui-tabs" fit="true" border="false">  
  
            <div title="系统管理" style="padding: 20px; overflow: hidden;" id="home">  
  
                <table id="dg"
                toolbar="#tb"
                ></table>
  
            </div>  
  
        </div>
   
     <script language="javascript" type="text/javascript" >
	    var datagrid;  
	    var rowEditor=undefined;  
	    $(function(){  
	        datagrid=$("#dg").datagrid({  
	            url:"../hospital/showAll",			//加载的URL  
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
	                  
	                        {field:'address',title:'地址',width:100,editor : {  
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
	                                	var string ="";
	                                	var userId=rows[0].Cells["id"].Value;
	                                
	                                    $.ajax({  
	                                        url : '../hospital/delete',  
	                                        data :  'data={id:123456}',
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
	          
	        	   datagrid.datagrid('load',{  
	                   text:$("#text").val()  
	               });  
	        });  
	    })  
	 </script> 
 
    
    <div id="tb" style="padding:5px;height:auto">
    
	<div style="margin-bottom:5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
	</div>
	<div>
		Date From: <input class="easyui-datebox" style="width:80px">
		To: <input class="easyui-datebox" style="width:80px">
		Language: 
		<input class="easyui-combobox" style="width:100px"
				url="data/combobox_data.json"
				valueField="id" textField="text">
		<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
	</div>
</div>
    
    
   <div id="tb" style="padding:3px">
	<span>Item ID:</span>
	<input id="itemid" style="line-height:26px;border:1px solid #ccc">
	<span>Product ID:</span>
	<input id="productid" style="line-height:26px;border:1px solid #ccc">
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
</div>
   
   <script language="JavaScript">  
   
       $(document).ready(function () {  
           $('.easyui-accordion li a').click(function () {  
               var tabTitle = $(this).text();  
               var url = $(this).attr("href");  
               addTab(tabTitle, url);  
               $('.easyui-accordion li div').removeClass("selected");  
               $(this).parent().addClass("selected");  
           }).hover(function () {  
               $(this).parent().addClass("hover");  
           }, function () {  
               $(this).parent().removeClass("hover");  
           });  
   
           function addTab(subtitle, url) {  
               if (!$('#tabs').tabs('exists', subtitle)) {  
                   $('#tabs').tabs('add', {  
                       title: subtitle,  
                       content: createFrame(url),  
                       closable: true,  
                       width: $('#mainPanle').width() - 10,  
                       height: $('#mainPanle').height() - 26  
                   });  
               } else {  
                   $('#tabs').tabs('select', subtitle);  
              }  
               tabClose();  
           }  
   
   
           function createFrame(url) {  
               var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';  
               return s;  
           }  
   
   
           function tabClose() {  
               /*双击关闭TAB选项卡*/  
               $(".tabs-inner").dblclick(function () {  
                   var subtitle = $(this).children("span").text();  
                   $('#tabs').tabs('close', subtitle);  
               })  
   
               $(".tabs-inner").bind('contextmenu', function (e) {  
                   $('#mm').menu('show', {  
                       left: e.pageX,  
                       top: e.pageY,  
                   });  
                   var subtitle = $(this).children("span").text();  
                   $('#mm').data("currtab", subtitle);  
                   return false;  
               });  
           }  
   
           //绑定右键菜单事件  
      function tabCloseEven() {  
               //关闭当前  
        $('#mm-tabclose').click(function () {  
                   var currtab_title = $('#mm').data("currtab");  
                   $('#tabs').tabs('close', currtab_title);  
               })  
               //全部关闭  
        $('#mm-tabcloseall').click(function () {  
                   $('.tabs-inner span').each(function (i, n) {  
                       var t = $(n).text();  
                      $('#tabs').tabs('close', t);  
                   });  
               });  
   
               //关闭除当前之外的TAB  
               $('#mm-tabcloseother').click(function () {  
                   var currtab_title = $('#mm').data("currtab");  
                   $('.tabs-inner span').each(function (i, n) {  
                       var t = $(n).text();  
                       if (t != currtab_title)  
                           $('#tabs').tabs('close', t);  
                   });  
               });  
               //关闭当前右侧的TAB  
               $('#mm-tabcloseright').click(function () {  
                   var nextall = $('.tabs-selected').nextAll();  
                   if (nextall.length == 0) {  
                      //msgShow('系统提示','后边没有啦~~','error');  
                       alert('后边没有啦~~');  
                       return false;  
                   }  
                   nextall.each(function (i, n) {  
                       var t = $('a:eq(0) span', $(n)).text();  
                       $('#tabs').tabs('close', t);  
                   });  
                   return false;  
              });  
               //关闭当前左侧的TAB  
               $('#mm-tabcloseleft').click(function () {  
                   var prevall = $('.tabs-selected').prevAll();  
                   if (prevall.length == 0) {  
                       alert('到头了，前边没有啦~~');  
                       return false;  
                   }  
                   prevall.each(function (i, n) {  
                       var t = $('a:eq(0) span', $(n)).text();  
                       $('#tabs').tabs('close', t);  
                   });  
                   return false;  
               });  
   
               //退出  
               $("#mm-exit").click(function () {  
                   $('#mm').menu('hide');  
   
               })  
           }  
       });
</body>

</html>