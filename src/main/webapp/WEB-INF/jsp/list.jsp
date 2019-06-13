<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="/css/layui.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>

<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>班级</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.sex}</td>
            <td>${list.classId}</td>
        </tr>
    </c:forEach>


    </tbody>
</table>


</body>
</html>
