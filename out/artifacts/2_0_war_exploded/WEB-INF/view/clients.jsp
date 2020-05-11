<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 01.04.2020
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Clients</title>
    <link rel="stylesheet" type="text/css" href="../../Designer.css">
</head>
<body>
<h1>
    <jsp:include page="menu.jsp"/>
    Clients
</h1>

<form:form action="add" method="POST" modelAttribute="clients">
    <table border="0" cellpadding="5" class="tdNoFon">
        <tr>
            <td></td>
                <%--<td>Client ID: </td>--%>
            <form:input type = "hidden" path="clientId"/>
        </tr>
        <tr>
            <td>Familia : </td>
            <td><form:input path="familia" type = "text" required = "required" pattern = "^[A-Z]+[a-z]+" placeholder="Holmes"/></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name" type = "text" required = "required" pattern = "^[A-Z]+[a-z]+" placeholder="Sherlock"/></td>
        </tr>
        <tr>
            <td>Telephone : </td>
            <td><form:input path="telephone" type = "number" required = "required" pattern="8[0-9]{10}"  placeholder="89200545436"/></td>
        </tr>
        <tr>
            <td>Passport : </td>
            <td><form:input path="passport" type = "number" required = "required" pattern="[0-9]{10}"  placeholder="2234564738"/></td>
        </tr>
    </table>
    <button class="buttonAdd">Add/Save</button>
</form:form>

<c:if test="${!empty listClients}">
    <table>
        <tr>
            <th width="100">Client ID</th>
            <th width="100">Familia</th>
            <th width="100">Name</th>
            <th width="100">Telephone</th>
            <th width="100">Passport</th>
        </tr>
        <c:forEach items="${listClients}" var="clients">
            <tr>
                <td>${clients.clientId}</td>
                <td>${clients.familia}</td>
                <td>${clients.name}</td>
                <td>${clients.telephone}</td>
                <td>${clients.passport}</td>
                <td class="tdNoFon">
                    <form:form action="edit" method="POST">
                        <input type="hidden" name="clientId" value="${clients.clientId}"/>
                        <input type="submit" class="buttonEdit" value="Edit">
                    </form:form>
                </td>
                <td class="tdNoFon">
                    <form:form action="delete" method="POST">
                        <input type="hidden" name="clientId" value="${clients.clientId}"/>
                        <input type="submit" class="buttonDel" value="Delete">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
