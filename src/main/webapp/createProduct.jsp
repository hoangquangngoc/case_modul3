<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2022
  Time: 10:11 AM
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
    <form action="/create">
<table>
    <tr>
        <td>Nhập id</td>
        <td><input name="idProduct" placeholder="Nhập id"></td>
    </tr>

    <tr>
        <td>Nhập name</td>
        <td><input name="nameProduct" placeholder="Nhập name"></td>
    </tr>
    <tr>
        <td>Nhập img</td>
        <td><input name="img" placeholder="Nhập img"></td>
    </tr>
    <tr>
        <td>Nhập price</td>
        <td><input name="price" placeholder="Nhập giá"></td>
    </tr>
    <tr>
        <td>Nhập status </td>
        <td><input name="status" placeholder="Nhập mô tả"></td>
    </tr>
    <tr>
        <td>Nhập amount</td>
        <td><input name="amount" placeholder="Nhập số lượng"></td>
    </tr>
</table>
<button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
