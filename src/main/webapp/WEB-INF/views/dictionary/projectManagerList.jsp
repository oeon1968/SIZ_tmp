<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ProjectManager</title>
</head>
<body>
<h1>Słownik kierowników projektu</h1>
<a href = "/SIZ/project_manager/ins"> Insert </a>
<table border = "1">
    <thead>
    <tr>
        <td> Id </td>
        <td> First Name</td>
        <td> Last Name</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" var="projectManager">
        <tr>
            <td>${projectManager.id}</td>
            <td>${projectManager.firstName}</td>
            <td>${projectManager.lastName}</td>
            <td><a href="/SIZ/project_manager/upd/${projectManager.id}"> Upgrade</a>
                <a href = "/SIZ/project_manager/del/${projectManager.id}"> Delete </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
