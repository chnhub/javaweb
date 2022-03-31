<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/26
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/jquery.serializejson.min.js"></script>
  </head>
  <script>
  function loginOut(){
      // $.ajax({
      //     type: 'get',
      //     url: "/loginOut",
      //     // contentType : false,
      //     processData : false,
      // });
      window.location.href="/loginOut";
  }
  </script>
  <body>
<%
    if(request.getSession().getAttribute("token") == null){
%>
未登录！<a href="/">去登陆</a>
<%
    } else {
%>
<h1>登录成功！</h1>
<%
  String username = (String)request.getSession().getAttribute("token");
%>
您好<%= username%>
<button id="login-out" onclick="loginOut()">退出</button>
<%
    }
%>

  </body>
</html>
