<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 01.04.2020
  Time: 14:03
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
    <title>Good</title>
    <link rel="stylesheet" type="text/css" href="../../Designer.css">
</head>
<body>
<h1>
    <jsp:include page="menu.jsp"/>
    Good
</h1>

<form:form action="add" method="POST" modelAttribute="good">
    <table border="0" cellpadding="5" class="tdNoFon">
        <tr>
                <%--<td>Good ID: </td>--%>
            <td><form:input type = "hidden" path="goodId"/></td>
        </tr>
        <tr>
            <td>Creator familia : </td>
            <td>
            <form:select path="creator">
                <c:forEach items="${listCreator}" var="creator">
                    <form:option value="${creator.artistId}"> ${creator.familia}</form:option>
                </c:forEach>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Name picture : </td>
            <td><form:input path = "name" type = "text" required = "required" pattern = "^[A-Z0-9]+[a-z0-9\s]+[a-zA-Z]+" placeholder="Vesna"/></td>
        </tr>
        <tr>
            <td>Year : </td>
            <td><form:input path="year" type = "number" required = "required" minlength="4" placeholder="2020"/></td>
        </tr>
        <tr>
            <td>Price : </td>
            <td><form:input path="price" type = "number" required = "required" placeholder="14000"/></td>
        </tr>
        <tr>
            <td>City : </td>
            <td><form:input path="city" type = "text" required = "required" pattern = "^[A-Z]+[a-z\s]+" placeholder="Moscow"/></td>
        </tr>
        <tr>
            <td>Museum gallery : </td>
            <td><form:input path="museum_gallery" type = "text" required = "required" pattern = "[a-zA-Z0-9\s]+[a-zA-Z]+" placeholder="Moscow gallery"/></td>
        </tr>
    </table>
    <button class="buttonAdd">Add/Save</button>
</form:form>

<c:if test="${!empty listGood}">
    <table>
        <tr>
            <th width="100">Good ID</th>
            <th width="100">Creator familia</th>
            <th width="100">Name picture</th>
            <th width="100">Year</th>
            <th width="100">Price</th>
            <th width="100">City</th>
            <th width="100">Museum gallery</th>
        </tr>
        <c:forEach items="${listGood}" var="good">
            <tr>
                <td>${good.goodId}</td>
                <td>${good.creator.familia}</td>
                <td>${good.name}</td>
                <td>${good.year}</td>
                <td>${good.price}</td>
                <td>${good.city}</td>
                <td>${good.museum_gallery}</td>
                <td class="tdNoFon">
                    <form:form action="edit" method="POST">
                        <input type="hidden" name="goodId" value="${good.goodId}"/>
                        <input type="submit" class="buttonEdit" value="Edit">
                    </form:form>
                </td>
                <td class="tdNoFon">
                    <form:form action="delete" method="POST">
                        <input type="hidden" name="goodId" value="${good.goodId}"/>
                        <input type="submit" class="buttonDel" value="Delete">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
