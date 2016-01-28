<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="../js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script> 

</head>
<body>
<form action="../reglog/username" id="form1" method="get">  

<p>用户名：<input type="text" name="username" id="username"/></p>  
<p>密码：<input type="text" name="password" id="password"/></p>    
<p>类型：<input type="text" name="type" id="type"/></p>    
<p><input type="button" id="send" value="提交" onclick="login();"/></p>  
</form>  

<ul id="list">  </ul>  
</body>
</html>