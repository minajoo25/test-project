<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#del').click(function(){
		var c =confirm('Are you really ? ');
		if(c==true){
			location.href='cdelete?id=${dc.id }';
		}
	});
	
});
</script>
</head>
<body>
	<h1>Cust Detail</h1>
	<h2>${dc.id }</h2>
	<h2>${dc.pwd }</h2>
	<h2>${dc.name }</h2>
	<h2>${dc.age }</h2>
	<c:choose>
		<c:when test="${dc.age } > 20">
			<h2>성인</h2>
		</c:when>
		<c:otherwise>
			<h2>미성년</h2>
		</c:otherwise>
	</c:choose>
	<a href="#" id="del">DELETE</a>
	<a href="cupdate?id=${dc.id }">UPDATE</a>
</body>
</html>

