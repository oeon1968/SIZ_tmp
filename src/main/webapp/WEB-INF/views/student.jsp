<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 19.03.2023
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    FirstName: <form:input path="firstName" /><br>
    LastName: <form:input path="lastName" /><br>
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="M"/><br>
    Country: <form:select path="country" items="${countryItems}"/><br>
    Notes: <form:textarea path="notes" rows="5" col="30" /><br>
  <%--  MailingList : <form:checkbox path="maillingList" value="0"/><br>--%>
    Programming Skills: <form:select path="programmingSkills" items="${skillsList}"/><br>
    Hobbies: <form:checkboxes path="hobbies" items="${hobbiesList}"/><br>--%>
</form:form>

</body>
</html>
