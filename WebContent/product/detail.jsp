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
<h1>Product Detail Page</h1>
<img src="img/${dp.imgname }">
<h3>${dp.id }</h3>
<h3>${dp.name }</h3>
<h3>${dp.price }</h3>
<h3>${dp.regdate }</h3>

<a href="product?cmd=remove&id=${dp.id }">DELETE</a>
<a href="product?cmd=update&id=${dp.id }">UPDATE</a>
</body>
</html>