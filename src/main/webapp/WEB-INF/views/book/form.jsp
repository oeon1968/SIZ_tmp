<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 19.03.2023
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Tytuł" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 19.03.2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
<form:errors path=""/>
    Tytuł: <form:input path="title"/> --->
    <form:errors path="title"/><br>
    Autorzy: <form:select path="authors" multiple="true" items="${authorList}" itemValue="id" itemLabel="fullName"/>--->
    <form:errors path="authors"/><br>
    Ocena: <form:input path="rating" type="number"/>--->
    <form:errors path="rating"/><br>
    Opis: <form:textarea path="description"/>--->
    <form:errors path="description"/><br>
    Wydawca: <form:select path="publisher.id">
        <form:option value="0" label="-- wybierz --"/>
        <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
        </form:select>--->
        <form:errors path="publisher"/><br>

    Strony: <form:input path="pages" type="number"/>--->
    <form:errors path="pages"/><br>

    <input type="submit"/>
</form:form>
</body>
</html>
