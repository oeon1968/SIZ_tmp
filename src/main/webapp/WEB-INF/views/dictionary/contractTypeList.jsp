<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract type</title>
</head>
<body>
<h1> Słownik typów kontraktów </h1>
<a href = "/SIZ/contract_type/ins"> Insert </a>
    <table border="1">
    <thead>
    <tr>
        <td> id </td>
        <td> name </td>
        <td> action </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" var="contractType">
        <tr>
            <td>${contractType.id}</td>
            <td>${contractType.contractName}</td>
            <td><a href="/SIZ/contract_type/upd/${contractType.id}"> Upgrade</a>
                <a href = "/SIZ/contract_type/del/${contractType.id}"> Delete </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
