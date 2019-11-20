<%--
  Created by IntelliJ IDEA.
  User: ThinKPad
  Date: 2019/11/17
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<form action="upp" method="post">
    文档名称:<input name="title" value="${d.title}"><br>
    文档摘要:<textarea rows="5" cols="10" name="summary">${d.summary}</textarea>
    <br>
    上传人:<input name="uploaduser" value="${d.uploaduser}"><br>
    上传时间:<input name="createdate" value="${d.createdate}"><br>
    分类:<select name="categoryid" >
    <option value=" ">全部    </option>
    <c:forEach  items="${clist}" var="c">
        <c:if test="${c.id==d.categoryid}">
            <option selected="selected" value="${c.id}">${c.name}</option>
        </c:if>
        <c:if test="${c.id!=d.categoryid}">
            <option value="${c.id}">${c.name}</option>
        </c:if>
    </c:forEach>
</select>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>
