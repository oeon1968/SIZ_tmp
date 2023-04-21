<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Kierownik Projektu</title>
</head>
<body>
<%--@elvariable id="projectManager" type="java"--%>
<form:form method="post" modelAttribute="projectManager">
    Identyfikator <form:input path="Id" /> <br>
    Imię <form:input path="firstName" /> <br>
    Nazwisko <form:input path="lastName"  /> <br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
