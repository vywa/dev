<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>

    
    <script src="<%=request.getContextPath() %>/js/pagination.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath() %>/css/pagination.css" rel="stylesheet" type="text/css" />

    
  <script language="javascript" type="text/javascript" >
  $.ajax({
      type: "get",
      dataType: "json",
      url: "../post/show",
      success: function (msg) {
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].id + "</td><td>" + msg[i].forumPlateId + "</td><td>" + msg[i].theme + "</td><td>" + msg[i].userId + "</td><td>" + msg[i].deliveryTime + "</td><td>" +
              msg[i].content +"</td><td>" + msg[i].title +"</td><td>" + msg[i].status +"</td><td>" + 
              msg[i].level +"</td><td>" + msg[i].commnetList +"</td><td>" + msg[i].viewCount +"</td><td>" +  
              msg[i].replyCount +"</td><td>" + msg[i].supportCount +"</td><td>" + msg[i].oppositionCount +"</td><td>" +  
              "<a href=\"postEdit.jsp?id="+msg[i].id+"\">修改</a>" +"</td><td>" +"<a href=\"../post/delete?data={id:"+msg[i].id+"}\">删除</a>" +"</td></tr>";
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
<td>帖子ID</td>
<td>所属板块</td>
<td>主题</td><td>发帖作者</td><td>发帖时间</td>
<td>帖子内容</td><td>帖子标题</td><td>帖子状态</td>
<td>帖子等级</td><td>评论列表</td><td>浏览次数</td>
<td>回复次数</td><td>支持次数</td><td>反对次数</td>
</tr></thead>
<tbody id="body">

</tbody>
</table>

</div>
</body>
</html>