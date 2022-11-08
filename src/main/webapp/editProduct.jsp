<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2022
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div align="center">
  <form action="/edit" method="post">
    <table>
      <tr>
        <td>Nhập id</td>
        <td><input name="idProduct" value="${p.idProduct}"></td>
      </tr>
      <tr>
        <td>Nhập name</td>
        <td><input name="nameProduct" value="${p.nameProduct}"></td>
      </tr>
      <tr>
        <td>Nhập img</td>
        <td><input name="img" value="${p.img}"></td>
      </tr>
      <tr>
        <td>Nhập price</td>
        <td><input name="price" value="${p.price}"></td>
      </tr>
      <tr>
        <td>Nhập status</td>
        <td><input name="status" value="${p.status}"></td>
      </tr>
      <tr>
        <td>Nhập amount</td>
        <td><input name="amount" value="${p.amount}"></td>
      </tr>
    </table>
    <button type="submit">Submit</button>
  </form>
</div>
</body>
</html>
