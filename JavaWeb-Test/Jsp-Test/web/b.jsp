<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/6/15
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/error.jsp"
         language="java" %>
<%--errorPage表示错误后自动跳转的路径
这个路径一般都是以/打头，它表示请求的地址是http://ip:port/工程路径/
映射到代码的web目录--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
b.jsp
    <%

    int i = 10/0;
    %>

</body>
</html>
