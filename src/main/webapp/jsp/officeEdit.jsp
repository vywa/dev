<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/office.js"></script>
  <script language="javascript" type="text/javascript" >
  $.ajax({
      type: "get",
      dataType: "json",
      url: "../office/query",
      data:'officeId=${param.officeId}',
      success: function (msg) {
       $("#officeId").val(msg.officeId);
       $("#hospitalId").val(msg.hospitalId);
       $("#officeName").val(msg.officeName);
       $("#description").val(msg.description);
     
      }
  });

  </script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/account.css"/>
</head>
<body>
<div id="add">
<form action="../office/update" id="form1" method="get">  
<p>科室编号：<input type="text" name="officeId" id="officeId"/></p>  
<p>医院Id：<input type="text" name="hospitalId" id="hospitalId"/></p>  
<p>科室名称：<input type="text" name="officeName" id="officeName"/></p>    
<p>描述：<input type="text" name="description" id="description"/></p>    
<p><input type="button" id="send" value="提交" onclick="update();"/></p>  
</form>
</div>
  
</body>
</html>