<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 23.04.2023
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
    <style>
        td {text-align: center}
    </style>
</head>
<body>
<h1> Lista klientów</h1>
<a href="/SIZ/client/ins"> Insert </a>
<table border = "1">
    <thead>
        <tr>
            <td>Id</td>
            <td>Abbreviation</td>
            <td>Client name</td>
            <td>Client Type</td>
            <td>Acc first name</td>
            <td>Acc last name</td>
            <td>Action </td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.client_abbreviation}</td>
                <td>${client.client_name}</td>
                <td>${client.clientType.typeName}</td>
                <td>${client.accountManager.firstName}</td>
                <td>${client.accountManager.lastName}</td>
                <td>
                    <a href = "/SIZ/client/upd/${client.id}">Upgrade</a>
                    <a href = "/SIZ/client/del/${client.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
