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
      url: "../account/show",
      success: function (msg) {
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].id + "</td><td>" + msg[i].catagory + "</td><td>" + msg[i].username + "</td><td>" + msg[i].mobilephone + "</td><td>" + msg[i].email + "</td><td>" +
              msg[i].workNum +"</td><td>" + msg[i].qQ +"</td><td>" + msg[i].weiChat +"</td><td>" + 
              msg[i].weiBo +"</td><td>" + msg[i].password +"</td><td>" + msg[i].status +"</td><td>" +  
              "<a href=\"accountEdit.jsp?id="+msg[i].id+"\">修改</a>" +"</td><td>" +"<a href=\"../account/delete?data={id:"+msg[i].id+"}\">删除</a>" +"</td></tr>";
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
<td>用户Id</td>
<td>用户类别</td>
<td>用户名</td><td>手机号</td><td>邮箱</td>
<td>工号</td><td>QQ</td><td>微信号</td>
<td>微博</td><td>密码</td><td>状态</td>
</tr></thead>
<tbody id="body">

</tbody>
</table>
</div>



</body>
</html>