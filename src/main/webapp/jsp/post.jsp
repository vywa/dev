<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/post.js"></script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/account.css"/>
</head>
<body>

<div id="add">
<form action="../account/add" id="form1" method="get">  



<p>主题：<input type="text" name="theme" id="theme"/></p>    

<p>帖子内容：<input type="text" name="content" id="content"/></p>    
<p>帖子标题：<input type="text" name="title" id="title"/></p>    

<p><input type="button" id="send" value="提交" onclick="add();"/></p>  

</form>
</div>

  
</body>
</html>