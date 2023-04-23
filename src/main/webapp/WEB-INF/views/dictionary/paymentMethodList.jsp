<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Method</title>
</head>
<body>
<h1> Słownik metod płatności </h1>
<a href = "/SIZ/payment_method/ins"> Insert </a>
<table border="1">
    <thead>
    <tr>
        <td> id </td>
        <td> payment method </td>
        <td> action </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" var="paymentMethod">
        <tr>
            <td>${paymentMethod.id}</td>
            <td>${paymentMethod.paymentMethod}</td>
            <td><a href="/SIZ/payment_method/upd/${paymentMethod.id}"> Upgrade</a>
                <a href = "/SIZ/payment_method/del/${paymentMethod.id}"> Delete </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
