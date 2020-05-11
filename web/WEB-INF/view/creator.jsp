<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 31.03.2020
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>

<%-- --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Creator</title>
    <link rel="stylesheet" type="text/css" href="../../Designer.css">
</head>
<body>
<h1>
    <jsp:include page="menu.jsp"/>
    Creator
</h1>
<form:form action="add" method="POST" modelAttribute="creator">
    <table border="0" cellpadding="5" class="tdNoFon">
        <tr>
                <%--<td>Artist ID: </td>--%>
            <td><form:input type = "hidden" path="artistId"/></td>
        </tr>
        <tr>
            <td>Familia : </td>
            <td><form:input cssStyle="border: 2px #ddbf32" path="familia" type = "text" required = "required" pattern = "^[A-Z]+[a-z]+" placeholder="Monet"/></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name" type = "text" required = "required" pattern = "^[A-Z]+[a-z]+" placeholder="Claud"/></td>
        </tr>
        <tr>
            <td>Country : </td>
            <td><form:input path="country" type = "text" required = "required" pattern = "^[A-Z]+[a-z\s]+" placeholder="France"/></td>
        </tr>
        <tr>
            <td>Date of birth : </td>
            <td><form:input path="dateOfBirth" type = "text" required = "required"
                       pattern = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" minlength="4" placeholder="05.10.2020"/></td>
        </tr>
        <tr>
            <td>Style : </td>
            <td><form:input path="style" type = "text" required = "required" pattern = "[a-z]+" placeholder="impressionizm"/></td>
        </tr>
    </table>
        <button class="buttonAdd">Add/Save</button>
</form:form>

<c:if test="${!empty listCreator}">
    <table>
        <tr>
            <th width="100">Artist ID</th>
            <th width="100">Familia</th>
            <th width="100">Name</th>
            <th width="100">Country</th>
            <th width="100">Date of birth</th>
            <th width="100">Style</th>
        </tr>
        <c:forEach items="${listCreator}" var="creator">
            <tr>
                <td>${creator.artistId}</td>
                <td>${creator.familia}</td>
                <td>${creator.name}</td>
                <td>${creator.country}</td>
                <td>${creator.dateOfBirth}</td>
                <td>${creator.style}</td>
                <td class="tdNoFon">
                    <form:form action="edit" method="POST">
                        <input type="hidden" name="artistId" value="${creator.artistId}"/>
                        <input type="submit" class="buttonEdit" value="Edit">
                    </form:form>
                </td>
                <td class="tdNoFon">
                    <form:form action="delete" method="POST">
                        <input type="hidden" name="artistId" value="${creator.artistId}"/>
                        <input type="submit" class="buttonDel" value="Delete">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>


