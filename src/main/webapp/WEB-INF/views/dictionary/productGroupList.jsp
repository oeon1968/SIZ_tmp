<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Group</title>
</head>
<body>
<h1> Słownik grup produktowych </h1>
<a href = "/SIZ/product_group/ins"> Insert </a>
<table border="1">
    <thead>
    <tr>
        <td> id </td>
        <td> name </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" var="productGroup">
        <tr>
            <td>${productGroup.id}</td>
            <td>${productGroup.name}</td>
            <td><a href="/SIZ/product_group/upd/${productGroup.id}"> Upgrade</a>
                <a href = "/SIZ/product_group/del/${productGroup.id}"> Delete </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
