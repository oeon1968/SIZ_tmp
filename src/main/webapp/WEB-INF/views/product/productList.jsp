<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Product</title>
    <style>
        td {text-align: center}
    </style>
</head>
<body>
<a href = "/SIZ/product/ins">Insert</a>
<table border="1">
    <thead>
    <tr>
        <td>Id</td>
        <td>Product group</td>
        <td>Product name</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td bgcolor="gray">${product.productGroup.name}</td>
            <td>${product.name}</td>
            <td>
                <a href = "/SIZ/product/upd/${product.id}">Update</a>
                <a href = "/SIZ/product/del/${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
