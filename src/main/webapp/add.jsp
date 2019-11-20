
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="k" method="post">
    文档名称:<input name="title"><br>
    文档摘要:<textarea rows="5" cols="10" name="summary"></textarea>
    <br>
    上传人:<input name="uploaduser"><br>
    上传时间:<input name="createdate"><br>
    分类:<select name="categoryid">
    <option value=" ">全部    </option>
    <c:forEach  items="${clist}" var="c">
        <option value="${c.id}">${c.name}</option>
    </c:forEach>
</select>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
