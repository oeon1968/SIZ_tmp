<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment method</title>
</head>
<body>
<%--@elvariable id="paymentMethod" type="java"--%>
<form:form method = "post" modelAttribute = "paymentMethod">
    <form:input path="id" />
    <form:input path="paymentMethod" />
    <button type="submit">Save</button>
</form:form>

</body>
</html>
