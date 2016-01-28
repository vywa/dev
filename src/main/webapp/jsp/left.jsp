<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/js/tree.js"></script>
	 <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/css/tree.css"/>
</head>
<body>
<h1 class="title"><span class="close">全部收起/展开</span>Jihua树形菜单</h1>
 <div class="menu">
   <h1 class="l1">一级菜单</h1>
  <div class="slist">
    <h2 class="l2"><a href="#">二级菜单</a></h2>
     <ul class="sslist">
      <li class="l3"><a href="#">·三级菜单</a></li>
     <li class="l3"><a href="#">·三级菜单</a></li>
       <li class="l3"><a href="http://jihua.cnblogs.com" target="_blank">·jihua.cnblogs.com</a></li>
       <li class="l3"><a href="#">·三级菜单</a></li>
    </ul>
   <h2 class="l2"><a href="#">二级菜单</a></h2>
     <ul class="sslist">
       <li class="l3"><a href="#">·三级菜单</a></li>
       <li class="l3"><a href="#">·三级菜单</a></li>
      <li class="l3"><a href="http://jihua.cnblogs.com" target="_blank">·三级菜单</a></li>
      <li class="l3"><a href="#">·三级菜单</a></li>
    </ul>
    <h2 class="l2"><a href="#">二级www.cnblogs.com/jihua</a></h2>
   </div>
  <h1 class="l1">一级博客园</h1>
  <div class="slist">
     <h2 class="l2"><a href="#">二级菜单计划</a></h2>
     <h2 class="l2"><a href="#">二级菜单</a></h2>
    <h2 class="l2"><a href="#">二级菜单</a></h2>
   </div>
   <h1 class="l1">一级菜单</h1>
   <div class="slist">
    <h2 class="l2"><a href="#">二级菜单</a></h2>
     <h2 class="l2"><a href="#">二级菜单</a></h2>
     <h2 class="l2"><a href="#">二级菜单</a></h2>
  </div>
 </div>
</body>
</html>