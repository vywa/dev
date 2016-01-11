<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user info</title>
  <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/PageDate.js"></script>
</head>
<body>
<table id="datas" border="1" cellspacing="0" style="border-collapse: collapse">
                <tr>
                    <th>
                        用户ID</th>
                    <th>
                      用户名</th>
                    <th>
                        手机</th>
                    <th>
                       邮箱</th>
                    <th>
                        明文密码</th>
                    <th>
                        加密密码</th>
                    <th>
                        用户类别</th>
                    <th>
                       账号状态</th>
                    <th>
                        备注</th>
                </tr>
                <tr id="template">
                    <td id="userId">
                    </td>
                    <td id="username">
                    </td>
                    <td id="mobilephone">
                    </td>
                    <td id="email">
                    </td>
                    <td id="simplePassword">
                    </td>
                    <td id="crypePassword">
                    </td>
                    <td id="userCatagory">
                    </td>
                    <td id="accountStatus">
                    </td>
                    <td id="more">
                    </td>
                </tr>
            </table>
</body>
</html>