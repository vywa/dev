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
      url: "../hospital/showAll",
      success: function (msg) {
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].id + "</td><td>" + msg[i].hospitalName + "</td><td>" + msg[i].level + "</td><td>" + msg[i].address + "</td><td>" + msg[i].telephone + "</td><td>" +
              msg[i].email +"</td><td>" + msg[i].hospitalIM +"</td><td>" + msg[i].weiChatNumber +"</td><td>" + 
              "<a href=\"hospitalEdit.jsp?id="+msg[i].id+"\">修改</a>" +"</td><td>" +"<a href=\"../info/delete?data={id:"+msg[i].id+"}\">删除</a>" +"</td></tr>";
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
<td>医院Id</td>
<td>医院名</td>
<td>等级</td><td>地址</td><td>电话</td>
<td>邮件</td><td>及时通信</td><td>公众号</td>
</tr></thead>
<tbody id="body">

</tbody>
</table>
</div>

<div id="kkpager"></div>

</body>
</html>