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
      url: "../info/show",
      success: function (msg) {
    
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].userId + "</td><td>" + "<img src=\"../info/download?iconUrl=temp.jpg&tocken="+"145292848417818510287653"+"\" />" + "</td><td>"+ 
            		  msg[i].trueName + "</td><td>" + msg[i].sex + "</td><td>" + 
              msg[i].birthday + "</td><td>" + msg[i].address + "</td><td>" +
              msg[i].height +"</td><td>" + msg[i].weight +"</td><td>" + msg[i].recordTime +"</td><td>" + 
              "<a href=\"informationEdit.jsp?id="+msg[i].userId+"\">修改</a>" +"</td><td>" +"<a href=\"../info/delete?data={id:"+msg[i].userId+"}\">删除</a>" +"</td></tr>";
          }
          $("tbody").append(str);
      }
  });

  </script>



  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/account.css" />	
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/kkpager_orange.css" />	

</head>
<body>
<input type='hidden' id='current_page' />
	<input type='hidden' id='show_per_page' />
<div id='page_navigation'></div><br>

<table id ="table1">
<thead><tr>
<td>用户Id</td><td>用户图片</td>
<td>用户名</td><td>性别</td><td>生日</td>
<td>住址</td><td>身高</td><td>体重</td>
<td>记录时间</td>
</tr></thead>
<tbody id="body">

</tbody>
</table>




</body>
</html>