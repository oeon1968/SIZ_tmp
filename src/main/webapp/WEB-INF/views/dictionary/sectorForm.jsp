<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 22.04.2023
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sector</title>
</head>
<body>
<%--@elvariable id="sector" type="java"--%>
<form:form method="post" modelAttribute="sector">
    <form:input path="id" />
    <form:input path="sectorName" />
    <button type="submit">Save</button>
</form:form>

</body>
</html>
