<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/account.js"></script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/account.css"/>
</head>

<body>
<div id="add">
<form action="../account/add" id="form1" method="get">  
<p>用户Id：<input type="text" name="id" id="id"/></p>  
<p>用户类别：<input type="text" name="catagory" id="catagory"/></p>  
<p>用户名：<input type="text" name="username" id="username"/></p>    
<p>手机号：<input type="text" name="mobilephone" id="mobilephone"/></p>    
<p>邮箱：<input type="text" name="email" id="email"/></p>  
<p>工号：<input type="text" name="workNum" id="workNum"/></p>    
<p>QQ：<input type="text" name="QQ" id="QQ"/></p>    
<p>微信号：<input type="text" name="weiChat"  id="weiChat"/></p>  
<p>微博：<input type="text" name="weiBo"  id="weiBo"/></p>  
<p>密码：<input type="text" name="password"  id="password"/></p>  
<p>状态：<input type="text" name="status"  id="status"/></p>  
<p><input type="button" id="send" value="提交" onclick="add();"/></p>  
</form>
</div>

  
</body>
</html>