<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 05.05.2020
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>УПС! 404</title>
    <link type="text/css" rel="stylesheet" href="../../error404.css" />
</head>

<body>
<div id="notfound">
    <div class="notfound">
        <div class="notfound-404">
            <h1>4<span></span>4</h1>
        </div>
        <h2>УПС! Вы ошиблись</h2>
        <p>Извините, но данная страница не существует. Возможно, она была удалена или вовсе не существовала и вы случайно на нее забрели)</p>
        <a href="/creator/">Вернуться в магазин</a>
    </div>
</div>
</body>
</html>