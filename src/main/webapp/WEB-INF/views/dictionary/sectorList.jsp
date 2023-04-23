<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 22.04.2023
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sectors</title>
</head>
<body>
<h1>Słownik sektorów</h1>
<a href="/SIZ/sector/ins"> Insert </a>
<table border="1">
    <thead>
    <tr>
        <td> Id</td>
        <td> Sector name</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" var="sector">
        <tr>
            <td>${sector.id}</td>
            <td>${sector.sectorName}</td>
            <td>
                <a href="/SIZ/sector/del/${sector.id}"> Delete </a>
                <a href="/SIZ/sector/upd/${sector.id}"> Update </a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
