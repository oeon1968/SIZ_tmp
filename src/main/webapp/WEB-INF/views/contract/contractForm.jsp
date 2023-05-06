<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract</title>
</head>
<body>

<%--@elvariable id="Contract" type="java"--%>
<form:form modelAttribute="Contract" method="post">
    Identyfikator <form:input path="id"/> <br>
    Nazwa klienta (skrót)
    <form:select path="client.id">
        <jsp:useBean id="clients" scope="request" type="java.util.List"/>
        <form:option value="" label="--NIEZNANY--"/>
        <form:options itemValue="id" itemLabel="client_abbreviation" items="${clients}"/><br>
    </form:select>
    <br>
    Metoda płatności
    <form:select path="paymentMethod.id">
        <jsp:useBean id="paymentMethods" scope="request" type="java.util.List"/>
        <form:option value="" label="--NIEZNANA--"/>
        <form:options items="${paymentMethods}" itemLabel="paymentMethod" itemValue="id"/>
    </form:select><br>
     Nr konta <form:input path="accountNo" maxlength="12"/>
     Nr umowy <form:input path="contractNo" maxlength="12"/><br>
    Waloryzacja? <form:checkbox path="valorization"/>
    Umowa aktywna? <form:checkbox path="activeContract"/><br>
    <br><br>
    Data startu <input type="date" name="start" id="contractDateStart" value="${Contract.contractStart}"/>
    Data startu <input type="date" name="finish" id="contractDateFinish" value="${Contract.contractFinish}"/>

    <br>

     Sector
         <form:select path="sector.id">
             <jsp:useBean id="sectors" scope="request" type="java.util.List"/>
             <form:option value="" label="--NIEZNANA--"/>
             <form:options items="${sectors}" itemLabel="sectorName" itemValue="id"/>
         </form:select>
     <br>
     Typ umowy
         <form:select path="contractType.id">
             <jsp:useBean id="contractTypes" scope="request" type="java.util.List"/>
             <form:option value="" label="--NIEZNANY--"/>
             <form:options items="${contractTypes}" itemLabel="contractName" itemValue="id"/>
         </form:select>
     Produkt
         <form:select path="product.id">
             <jsp:useBean id="products" scope="request" type="java.util.List"/>
             <form:option value="" label="--NIEZNANY--"/>
             <form:options items="${products}" itemLabel="name" itemValue="id"/>
         </form:select>
     <br>
     Kierownik projektu
         <form:select path="projectManager.id">
             <jsp:useBean id="projectManagers" scope="request" type="java.util.List"/>
             <form:option value = "" label="--NIEZNANY--"/>
             <form:options items = "${projectManagers}" itemLabel="name" itemValue="id"/>
         </form:select><br>
    <button type="submit">Save</button>
</form:form>

</body>
</html>
