
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<center>
    <form action="n" method="post">
        文档分类:<select name="lname">
        <option selected="selected" value="0">全部</option>
        <c:forEach  items="${clist}" var="c">
            <c:if test="${lname==c.id}">
                <option selected="selected" value="${c.id}">${c.name}</option>
            </c:if>
            <c:if test="${lname!=c.id}">
                <option value="${c.id}">${c.name}</option>
            </c:if>
        </c:forEach>
    </select>
        <input type="submit">
    </form>
    <a href="add.jsp">增加</a>
    <table border="1px">
        <tr><td>编号</td>
            <td>名称</td>
            <td>摘要</td>
            <td>上传人</td>
            <td>上传时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.title}</td>
                <td>${e.summary}</td>
                <td>${e.uploaduser}</td>
                <td>${e.createdate}</td>
                <td><a href="del/${e.id}">删除</a>
                    <a href="up/${e.id}">修改</a>

                </td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="6">
                <span id="info">${shan}</span>
            </th>
        </tr>
    </table>
    <a href="in/1">首页</a>
    <a href="in/${info.getPrePage()}">上一页</a>
    <a href="in/${info.getNextPage()}">下一页</a>
    <a href="in/${info.getPages()}">末页</a>
    <a>第${info.getPageNum()}页/共${info.getPages()}页</a>
</center>
</body>
</html>
