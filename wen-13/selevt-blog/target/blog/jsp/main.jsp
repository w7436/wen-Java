<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/5/7
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
<%--    <link href="static/css/app.css" rel="stylesheet">--%>
    <!-- jQuery -->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type = "text/javascript">
        $(document).ready(function(){
//            alert("jsp文件加载");
            $.ajax({
               url:"login",
               type:"post",
               contentType:"application/json",//请求的数据格式
               data:{username:"abc",password:"124"},//请求的数据
               dataType:"json",//响应的数据格式
               success:function (data) {//状态码为200，调用这个函数

               }
            });
            $("#byn").click(function () {
 //               alert("点击");
            });
        });

    </script>
</head>
<body>
<!--访问到的是http://localhost:8080/blog/login-->
<!--action为 login   http://localhost:8080/blog/jsp/login  -->
<!--action为/login http://localhost:8080/login   -->
<!--解决办法：添加jsp变量及base标签，action为login-->
    <form action="login">
        <input type = "text" name = "usename" placeholder="请输入用户名">
        <input type="password" name="password" placeholder="请输入密码">
        <input type="submit" value="提交">
    </form>
    <input id="byn" type ="button" value="点击事件">
</body>
</html>
