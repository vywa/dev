<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bootstrap实例</title>
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">  
  <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
      <h2>表格</h2>
      <p>创建响应式表格 (将在小于768px的小型设备下水平滚动)。另外：添加交替单元格的背景色：</p>      
      <div class="table-responsive">          
       <table class="table table-striped table-bordered">
         <thead>
           <tr>
             <th>#</th>
             <th>Name</th>
             <th>Street</th>
           </tr>
         </thead>
         <tbody>
           <tr>
             <td>1</td>
             <td>Anna Awesome</td>
             <td>Broome Street</td>
           </tr>
           <tr>
             <td>2</td>
             <td>Debbie Dallas</td>
             <td>Houston Street</td>
           </tr>
           <tr>
             <td>3</td>
             <td>John Doe</td>
             <td>Madison Street</td>
           </tr>
         </tbody>
       </table>
      </div>

      <h2>图像</h2>
      <p>创建项应式图片(将扩展到父元素)。 另外：图片以椭圆型展示：</p>            
      <img src="cinqueterre.jpg" class="img-responsive img-circle" alt="Cinque Terre" width="304" height="236"> 
      
      <h2>图标</h2>
      <p>插入图标:</p>      
      <p>云图标: <span class="glyphicon glyphicon-cloud"></span></p>      
      <p>信件图标: <span class="glyphicon glyphicon-envelope"></span></p>            
      <p>搜索图标: <span class="glyphicon glyphicon-search"></span></p>
      <p>打印图标: <span class="glyphicon glyphicon-print"></span></p>      
      <p>下载图标：<span class="glyphicon glyphicon-download"></span></p>      
    </div>


</body>
</html>