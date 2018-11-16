<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<h1>Cust List</h1>
	<c:forEach var="cust" items="${cl }">
	<h2><a href="cdetail?id=${cust.id }">${cust.id }</a> ${cust.name } ${cust.age }</h2>
	</c:forEach>
	
	
</body>
</html>