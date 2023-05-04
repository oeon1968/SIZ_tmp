<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 24.04.2023
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract List</title>
</head>
<body>
<a href="/SIZ/contract/ins"> Insert </a>
<table border="1">
    <thead>
    <tr>
        <td>id</td>
        <td>Account No</td>
        <td>Contract No</td>
        <td>Start</td>
        <td>Finish</td>
        <%--<td>Scope</td>--%>
        <td>Valorization</td>
        <td>Active?</td>
        <td>Client Abb</td>
        <td>Payment method</td>
        <td>Sector</td>
        <td>Contract type</td>
        <td>Product</td>
        <td>Project Manager</td>
        <td>Action</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="contract" items="${Contracts}">
        <tr>
            <td>${contract.id}</td>
            <td>${contract.accountNo}</td>
            <td>${contract.contractNo}</td>
            <td>${contract.contractStart}</td>
            <td>${contract.contractFinish}</td>
            <%--<td>${contract.Scope}</td>--%>
            <td>${contract.valorization}</td>
            <td>${contract.activeContract}</td>
            <td>${contract.client.client_abbreviation}</td>
            <td>${contract.paymentMethod.paymentMethod}</td>
            <td>${contract.sector.sectorName}</td>
            <td>${contract.contractType.contractName}</td>
            <td>${contract.product.name}</td>
            <td>${contract.projectManager.name}</td>
            <td>
                <a href="/SIZ/contract/upd/${contract.id}"> Update</a>
                <a href="/SIZ/contract/del/${contract.id}"> Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
