<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Group</title>
</head>
<body>
<%--@elvariable id="productGroup" type="java"--%>
<form:form method = "post" modelAttribute = "productGroup">
    <form:input path="id" />
    <form:input path="name" />
    <button type="submit">Save</button>
</form:form>

</body>
</html>
