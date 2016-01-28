<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
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
      url: "../reglog/show",
      success: function (msg) {
          var str = "";
          for (i in msg) {
              str += "<tr><td>" + msg[i].userId + "</td><td>" + msg[i].loginModel + "</td><td>" + msg[i].loginChannel + "</td><td>" +
              msg[i].loginUsername + "</td><td>" + 
              msg[i].mobilephone + "</td><td>" +
              msg[i].password +"</td><td>" + msg[i].catagory +"</td><td>" + msg[i].longitude +"</td><td>" + 
              msg[i].latitude +"</td><td>" + msg[i].userLoginIp +"</td><td>" + msg[i].userLoginTime +"</td><td>" +  
              msg[i].userLogoutTime +"</td><td>" + msg[i].loginStatus +"</td><td>" + msg[i].sessionid +"</td><td>" + 
              msg[i].loginCount +"</td><td>" + 
              "<a href=\"accountEdit.jsp?id="+msg[i].id+"\">修改</a>" +"</td><td>" +
            		  "<a href=\"../account/delete?data={id:"+msg[i].id+"}\">删除</a>" +"</td></tr>";
          }
          $("tbody").append(str);
      }
  });

  </script>


  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/account.css" />	
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/kkpager_orange.css" />	

</head>
<body>
<div id="setpage"></div> 
<script type="text/javascript"> 

var totalpage,pagesize,cpage,count,curcount,outstr; 
//初始化 
cpage = 1; 
totalpage = 56; 
pagesize = 10; 
outstr = ""; 
function gotopage(target) 
{     
    cpage = target;        //把页面计数定位到第几页 
    setpage(); 
    //reloadpage(target);    //调用显示页面函数显示第几页,这个功能是用在页面内容用ajax载入的情况 
} 
function setpage() 
{ 
    if(totalpage<=10){        //总页数小于十页 
        for (count=1;count<=totalpage;count++) 
        {    if(count!=cpage) 
            { 
                outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
            }else{ 
                outstr = outstr + "<span class='current' >"+count+"</span>"; 
            } 
        } 
    } 
    if(totalpage>10){        //总页数大于十页 
        if(parseInt((cpage-1)/10) == 0) 
        {             
            for (count=1;count<=10;count++) 
            {    if(count!=cpage) 
                { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                }else{ 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'> next </a>"; 
        } 
        else if(parseInt((cpage-1)/10) == parseInt(totalpage/10)) 
        {     
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+(parseInt((cpage-1)/10)*10)+")'>previous</a>"; 
            for (count=parseInt(totalpage/10)*10+1;count<=totalpage;count++) 
            {    if(count!=cpage) 
                { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                }else{ 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
        } 
        else 
        {     
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+(parseInt((cpage-1)/10)*10)+")'>previous</a>"; 
            for (count=parseInt((cpage-1)/10)*10+1;count<=parseInt((cpage-1)/10)*10+10;count++) 
            {         
                if(count!=cpage) 
                { 
                    outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'>"+count+"</a>"; 
                }else{ 
                    outstr = outstr + "<span class='current'>"+count+"</span>"; 
                } 
            } 
            outstr = outstr + "<a href='javascript:void(0)' onclick='gotopage("+count+")'> next </a>"; 
        } 
    }     
    document.getElementById("setpage").innerHTML = "<div id='setpage'><span id='info'>共"+totalpage+"页|第"+cpage+"页<\/span>" + outstr + "<\/div>"; 
    outstr = ""; 
} 
setpage();    //调用分页 

</script> 
<div id="content">
<table id ="table1">

<thead><tr>
<td>用户Id</td><td>登陆方式</td><td>登陆通道</td>
<td>登陆名称</td><td>手机号</td><td>密码</td>
<td>用户类型</td><td>经度</td><td>纬度</td>
<td>登陆IP</td><td>登陆时间</td><td>退出时间</td>
<td>登陆状态</td><td>会话ID</td><td>在线数量</td>
</tr></thead>
<tbody id="body">

</tbody>
</table>
</div>


</body>
</html>