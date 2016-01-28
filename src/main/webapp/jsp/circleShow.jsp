<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/kkpager.js"></script>
    
    <script src="<%=request.getContextPath() %>/js/pagination.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath() %>/css/pagination.css" rel="stylesheet" type="text/css" />

    
  <script language="javascript" type="text/javascript" >
  $.ajax({
      type: "get",
      dataType: "json",
      url: "../circle/getUnhandled",
      success: function (msg) {
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].friendId + "</td><td>" + msg[i].friendName + "</td><td>" + 
              msg[i].loginStatus + "</td><td>" + msg[i].relation + "</td><td>"  +  
              msg[i].privilege + "</td><td>"  +  
              "<a href=\"unhandledEdit.jsp?id="+msg[i].friendId+"\">修改</a>" +"</td><td>" +"<a href=\"../circle/addPatient?data={id:"+msg[i].friendId+"}\">删除</a>" +"</td></tr>";
          }
          $("tbody").append(str);
      }
  });

  </script>


  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/account.css" />	
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/kkpager_orange.css" />	

</head>
<body>





<div id="content">
<table id ="table1">
<thead><tr>
<td>朋友ID</td>
<td>朋友名称</td>
<td>登陆状态</td><td>关系</td><td>权限</td>

</tr></thead>
<tbody id="body">

</tbody>
</table>
</div>



</body>
</html>