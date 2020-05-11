<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 07.05.2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Request</title>
    <link rel="stylesheet" type="text/css" href="../../Designer.css">
</head>
<body>
<h1>
    Request
    <jsp:include page="menu.jsp"/>
</h1>
<ul>Первый запрос на картинны, проданные определенным художником</ul>
<c:if test="${!empty listGoods}">
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
        <c:forEach items="${listGoods}" var="goods">
            <tr>
                <td>${goods.goodId}</td>
                <td>${goods.creator.familia}</td>
                <td>${goods.name}</td>
                <td>${goods.year}</td>
                <td>${goods.price}</td>
                <td>${goods.city}</td>
                <td>${goods.museum_gallery}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<td>
   Общая стоимость проданных картин: ${sum}
</td>
<tr>
<ul>Второй запрос на картины, цена которых выше средней</ul>
</tr>
<tr>
<c:if test="${!empty listPicture}">
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
    <c:forEach items="${listPicture}" var="goods">
        <tr>
            <td>${goods.goodId}</td>
            <td>${goods.creator.familia}</td>
            <td>${goods.name}</td>
            <td>${goods.year}</td>
            <td>${goods.price}</td>
            <td>${goods.city}</td>
            <td>${goods.museum_gallery}</td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</tr>
</body>
</html>
