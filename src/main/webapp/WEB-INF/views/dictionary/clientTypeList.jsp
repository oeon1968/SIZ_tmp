<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client type</title>
</head>
<body>
<h1> Słownik typów klientów </h1>
<table border="1">
    <thead>
    <tr>
        <td> id </td>
        <td> name </td>
        <td> action </td>
    </tr>
    </thead>
    <c:forEach items="${list}" var="clientType">
        <tr>
            <td>${clientType.id}</td>
            <td>${clientType.typeName}</td>
            <td><a href="/SIZ/client_type/upd/${clientType.id}"> Upgrade</a> </td>
            <td><a href = "/SIZ/client_type/del/${clientType.id}"> Delete </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
