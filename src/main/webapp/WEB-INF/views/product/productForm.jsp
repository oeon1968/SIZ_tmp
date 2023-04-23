<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 23.04.2023
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<%--@elvariable id="product" type="java"--%>
<form:form method="post" modelAttribute="product">
    Identyfikator: <form:input path="id"/> <br>
    Nazwa produktu:<form:input path="name"/> <br>
    Grupa produktowa:<form:select path="productGroup.id">
                    <form:option value="" label="Brak"/>
                    <form:options items="${productGroups}" itemValue="id" itemLabel="name"/>
                    </form:select><br>
    <button type="submit">Save</button>
</form:form>

</body>
</html>
