<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/hospital.js"></script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/hospital.css"/>
</head>
<body>
<h2>天衡医院医生录入</h2>
<div id="add">
<form  id="form1" method="get">  

<p>工号：<input type="text" name="workNum" id="workNum"/></p>    

<p>医院ID：<input type="text" name="hospitalId" id="hospitalId"/></p>    

<p><input type="button" id="send" value="提交" onclick="add();"/></p>  
</form>
</div>

  
</body>
</html>