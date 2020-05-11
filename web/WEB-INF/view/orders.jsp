<%--
  Created by IntelliJ IDEA.
  User: Ленка
  Date: 01.04.2020
  Time: 14:10
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
    <title>Orders</title>
    <link rel="stylesheet" type="text/css" href="../../Designer.css">
</head>
<body>
<h1>
    <jsp:include page="menu.jsp"/>
    Orders
</h1>

<form:form action="addOrders" method="POST" modelAttribute="orders">
    <table border="0" cellpadding="5" class="tdNoFon">
        <tr>
                <%--<td>Order Id: </td>--%>
            <td><form:input type = "hidden" path="orderId"/></td>
        </tr>
        <tr>
            <td>Client familia : </td>
            <td>
                <c:if test="${orders.orderId == 0}">
                    <p><select path="clients" name="clients">
                        <option disabled>Выберите фамилию клиента</option>
                    <c:forEach items="${listClients}" var="clients">
                        <option value="${clients.clientId}"> ${clients.familia}</option>
                    </c:forEach>
                    </select></p>
                </c:if>

                <c:if test="${orders.orderId != 0}">
                    ${orders.clients.familia}
                    <form:hidden path="clients" value="${orders.clients.clientId}"/>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Date of order : </td>
            <td><form:input path="dateOfOrder" type ="text" required ="required"
                       pattern ="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}" placeholder="05.10.2020"/></td>
        </tr>
             <tr>
                 <td>Name Picture: </td>
                 <td>
                     <p><select path="good" size="${listGood.size()}" multiple name="picture[]">
                         <option disabled>Выберите картину</option>
                         <c:forEach items="${listGood}" var="good">
                             <option value="${good.goodId}"> ${good.name}</option>
                         </c:forEach>
                     </select></p>
                 </td>
             </tr>
    </table>
    <button class="buttonAdd">Add/Save</button>
</form:form>

<c:if test="${!empty listOrders}">
    <table>
        <tr>
            <th width="100">Order ID</th>
            <th width="100">Client familia</th>
            <th width="100">Date of order</th>
            <th width="100">All price</th>
            <th width="100">Name Picture</th>
        </tr>
        <c:forEach items="${listOrders}" var="orders">
            <tr>
                <td>${orders.orderId}</td>
                <td>${orders.clients.familia}</td>
                <td>${orders.dateOfOrder}</td>
                <td>${orders.allPrice}</td>
                <td>
                    <ul>
                        <c:forEach items="${orders.good}" var="picture">
                            <li style="list-style-type: square">${picture.name}</li>
                        </c:forEach>
                    </ul>
                </td>
            <td class="tdNoFon">
                <form:form action="edit" method="POST">
                    <input type="hidden" name="orderId" value="${orders.orderId}"/>
                    <input type="submit" class="buttonEdit" value="Edit">
                </form:form>
            </td>
            <td class="tdNoFon">
                <form:form action="delete" method="POST">
                    <input type="hidden" name="orderId" value="${orders.orderId}"/>
                    <input type="submit" class="buttonDel" value="Delete">
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>

