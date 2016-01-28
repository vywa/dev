<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/kkpager.js"></script>
  <script language="javascript" type="text/javascript" >
  $.ajax({
      type: "get",
      dataType: "json",
      url: "../office/show",
      success: function (msg) {
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].officeId + "</td><td>" + msg[i].hospitalId + "</td><td>" + msg[i].officeName + "</td><td>" + msg[i].description +"</td><td>"+
              "<a href=\"officeEdit.jsp?officeId="+msg[i].officeId+"\">修改</a>" +"</td><td>" +"<a href=\"../office/delete?data={id:"+msg[i].officeId+"}\">删除</a>" +"</td></tr>";
          }
          $("tbody").append(str);
      }
  });

  </script>


  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/hospital.css" />	
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/kkpager_orange.css" />	

</head>
<body>
<div id="content">
<table id ="table1">
<thead><tr>
<td>科室编号</td>
<td>医院Id</td>
<td>科室名称</td><td>描述</td>
</tr></thead>
<tbody id="body">

</tbody>
</table>
</div>

<div id="kkpager"></div>

</body>
</html>