<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client type</title>
</head>
<body>
    <form:form method = "post" modelAttribute = "clientType">
        <form:input path="id" />
        <form:input path="typeName" />
        <button type="submit">Save</button>
    </form:form>

</body>
</html>
