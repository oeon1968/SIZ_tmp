<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>AccountManager</title>
</head>
<body>
  <h1>Słownik opiekunów klienta</h1>
  <a href = "/SIZ/account_manager/ins"> Insert </a>
  <table border = "1">
    <thead>
    <tr>
      <td> Id </td>
      <td> First Name</td>
      <td> Last Name</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" var="accountManager">
      <tr>
        <td>${accountManager.id}</td>
        <td>${accountManager.firstName}</td>
        <td>${accountManager.lastName}</td>
        <td><a href="/SIZ/account_manager/upd/${accountManager.id}"> Upgrade</a>
            <a href = "/SIZ/account_manager/del/${accountManager.id}"> Delete </a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</body>
</html>
