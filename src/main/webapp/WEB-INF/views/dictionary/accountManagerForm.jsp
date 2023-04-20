<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Doradca Klienta</title>
</head>
<body>
    <form:form method="post" modelAttribute="accountManager">
        Identyfikator <form:input path="Id" /> <br>
        Imię <form:input path="firstName" /> <br>
        Nazwisko <form:input path="lastName"  /> <br>
        <button type="submit">Save</button>
    </form:form>
</body>
</html>
