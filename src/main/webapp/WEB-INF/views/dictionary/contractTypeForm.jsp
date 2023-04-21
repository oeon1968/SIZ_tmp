<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract type</title>
</head>
<body>
<%--@elvariable id="contractType" type="java"--%>
<form:form method = "post" modelAttribute = "contractType">
    <form:input path="id" />
    <form:input path="contractName" />
    <button type="submit">Save</button>
</form:form>

</body>
</html>
