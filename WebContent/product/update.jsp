<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<h1>Product Update Page</h1>
<form enctype="multipart/form-data" action="product?cmd=updateimpl&id=" method="post">
ID:${up.id }
<input type="hidden" name="id" value="${up.id }"><br>
NAME<input type="text" name="name" value="${up.name }"><br>
PRICE<input type="number" name="price" value="${up.price}"><br>
IMG<input type="file" name="newimgname"><br>
	<input type="hidden" name="imgname" value="${up.imgname }">
    <input type="submit" value="UPDATE">
</form>
</body>
</html>