<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/post.js"></script>
  <script language="javascript" type="text/javascript" >
  $.ajax({
      type: "get",
      dataType: "json",
      url: "../post/index",
      data:'data={id:${param.id}}',
      success: function (msg) {
       $("#id").val(msg.id);
       $("#forumPlateId").val(msg.forumPlateId);
       $("#theme").val(msg.theme);
       $("#userId").val(msg.userId);
       $("#deliveryTime").val(msg.deliveryTime);
       $("#content").val(msg.content);
       $("#title").val(msg.title);
       $("#status").val(msg.status);
       $("#level").val(msg.level);
       $("#commnetList").val(msg.commnetList);
    
      }
  });
 
  </script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/account.css"/>
</head>
<body>
<div id="add">
<form action="..//add" id="form1" method="get">  

<p>帖子ID：<input type="text" name="id" id="id"/></p>  
<p>所属板块：<input type="text" name="forumPlateId" id="forumPlateId"/></p>  
<p>主题：<input type="text" name="theme" id="theme"/></p>    
<p>发帖作者：<input type="text" name="userId" id="userId"/></p>    
<p>发帖时间：<input type="text" name="deliveryTime" id="deliveryTime"/></p>  
<p>帖子内容：<input type="text" name="content" id="content"/></p>    
<p>帖子标题：<input type="text" name="title" id="title"/></p>    
<p>帖子状态：<input type="text" name="status"  id="status"/></p>  
<p>帖子等级：<input type="text" name="level"  id="level"/></p>  
<p>评论列表：<input type="text" name="commnetList"  id="commnetList"/></p>  
<p><input type="button" id="send" value="提交" onclick="update();"/></p>  
</form>
</div>
  
</body>
</html>