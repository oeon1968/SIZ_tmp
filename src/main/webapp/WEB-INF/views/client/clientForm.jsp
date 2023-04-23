<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client</title>
</head>
<body>
<h1>Formularz danych klienta</h1>
<%--@elvariable id="client" type="java"--%>
<form:form method="post" modelAttribute="client">
    Identyfikator: <form:input path="id"/> <br>
    Skrót nazwy: <form:input path="client_abbreviation"/>
    Pełna nazwa: <form:input path="client_name"/><br>
    Typ Klienta:<form:select path="clientType.id">
    <jsp:useBean id="clientTypes" scope="request" type="java.util.List"/>
                <form:option  value="" label="Nieznany"/>
                <form:options  itemValue="id" itemLabel="typeName" items="${clientTypes}"/>
                </form:select> <br>
    Opiekun klienta:<form:select path="accountManager.id">
    <jsp:useBean id="accountManagers" scope="request" type="java.util.List"/>
                        <form:option value="" label="Brak"/>
                        <form:options itemValue="id"
                                      itemLabel="firstName"
                                      items="${accountManagers}"/>
                    </form:select><br>
    <button type="submit"> Zapisz</button>
</form:form>

</body>
</html>
