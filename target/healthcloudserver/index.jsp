<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>衡云后台管理首页</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="../js/login.js"></script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/home.css"/>
</head>
<body>
<body>
<div id="content">
<div id="adaptor">
<div id="left">
<div id="lcontent" >
<div>衡云后台管理系统</div>
</div>
</div>

<div id="right">
<div id="rcontent">
<form id="form1" action="../reglog/username">
<div>用户名:<input type="text"></div>
<div>密　码:<input type="password"></div>
<div>验证码:<img src="" /></div>
<div><input type="button" value="登陆" onclick=login(); ></div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>