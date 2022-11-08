<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2022
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
  <h2>Giỏ Hàng</h2>
  <table class="table table-dark table-striped">
    <thead>
    <tr>
      <th>id_account</th>
      <th>NAME</th>
      <th>PRICE</th>
      <th>AMOUNT</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${carts}" var="c">
      <tr>
        <td>${c.id_sp}</td>
        <td>${c.name}</td>
        <td>${c.price}</td>
        <td>${c.amount}</td>
        <td><a href="/Addcart?idProduct=${c.id_sp}&action=delete" type="button" class="btn btn-danger">delete</a></td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
  <h1 style="color: red">Tổng Giá : ${total}</h1>
  <a type="button"class="btn btn-success" >Mua Hàng</a>
</div>
</body>
</html>
