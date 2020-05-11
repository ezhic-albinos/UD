<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 01.04.2020
  Time: 14:11
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
    <title>Ordered good</title>
    <link rel="stylesheet" type="text/css" href="../../Designer.css">
</head>
<body>
<h1>
    <jsp:include page="menu.jsp"/>
    Ordered good
</h1>
<c:if test="${!empty listOrdered_good}">
    <table>
        <tr>
            <th width="100">Good ID</th>
            <th width="100">Order ID</th>
        </tr>
        <c:forEach items="${listOrdered_good}" var="ordered_good">
            <tr>
                <td>${ordered_good.goodId}</td>
                <td>${ordered_good.orderId}</td>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
