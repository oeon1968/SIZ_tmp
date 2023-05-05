<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="contractPayment" scope="request" type="pl.coderslab.model.ContractPayment"/>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 05.05.2023
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add payment</title>
</head>
<body>
<div>
    <h1>Umowa dla:
        <label style="color: blue">${contractPayment.contract.client.client_abbreviation}</label><br>
    </h1>
    <span>
            Numer Konta <label style="color: blue">${contractPayment.contract.accountNo}</label><br>
            Numer Umowy <label style="color: blue">${contractPayment.contract.contractNo}</label><br>
            Typ umowy: <label style="color: blue">${contractPayment.contract.contractType.contractName}</label><br>
        </span>
    <span>
            Rozpoczęcie:<label style="color: blue">${contractPayment.contract.contractStart}</label>
            Zakończenie:<label style="color: blue">${contractPayment.contract.contractFinish}</label>
        </span><br>
    <span>
            Produkt: <label style="color: blue">${contractPayment.contract.product.name}</label><br>
            Sposób płatności: <label style="color: blue">${contractPayment.contract.paymentMethod.paymentMethod}</label>
        </span>
    ,    </div>
<br><br>
<form method="post">
    <div>
        Data płatności <input type="date" name="paymentDate"/><br>
        Kwota <input type="number" name="paymentValue" min="0" step="0.01"/>
        <button type="submit" style="align-content: center">Dodaj nowy termin</button>
    </div>
</form>
<form method="get"  action="/SIZ/contract">
    <button type="submit"> Zakończ </button>
</form>

<table style="border: blue">
    <thead>
    <tr>
        <td>Lp</td>
        <td>Data płatności</td>
        <td>Kwota</td>

    </tr>
    </thead>
    <jsp:useBean id="contractPaymentList" scope="request" type="java.util.List"/>
    <tbody>
        <c:forEach items="${contractPaymentList}" var="cp" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${cp.paymentDate}</td>
            <td>${cp.paymentValue}</td>
        </tr>
    </tbody>


    </c:forEach>
</table>



</body>
</html>
