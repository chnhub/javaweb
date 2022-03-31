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
    // $("#login11").submit((e) => {
    //   console.log(e);
      // $.ajax({
      //   type:'POST',
      //   url:'/login',
      //   data: new FormData($('#login_form')[0]),
      //   contentType:'application/json',
      //   processData: false,
      //   success: function (){
      //     alert("success")
      //   },
      //   error:function (){
      //     alert("error")
      //   }
      // });
    //   e.preventDefault();
    //
    // });
    function formSubmit(ele,e){
      console.log(e)
      e.preventDefault();
      $.ajax({
        type: 'POST',
        url: "/login",
        // contentType : false,
        processData : false,
        contentType:"application/json",
        dataType: "json",
        data: JSON.stringify($('#login_form').serializeJSON()),
        success: function (data){
          console.log(data)
          if(data&&data.success === true){
            alert("登录成功");
          }
        },
        error:function (data){
          console.log("error",data)
        },

      });
      // e.preventDefault();
      return false;
    }
  </script>
  <body>
  <form id="login_form"  onsubmit="return formSubmit(this,event)" >
    <span>用户名：</span><input name="name"/> </br>
    <span>密码：</span><input name="password"/> </br>
    <span>验证码：</span><input name="verification"/> </br>
<%--    <input type="checkbox"/><span>记住用户名</span></br>--%>
    <input type="checkbox">记住用户名</input></br>
    <button type="submit" id="login"/>登录</button>
  </form>
<%--  防止跳转 加个target--%>
<%--  <iframe  name="stop" style="display:none;"></iframe>--%>

  </body>
</html>
